import { Component } from '@angular/core';

@Component({
  selector: 'app-product-mvp',
  templateUrl: './product-mvp.component.html',
  styleUrls: ['./product-mvp.component.css']
})
export class ProductMvpComponent {
  mvp_prod:any={
    tendency:1,
    sale_pourcentage:.56,
    prod_name:"white chicken"
  }
}
