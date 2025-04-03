import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ActorsModule } from './actors/actors.module';
import { CatalogModule } from './catalog/catalog.module';
import { CategoryListComponent } from './categories/components/category-list/category-list.component';
import { CategoryService } from './categories/services/category.service';

@NgModule({
  declarations: [
  ],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule, ActorsModule, AppComponent, CatalogModule, CategoryListComponent, CategoryService],
  providers: [],
})
export class AppModule {}
