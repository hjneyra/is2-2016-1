'use strict';

import {Component, Inject} from 'angular2/core';
import {Router, ROUTER_DIRECTIVES} from 'angular2/router';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {ArtistacrudService} from '../service/artistacrud.service';




@Component({
    selector: 'test',
    templateUrl: 'app/artista/artistacrud.component.html',
    providers: [ArtistacrudService],
    directives: [CORE_DIRECTIVES, RouterLink]
})

export class ArtistacreateComponent {


    constructor(
        @Inject(ArtistacrudService) private artistacrudService: ArtistacrudService,
        private router: Router) { }

    data:any = {};
    /*
    fromSubmit se refiere a lo que se va ejecutar al hacer click en el boton definido en login.Component.html
    */
    saveArtistaSubmit() {
        console.log(this.data);
        this.artistacrudService.save(this.data.name, this.data.genero,this.data.descripcion,this.data.pais,this.data.ciudad).subscribe(
        (result) => {
        console.log(result);
        });
    }
}
