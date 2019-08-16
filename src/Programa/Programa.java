
package Programa;

import Threads.RunAudio;
import Threads.RunJFrame;
import Cenario.ContainerDeJanelas;

public class Programa {
	public static void main(String[] args) {
		RunAudio audio = new RunAudio();
		Thread thread_audio = new Thread(audio);
		thread_audio.start();
		
		RunJFrame frame = new RunJFrame();
		Thread thread_frame = new Thread(frame);
		thread_frame.start();
		
		
	}

}
