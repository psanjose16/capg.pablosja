import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActorService } from '../services/actor.service';
import { Film } from '../models/film.model';

@Component({
  selector: 'app-actor-films',
  templateUrl: './actor-films.component.html',
  styleUrls: ['./actor-films.component.css']
})
export class ActorFilmsComponent implements OnInit {
  films: Film[] = [];
  errorMessage: string | null = null;

  constructor(private actorService: ActorService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.fetchActorFilms(id);
  }

  fetchActorFilms(id: number): void {
    this.actorService.getActorFilms(id).subscribe(
      (data) => {
        this.films = data;
        this.errorMessage = null;
      },
      (error) => {
        this.films = [];
        this.errorMessage = 'Actor not found';
        console.error('Error fetching actor films', error);
      }
    );
  }
}
