'use strict';

import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';

import {LoginComponent} from './components/login.component';
import {HelloComponent} from './components/hello.component';
import {UsuarioComponent} from './components/usuario.component';
import {RegisterComponent} from './components/register.component';
import {HomeComponent} from './home/home.component';
import {AdminComponent} from './components/admin.component';
import {Alert} from 'ng2-bootstrap/ng2-bootstrap';

@Component({
    selector: 'music-online',
    template: '<router-outlet></router-outlet>',
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
    {path: '/home', name: 'HomePage', component: HomeComponent},
    {path: '/hello', name: 'HelloPage', component: HelloComponent},
    {path: '/usuario', name: 'Usuario', component: UsuarioComponent},
    {path: '/login', name: 'Login', component: LoginComponent},
    {path: '/registro', name: 'Register', component: RegisterComponent},
    {path: '/**', redirectTo: ['HomePage']}
])
export class AppComponent {
}
