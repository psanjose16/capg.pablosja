import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActorListComponent } from './components/actor-list/actor-list.component';
import { ActorDetailsComponent } from './components/actor-details/actor-details.component';
import { ActorFormComponent } from './components/actor-form/actor-form.component';
import { ActorEditFormComponent } from './components/actor-edit-form/actor-edit-form.component';
import { ActorService } from './services/actor.service';

@NgModule({
  declarations: [],
  imports: [CommonModule, FormsModule, ActorListComponent, ActorDetailsComponent, ActorFormComponent, ActorEditFormComponent],
  providers: [ActorService],
  exports: [ActorListComponent, ActorDetailsComponent, ActorFormComponent, ActorEditFormComponent]
})
export class ActorsModule {}
