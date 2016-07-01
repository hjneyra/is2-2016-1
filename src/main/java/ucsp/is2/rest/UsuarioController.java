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

import ucsp.is2.model.Usuario;
import ucsp.is2.repository.UsuarioRepository;


class Log_Usuario {
	public String name;
	public String last_name;
	public String email;
	public String password;
};

@RestController
public class UsuarioController {

	@Autowired
	UsuarioRepository repository;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public Usuario save(@RequestBody Usuario log) {
		Usuario usuario = repository.findByEmail(log.getEmail());
		if(usuario != null){
			/*usuario = new Usuario(log.name,log.last_name,log.email,log.password);
			repository.save(usuario);*/
			return null;
		}
		return repository.save(log);
	}

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
