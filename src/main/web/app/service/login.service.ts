'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response} from 'angular2/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class LoginService {

    constructor(@Inject(Http) private http: Http) {}

    login(email: string, password: string) {
        return this.http.post('/login', '{"email": "' + email + '", "password": "' + password + '"}');
            .map((res:Response) => res.json());
    }
}
