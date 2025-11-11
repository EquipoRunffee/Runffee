import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cafeteria } from './cafeteria';

describe('Cafeteria', () => {
  let component: Cafeteria;
  let fixture: ComponentFixture<Cafeteria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Cafeteria]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Cafeteria);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
