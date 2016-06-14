'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RegisterService {
    private loggedUp = false;

    constructor( @Inject(Http) private http: Http) {
		this.loggedUp = !!localStorage.getItem('auth_token')
    }
    
    register(name: string,last_name: string,email: string,password: string) {
	    let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
	    let options = new RequestOptions({ headers: headers });
        return this.http.post('/register','{"name": "' + name + '","last_name": "' + last_name + '","email": "' + email + '", "password": "' + password + '"}',options)
            .map((res:Response) => res.json())
			.map((res) => {
				localStorage.setItem('auth_token', res.auth_token);
				this.loggedUp = true;
				return res.success;
			});
    }
	isLoggedUn() {
		return this.loggedUp;
	}
}