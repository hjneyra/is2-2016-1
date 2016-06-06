package ucsp.is2.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ucsp.is2.model.Usuario;
import ucsp.is2.repository.UsuarioRepository;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@RequestMapping(value = "usuarios", method = RequestMethod.GET)
	public List<Usuario> listAll() {
		return repository.findAll();
	}

	@RequestMapping(value = "usuario/{id}")
	public HttpEntity<Usuario> listAll(@PathVariable Long id) {
		Usuario usuario = repository.findById(id);
		if (usuario == null) {
			return (HttpEntity<Usuario>) HttpEntity.EMPTY;
		}
		return new HttpEntity<Usuario>(usuario);
	}
}
