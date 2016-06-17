package ucsp.is2.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import ucsp.is2.model.Artista;

public interface ArtistaRepository extends Repository<Artista, Long> {
	public Artista save(Artista artista);
	public Artista findById(Long id);
	public Artista findByName(String name);
	public List<Artista> findAll();
	
}
