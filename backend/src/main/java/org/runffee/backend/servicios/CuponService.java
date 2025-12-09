package org.runffee.backend.servicios;

import org.runffee.backend.DTO.CuponDTO;
import org.runffee.backend.modelos.Cupon;
import org.runffee.backend.modelos.TipoCupon;
import org.runffee.backend.repositorios.ICuponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CuponService {

    @Autowired
    private ICuponRepository cuponRepository;

    /**
     * Función que devuelve todos los cupones
     * @return
     */
    public List<Cupon> obtenerCupones() {
        return cuponRepository.findAll().stream().filter(cupon -> !cupon.getEliminado()).toList();
    }

    /**
     * Función que devuelve el cupón por su id
     * @param id
     * @return
     */
    public Cupon obtenerCupon(int id) {
        return cuponRepository.findById(id).orElse(null);
    }

    /**
     * Función para crear un nuevo cupón
     * @param cupon
     */
    public void crearCupon(CuponDTO cupon) {
        Cupon nuevoCupon = new Cupon();

        nuevoCupon.setNombre(cupon.getNombre());
        nuevoCupon.setFechaCaducidad(cupon.getFechaCaducidad());
        nuevoCupon.setTipo(cupon.getTipo());
        nuevoCupon.setUsado(cupon.getUsado());
        nuevoCupon.setImagen(cupon.getImagen());
        nuevoCupon.setPorcentaje(cupon.getPorcentaje());
        nuevoCupon.setDescripcion(cupon.getDescripcion());

        cuponRepository.save(nuevoCupon);
    }

    /**
     * Función para eliminar un cupón
     * @param id
     */
    public void eliminarCupon(int id) {
        Cupon cupon = cuponRepository.findById(id).orElse(null);
        if (cupon != null) {
            cupon.setEliminado(true);
        }
    }

    public List<Cupon> obtenerCuponPorUsuario(Integer idUsuario) {
        return cuponRepository.obtenerCuponPorUsuario(idUsuario);
    }

    public Cupon cuponRandom(){
        Cupon randomCupon = new Cupon();

        // 1. Generar nombre único
        String nombre;
        do {
            nombre = generarNombreAleatorio();
        } while (cuponRepository.existsByNombre(nombre));
        randomCupon.setNombre(nombre);

        // 2. Generar fecha de caducidad (ej: +30 días)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 30);
        randomCupon.setFechaCaducidad(cal.getTime());

        // 3. Elegir tipo aleatorio
        TipoCupon tipo = Math.random() < 0.5 ? TipoCupon.DESCUENTO : TipoCupon.PRODUCTO;
        randomCupon.setTipo(tipo);

        // 4. Ajustar los campos según tipo
        if (tipo == TipoCupon.DESCUENTO) {
            // Porcentaje entre 5% y 50%
            int porcentaje = (int) (Math.random() * (30 - 7 + 1)) + 7;
            randomCupon.setPorcentaje(porcentaje);

            randomCupon.setDescripcion(null);
            randomCupon.setImagen(null);

        } else { // PRODUCTO (regalo)
            List<String> regalosDisponibles = new ArrayList<>();
            regalosDisponibles.add("https://anderolivos.com/runffee/assets/images/merch/merch_cinturon.png");
            regalosDisponibles.add("https://anderolivos.com/runffee/assets/images/merch/merch_coffee.png");
            regalosDisponibles.add("https://anderolivos.com/runffee/assets/images/merch/merch_gorra.png");
            regalosDisponibles.add("https://anderolivos.com/runffee/assets/images/merch/merch_termo.png");
            regalosDisponibles.add("https://anderolivos.com/runffee/assets/images/merch/merch_tote.png");
            regalosDisponibles.add("https://anderolivos.com/runffee/assets/images/merch/merch_vaso.png");

            int numeroRegalo = (int) (Math.random() * 6);

            randomCupon.setPorcentaje(null);
            randomCupon.setDescripcion("Regalo especial para tu próximo pedido.");
            randomCupon.setImagen(regalosDisponibles.get(numeroRegalo));
        }

        // 5. Campos por defecto
        randomCupon.setUsado(false);
        randomCupon.setEliminado(false);

        return randomCupon;
    }

    public String generarNombreAleatorio() {
        return "CPN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public ResponseEntity<?> obtenerCuponCarrito(Integer idUsuario, String nombreCupon){
        Cupon cupon = cuponRepository.obtenerCuponCarrito(idUsuario, nombreCupon);

        if(cupon != null){
            if (cupon.getEliminado()){
                return ResponseEntity.ok("El cupón fue eliminado.");
            }

            if (cupon.getUsado()){
                return ResponseEntity.ok("El cupón fue usado.");
            }

            if (cupon.getFechaCaducidad().before(new Date())){
                cupon.setUsado(true);
                cuponRepository.save(cupon);
                return ResponseEntity.ok("El cupón fue usado.");
            }

            return ResponseEntity.ok(cupon);
        }

        return ResponseEntity.ok("No existe el cupón.");
    }
}
