import { Component, OnInit } from '@angular/core';
import {Category} from '../../model/category';
import {CategoryService} from '../../services/category.service';

@Component({
  selector: 'app-movie-category-menu',
  templateUrl: './movie-category-menu.component.html',
  styleUrls: ['./movie-category-menu.component.css']
})
export class MovieCategoryMenuComponent implements OnInit {

  categories: Category[] = [];

  constructor(@Inject(CategoryService) private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.categoryService.getAllCategory().subscribe(data => {
      this.categories = data;
    });
  }

}
function Inject(CategoryService: any): (target: typeof MovieCategoryMenuComponent, propertyKey: undefined, parameterIndex: 0) => void {
  throw new Error('Function not implemented.');
}

