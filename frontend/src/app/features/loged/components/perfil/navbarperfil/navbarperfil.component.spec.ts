import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarperfilComponent } from './navbarperfil.component';

describe('NavbarperfilComponent', () => {
  let component: NavbarperfilComponent;
  let fixture: ComponentFixture<NavbarperfilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NavbarperfilComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NavbarperfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
