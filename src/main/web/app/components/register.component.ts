'use strict';

import {Component, Inject} from 'angular2/core';
import {Router, ROUTER_DIRECTIVES} from 'angular2/router';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {RegisterService} from '../service/register.service';

@Component({
    templateUrl: 'app/html/register.component.html',
    providers: [RegisterService],
    directives: [CORE_DIRECTIVES, RouterLink]
})
export class RegisterComponent {
	
    constructor(@Inject(RegisterService) private registerService: RegisterService) {}
 	data:Object = {};

    fromSubmit(){
        this.registerService.register(this.data.name,this.data.last_name,this.data.email,this.data.password).subscribe(
          data => { },
            () => { })
    };
    
}
