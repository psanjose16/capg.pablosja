// film.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { FilmShortDTO, FilmDetailsDTO } from './film.model';

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

  private handleError(error: HttpErrorResponse) {
    // Handle error appropriately
    console.error('An error occurred:', error);
    return throwError('Something went wrong; please try again later.');
  }
}
