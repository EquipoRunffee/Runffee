import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {AdminService} from '@core/services/admin/adminService';
import {adminCafeteria} from '@core/models/adminCafeteria';

@Component({
  selector: 'app-controlcafeteria',
  standalone: true,
  templateUrl: './controlcafeteria.html',
  styleUrl: './controlcafeteria.css',
  imports: [
    FormsModule
  ]

})
export class Controlcafeteria{

// CAMPOS - CREAR CAFETERÍA
  crearNombre = '';
  crearDescripcion = '';
  crearLatitud: number | null = null;
  crearLongitud: number | null = null;
  crearImagen = '';
  crearTipoCafeteria = '';
  crearEliminado = 'false';

  // CAMPOS - MODIFICAR CAFETERÍA
  modificarId: number | null = null;
  nuevoNombre = '';
  nuevaDescripcion = '';
  nuevaLatitud: number | null = null;
  nuevaLongitud: number | null = null;
  nuevaImagen = '';
  nuevoTipoCafeteria = '';
  nuevoEliminado = 'false';

  // CAMPO - ELIMINAR CAFETERÍA
  eliminarId: number | null = null;

  constructor(private adminService: AdminService) {}

  //FUNCIÓN PARA CREAR CAFETERIA



  //FUNCIÓN PARA CARGAR LA CAFETERIA A MODIFICAR


  //FUNCIÓN PARA MODIFICAR


  //FUNCIÓN PARA ELIMINAR


}
