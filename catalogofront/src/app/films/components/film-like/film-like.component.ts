// film-like.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmService } from '../../services/film.service';


@Component({
  selector: 'app-film-like',
  templateUrl: './film-like.component.html',
  styleUrls: ['./film-like.component.css']
})
export class FilmLikeComponent implements OnInit {
  successMessage: string = '';
  errorMessage: string = '';
  filmId: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.filmId = +this.route.snapshot.paramMap.get('id');
  }

  likeFilm(): void {
    this.filmService.likeFilm(this.filmId).subscribe(
      () => {
        this.successMessage = 'Film liked successfully!';
      },
      (error) => this.errorMessage = error
    );
  }
}
