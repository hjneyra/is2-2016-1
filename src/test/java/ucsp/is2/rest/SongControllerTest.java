package ucsp.is2.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Random;
import ucsp.is2.MusicOnlineApplication;
import ucsp.is2.model.Song;
import ucsp.is2.model.Usuario;
import ucsp.is2.repository.SongRepository;
import ucsp.is2.service.LoginService;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.rest.UsuarioController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class SongControllerTest {

	Long id;
	
	@Autowired
	SongController songController;
	
	
	@Test
	public void testSaveSong() {
		Song song = new Song();
		song.setName("Bring me to Life");
		song.setAuthor("evanescence");
		song.setAlbum("Fallen");
		songController.save(song);

		Assert.assertNotNull(song.getId());
	}
	
	
	@Test
	public void Testscore() {
		
		Log_Score sc= new Log_Score();
		
		sc.id="1";
		sc.score="5";
		Song res= songController.score(sc);
		Assert.assertTrue("Esta mal el primer test de testscore",res==null);
		
		sc.id="55";
		sc.score="5";
		res= songController.score(sc);
		Assert.assertTrue("la segunda prueba deberia retornar un no nulo",res!=null);
		
	}


}
