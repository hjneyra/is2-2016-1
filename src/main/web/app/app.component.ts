'use strict';

import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {HelloComponent} from './hello/hello.component';
import {HomeComponent} from './home/home.component';
import {AdminComponent} from './components/admin.component';
import {ArtistaComponent} from './artista/artista.component';
import {ArtistacreateComponent} from './artista/artistacreate.component';

import {Alert} from 'ng2-bootstrap/ng2-bootstrap';



@Component({
    selector: 'music-online',
    template: '<router-outlet></router-outlet>',
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
        {path: '/home', name: 'HomePage', component: HomeComponent},
        {path: '/hello', name: 'HelloPage', component: HelloComponent},
        {path: '/artista', name: 'ArtistaPage', component: ArtistaComponent},
        {path: '/artistacrear', name: 'ArtistaCreatePage', component: ArtistacreateComponent},
        {path: '/usuario', name: 'Usuario', component: UsuarioComponent},
        {path: '/login', name: 'Login', component: LoginComponent},
        {path: '/registro', name: 'Register', component: RegisterComponent},
        {path: '/**', redirectTo: ['HomePage']}
])
export class AppComponent {
}
