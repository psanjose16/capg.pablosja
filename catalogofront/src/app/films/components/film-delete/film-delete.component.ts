import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmService } from '../../services/film.service';


@Component({
  selector: 'app-film-delete',
  templateUrl: './film-delete.component.html',
  styleUrls: ['./film-delete.component.css']
})
export class FilmDeleteComponent implements OnInit {
  successMessage: string = '';
  errorMessage: string = '';
  filmId!: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.filmId = +this.route.snapshot.paramMap.get('id');
  }

  deleteFilm(): void {
    this.filmService.deleteFilm(this.filmId).subscribe(
      () => {
        this.successMessage = 'Film deleted successfully!';
        this.router.navigate(['/films']);
      },
      (error) => this.errorMessage = error
    );
  }
}
