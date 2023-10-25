import { Component } from '@angular/core';
import { CardInfo } from '../models/card-info';
@Component({
  selector: 'app-stat-item',
  templateUrl: './stat-item.component.html',
  styleUrls: ['./stat-item.component.css']
})
export class StatItemComponent {

  itemInfo : CardInfo = {
    card_title:"chicken & eggs numbers",
    img_url:"assets/images/illustrations/chicken-coop.png",
    currency_code:"USD",
    turnover:1500,
    product_1_name:"Eggs",
    product_1_sale_nb:54,
    product_1_total_nb:100,
    product_1_sale_amount: 54*.95,
    product_2_name:"Chicken",
    product_2_sale_nb:35,
    product_2_total_nb:97,
    product_2_sale_amount: 35*7,
  };

  saledProductPercentage(){
    const res = (((this.itemInfo.product_1_sale_amount + this.itemInfo.product_2_sale_amount)/this.itemInfo.turnover)*100).toFixed(2);
    console.log(res);
    return !Number.isNaN(res)?res:0;
  }
}

