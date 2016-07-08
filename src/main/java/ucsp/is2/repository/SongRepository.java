package ucsp.is2.repository;

import org.springframework.data.repository.Repository;
import java.util.List;

import ucsp.is2.model.Song;

public interface SongRepository extends Repository<Song, Long> {
	public Song save(Song song);
	public Song findById(Long id);
	public List<Song> findAll();
}
