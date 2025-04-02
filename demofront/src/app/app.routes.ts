import { UrlSegment, Routes } from '@angular/router';
import { DemosComponent } from './ejemplos';
import { FormulariosComponent } from './ejemplos/formularios/formularios.component';
import { HomeComponent, PageNotFoundComponent } from './main';
import { LoginFormComponent, RegisterUserComponent } from './security';
import { ContactosListComponent, ContactosAddComponent, ContactosEditComponent, ContactosViewComponent } from './contactos';

export function graficoFiles(url: UrlSegment[]) {
  return url.length === 1 && url[0].path.endsWith('.svg') ? ({consumed: url}) : null;
}

export const routes: Routes = [
  {path: '', component: HomeComponent, pathMatch: 'full' },
  {path: 'inicio', component: HomeComponent, },
  {path: 'demos', component: DemosComponent, title: 'Demostración'},
  {path: 'esto/es/un/formulario', component: FormulariosComponent},
  {path: 'personas', component: FormulariosComponent},
  {path: 'personas/add', component: FormulariosComponent},
  {path: 'personas/:id/edit', component: FormulariosComponent},
  {path: 'personas/:id', component: FormulariosComponent},
  {path: 'personas/:id/:kk', component: FormulariosComponent},
  {path: 'pepito/grillo', redirectTo: '/persona/2'},
  {path: 'contactos', children: [
    { path: '', component: ContactosListComponent},
    { path: 'add', component: ContactosAddComponent},
    { path: ':id/edit', component: ContactosEditComponent},
    { path: ':id', component: ContactosViewComponent},
    { path: ':id/:kk', component: ContactosViewComponent},
   // {path: '', component: FormulariosComponent},
  //  {path: 'add', component: FormulariosComponent},
   // {path: ':id/edit', component: FormulariosComponent},
  //  {path: ':id', component: FormulariosComponent},
   // {path: ':id/:kk', component: FormulariosComponent},
  ]},
  {
    path: 'contactos', loadChildren: () => import('./contactos/modulo.module').then(mod => mod.ContactosModule), title: 'contactos',
    /*canActivate: [AuthCanActivateFn]*/
  },
  { path: 'login', component: LoginFormComponent },
  { path: 'registro', component: RegisterUserComponent },
  {matcher: graficoFiles, loadComponent: () => import('./ejemplos/grafico-svg/grafico-svg.component') },
  {path: 'config', loadChildren: () => import('./config/config.module') },
  {path: '404.html', component: PageNotFoundComponent},
  {path: '**', component: PageNotFoundComponent}
];
