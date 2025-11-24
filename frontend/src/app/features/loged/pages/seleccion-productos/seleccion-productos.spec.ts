import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeleccionProductos } from './seleccion-productos';

describe('SeleccionProductos', () => {
  let component: SeleccionProductos;
  let fixture: ComponentFixture<SeleccionProductos>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SeleccionProductos]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeleccionProductos);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
