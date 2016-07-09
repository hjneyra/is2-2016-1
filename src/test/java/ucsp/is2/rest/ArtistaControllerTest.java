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

import java.util.List;
import java.util.Random;

import ucsp.is2.MusicOnlineApplication;
import ucsp.is2.model.Artista;
import ucsp.is2.model.Song;
import ucsp.is2.model.Usuario;
import ucsp.is2.repository.ArtistaRepository;
import ucsp.is2.repository.SongRepository;
import ucsp.is2.service.LoginService;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.rest.UsuarioController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MusicOnlineApplication.class)
@WebAppConfiguration
public class ArtistaControllerTest {
	
	Long id;
	Long idartist;
	String name;
	
	@Autowired
	ArtistaRepository artistaRepository;
	
	@Autowired
	ArtistaController artistaController;
	
	@Test
	public void ArtistaTestSaveName()
	{	
		Log_Artista artista = new Log_Artista();
		artista.name="Juanes";
		artistaController.saveArtista(artista);
		Assert.assertNotNull(artista.name);
	}

	@Test
	public void DeleteArtistaTest()
	{	
		Log_Artista artista = new Log_Artista();
		artista.name="Jose";
		artistaController.delArtista(idartist);
		Assert.assertNotNull(idartist);
	}
	
	@Test
	public void EditArtistaTest()
	{	
		Log_Artista artista = new Log_Artista();
		artista.name="Juanes";
		artistaRepository.findById(id);
		artistaController.edit_artista(id);
		Assert.assertNotNull(id);
	}
	
	@Test
	public void ListArtistaTest()
	{	
		artistaController.listAll();
		Assert.assertFalse(null,true);
	}
	
}
