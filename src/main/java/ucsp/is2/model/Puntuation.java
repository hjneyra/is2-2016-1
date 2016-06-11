package ucsp.is2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Puntuation{

    @Id
    @SequenceGenerator(name="PUNTIATION_GENERATOR", sequenceName="PUNTUATION_SEQ")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUNTUATION_GENERATOR")
    private long id;

    private long score = 0;

    public Puntuation(){

	  }

  	public long getScore() {
  		return score;
  	}

  	public void setScore(long score) {
  		this.score = score;
  	}

    public static int clasification(){
      // You can't save objects on the model :'(
      //score = score + 1;
      //Puntuation.save(score);
      //System.out.println(score);
      return 0;
    }

}
