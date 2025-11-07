import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapaGoogle } from './mapa-google';

describe('MapaGoogle', () => {
  let component: MapaGoogle;
  let fixture: ComponentFixture<MapaGoogle>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MapaGoogle]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MapaGoogle);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
