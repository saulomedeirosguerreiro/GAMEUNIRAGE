package Programa;
import Cenario.Control;
import Cenario.Fase;
import Cenario.PauseMenu;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import Lista.ListArray;
import Threads.RunAudio;
import Threads.RunAudioTiro;
import Threads.RunSpecial;

// classe do lutador
public class Fighter {
	private Image imagem;
	private boolean flagSaltar;
	private boolean flagMovimentar;
	private boolean flagAtira;
	private boolean flagChute;
	private boolean flagEspecial;
	private int x,y;
	private int dx,dy;
	private int life;
	private String name;
	private int pontuacao;
	private List<Armament> armamento;
	private int altura, largura;
	private boolean isVisible;
	private JProgressBar progressBar;
	private Fase fase;
	private ListArray lista;
	public static int tipoDeEspeciais;
	public Fighter(Fase fase ,String name){
		this.setLista(new ListArray());
		tipoDeEspeciais=0;
		
		ImageIcon referencia = new ImageIcon("Feature//MegamanParado.gif");
		this.setImagem(referencia.getImage());
		this.setFase(fase);
		this.setAltura(this.getImagem().getHeight(null));
		this.setLargura(this.getImagem().getWidth(null));
		this.setFlagSaltar(false);
		this.setFlagMovimentar(false);
		this.setFlagAtira(false);
		this.setFlagChute(false);
		this.setFlagEspecial(false);
		this.setX(20);
		this.setY(409);
		this.setLife(4000);
		this.setName(name);
		this.setPontuacao(0);
		this.setArmamento(new ArrayList<Armament>());
		this.setVisible(true);
		
		this.setProgressBar(new JProgressBar());
		this.getProgressBar().setOrientation(SwingConstants.VERTICAL);
		this.getProgressBar().setBounds(6, 6, 15, 167);
		this.getProgressBar().setStringPainted(true);
		this.getProgressBar().setValue(100);
	}
	
	
	public boolean isFlagEspecial() {
		return flagEspecial;
	}



	public void setFlagEspecial(boolean flagEspecial) {
		this.flagEspecial = flagEspecial;
	}



	public ListArray getLista() {
		return lista;
	}



	public void setLista(ListArray lista) {
		this.lista = lista;
	}



	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	public boolean isFlagChute() {
		return flagChute;
	}


	public void setFlagChute(boolean flagChute) {
		this.flagChute = flagChute;
	}


	public boolean isVisible() {
		return isVisible;
	}


	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}


	public boolean isFlagAtira() {
		return flagAtira;
	}


	public void setFlagAtira(boolean flagAtira) {
		this.flagAtira = flagAtira;
	}


	public List<Armament> getArmamento() {
		return armamento;
	}


	public void setArmamento(List<Armament> armamento) {
		this.armamento = armamento;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getLargura() {
		return largura;
	}


	public void setLargura(int largura) {
		this.largura = largura;
	}


	public boolean isFlagMovimentar() {
		return flagMovimentar;
	}

	public void setFlagMovimentar(boolean flagMovimentar) {
		this.flagMovimentar = flagMovimentar;
	}

	public boolean isFlagSaltar() {
		return flagSaltar;
	}

	public void setFlagSaltar(boolean flagSaltar) {
		this.flagSaltar = flagSaltar;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public Image getImagem() {
		return imagem;
	}
	
	public void setImagem(Image imagem) {
		this.imagem=imagem;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(int pontuacao) {
		this.pontuacao =this.pontuacao + pontuacao;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int progressLife(){
		return this.getLife()/40;
	}
	
	public void atira(int aux){
		Armament aux_arma=new Armament(this.getX()+this.getLargura()/2,this.getY()+this.getAltura()/80);
		if(aux==1){
			RunAudioTiro audio = new RunAudioTiro("Feature//tiro1.wav");
			Thread thread_audio_tiro = new Thread(audio);
			thread_audio_tiro.start();
			ImageIcon referencia = new ImageIcon("Feature//fireball.gif");
			aux_arma.setImagem(referencia.getImage());
			this.getArmamento().add(aux_arma);
		}
		else if(aux==2){
			ImageIcon referencia = new ImageIcon("Feature//meteoro.gif");
			aux_arma.setImagem(referencia.getImage());
			if(this.getX()<490/2){
				RunAudioTiro audio = new RunAudioTiro("Feature//tiro2.wav");
				Thread thread_audio_tiro = new Thread(audio);
				thread_audio_tiro.start();
				this.getArmamento().add(aux_arma);
			}
			else{
				RunAudioTiro audio = new RunAudioTiro("Feature//ArmamentoVazio.wav");
				Thread thread_audio_tiro = new Thread(audio);
				thread_audio_tiro.start();
			}
		}
		else if(aux==3){
//			ImageIcon referencia = new ImageIcon("Feature//zero1.gif");
			if(this.tipoDeEspeciais==0){
				ImageIcon referencia = new ImageIcon("Feature//ArmaParaEspecial1.gif");
				aux_arma.setImagem(referencia.getImage());
				RunAudioTiro audio = new RunAudioTiro("Feature//AudioEspecial0.wav");
				Thread thread_audio_tiro = new Thread(audio);
				thread_audio_tiro.start();
				this.setFlagEspecial(true);
				this.getArmamento().add(aux_arma);
			}
			else if(this.tipoDeEspeciais==1){
				ImageIcon referencia = new ImageIcon("Feature//zero1.gif");
				aux_arma.setImagem(referencia.getImage());
				RunAudioTiro audio = new RunAudioTiro("Feature//AudioEspecial1.wav");
				Thread thread_audio_tiro = new Thread(audio);
				thread_audio_tiro.start();
				this.setFlagEspecial(true);
				this.getArmamento().add(aux_arma);
			}
			else if(this.tipoDeEspeciais==2){
				ImageIcon referencia = new ImageIcon("Feature//ArmaEspecial2.gif");
				aux_arma.setImagem(referencia.getImage());
				RunAudioTiro audio = new RunAudioTiro("Feature//tiro2.wav");
				Thread thread_audio_tiro = new Thread(audio);
				thread_audio_tiro.start();
				this.setFlagEspecial(true);
				this.getArmamento().add(aux_arma);
			}
			
			
		}
	
		
		
		//this.getArmamento().add(new Armament(this.getX()+this.getLargura()/2,this.getY()+this.getAltura()/80));
	}
	public void acertouTiro(Enemy inimigo,int danoAdicional){
		inimigo.tirarLife(200+danoAdicional);
	}
	public void acertouChute(Enemy inimigo,int danoAdicional){
		inimigo.tirarLife(400+danoAdicional);
	}
//	public void acertouEspecial(Enemy inimigo,int danoAdicional){
//		inimigo.tirarLife(1000+danoAdicional);
//	}
	public void saltar(){
		this.setY(this.getY()+this.getDy());
		if(this.getY()<336)//288
		  this.setY(336);
		if(this.getY()>430)
			this.setY(430);
	}
	public void hadouken(Enemy inimigo){
		inimigo.tirarLife(1000);
	}
	public void movimentar(){
		this.setX(this.getX()+this.getDx());
		this.setY(this.getY()+this.getDy());
		//System.out.println(x+","+y);
		if(this.getX()<-1)//2
			this.setX(-1);
		if(this.getX()>602)//561
			this.setX(602);
		if(this.getY()<385)//344
			this.setY(385);
		if(this.getY()>430)//375
			this.setY(430);
		
//		if(this.getY()<2)
//			this.setY(2);	
	}
	public void comboOne(Enemy inimigo){
		this.acertouTiro(inimigo,30);
		this.acertouChute(inimigo,60);
	}
	public void comboTwo(Enemy inimigo){
		this.acertouTiro(inimigo,30);
		this.acertouChute(inimigo,60);

	}
	public Rectangle getBound(){
		return new Rectangle(this.getX(),this.getY(),this.getLargura(),this.getAltura());
	}
	public void tirarLife(int life){
		if((this.getLife()-life)<0){
			if((this.getLife()-life)<0){
				this.setLife(this.getLife()-this.getLife());
			}
			else{
				this.setLife(this.getLife()-life);
			}
			System.out.println("Lutador morreu");
		}
		else{
			this.setLife(this.getLife()-life);
		}
		//System.out.println("life Lutador:"+this.getLife());
	}
	public void keyPressed(KeyEvent tecla){
		int codigo=tecla.getKeyCode();
		//		this.getLista().Inserir(codigo);
		//		this.getLista().Imprimir();
		if(this.flagEspecial==true){
			Thread t = new Thread();
			try {
				t.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else{
			if(this.getLista().lenght()==3){
				System.out.println("comparar:"+this.getLista().Comparar());
				if(this.getLista().Comparar()==true){
					this.setFlagEspecial(true);
					RunSpecial special = new RunSpecial(fase,this);
					Thread thread_special = new Thread(special);
					thread_special.start();
					//fase.controlMove=1;
					//atira(3);
					//this.setFlagAtirandoEspecial(false);
				}
			}
			if(codigo==KeyEvent.VK_UP || codigo==KeyEvent.VK_DOWN || codigo==KeyEvent.VK_RIGHT || codigo==KeyEvent.VK_LEFT){
				this.setFlagMovimentar(true);
			}
			if(codigo == (KeyEvent.VK_UP) ){
				this.setDy(-1);
			}
			if(codigo == KeyEvent.VK_DOWN){
				this.setDy(1);
			}
			if(codigo == KeyEvent.VK_RIGHT){
				this.setDx(1);
			}
			if(codigo == KeyEvent.VK_LEFT){
				this.setDx(-1);
			}
			if(codigo == KeyEvent.VK_V){
				this.setFlagSaltar(true);
				this.setDy(-2);
			}
			if(codigo == KeyEvent.VK_X){
				if(this.isFlagEspecial()==false){
					this.setFlagAtira(true);
					Fase.controlMove=1;
					atira(1);
				}
			}
			if(codigo==KeyEvent.VK_C){
				if(this.isFlagEspecial()==false){
					this.setFlagChute(true);
					Fase.controlMove=2;
					atira(2);
				}
			}
			if(codigo==KeyEvent.VK_ESCAPE){
				this.getFase().setEmJogo(false);
				this.getFase().setVisible(false);
				this.getFase().getFrame().setVisible(false);
				this.getFase().getFrame().validate();
				this.getFase().getFrame().add(new PauseMenu(this.getFase().getFrame(),this.getFase(),this.getName()));
				this.getFase().getFrame().setVisible(true);
			}	
		}	
	}
	public void keyReleased(KeyEvent tecla){
		int codigo = tecla.getKeyCode();
		if(codigo == KeyEvent.VK_UP){
			this.setDy(0);
		}
		if(codigo == KeyEvent.VK_DOWN){
			this.setDy(0);
		}
		if(codigo == KeyEvent.VK_RIGHT){
			this.setDx(0);
		}
		if(codigo == KeyEvent.VK_LEFT){
			this.setDx(0);
		}
		if(codigo == KeyEvent.VK_V){
			this.setDy(2);
			this.setFlagSaltar(false);
		}
		if(codigo==KeyEvent.VK_UP || codigo==KeyEvent.VK_DOWN || codigo==KeyEvent.VK_RIGHT || codigo==KeyEvent.VK_LEFT){
			this.setFlagMovimentar(false);
		}
		if(codigo == KeyEvent.VK_X){
			this.setFlagAtira(false);
  		}
		if(codigo==KeyEvent.VK_C){
			this.setFlagChute(false);
		}
		
	}
	
}
