import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ActorListComponent } from './components/actor-list/actor-list.component';
import { ActorDetailsComponent } from './components/actor-details/actor-details.component';
import { ActorFormComponent } from './components/actor-form/actor-form.component';

const routes: Routes = [
  { path: 'actors', component: ActorListComponent },
  { path: 'actors/:id', component: ActorDetailsComponent },
  { path: 'create-actor', component: ActorFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ActorsRoutingModule {}
