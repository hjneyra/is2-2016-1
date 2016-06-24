package ucsp.is2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ucsp.is2.model.Song;

@RestController
public class ObtainMusicController {
	
	@Autowired
	private Song songs;
	
	@RequestMapping(value="/song/get/json", method=RequestMethod.GET)
	public ResponseEntity<Song> getSong(@PathVariable("id") long id) {
		Song song = songs.findById(id);
		if (song == null) {
			System.out.println("Song" + id + "not found");
			return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Song>(song, HttpStatus.OK);	
	}
}
