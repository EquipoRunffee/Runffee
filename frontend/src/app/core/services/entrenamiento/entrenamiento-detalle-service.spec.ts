import { TestBed } from '@angular/core/testing';

import { EntrenamientoDetallesService } from './entrenamientoDetallesService';

describe('EntrenamientoDetallesService', () => {
  let service: EntrenamientoDetallesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EntrenamientoDetallesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
