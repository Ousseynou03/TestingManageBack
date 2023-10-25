import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { StatItemComponent } from './stat-item/stat-item.component';
import { StatItemBilanComponent } from './stat-item-bilan/stat-item-bilan.component';
import { ProductMvpComponent } from './product-mvp/product-mvp.component';
import { TableInfoManagerComponent } from './table-info-manager/table-info-manager.component';

@NgModule({
  declarations: [
    AppComponent,
    SignUpComponent,
    LoginComponent,
    HomeComponent,
    StatItemComponent,
    StatItemBilanComponent,
    ProductMvpComponent,
    TableInfoManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
