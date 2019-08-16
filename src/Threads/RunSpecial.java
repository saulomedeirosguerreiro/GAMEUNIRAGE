package Threads;

import Cenario.Fase;
import Programa.Fighter;

public class RunSpecial implements Runnable{
	private Fase fase;
	private Fighter lutador;
	public RunSpecial(Fase fase, Fighter lutador){
		this.setFase(fase);
		this.setLutador(lutador);
	}
	
	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Fighter getLutador() {
		return lutador;
	}

	public void setLutador(Fighter lutador) {
		this.lutador = lutador;
	}

	public void run(){
		int tempo = 0;
		if(this.getLutador().tipoDeEspeciais==0){
			tempo=2000;
		}
		else if(this.getLutador().tipoDeEspeciais==1){
			tempo=2300;
		}
		else if(this.getLutador().tipoDeEspeciais==2){
			tempo=4000;
		}
		Thread t = new Thread();
		try {
			t.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ACABOU");
		this.getFase().controlMove=1;
		this.getLutador().atira(3);
		if(this.getLutador().tipoDeEspeciais==2){
			this.getLutador().setY(409);
		}
		this.getLutador().setFlagEspecial(false);
		while(this.getLutador().getLista().isEmpty()==false){
			this.getLutador().getLista().removerInicio();
		}
		if(this.getLutador().tipoDeEspeciais==2){
			this.getLutador().tipoDeEspeciais=0;
		}
		else{
			this.getLutador().tipoDeEspeciais++;
		}
		
	}
}
