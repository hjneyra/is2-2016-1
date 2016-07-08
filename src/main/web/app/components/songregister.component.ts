
import {Component, Inject} from 'angular2/core';
import {Router, ROUTER_DIRECTIVES} from 'angular2/router';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {SongregisterService} from '../service/songregister.service';

@Component({
    templateUrl: 'app/html/songregister.component.html',
    providers: [SongregisterService],
    directives: [CORE_DIRECTIVES, RouterLink]
})
export class SongregisterComponent {
	
    constructor( @Inject(SongregisterService) private songregisterService: SongregisterService,
        private router: Router) { }
 	data:Object = {};

    fromSubmit(){
        this.songregisterService.register(this.data.name,this.data.author,this.data.album,
            this.data.url).subscribe((result) => {
                this.router.navigate(['HomePage']);
            });
    }
}
