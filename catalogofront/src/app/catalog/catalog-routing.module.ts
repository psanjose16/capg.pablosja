import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatalogResourcesComponent } from './components/catalog-resources/catalog-resources.component';
import { NewsComponent } from '../news/components/news/news.component';

const routes: Routes = [
  { path: 'catalog', component: CatalogResourcesComponent }
  { path: 'news', component: NewsComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CatalogRoutingModule {}
