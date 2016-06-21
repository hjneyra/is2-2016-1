'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()

export class UnsubscribeService {
    private loggedOn = false;

    constructor(@Inject(Http) private http: Http) {
        this.loggedOn = !!localStorage.getItem('auth_token')
    }

    unsubscribe(id: string) {
        let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/unsubscribe','{"id": "' + id + '"}',options)
                .map((res:Response) => res.json())
                .map((res) => {
                    localStorage.setItem('auth_token', res.auth_token);
                    this.loggedOn = true;
                    return res.success;
                });
    }
    isLoggedOn() {
        return this.loggedOn;
    }
}
