'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';

import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()

export class SongService {

    constructor(@Inject(Http) private http: Http) {}

    score(id: string, score: string) {
        let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        return this.http.post('/score','{"id": "' + id + '", "score": "' + score + '"}',options)
                .map((res:Response) => res.json())
                .map((res) => {
                    localStorage.setItem('auth_token', res.auth_token);
                    return res.success;
                });
    }
    getSongs() {
        return this.http.get('/song')
            .map((res:Response) => res.json());
    }
}