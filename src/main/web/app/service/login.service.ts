'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()

export class LoginService {
	private loggedIn = false;

    constructor(@Inject(Http) private http: Http) {
		this.loggedIn = !!localStorage.getItem('auth_token')
    }

    login(email: string, password: string) {
        let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
        let options = new RequestOptions({ headers: headers });
		return this.http.post('/login', '{"email": "' + email + '", "password": "' + password + '"}', options)
				.map((res: Response) => res.json())
				.map((res) => {
					// if (res.success) 
					// {
					// 	console.log("hallo");
					// 	localStorage.setItem('auth_token', res.auth_token);
					// 	this.loggedIn = true;
					// }
					localStorage.setItem('auth_token', res.auth_token);
					this.loggedIn = true;
					return res.success;
				});	
    }
	// logout() {
	// 	localStorage.removeItem('auth_token');
	// 	this.loggedIn = false;
	// }

	isLoggedIn() {
		return this.loggedIn;
	}
}

