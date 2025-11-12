import { TestBed } from '@angular/core/testing';

import { Apiprueba } from './apiprueba';

describe('Apiprueba', () => {
  let service: Apiprueba;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Apiprueba);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
