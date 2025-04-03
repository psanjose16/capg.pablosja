// category-delete.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-category-delete',
  templateUrl: './category-delete.component.html',
  styleUrls: ['./category-delete.component.css']
})
export class CategoryDeleteComponent implements OnInit {
  successMessage: string = '';
  errorMessage: string = '';
  categoryId!: number;

  constructor(private categoryService: CategoryService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.categoryId = +this.route.snapshot.paramMap.get('id');
  }

  deleteCategory(): void {
    this.categoryService.deleteCategory(this.categoryId).subscribe(
      () => {
        this.successMessage = 'Category deleted successfully!';
        this.router.navigate(['/categories']);
      },
      (error) => this.errorMessage = error
    );
  }
}
