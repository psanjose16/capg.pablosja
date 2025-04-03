import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CatalogResources } from '../models/catalog-resources.model';

@Injectable({
  providedIn: 'root'
})
export class CatalogService {
  private baseUrl = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  getCatalogResources(): Observable<CatalogResources> {
    return this.http.get<CatalogResources>(this.baseUrl);
  }
}
