package ucsp.is2.service;

import org.springframework.stereotype.Service;
import java.util.List;
import ucsp.is2.repository.UsuarioRepository;
import ucsp.is2.model.Usuario;
@Service
public class UsuarioService {
	public List<Usuario> getAll() {
		UsuarioRepository usuarios = new UsuarioRepository();
		return usuarios.findAll();
	}
}
