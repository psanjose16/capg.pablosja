// film-details.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmDetailsDTO } from '../../models/film.model';
import { FilmService } from '../../services/film.service';


@Component({
  selector: 'app-film-details',
  templateUrl: './film-details.component.html',
  styleUrls: ['./film-details.component.css']
})
export class FilmDetailsComponent implements OnInit {
  film: FilmDetailsDTO | null = null;
  errorMessage: string = '';
  filmId!: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.filmId = +this.route.snapshot.paramMap.get('id');
    this.loadFilmDetails();
  }

  loadFilmDetails(): void {
    this.filmService.getFilmDetails(this.filmId).subscribe(
      (data) => this.film = data,
      (error) => this.errorMessage = error
    );
  }
}
