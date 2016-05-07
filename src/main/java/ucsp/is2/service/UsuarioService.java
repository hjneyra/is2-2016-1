package ucsp.is2.service;

import org.springframework.stereotype.Service;
import java.util.Collection;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.model.Usuario;
public class UsuarioService {
	public Collection<Usuario> getAll() {
		UsuarioRepository usuarios= new UsuarioRepository();
		return usuarios.findAll();
	}
}
