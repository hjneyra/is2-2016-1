package ucsp.is2.model;

import javazoom.jlgui.basicplayer.BasicPlayer;
import java.io.File;

public class MusicPlayer {
	
	private BasicPlayer player;
	
	public MusicPlayer(){
		player = new BasicPlayer();
	}
	
	
	public void Play() throws Exception{
		player.play();
	}
	
	public void OpenFile(String route) throws Exception{
		player.open(new File(route));
	}
	
	public void Pause() throws Exception{
		player.pause();
	}
	
	public void Next() throws Exception{
		player.resume();
	}
	
	public void Stop() throws Exception{
		player.stop();
	}
	
	public void MusicPlayerMp3() throws Exception{
		try{
			 MusicPlayer music_player = new MusicPlayer();
			  music_player.OpenFile("c:/mi_archivo_de_musica.mp3");
			  music_player.Play();
			} catch (Exception ex) {
			  System.out.println("Error: " + ex.getMessage());
			}
		}
	
	public static void main(String args[]) throws Exception{
		
		MusicPlayer m = new MusicPlayer();
		m.OpenFile("C:/Users/Public/Music/Sample Music");
		m.Play();
	}
}
