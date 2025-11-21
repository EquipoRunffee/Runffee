import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cupon } from './cupon';

describe('Cupon', () => {
  let component: Cupon;
  let fixture: ComponentFixture<Cupon>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Cupon]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Cupon);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
