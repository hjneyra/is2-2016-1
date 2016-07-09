package ucsp.is2.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ucsp.is2.model.Usuario;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.service.LoginService;
/*
class Log_Login {
	public String email;
	public String password;
};
*/
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public HttpEntity<Usuario> login(@RequestBody Usuario log, HttpServletRequest request, HttpSession session) {
		Usuario usuario = loginService.login(log.getEmail(), log.getPassword());
		if(usuario==null){
			return (HttpEntity<Usuario>) HttpEntity.EMPTY;
		}

		session.invalidate();
		HttpSession newSession = request.getSession();
		newSession.setAttribute("username", log.getEmail());

		return new HttpEntity<Usuario>(usuario);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public Usuario me(HttpSession session) {
		Usuario user = usuarioRepository.findByEmail(session.getAttribute("username").toString());

		return user;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public Boolean logout(HttpSession session) {
		session.invalidate();

		return Boolean.TRUE;
	}
}
