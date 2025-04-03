// film.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { FilmShortDTO } from '../models/film-short.model';
import { FilmDetailsDTO } from '../models/film.model';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  private apiUrl = '/peliculas/v1';

  constructor(private http: HttpClient) {}

  getAllFilms(mode: string = 'short'): Observable<FilmShortDTO[] | FilmDetailsDTO[]> {
    return this.http.get<FilmShortDTO[] | FilmDetailsDTO[]>(`${this.apiUrl}?mode=${mode}`).pipe(
      catchError(this.handleError)
    );
  }

  getFilmDetails(id: number): Observable<FilmDetailsDTO> {
    return this.http.get<FilmDetailsDTO>(`${this.apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  createFilm(film: FilmDetailsDTO): Observable<FilmDetailsDTO> {
    return this.http.post<FilmDetailsDTO>(this.apiUrl, film).pipe(
      catchError(this.handleError)
    );
  }

  updateFilm(id: number, film: FilmDetailsDTO): Observable<FilmDetailsDTO> {
    return this.http.put<FilmDetailsDTO>(`${this.apiUrl}/${id}`, film).pipe(
      catchError(this.handleError)
    );
  }

  deleteFilm(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`).pipe(
      catchError(this.handleError)
    );
  }

  searchFilms(criteria: any): Observable<FilmShortDTO[] | FilmDetailsDTO[]> {
    return this.http.get<FilmShortDTO[] | FilmDetailsDTO[]>(`${this.apiUrl}/filtro`, { params: criteria }).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    // Handle error appropriately
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
