'use strict';

import {Component, Inject} from 'angular2/core';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {LoginService} from '../service/login.service';

@Component({
    selector: 'test',
    templateUrl: 'app/html/login.component.html',
    providers: [LoginService],
    directives: [CORE_DIRECTIVES, RouterLink]
})
export class LoginComponent {

    private jsonResponse: string;
    private message: string;

    constructor(@Inject(LoginService) private loginService: LoginService) {}

    ngOnInit() {
        this.loginService.getTest().subscribe(
            data => {this.jsonResponse = JSON.stringify(data),
                     this.message = data.test.message},
            () => console.log('../test/get/json returned: \n' + this.jsonResponse)
        );
    }
}
