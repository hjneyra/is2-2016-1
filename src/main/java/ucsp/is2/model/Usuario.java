package ucsp.is2.model;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinTable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import ucsp.is2.model.Song;

@Entity
public class Usuario {

    @Id
    @SequenceGenerator(name="USUARIO_ID_GENERATOR", sequenceName="USUARIO_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
    private Long id;
    private String name;
    private String last_name;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(name="usuario_usuario")
    private Collection<Usuario> usuarios;

    @OneToMany
    private Collection<Song> play_list;

    public Usuario (String name, String last_name,String email,String password){
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }
    public Usuario(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return last_name;
    }

    public void setLastname(String last_name) {
        this.last_name = last_name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
