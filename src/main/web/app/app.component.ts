'use strict';

import {Component} from 'angular2/core';
import {RouteConfig, ROUTER_DIRECTIVES} from 'angular2/router';
import {HelloComponent} from './hello/hello.component';
import {HomeComponent} from './home/home.component';
import {ArtistaComponent} from './artista/artista.component';
import {ArtistacreateComponent} from './artista/artistacreate.component';


@Component({
    selector: 'music-online',
    template: '<router-outlet></router-outlet>',
    directives: [ROUTER_DIRECTIVES]
})
@RouteConfig([
        {path: '/home', name: 'HomePage', component: HomeComponent},
        {path: '/artista', name: 'ArtistaPage', component: ArtistaComponent},
        {path: '/artistacrear', name: 'ArtistaCreatePage', component: ArtistacreateComponent},
        
        {path: '/hello', name: 'HelloPage', component: HelloComponent},
        {path: '/**', redirectTo: ['HomePage']}
])
export class AppComponent {
}
