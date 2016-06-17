package ucsp.is2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ucsp.is2.model.Artista;
import ucsp.is2.model.Song;
import ucsp.is2.repository.ArtistaRepository;
import ucsp.is2.repository.SongRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class MusicOnlineApplicationTests {
	@Autowired
	SongRepository songRepository;

	
	@Autowired
	ArtistaRepository artistaRepository;
	
	@Test
	public void testSaveSong() {
		Song song = new Song();
		song.setName("My Song");
		songRepository.save(song);
		Assert.assertNotNull(song.getId());
	}


	@Test
	public void saveArtista() {
		Artista artista = new Artista();
		artista.setName("Luis");
		artistaRepository.save(artista);
		Assert.assertNotNull(artista.getId());
		
	}

}
