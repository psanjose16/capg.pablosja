import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Category } from '../models/category.component';
import { FilmShortDTO } from '../../films/models/film-short.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  private apiUrl = '/categorias/v1';

  constructor(private http: HttpClient) {}

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.apiUrl).pipe(
      catchError(this.handleError)
    );
  }


  getMoviesByCategoryId(id: number): Observable<FilmShortDTO[]> {
    return this.http.get<FilmShortDTO[]>(`${this.apiUrl}/${id}/peliculas`).pipe(
      catchError(this.handleError)
    );
  }

  createCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(this.apiUrl, category).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
