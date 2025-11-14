import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Detallecafeteria } from './detallecafeteria';

describe('Detallecafeteria', () => {
  let component: Detallecafeteria;
  let fixture: ComponentFixture<Detallecafeteria>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Detallecafeteria]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Detallecafeteria);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
