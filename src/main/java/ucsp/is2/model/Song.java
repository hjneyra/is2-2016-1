package ucsp.is2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Calendar;

@Entity
public class Song {

	@Id
	@SequenceGenerator(name="SONG_ID_GENERATOR", sequenceName="SONG_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SONG_ID_GENERATOR")
	private long id;

	public long Play_Counter=0;
	private int Month;

	public void Increase_Counter(){
		Play_Counter++;
	}

	private void Update_Month(){
		//Calendar Today = Calendar.getInstance();
		//if (Month!=Today.get(Calendar.MONTH)){
		//	Month=Today.get(Calendar.MONTH);
		//	Play_Counter=0;
		//}
	}


	private String name;

	public long getId() {
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
}
