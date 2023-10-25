import { Component } from '@angular/core';
import { TableItem } from '../models/tableItem';

@Component({
  selector: 'app-table-info-manager',
  templateUrl: './table-info-manager.component.html',
  styleUrls: ['./table-info-manager.component.css']
})

export class TableInfoManagerComponent {
   element1 = new Map([
    ["names", "anakin skywalker"],
    ["mail address", "s.anakin@gstarwars.net"],
    ["address", "tartarus"],
    ["status", "jedi"]
  ]);
  element2 = new Map([
    ["names", "kailo ren"],
    ["mail address", "r.kailo@gstarwars.net"],
    ["address", "stargates"],
    ["status", "site"]
  ]);
  element3 = new Map([
    ["names", "luc skywalker"],
    ["mail address", "r.luc@gstarwars.net"],
    ["address", "centorus"],
    ["status", "jedi"]
  ]);


  users:TableItem={
    select_col: true,
    Content: [this.element1, this.element2, this.element3]
  };

  constructor(){
  }
}
