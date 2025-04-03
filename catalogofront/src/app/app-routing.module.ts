import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryFilmsComponent } from './categories/components/category-films/category-films.component';

export const routes: Routes = [
  { path: '', redirectTo: '/actors', pathMatch: 'full' },
  { path: '**', redirectTo: '/actors' },
  { path: '', redirectTo: '/catalog', pathMatch: 'full' },
  { path: '**', redirectTo: '/catalog' },
  { path: '', redirectTo: '/categories', pathMatch: 'full' },
  { path: '**', redirectTo: '/categories' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
