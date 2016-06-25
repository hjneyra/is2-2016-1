'use strict';
import {Injectable, Inject} from 'angular2/core';
import {Http, Response, RequestOptions, Headers} from 'angular2/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';


@Injectable()
export class ArtistacrudService {

    constructor(@Inject(Http) private http: Http) {}


    save(name: string, genero: string, descripcion: string, pais: string, ciudad: string) {
      
        let headers = new Headers({ 'Content-Type': 'application/json', 'Accept': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        
        
		return this.http.post('/saveArtista',
		 '{"name": "' + name + '", "genero": "' + genero + '", "descripcion": "' + descripcion + '", "pais": "' + pais + '", "ciudad": "' + ciudad + '"}', options)
		 
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
    

    
    update(){
    
    }
}
