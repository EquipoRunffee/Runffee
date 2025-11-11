import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapaCafeteria } from './mapa-cafeteria';

describe('MapaCafeteria', () => {
  let component: MapaCafeteria;
  let fixture: ComponentFixture<MapaCafeteria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MapaCafeteria]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MapaCafeteria);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
