import { Component, OnInit } from '@angular/core';
import { Language } from '../../models/language.model';
import { LanguageService } from '../../services/language.service';

@Component({
  selector: 'app-language-list',
  templateUrl: './language-list.component.html',
  styleUrls: ['./language-list.component.css']
})
export class LanguageListComponent implements OnInit {
  languages: Language[] = [];
  errorMessage: string = '';

  constructor(private languageService: LanguageService) {}

  ngOnInit(): void {
    this.loadLanguages();
  }

  loadLanguages(): void {
    this.languageService.getAllLanguages().subscribe(
      (data) => this.languages = data,
      (error) => this.errorMessage = error
    );
  }
}
