import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrenamientoCard } from './entrenamiento-card';

describe('EntrenamientoCard', () => {
  let component: EntrenamientoCard;
  let fixture: ComponentFixture<EntrenamientoCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EntrenamientoCard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EntrenamientoCard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
