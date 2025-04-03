// language-films.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmShortDTO } from '../../../films/models/film.model';
import { LanguageService } from '../../services/language.service';

@Component({
  selector: 'app-language-films',
  templateUrl: './language-films.component.html',
  styleUrls: ['./language-films.component.css']
})
export class LanguageFilmsComponent implements OnInit {
  films: FilmShortDTO[] = [];
  errorMessage: string = '';
  languageId!: number;

  constructor(private languageService: LanguageService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.languageId = +this.route.snapshot.paramMap.get('id');
    this.loadFilms();
  }

  loadFilms(): void {
    this.languageService.getFilmsByLanguageId(this.languageId).subscribe(
      (data) => this.films = data,
      (error) => this.errorMessage = error
    );
  }
}
