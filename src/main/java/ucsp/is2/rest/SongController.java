package ucsp.is2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import ucsp.is2.model.Song;
import ucsp.is2.repository.SongRepository;


class Log_Score {
	public String id;
	public String score;
};
class Log_Song {
	public String id;
};

@RestController
public class SongController {

	@Autowired
	SongRepository repository;

	@RequestMapping(value = "/song", method = RequestMethod.GET)
	public List<Song> songById() {
		return repository.findAll();
	}

	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public Song score(@RequestBody Log_Score log) {
		Long id = Long.parseLong(log.id);
		Song song = repository.findById(id);
		if(song == null){
			return null;
		}
		int score = Integer.parseInt(log.score);
		int new_score = song.getScore() * song.getNscore();
		new_score = new_score + score;
		new_score = new_score / (song.getNscore()+1);
		song.setNscore(song.getNscore()+1);
		song.setScore(new_score);
		repository.save(song);
		return song;
	}

}
