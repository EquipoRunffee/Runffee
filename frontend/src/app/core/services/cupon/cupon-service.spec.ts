import { TestBed } from '@angular/core/testing';

import { Cupon } from './cuponService';

describe('Cupon', () => {
  let service: Cupon;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cupon);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
