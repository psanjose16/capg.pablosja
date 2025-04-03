// category-films.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CategoryService } from './category.service';
import { FilmShortDTO } from './film-short.model';

@Component({
  selector: 'app-category-films',
  templateUrl: './category-films.component.html',
  styleUrls: ['./category-films.component.css']
})
export class CategoryFilmsComponent implements OnInit {
  films: FilmShortDTO[] = [];
  errorMessage: string = '';
  categoryId: number;

  constructor(private categoryService: CategoryService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.categoryId = +this.route.snapshot.paramMap.get('id');
    this.categoryService.getFilmsByCategoryId(this.categoryId).subscribe(
      (data) => this.films = data,
      (error) => this.errorMessage = error
    );
  }
}
