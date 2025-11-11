import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cafeterias } from './cafeterias';

describe('Cafeterias', () => {
  let component: Cafeterias;
  let fixture: ComponentFixture<Cafeterias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [Cafeterias]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Cafeterias);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
