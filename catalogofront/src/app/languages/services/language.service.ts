import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Language } from '../models/language.model';
import { FilmShortDTO } from '../../films/models/film-short.model';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {
  private apiUrl = '/idiomas/v1';

  constructor(private http: HttpClient) {}

  getAllLanguages(): Observable<Language[]> {
    return this.http.get<Language[]>(this.apiUrl).pipe(
      catchError(this.handleError)
    );
  }

  getFilmsByLanguageId(id: number): Observable<FilmShortDTO[]> {
    return this.http.get<FilmShortDTO[]>(`${this.apiUrl}/${id}/peliculas`).pipe(
      catchError(this.handleError)
    );
  }

  createLanguage(language: Language): Observable<Language> {
    return this.http.post<Language>(this.apiUrl, language).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    // Handle error appropriately
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
