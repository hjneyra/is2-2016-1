package ucsp.is2.rest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Random;

import ucsp.is2.MusicOnlineApplication;
import ucsp.is2.model.Artista;
import ucsp.is2.model.Song;
import ucsp.is2.model.Usuario;
import ucsp.is2.repository.SongRepository;
import ucsp.is2.service.LoginService;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.rest.UsuarioController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class ArtistaControllerTest {

	Long id;
	
	@Autowired
	ArtistaController artistaController;
	
	
	@Test
	public void TestSaveArtista() {
		
		Log_Artista artista = new Log_Artista();
		
		artista.name="NEK";
		artista.genero="Rock latino";
		artista.descripcion="Cantante, compositor, productor.";
		artista.ciudad="Sassuolo";
		artista.pais="Italia";
		
		Assert.assertNotNull(artistaController.saveArtista(artista));
	
	}
	
	
	@Test
	public void TestListArtista() {
		
		HttpEntity<Artista> artista= artistaController.listAll(1L);
		Assert.assertTrue("la segunda prueba deberia retornar un no nulo",artista!=null);
		
	}


}
