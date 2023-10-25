import { Component } from '@angular/core';
import { CardInfoTurnover } from '../models/card-info-turnover';

@Component({
  selector: 'app-stat-item-bilan',
  templateUrl: './stat-item-bilan.component.html',
  styleUrls: ['./stat-item-bilan.component.css']
})
export class StatItemBilanComponent {
  itemInfo:CardInfoTurnover = {
    card_title: "chicken & eggs numbers",
    currency_code: "USD",
    turnover: 1500,
    product_1_name: "Eggs",
    product_1_sale_nb: 54,
    product_1_total_nb: 100,
    product_1_sale_amount: 54 * .95,
    product_2_name: "Chicken",
    product_2_sale_nb: 35,
    product_2_total_nb: 97,
    product_2_sale_amount: 35 * 7,
    spent_amount: 120
  };
  trending:number = 1;


  saledProductPercentage(){
    const res = (((this.itemInfo.product_1_sale_amount + this.itemInfo.product_2_sale_amount)/this.itemInfo.turnover)*100).toFixed(2);
    return !Number.isNaN(res)?res:0;
  }

  selectTrending(){
    return this.trending == 1 ? "assets/images/icons/trend.png":"assets/images/icons/down-right.png";
  }
}
