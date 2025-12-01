import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Controlreto } from './controlreto';

describe('Controlreto', () => {
  let component: Controlreto;
  let fixture: ComponentFixture<Controlreto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Controlreto]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Controlreto);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
