package ucsp.is2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ucsp.is2.repository.SongRepository;

@RestController
public class ObtainMusicController {
	
	@Autowired
	private SongRepository songs;
	
	@RequestMapping(value="/song/get/json", method=RequestMethod.GET)
	public ResponseEntity<SongRepository> getSong(@PathVariable Long id) {
		SongRepository song = (SongRepository) songs.findById(id);
		if (song == null) {
			System.out.println("Song" + id + "not found");
			return new ResponseEntity<SongRepository>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SongRepository>(song, HttpStatus.OK);	
	}
}

