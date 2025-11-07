import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContrasenaComponent } from './contrasena.component';

describe('Contrasena', () => {
  let component: ContrasenaComponent;
  let fixture: ComponentFixture<ContrasenaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ContrasenaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ContrasenaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
