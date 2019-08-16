package Threads;

import Cenario.ContainerDeJanelas;

public class RunJFrame implements Runnable {
	public void run(){
		new ContainerDeJanelas();
	}
}
