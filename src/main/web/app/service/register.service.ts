'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class RegisterService {
    
    constructor(@Inject(Http) private http: Http) {}
    
    register(name: string,last_name: string,email: string,password: string) {
	    let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
	    let options = new RequestOptions({ headers: headers });
        return this.http.post('/register','{"name": "' + name + '","last_name": "' + last_name + '","email": "' + email + '", "password": "' + password + '"}',options)
            .map((res:Response) => res.json());
    }
}