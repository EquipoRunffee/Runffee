import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardReto } from './card-reto';

describe('CardReto', () => {
  let component: CardReto;
  let fixture: ComponentFixture<CardReto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CardReto]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardReto);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
