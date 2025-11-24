import { TestBed } from '@angular/core/testing';

import { ValoracionesService } from './valoracionesService';

describe('ValoracionesService', () => {
  let service: ValoracionesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ValoracionesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
