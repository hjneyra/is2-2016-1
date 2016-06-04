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
    private username: string;
    private password: string;
    constructor( @Inject(LoginService) private loginService: LoginService) {}
    data:Object = {};
    fromSubmit(){
        console.log(this.data);
        if (this.data.email == "prueba@test.com" && this.data.password== "123456"){
            console.log("Hello");
            this.loginService.login(this.data.username, this.data.password);
        }
        else{
            console.log("Who are you?");
        }
    }

}
