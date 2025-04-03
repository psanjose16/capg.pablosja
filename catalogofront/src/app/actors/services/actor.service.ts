import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Actor } from '../models/actor.model';
import { Film } from '../../films/models/film.model';

@Injectable({
  providedIn: 'root'
})
export class ActorService {
  private baseUrl = 'http://localhost:8080/actores/v1';

  constructor(private http: HttpClient) {}

  getAllActors(mode: string = 'largo', page?: number): Observable<Actor[]> {
    let params = new HttpParams().set('modo', mode);
    if (page !== undefined) {
      params = params.set('page', page.toString());
    }
    return this.http.get<Actor[]>(this.baseUrl, { params });
  }

getActorById(id: number): Observable<Actor> {
  return this.http.get<Actor>(`${this.baseUrl}/${id}`);
  }

createActor(actor: Actor): Observable<any> {
    return this.http.post(this.baseUrl, actor);
  }

  updateActor(id: number, actor: Actor): Observable<any> {
    return this.http.put(`${this.baseUrl}/${id}`, actor);
  }

  deleteActor(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getActorFilms(id: number): Observable<Film[]> {
    return this.http.get<Film[]>(`${this.baseUrl}/${id}/pelis`);
  }

  retireActor(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}/jubilacion`);
  }

}
