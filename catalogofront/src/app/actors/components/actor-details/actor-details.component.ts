import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ActorService } from '../../services/actor.service';
import { Actor } from '../../models/actor.model';

@Component({
  selector: 'app-actor-details',
  templateUrl: './actor-details.component.html',
  styleUrls: ['./actor-details.component.css']
})
export class ActorDetailsComponent implements OnInit {
  actor: Actor | null = null;
  errorMessage: string | null = null;

  constructor(private actorService: ActorService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id')!;
    this.fetchActorDetails(id);
  }

  fetchActorDetails(id: number): void {
    this.actorService.getActorById(id).subscribe(
      (data) => {
        this.actor = data;
        this.errorMessage = null;
      },
      (error) => {
        this.actor = null;
        this.errorMessage = 'Actor not found';
        console.error('Error fetching actor details', error);
      }
    );
  }
}
