import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CatalogResourcesComponent } from './components/catalog-resources/catalog-resources.component';
import { CatalogService } from './services/catalog.service';
import { NewsService } from '../news/services/news.service';
import { NewsComponent } from '../news/components/news/news.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [CatalogResourcesComponent, NewsComponent],
  imports: [CommonModule, FormsModule],
  providers: [CatalogService, NewsComponent],
  exports: [CatalogResourcesComponent, NewsComponent]
})
export class CatalogModule {}
