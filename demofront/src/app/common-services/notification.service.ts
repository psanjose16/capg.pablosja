import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';


@Injectable({ providedIn: 'root'})
export class NotificationService {
  public readonly NotificationType = NotificationType;
  private listado: Notification[] = [];

  constructor(private out: LoggerService) { }

  public get Listado(): Notification[]
  { return Object.assign([], this.listado); }
  public get HayNotificaciones() { return this.listado.length > 0; }

  public add(msg: string, type: NotificationType = NotificationType.error) {
    if (!msg || msg === '') {
    this.out.error('Falta el mensaje de notificación.');
    return;
    }
    const id = this.HayNotificaciones ?
    (this.listado[this.listado.length - 1].Id + 1) : 1;
    const n = new Notification(id, msg, type);
    this.listado.push(n);
    this.notificacion$.next(n);
    // Redundancia: Los errores también se muestran en consola
    if (type === NotificationType.error) {
    this.out.error(`NOTIFICATION: ${msg}`);
    }
    }

    public remove(index: number) {
      if (index < 0 || index >= this.listado.length) {
      this.out.error('Index out of range.');
      return;
      }
      this.listado.splice(index, 1);
      }

      public clear() {
        if (this.HayNotificaciones)
        this.listado.splice(0);
        }
      }

      @Injectable({ providedIn: 'root'})
export class NotificationService implements OnDestroy {

  private notificacion$ = new Subject<Notification>();
  public get Notificacion() { return this.notificacion$; }

  ngOnDestroy(): void {
    this.notificacion$.complete()
    }
  }
