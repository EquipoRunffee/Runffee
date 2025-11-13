import { TestBed } from '@angular/core/testing';

import { EntrenamientoService } from './entrenamientoService';

describe('EntrenamientoService', () => {
  let service: EntrenamientoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EntrenamientoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
