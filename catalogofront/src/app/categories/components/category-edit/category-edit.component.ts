// category-edit.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Category } from '../../models/category.component';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  category: Category = { id: 0, name: '', description: '' };
  successMessage: string = '';
  errorMessage: string = '';
  categoryId!: number;

  constructor(private categoryService: CategoryService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.categoryId = +this.route.snapshot.paramMap.get('id');
    this.categoryService.getCategoryById(this.categoryId).subscribe(
      (data: Category) => this.category = data,
      (error: string) => this.errorMessage = error
    );
  }

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.categoryService.updateCategory(this.categoryId, this.category).subscribe(
        (data) => {
          this.successMessage = 'Category updated successfully!';
          form.resetForm();
        },
        (error) => this.errorMessage = error
      );
    }
  }
}
