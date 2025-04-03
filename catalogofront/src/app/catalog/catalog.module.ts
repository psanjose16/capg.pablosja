import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CatalogResourcesComponent } from './components/catalog-resources/catalog-resources.component';
import { CatalogService } from './services/catalog.service';

@NgModule({
  declarations: [CatalogResourcesComponent],
  imports: [CommonModule],
  providers: [CatalogService],
  exports: [CatalogResourcesComponent]
})
export class CatalogModule {}
