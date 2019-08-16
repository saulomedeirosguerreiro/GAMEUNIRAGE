package Threads;

import Programa.JLayerPlayer;

public class RunAudio implements Runnable{
	public void run(){
		JLayerPlayer audio= new JLayerPlayer();
		audio.tocaMusica("Feature//SOLDIERBattle.wav");
	}
}
