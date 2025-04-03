import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogResourcesComponent } from './components/catalog-resources/catalog-resources.component';

const routes: Routes = [
  { path: 'catalog', component: CatalogResourcesComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CatalogRoutingModule {}
