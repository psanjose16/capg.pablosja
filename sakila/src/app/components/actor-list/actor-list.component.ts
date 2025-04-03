import { ActorService } from '../../services/actor.service';
import { Component, Inject, OnInit } from '@angular/core';
import { Actor } from 'src/app/model/actor';
import {FormGroup} from '@angular/forms';

@Component({
  selector: 'app-actor-list',
  templateUrl: './actor-list.component.html',
  styleUrls: ['./actor-list.component.css']
})
export class ActorListComponent implements OnInit {

  actorFormGroup!: FormGroup;

  actorList: Actor[] = [];

  constructor(@Inject(ActorService) private actorService: ActorService) { }

  ngOnInit(): void {
    this.actorService.getAllActor().subscribe((data: Actor[]) => {
      this.actorList = data;
    });
  }

}
