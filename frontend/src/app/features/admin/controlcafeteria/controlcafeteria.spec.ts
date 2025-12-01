import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Controlcafeteria } from './controlcafeteria';

describe('Controlcafeteria', () => {
  let component: Controlcafeteria;
  let fixture: ComponentFixture<Controlcafeteria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Controlcafeteria]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Controlcafeteria);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
