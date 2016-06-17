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

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Artista save(@RequestBody Log_Artista log) {
		Artista Artista = repository.findByName(log.name);
		if(Artista == null){
			Artista = new Artista(log.name,log.genero,log.descripcion,log.ciudad,log.pais);
			repository.save(Artista);
			return Artista;
		}
		return null;
	}

	@RequestMapping(value = "artistas", method = RequestMethod.GET)
	public List<Artista> listAll() {
		return repository.findAll();
	}

	@RequestMapping(value = "artista/{id}")
	public HttpEntity<Artista> listAll(@PathVariable Long id) {
		Artista Artista = repository.findById(id);
		if (Artista == null) {
			return (HttpEntity<Artista>) HttpEntity.EMPTY;
		}
		return new HttpEntity<Artista>(Artista);
	}

}