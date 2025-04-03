import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Language } from '../../models/language.model';
import { LanguageService } from '../../services/language.service';

@Component({
  selector: 'app-language-create',
  templateUrl: './language-create.component.html',
  styleUrls: ['./language-create.component.css']
})
export class LanguageCreateComponent {
  language: Language = { id: 0, name: '' };
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private languageService: LanguageService) {}

  onSubmit(form: NgForm): void {
    if (form.valid) {
      this.languageService.createLanguage(this.language).subscribe(
        (data) => {
          this.successMessage = 'Language created successfully!';
          form.resetForm();
        },
        (error) => this.errorMessage = error
      );
    }
  }
}
