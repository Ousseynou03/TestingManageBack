import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatItemBilanComponent } from './stat-item-bilan.component';

describe('StatItemBilanComponent', () => {
  let component: StatItemBilanComponent;
  let fixture: ComponentFixture<StatItemBilanComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StatItemBilanComponent]
    });
    fixture = TestBed.createComponent(StatItemBilanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
