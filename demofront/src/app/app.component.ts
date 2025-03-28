import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  :
  imports: [CommonModule, RouterOutlet, NotificationComponent, DemosComponent, ],
})

@Component({
  :
  imports: [CommonModule, RouterOutlet, NotificationComponent,],
})

@Component({
  :
  imports: [CommonModule, RouterOutlet, NotificationModalComponent, DemosComponent],
})

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title: string = 'world';
}

