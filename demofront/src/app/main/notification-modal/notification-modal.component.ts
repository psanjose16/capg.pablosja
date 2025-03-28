import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
@Component({
  selector: 'app-notification-modal',
  standalone: true,
  imports: [NgClass],
  templateUrl: './notification-modal.component.html',
  styleUrls: ['./notification-modal.component.css']
})
export class NotificationModalComponent {
  constructor(private vm: NotificationService) {}

  public get VM() {
    return this.vm;
  }
}

    public get VM() { return this.vm; }
