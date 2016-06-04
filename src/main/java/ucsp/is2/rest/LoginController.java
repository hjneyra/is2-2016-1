package ucsp.is2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ucsp.is2.model.Usuario;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.service.LoginService;

class Log {
	public String email;
	public String password;
};

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<Usuario> login(@RequestBody Log log) {
		Usuario usuario = loginService.login(log.email, log.password);
		if(usuario==null){
			return (HttpEntity<Usuario>) HttpEntity.EMPTY;
		}
//		System.out.println("Usuario: " + (usuario == null ? null : usuario.getEmail()));
		return new HttpEntity<Usuario>(usuario);
	}
}
