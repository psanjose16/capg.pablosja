// film-create.component.ts
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { FilmDetailsDTO } from '../../models/film.model';
import { FilmService } from '../../services/film.service';

@Component({
  selector: 'app-film-create',
  templateUrl: './film-create.component.html',
  styleUrls: ['./film-create.component.css']
})
export class FilmCreateComponent {
  film: FilmDetailsDTO = { id: 0, title: '', description: '', rating: '', length: 0 };
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private filmService: FilmService) {}

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.filmService.createFilm(this.film).subscribe(
        (data) => {
          this.successMessage = 'Film created successfully!';
          form.resetForm();
        },
        (error) => this.errorMessage = error
      );
    }
  }
}
