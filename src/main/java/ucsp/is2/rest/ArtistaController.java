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

import ucsp.is2.model.Artista;
import ucsp.is2.repository.ArtistaRepository;


class Log_Artista {
	public String name;
	public String genero;
	public String descripcion;
	public String ciudad;
	public String pais;
};

@RestController
public class ArtistaController {

	@Autowired
	ArtistaRepository repository;

	@RequestMapping(value = "/saveArtista", method = RequestMethod.POST)
	public HttpEntity<Artista> saveArtista(@RequestBody Log_Artista log) {
		System.out.println(log.name);
		Artista artista; //= repository.findByName(log.name);
		
		//if(Artista == null){
			artista = new Artista(log.name,log.genero,log.descripcion,log.ciudad,log.pais);
			repository.save(artista);
			//return Artista;
			return new HttpEntity<Artista>(artista);
		/*}
		return null;*/
	}
	
	@RequestMapping(value = "/delArtista", method = RequestMethod.POST)
	public HttpEntity<Artista> delArtista(@RequestBody Long idartista) {
		System.out.println(idartista);
		Artista artista; //= repository.findByName(log.name);
		
		//if(Artista == null){
			artista = repository.findById(idartista);
			repository.delete(artista);
			//return Artista;
			
			return new HttpEntity<Artista>(artista);
		/*}
		return null;*/
	}
	
	
	
	/*
	 * function listar usuarios llamada desde usuario en el frontEnd
	 * @author LuisAndia 
	 * */
	@RequestMapping(value = "artistas", method = RequestMethod.GET)
	public List<Artista> listAll() {
		return repository.findAll();
	}
	/*
	 * lista un usuario especifico ejm: usuario?id=1
	 * @author LuisAndia 
	 * */
	@RequestMapping(value = "artista/{id}")
	public HttpEntity<Artista> listAll(@PathVariable Long id) {
		Artista Artista = repository.findById(id);
		if (Artista == null) {
			return (HttpEntity<Artista>) HttpEntity.EMPTY;
		}
		return new HttpEntity<Artista>(Artista);
	}

}