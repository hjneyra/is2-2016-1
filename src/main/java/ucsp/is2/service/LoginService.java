package ucsp.is2.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.model.Usuario;

@Service
public class LoginService {

	@Autowired
	UsuarioRepository userRepository;

	@Transactional
	public Usuario login(String email, String password){
		Usuario usuario = userRepository.findByEmailAndPassword(email, password);
		if (usuario == null){
			// usuario = new Usuario();
			// usuario.setEmail(email);
			// usuario.setPassword(password);
			// userRepository.save(usuario);
			return null;
		}
		System.out.println(usuario.getEmail());	
		return usuario;
	}

}
