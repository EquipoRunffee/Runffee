import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardProducto } from './card-producto';

describe('CardProducto', () => {
  let component: CardProducto;
  let fixture: ComponentFixture<CardProducto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CardProducto]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardProducto);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
