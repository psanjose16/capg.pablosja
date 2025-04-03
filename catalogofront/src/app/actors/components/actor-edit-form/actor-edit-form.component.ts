import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ActorService } from '../../services/actor.service';
import { Actor } from '../../models/actor.model';

@Component({
  selector: 'app-actor-edit-form',
  templateUrl: './actor-edit-form.component.html',
  styleUrls: ['./actor-edit-form.component.css']
})
export class ActorEditFormComponent implements OnInit {
  actor: Actor | null = null;
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(private actorService: ActorService, private route: ActivatedRoute, private router: Router) {}

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

  updateActor(): void {
    if (this.actor) {
      this.actorService.updateActor(this.actor.actorId, this.actor).subscribe(
        () => {
          this.successMessage = 'Actor updated successfully';
          this.errorMessage = null;
          this.router.navigate(['/actors']);
        },
        (error) => {
          this.successMessage = null;
          this.errorMessage = 'Error updating actor: ' + error.message;
          console.error('Error updating actor', error);
        }
      );
    }
  }
}
