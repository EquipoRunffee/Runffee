import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValoracionRating } from './valoracion-rating';

describe('ValoracionRating', () => {
  let component: ValoracionRating;
  let fixture: ComponentFixture<ValoracionRating>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ValoracionRating]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValoracionRating);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
