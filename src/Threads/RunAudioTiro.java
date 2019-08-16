package Threads;

import Programa.JLayerPlayer;

	public class RunAudioTiro implements Runnable{
		private String audiotiro;
		public RunAudioTiro(String audiotiro){
			this.setAudiotiro(audiotiro);
		}
		
		public String getAudiotiro() {
			return audiotiro;
		}

		public void setAudiotiro(String audiotiro) {
			this.audiotiro = audiotiro;
		}

		public void run(){
			JLayerPlayer audio= new JLayerPlayer();
			audio.tocaMusica(this.getAudiotiro());
		}
	}
