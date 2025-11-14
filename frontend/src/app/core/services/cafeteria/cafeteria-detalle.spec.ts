import { TestBed } from '@angular/core/testing';

import { CafeteriaDetallesService } from './cafeteriaDetallesService';

describe('CafeteriaDetallesService', () => {
  let service: CafeteriaDetallesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CafeteriaDetallesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
