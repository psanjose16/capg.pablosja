import { Component, OnInit } from '@angular/core';
import { Category } from '../../models/category.component';
import { CategoryService } from '../../services/category.service';


@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categories: Category[] = [];
  errorMessage: string = '';

  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.categoryService.getAllCategories().subscribe(
      (data) => this.categories = data,
      (error) => this.errorMessage = error
    );
  }
}
