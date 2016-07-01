package ucsp.is2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;




//import org.hamcrest.Matchers.containsString; 
import java.util.Random;

import ucsp.is2.model.Song;
import ucsp.is2.model.Usuario;
import ucsp.is2.repository.SongRepository;
import ucsp.is2.service.LoginService;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.rest.UsuarioController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class MusicOnlineApplicationTests {
	@Autowired
	SongRepository songRepository;

	@Autowired
	LoginService loginService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	Long id;
	
	@Autowired
	UsuarioController cu;
	
	
	
	private MockMvc mockMvc;

	
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

		
		Usuario user = new Usuario();
		Random ram= new Random();
		user.setPassword("123");
		user.setEmail("ework@gmail.com"+ram.nextFloat());
		user.setLastname("Team2");
		user.setName("ework");
		
		usuarioRepository.save(user);
		id=user.getId();
		Assert.assertNotNull(id);

		Usuario user2 = usuarioRepository.findById(id);
		
		Usuario usuario =loginService.login(user2.getEmail(),user2.getPassword());
		
		Assert.assertNotNull(usuario);
		
		Usuario usuario1 =loginService.login("luis","12345");
		Assert.assertNull(usuario1);
		
		
		//Usuario user3 = new Usuario("ework","ework_last_name","ework@gmail.com"+ram.nextFloat(),"123");
		//Assert.assertNotNull(user3);
	}

	@Test
	public void UsuarioTest()
	{
		//UsuarioController cu = new UsuarioController();
		
		/*cu.Log_Usuario c = new cu.Log_Usuario();
		c.name="ework";
		c.last_name="ework lastname";
		c.email="ework@gmail.com";
		c.password="123";
		Usuario res= cu.save(c);*/
		
		
		HttpEntity<Usuario> user = cu.listAll(1L);
		Assert.assertNotNull(user);

	}

}
