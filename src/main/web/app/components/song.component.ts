'use strict';

import {Component, Inject} from 'angular2/core';
import {Router, ROUTER_DIRECTIVES} from 'angular2/router';
import {CORE_DIRECTIVES} from 'angular2/common';
import {Response} from 'angular2/http';
import {RouterLink} from 'angular2/router';
import {SongService} from '../service/song.service';

@Component({
    selector: 'test',
    templateUrl: 'app/html/song.component.html',
    providers: [SongService],
    directives: [CORE_DIRECTIVES, RouterLink]
})
export class SongComponent {

    private jsonResponse: string;
    private message: string;
    private song: Array<any>;

    constructor(@Inject(SongService) private songService: SongService,
        private router: Router) {}
    data:Object = {};

    ngOnInit() {
        this.songService.getSongs().subscribe(
            data => {this.jsonResponse = JSON.stringify(data),
                     this.message = data[0].score, this.song = data}
        );
    }
    fromSubmit(){
        let id: string = "1";
        this.songService.score( id , this.data.score).subscribe((result) => {
                this.router.navigate(['Song']);
            });
    }
}