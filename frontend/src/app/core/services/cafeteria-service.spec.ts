import { TestBed } from '@angular/core/testing';

import { Cafeteria } from './cafeteria';

describe('Cafeteria', () => {
  let service: Cafeteria;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Cafeteria);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
