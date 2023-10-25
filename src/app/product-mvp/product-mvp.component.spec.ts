import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductMvpComponent } from './product-mvp.component';

describe('ProductMvpComponent', () => {
  let component: ProductMvpComponent;
  let fixture: ComponentFixture<ProductMvpComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ProductMvpComponent]
    });
    fixture = TestBed.createComponent(ProductMvpComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
