'use strict';
import {Component, Inject} from 'angular2/core';
import {Router, ROUTER_DIRECTIVES} from 'angular2/router';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {LoginService} from '../service/login.service';
// @Component({
//     selector: 'test',
//     templateUrl: 'app/html/login.component.html',
//     providers: [LoginService],
//     directives: [CORE_DIRECTIVES, RouterLink]
// })

@Component({
    templateUrl: 'app/html/login.component.html',
    providers: [LoginService],
    directives: [CORE_DIRECTIVES, RouterLink]
})


export class LoginComponent {
    private email: string;
    private password: string;
    constructor(
        @Inject(LoginService) private loginService: LoginService,
        private router: Router) { }
    /*
    el data:Object{} se usa para poder captura los datos del formulario de login.Component.html
    */
    data:Object = {};
    /*
    fromSubmit se refiere a lo que se va ejecutar al hacer click en el boton definido en login.Component.html
    */
    fromSubmit() {
        console.log(this.data);
        this.loginService.login(this.data.email, this.data.password).subscribe((result) => {
            this.router.navigate(['Usuario']);
        });
    }
}
