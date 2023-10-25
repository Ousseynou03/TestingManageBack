import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableInfoManagerComponent } from './table-info-manager.component';

describe('TableInfoManagerComponent', () => {
  let component: TableInfoManagerComponent;
  let fixture: ComponentFixture<TableInfoManagerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TableInfoManagerComponent]
    });
    fixture = TestBed.createComponent(TableInfoManagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
