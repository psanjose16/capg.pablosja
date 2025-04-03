import { Component, OnInit } from '@angular/core';
import { ActorService } from '../../services/actor.service';
import { Actor } from '../../models/actor.model';

@Component({
  selector: 'app-actor-list',
  templateUrl: './actor-list.component.html',
  styleUrls: ['./actor-list.component.css']
})
export class ActorListComponent implements OnInit {
  actors: Actor[] = [];
  mode: string = 'largo';
  page: number = 1;
  successMessage!: string;
  errorMessage!: string | null;

  constructor(private actorService: ActorService) {}

  ngOnInit(): void {
    this.fetchActors();
  }

  fetchActors(): void {
    this.actorService.getAllActors(this.mode, this.page).subscribe(
      (data) => {
        this.actors = data;
      },
      (error) => {
        console.error('Error fetching actors', error);
      }
    );
  }

  changeMode(newMode: string): void {
    this.mode = newMode;
    this.fetchActors();
  }

  nextPage(): void {
    this.page++;
    this.fetchActors();
  }

  previousPage(): void {
    if (this.page > 1) {
      this.page--;
      this.fetchActors();
    }
  }

  deleteActor(id: number): void {
    this.actorService.deleteActor(id).subscribe(
      () => {
        this.successMessage = 'Actor deleted successfully';
        this.errorMessage = null;
        this.fetchActors();
      },
      (error) => {
        console.error('Error deleting actor', error);
        this.errorMessage = 'Error deleting actor: ' + error.message;
      }
    );
  }
    retireActor(id: number): void {
      this.actorService.retireActor(id).subscribe(
        () => {
          this.successMessage = 'Actor retired successfully';
          this.errorMessage = null;
          this.fetchActors();
        },
        (error) => {
          console.error('Error retiring actor', error);
          this.errorMessage = 'Error retiring actor: ' + error.message;
        }
      );

  }
}
function retireActor(id: number, number: any) {
  throw new Error('Function not implemented.');
}

