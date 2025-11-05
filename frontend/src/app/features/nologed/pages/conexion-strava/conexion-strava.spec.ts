import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConexionStrava } from './conexion-strava';

describe('ConexionStrava', () => {
  let component: ConexionStrava;
  let fixture: ComponentFixture<ConexionStrava>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ConexionStrava]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConexionStrava);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
