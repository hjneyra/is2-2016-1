package ucsp.is2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ucsp.is2.model.Song;
import ucsp.is2.model.Usuario;
import ucsp.is2.repository.SongRepository;
import ucsp.is2.service.LoginService;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class MusicOnlineApplicationTests {
	@Autowired
	SongRepository songRepository;

	@Autowired
	LoginService loginService;
	
	@Test
	public void testSaveSong() {
		Song song = new Song();
		song.setName("My Song");
		songRepository.save(song);
		Assert.assertNotNull(song.getId());
	}


	/*
	 * test unitario para verificar si el usuario ingresado
	 * es correcto
	 * */
	@Test
	public void testLogin() {

		 
		Usuario usuario =loginService.login("luis","1234");
		Assert.assertNotNull(usuario);
		
		Usuario usuario1 =loginService.login("luis","12345");
		Assert.assertNull(usuario1);
	}


}
