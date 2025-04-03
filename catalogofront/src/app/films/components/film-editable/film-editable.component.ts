import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmEditDTO } from '../../models/film.model';
import { FilmService } from '../../services/film.service';

@Component({
  selector: 'app-film-editable',
  templateUrl: './film-editable.component.html',
  styleUrls: ['./film-editable.component.css']
})
export class FilmEditableComponent implements OnInit {
  film: FilmEditDTO | null = null;
  errorMessage: string = '';
  filmId!: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.filmId = +this.route.snapshot.paramMap.get('id');
    this.loadFilmEditable();
  }

  loadFilmEditable(): void {
    this.filmService.getFilmEditable(this.filmId).subscribe(
      (data) => this.film = data,
      (error) => this.errorMessage = error
    );
  }
}
