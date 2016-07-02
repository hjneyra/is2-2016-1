package ucsp.is2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Song {

	@Id
	@SequenceGenerator(name="SONG_ID_GENERATOR", sequenceName="SONG_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SONG_ID_GENERATOR")
	private Long id;
	private String name;
	private String author;
	private String album;
	private String url;
	private int score;
	private int nscore;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNscore() {
		return nscore;
	}

	public void setNscore(int nscore) {
		this.nscore = nscore;
	}
}
