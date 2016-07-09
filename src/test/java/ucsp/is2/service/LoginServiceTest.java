package ucsp.is2.service;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ucsp.is2.MusicOnlineApplication;
import ucsp.is2.model.Usuario;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.service.LoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class LoginServiceTest {
	
@Autowired
	LoginService loginService;
	Long id;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	
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

}
