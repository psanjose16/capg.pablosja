import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActorListComponent } from './components/actor-list/actor-list.component';
import { ActorDetailsComponent } from './components/actor-details/actor-details.component';
import { ActorService } from './services/actor.service';

@NgModule({
  declarations: [],
  imports: [CommonModule, ActorListComponent, ActorDetailsComponent],
  providers: [ActorService],
  exports: [ActorListComponent, ActorDetailsComponent]
})
export class ActorsModule {}
