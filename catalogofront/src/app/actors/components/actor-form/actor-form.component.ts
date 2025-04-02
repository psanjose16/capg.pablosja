import { Component, Inject } from '@angular/core';
import { ActorService } from '../../services/actor.service';
import { Actor } from '../../models/actor.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-actor-form',
  templateUrl: './actor-form.component.html',
  styleUrls: ['./actor-form.component.css']
})
export class ActorFormComponent {
  actor: Actor = {
    actorId: 0,
    firstName: '',
    lastName: ''

  };
  successMessage: string | null = null;
  errorMessage: string | null = null;

  constructor(@Inject(ActorService) private actorService: ActorService, private router: Router) {}

  createActor(): void {
    this.actorService.createActor(this.actor).subscribe(
      () => {
        this.successMessage = 'Actor created successfully';
        this.errorMessage = null;
        this.router.navigate(['/actors']);
      },
      (error) => {
        this.successMessage = null;
        this.errorMessage = 'Error creating actor: ' + error.message;
        console.error('Error creating actor', error);
      }
    );
  }
}
