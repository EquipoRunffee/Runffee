import { TestBed } from '@angular/core/testing';

import { LineaPedidoService } from './lineaPedido-service';

describe('LineaPedidoService', () => {
  let service: LineaPedidoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LineaPedidoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
