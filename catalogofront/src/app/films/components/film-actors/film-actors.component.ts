import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActorDTO } from '../../../actors/models/actor.model';
import { FilmService } from '../../services/film.service';

@Component({
  selector: 'app-film-actors',
  templateUrl: './film-actors.component.html',
  styleUrls: ['./film-actors.component.css']
})
export class FilmActorsComponent implements OnInit {
  actors: ActorDTO[] = [];
  errorMessage: string = '';
  filmId!: number;

  constructor(private filmService: FilmService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.filmId = +this.route.snapshot.paramMap.get('id');
    this.loadActors();
  }

  loadActors(): void {
    this.filmService.getActorsByFilmId(this.filmId).subscribe(
      (data) => this.actors = data,
      (error) => this.errorMessage = error
    );
  }
}
