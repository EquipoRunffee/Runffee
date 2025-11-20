import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValoracionCard } from './valoracion-card';

describe('ValoracionCard', () => {
  let component: ValoracionCard;
  let fixture: ComponentFixture<ValoracionCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ValoracionCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ValoracionCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
