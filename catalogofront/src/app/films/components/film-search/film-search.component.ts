// film-search.component.ts
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FilmShortDTO } from '../../models/film-short.model';
import { FilmDetailsDTO } from '../../models/film.model';
import { FilmService } from '../../services/film.service';

@Component({
  selector: 'app-film-search',
  templateUrl: './film-search.component.html',
  styleUrls: ['./film-search.component.css']
})
export class FilmSearchComponent {
  films: FilmShortDTO[] | FilmDetailsDTO[] = [];
  errorMessage: string = '';
  searchCriteria: any = {
    title: '',
    minlength: null,
    maxlength: null,
    rating: '',
    mode: 'short'
  };

  constructor(private filmService: FilmService) {}

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.filmService.searchFilms(this.searchCriteria).subscribe(
        (data) => this.films = data,
        (error) => this.errorMessage = error
      );
    }
  }
}
