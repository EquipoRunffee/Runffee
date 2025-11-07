import { TestBed } from '@angular/core/testing';

import { GoogleMapsLoad } from './google-maps-load';

describe('GoogleMapsLoad', () => {
  let service: GoogleMapsLoad;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoogleMapsLoad);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
