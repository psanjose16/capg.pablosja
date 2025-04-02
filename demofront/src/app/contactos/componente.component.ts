import { DatePipe } from "@angular/common";
import { Component, forwardRef, OnDestroy, OnInit } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { TypeValidator } from "../../lib/my-core/directives/mis-validaciones.directive";
import { ContactosViewModelService } from "./contactos.view.model.service";

@Component({
  selector: 'app-contactos',
  templateUrl: './tmpl-anfitrion.component.html',
  styleUrls: ['./componente.component.css'],
  imports: [
  forwardRef(() => ContactosAddComponent),
  forwardRef(() => ContactosEditComponent),
  forwardRef(() => ContactosViewComponent),
  forwardRef(() => ContactosListComponent),
  ],
  })
  export class ContactosComponent implements OnInit, OnDestroy {
   constructor(protected vm: ContactosViewModelService) { }
   public get VM(): ContactosViewModelService { return this.vm; }
   ngOnInit(): void { this.vm.list(); }
  ngOnDestroy(): void { this.vm.clear(); }
  }

  @Component({
    selector: 'app-contactos-list',
    templateUrl: './tmpl-list.component.html',
    styleUrls: ['./componente.component.css'],
   })
   export class ContactosListComponent implements OnInit, OnDestroy {
    constructor(protected vm: ContactosViewModelService) { }
    public get VM(): ContactosViewModelService { return this.vm; }
    ngOnInit(): void {
        console.log('ContactosAddComponent initialized');
    }
   ngOnDestroy(): void { this.vm.clear(); }
   }

   @Component({
    selector: 'app-contactos-add',
    templateUrl: './tmpl-form.component.html',
   styleUrls: ['./componente.component.css'],
   imports: [FormsModule, TypeValidator, ErrorMessagePipe]
   })
   export class ContactosAddComponent implements OnInit {
    constructor(protected vm: ContactosViewModelService) { }
    public get VM(): ContactosViewModelService { return this.vm; }
    ngOnInit(): void { }
   }
   @Component({
    selector: 'app-contactos-edit',
    templateUrl: './tmpl-form.component.html',
    styleUrls: ['./componente.component.css'],
   imports: [FormsModule, TypeValidator, ErrorMessagePipe]
   })
   export class ContactosEditComponent implements OnInit, OnDestroy {
    constructor(protected vm: ContactosViewModelService) { }
    public get VM(): ContactosViewModelService { return this.vm; }
    ngOnInit(): void { }
    ngOnDestroy(): void { }
   }
   @Component({
    selector: 'app-contactos-view',
    templateUrl: './tmpl-view.component.html',
    styleUrls: ['./componente.component.css'],
   imports: [DatePipe]
   })
   export class ContactosViewComponent implements OnInit, OnDestroy {
    constructor(protected vm: ContactosViewModelService) { }
    public get VM(): ContactosViewModelService { return this.vm; }
    ngOnInit(): void { }
    ngOnDestroy(): void { }
   }

   export const CONTACTOS_COMPONENTES = [
    ContactosComponent, ContactosListComponent, ContactosAddComponent,
    ContactosEditComponent, ContactosViewComponent,
   ];
