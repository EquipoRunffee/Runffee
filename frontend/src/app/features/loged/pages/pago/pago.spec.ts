import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Pago } from './pago';

describe('Pago', () => {
  let component: Pago;
  let fixture: ComponentFixture<Pago>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Pago]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Pago);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
