import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { FilmDetailsDTO } from '../../models/film.model';
import { FilmService } from '../../services/film.service';

@Component({
  selector: 'app-film-edit',
  templateUrl: './film-edit.component.html',
  styleUrls: ['./film-edit.component.css']
})
export class FilmEditComponent implements OnInit {
  film: FilmDetailsDTO = { id: 0, title: '', description: '', rating: '', length: 0 };
  successMessage: string = '';
  errorMessage: string = '';
  filmId!: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute, private router: Router) {}

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

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.filmService.updateFilm(this.filmId, this.film).subscribe(
        (data) => {
          this.successMessage = 'Film updated successfully!';
          this.router.navigate(['/films', this.filmId]);
        },
        (error) => this.errorMessage = error
      );
    }
  }
}
