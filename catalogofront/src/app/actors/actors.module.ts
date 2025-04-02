import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActorListComponent } from './components/actor-list/actor-list.component';
import { ActorService } from './services/actor.service';

@NgModule({
  declarations: [],
  imports: [CommonModule, ActorListComponent],
  providers: [ActorService],
  exports: [ActorListComponent]
})
export class ActorsModule {}
