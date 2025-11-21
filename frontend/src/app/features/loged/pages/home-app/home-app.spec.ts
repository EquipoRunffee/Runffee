import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeApp } from './home-app';

describe('HomeApp', () => {
  let component: HomeApp;
  let fixture: ComponentFixture<HomeApp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HomeApp]
    })
    .compileComponents();

    fixture = TestBed.createComponent(HomeApp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
