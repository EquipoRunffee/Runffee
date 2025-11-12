import { TestBed } from '@angular/core/testing';

import { Valoracion } from './valoracion';

describe('Valoracion', () => {
  let service: Valoracion;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Valoracion);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
