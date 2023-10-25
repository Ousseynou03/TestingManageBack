import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StatItemComponent } from './stat-item.component';

describe('StatItemComponent', () => {
  let component: StatItemComponent;
  let fixture: ComponentFixture<StatItemComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StatItemComponent]
    });
    fixture = TestBed.createComponent(StatItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
