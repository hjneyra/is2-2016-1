'use strict';

import {Component, Inject} from 'angular2/core';
import {Router, ROUTER_DIRECTIVES} from 'angular2/router';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {UsuarioService} from '../service/usuario.service';
import {UnsubscribeService} from '../service/unsubscribe.service';

@Component({
    selector: 'test',
    templateUrl: 'app/html/usuario.component.html',
    providers: [UsuarioService, UnsubscribeService],
    directives: [CORE_DIRECTIVES, RouterLink]
})
export class UsuarioComponent {

    private jsonResponse: string;
    private message: string;
    private usuarios: Array<any>;

    constructor(@Inject(UnsubscribeService) private unsubscribeService: UnsubscribeService,
        @Inject(UsuarioService) private usuarioService: UsuarioService,
        private router: Router) {}
    data:Object = {};

    ngOnInit() {
        this.usuarioService.getUsuarios().subscribe(
            data => {this.jsonResponse = JSON.stringify(data),
                     this.message = data[0].email, this.usuarios = data}
        );
    }
    fromSubmit(){
        this.unsubscribeService.unsubscribe(this.usuarios[0].id).subscribe((result) => {
                this.router.navigate(['HomePage']);
            });
    }
}
