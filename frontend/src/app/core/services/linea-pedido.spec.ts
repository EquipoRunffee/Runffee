import { TestBed } from '@angular/core/testing';

import { LineaPedido } from './lineaPedido';

describe('LineaPedido', () => {
  let service: LineaPedido;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LineaPedido);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
