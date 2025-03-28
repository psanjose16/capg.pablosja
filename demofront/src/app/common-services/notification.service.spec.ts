import { TestBed } from '@angular/core/testing';

import { NotificationService } from './notification.service';
export enum NotificationType { error = 'error', warn = 'warn', info = 'info', log
  = 'log' }

  export class Notification {
    constructor(private id: number, private message: string,
    private type: NotificationType) {}
    public get Id() { return this.id; }
    public get Message() { return this.message; }
    public get Type() { return this.type; }
   }

describe('NotificationService', () => {
  let service: NotificationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotificationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
