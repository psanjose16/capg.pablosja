// category-create.component.ts
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Category } from '../../models/category.component';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent {
  category: Category = { id: 0, name: '', description: '' };
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private categoryService: CategoryService) {}

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.categoryService.createCategory(this.category).subscribe(
        (data) => {
          this.successMessage = 'Category created successfully!';
          form.resetForm();
        },
        (error) => this.errorMessage = error
      );
    }
  }
}
