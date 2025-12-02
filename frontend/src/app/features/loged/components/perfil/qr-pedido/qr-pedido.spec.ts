import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QrPedido } from './qr-pedido';

describe('QrPedido', () => {
  let component: QrPedido;
  let fixture: ComponentFixture<QrPedido>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [QrPedido]
    })
    .compileComponents();

    fixture = TestBed.createComponent(QrPedido);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
