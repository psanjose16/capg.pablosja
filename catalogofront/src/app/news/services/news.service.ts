import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NewsItem } from '../models/news-item.model';

@Injectable({
  providedIn: 'root'
})
export class NewsService {
  private baseUrl = 'http://localhost:8080/novedades/v1';

  constructor(private http: HttpClient) {}

  getLatestNews(date: string = '2021-01-01 00:00:00'): Observable<NewsItem[]> {
    let params = new HttpParams().set('fecha', date);
    return this.http.get<NewsItem[]>(this.baseUrl, { params });
  }
}
