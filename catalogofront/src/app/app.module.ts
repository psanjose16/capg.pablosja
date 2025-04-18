import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ActorsModule } from './actors/actors.module';
import { CatalogModule } from './catalog/catalog.module';
import { CategoryListComponent } from './categories/components/category-list/category-list.component';
import { CategoryService } from './categories/services/category.service';
import { CategoryFilmsComponent } from './categories/components/category-films/category-films.component';
import { CategoryCreateComponent } from './categories/components/category-create/category-create.component';
import { CategoryEditComponent } from './categories/components/category-edit/category-edit.component';
import { CategoryDeleteComponent } from './categories/components/category-delete/category-delete.component';
import { FilmListComponent } from './films/components/film-list/film-list.component';
import { FilmService } from './films/services/film.service';
import { FilmDetailsComponent } from './films/components/film-details/film-details.component';
import { FilmCreateComponent } from './films/components/film-create/film-create.component';
import { FilmEditComponent } from './films/components/film-edit/film-edit.component';
import { FilmDeleteComponent } from './films/components/film-delete/film-delete.component';
import { FilmSearchComponent } from './films/components/film-search/film-search.component';
import { FilmEditableComponent } from './films/components/film-editable/film-editable.component';
import { FilmActorsComponent } from './films/components/film-actors/film-actors.component';
import { FilmCategoriesComponent } from './films/components/film-categories/film-categories.component';
import { FilmLikeComponent } from './films/components/film-like/film-like.component';
import { LanguageListComponent } from './languages/components/language-list/language-list.component';
import { LanguageService } from './languages/services/language.service';
import { LanguageFilmsComponent } from './languages/components/language-films/language-films.component';
import { LanguageCreateComponent } from './languages/components/language-create/language-create';

@NgModule({
  declarations: [
  ],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule, ActorsModule, AppComponent, CatalogModule, CategoryListComponent, CategoryService, CategoryFilmsComponent, CategoryCreateComponent, CategoryEditComponent, CategoryDeleteComponent, FilmListComponent, FilmService, FilmDetailsComponent, FilmCreateComponent, FilmEditComponent, FilmDeleteComponent, FilmSearchComponent, FilmEditableComponent, FilmActorsComponent, FilmCategoriesComponent, FilmLikeComponent, LanguageListComponent, LanguageService, LanguageFilmsComponent, LanguageCreateComponent],
  providers: [],
})
export class AppModule {}
