// film-list.component.ts
import { Component, OnInit } from '@angular/core';
import { FilmService } from './film.service';
import { FilmShortDTO, FilmDetailsDTO } from './film.model';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css']
})
export class FilmListComponent implements OnInit {
  films: FilmShortDTO[] | FilmDetailsDTO[] = [];
  errorMessage: string = '';
  mode: string = 'short';

  constructor(private filmService: FilmService) {}

  ngOnInit(): void {
    this.loadFilms();
  }

  loadFilms(): void {
    this.filmService.getAllFilms(this.mode).subscribe(
      (data) => this.films = data,
      (error) => this.errorMessage = error
    );
  }

  switchMode(mode: string): void {
    this.mode = mode;
    this.loadFilms();
  }
}
