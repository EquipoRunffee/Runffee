import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Navbarperfil } from './navbarperfil';

describe('Navbarperfil', () => {
  let component: Navbarperfil;
  let fixture: ComponentFixture<Navbarperfil>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Navbarperfil]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Navbarperfil);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
