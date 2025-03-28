import { Component } from '@angular/core';

export class DemosComponent implements OnInit, OnDestroy {
  private suscriptor: Unsubscribable | undefined;
  ngOnInit(): void {
    this.suscriptor = this.vm.Notificacion.subscribe(n => {
    if (n.Type !== NotificationType.error) { return; }
    window.alert(`Suscripción: ${n.Message}`);
    this.vm.remove(this.vm.Listado.length - 1);
    });
    }
    ngOnDestroy(): void {
      if (this.suscriptor) {
      this.suscriptor.unsubscribe();
      }
      }
    }

@Component({
  selector: 'app-demos',
  imports: [],
  templateUrl: './demos.component.html',
  styleUrl: './demos.component.css'
})
export class DemosComponent {

  constructor(public vm: NotificationService) { }
}

