'use strict';

import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class ArtistaService {

    constructor(@Inject(Http) private http: Http) {}

    getArtistas() {
        return this.http.get('/artistas')
            .map((res:Response) => res.json());
    }
    
    del_artista(id:string){

       let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        
        
		return this.http.post('/delArtista',
		 '{"id": "' + id + '"}', options)
		 
				.map((res: Response) => res.json())
				.map((res) => {
				console.log("resultados\n");
				console.log(res);

					if(res.id)
						return true;
					else
						return false;
				});

    
    }
}
