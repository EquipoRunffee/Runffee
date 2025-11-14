import { TestBed } from '@angular/core/testing';

import { CafeteriaDetalleService } from './cafeteriaDetalleService';

describe('CafeteriaDetalleService', () => {
  let service: CafeteriaDetalleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CafeteriaDetalleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
