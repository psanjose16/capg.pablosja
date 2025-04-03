import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

export const routes: Routes = [
  { path: '', redirectTo: '/actors', pathMatch: 'full' },
  { path: '**', redirectTo: '/actors' },
  { path: '', redirectTo: '/catalog', pathMatch: 'full' },
  { path: '**', redirectTo: '/catalog' },
  { path: '', redirectTo: '/categories', pathMatch: 'full' },
  { path: '**', redirectTo: '/categories' },
  { path: '', redirectTo: '/films', pathMatch: 'full' },
  { path: '**', redirectTo: '/films' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
