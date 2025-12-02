import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapaEntrenamiento } from './mapa-entrenamiento';

describe('MapaEntrenamiento', () => {
  let component: MapaEntrenamiento;
  let fixture: ComponentFixture<MapaEntrenamiento>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MapaEntrenamiento]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MapaEntrenamiento);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
