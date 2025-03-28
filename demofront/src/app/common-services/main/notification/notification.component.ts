import { Component } from '@angular/core';

@Component({
  :
  imports: [I18nSelectPipe]
  })
  export class NotificationComponent {

    constructor(private vm: NotificationService) { }

    public get VM() { return this.vm; }
  }
