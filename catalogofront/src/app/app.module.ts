import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ActorsModule } from './actors/actors.module';

@NgModule({
  declarations: [],
  imports: [BrowserModule, HttpClientModule, AppRoutingModule, ActorsModule, AppComponent],
  providers: [],
})
export class AppModule {}
