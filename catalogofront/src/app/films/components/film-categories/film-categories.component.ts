import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Category } from '../../../categories/models/category.component';
import { FilmService } from '../../services/film.service';

@Component({
  selector: 'app-film-categories',
  templateUrl: './film-categories.component.html',
  styleUrls: ['./film-categories.component.css']
})
export class FilmCategoriesComponent implements OnInit {
  categories: Category[] = [];
  errorMessage: string = '';
  filmId!: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.filmId = +this.route.snapshot.paramMap.get('id');
    this.loadCategories();
  }

  loadCategories(): void {
    this.filmService.getCategoriesByFilmId(this.filmId).subscribe(
      (data) => this.categories = data,
      (error) => this.errorMessage = error
    );
  }
}
