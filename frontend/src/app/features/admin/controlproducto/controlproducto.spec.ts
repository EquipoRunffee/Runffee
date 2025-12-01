import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Controlproducto } from './controlproducto';

describe('Controlproducto', () => {
  let component: Controlproducto;
  let fixture: ComponentFixture<Controlproducto>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Controlproducto]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Controlproducto);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
