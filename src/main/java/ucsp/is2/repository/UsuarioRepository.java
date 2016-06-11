package ucsp.is2.repository;

import java.util.List;
import org.springframework.data.repository.Repository;
import ucsp.is2.model.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Long> {
	public Usuario findById(Long id);
	public Usuario findByEmailAndPassword(String email, String password);
	public List<Usuario> findAll();
	public Usuario findByEmail(String email);
	public void save(Usuario usuario);
}
