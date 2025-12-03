import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Controlusuario } from './controlusuario';

describe('Controlusuario', () => {
  let component: Controlusuario;
  let fixture: ComponentFixture<Controlusuario>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Controlusuario]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Controlusuario);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
