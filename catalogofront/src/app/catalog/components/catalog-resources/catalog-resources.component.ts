import { Component, OnInit } from '@angular/core';
import { CatalogService } from '../services/catalog.service';
import { CatalogResources } from '../models/catalog-resources.model';

@Component({
  selector: 'app-catalog-resources',
  templateUrl: './catalog-resources.component.html',
  styleUrls: ['./catalog-resources.component.css']
})
export class CatalogResourcesComponent implements OnInit {
  catalogResources: CatalogResources | null = null;
  errorMessage: string | null = null;

  constructor(private catalogService: CatalogService) {}

  ngOnInit(): void {
    this.fetchCatalogResources();
  }

  fetchCatalogResources(): void {
    this.catalogService.getCatalogResources().subscribe(
      (data) => {
        this.catalogResources = data;
        this.errorMessage = null;
      },
      (error) => {
        this.catalogResources = null;
        this.errorMessage = 'Error fetching catalog resources';
        console.error('Error fetching catalog resources', error);
      }
    );
  }
}
