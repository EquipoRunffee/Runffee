import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Controlentrenamiento } from './controlentrenamiento';

describe('Controlentrenamiento', () => {
  let component: Controlentrenamiento;
  let fixture: ComponentFixture<Controlentrenamiento>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Controlentrenamiento]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Controlentrenamiento);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
