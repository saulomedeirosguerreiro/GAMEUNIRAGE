package Cenario;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Programa.Armament;
import Programa.Enemy;
import Programa.Fighter;
import Threads.RunAudioTiro;

public class Fase extends JPanel implements ActionListener{
	private JLabel imagemfundo;
	private JLabel barraHadouken;
	private JLabel impressaolista;
	private Fighter lutador;
	//private Enemy inimigo;
	private List<Enemy> inimigos;
	private Timer timer;
	private boolean emJogo;
	private int[][] coordenadas = {{233,381},{339,430},{587,424},{330,365},{418,391}};
	public static char[] teclas=new char[3];
	public static int controlMove=0;
	public static int controlTrocaFase=1;
	private JFrame frame;
	
	public Fase(JFrame frame,String nameplayer){
		this.setFrame(frame);
		controlMove=0;
		controlTrocaFase=1;
		
		this.setLayout(null);
		this.setSize(640,500);
		this.setImagemfundo(new JLabel());
		this.getImagemfundo().setIcon(new ImageIcon("Feature//fase1.png"));
		this.getImagemfundo().setBounds(0, -10,640,500);
		
		this.setBarraHadouken(new JLabel());
		this.getBarraHadouken().setIcon(new ImageIcon("Feature//vermelho.jpg"));
		this.getBarraHadouken().setBounds(265, 0, 109, 44);
		
		this.setImpressaolista(new JLabel());
		this.getImpressaolista().setBounds(265, 20, 109, 16);
		this.getImpressaolista().setText("   Ø       Ø      Ø");

		//ImageIcon referencia = new ImageIcon("Feature//fase1.png");
		//this.setImagemfundo(referencia.getImage());
		
		this.setTimer(new Timer(5,this));
		this.getTimer().start();
		this.setEmJogo(true);
		this.inicializarInimigos();
      //this.setInimigo(new Enemy());
		this.setLutador(new Fighter(this,nameplayer));
		addKeyListener(new TecladoAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		
		

		this.add(this.getLutador().getProgressBar());
		this.add(this.getImpressaolista());
		this.add(this.getBarraHadouken());
		this.add(this.getImagemfundo());
	}
	
	
	public JLabel getImpressaolista() {
		return impressaolista;
	}


	public void setImpressaolista(JLabel impressaolista) {
		this.impressaolista = impressaolista;
	}


	public JLabel getBarraHadouken() {
		return barraHadouken;
	}


	public void setBarraHadouken(JLabel barraHadouken) {
		this.barraHadouken = barraHadouken;
	}


	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JLabel getImagemfundo() {
		return imagemfundo;
	}
	public void setImagemfundo(JLabel imagemfundo) {
		this.imagemfundo = imagemfundo;
	}
	
	public List<Enemy> getInimigos() {
		return inimigos;
	}


	public void setInimigos(List<Enemy> inimigos) {
		this.inimigos = inimigos;
	}


	public boolean isEmJogo() {
		return emJogo;
	}


	public void setEmJogo(boolean emJogo) {
		this.emJogo = emJogo;
	}

	public Fighter getLutador() {
		return lutador;
	}
	public void setLutador(Fighter lutador) {
		this.lutador = lutador;
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	 public void run () {
		 //dasdakljsa
     }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("mov:"+this.getLutador().isFlagMovimentar()+" saltar:"+ this.getLutador().isFlagSaltar());
		//this.getInimigo().movimentoAleatorio();
		//System.out.println(this.getLutador());	
	if(emJogo){
		if(this.getLutador().getLista().isEmpty()){
			this.getImpressaolista().setText("   Ø       Ø      Ø");
		}
		else{
			if(Fase.teclas[0]=='Z' && Fase.teclas[1]=='X' && Fase.teclas[2]=='C'){
				this.getBarraHadouken().setIcon(new ImageIcon("Feature//verde.jpg"));
			}
			else{
				this.getBarraHadouken().setIcon(new ImageIcon("Feature//vermelho.jpg"));
			}
			this.getImpressaolista().setText("   "+Fase.teclas[0]+"       "+Fase.teclas[1]+"      "+Fase.teclas[2]);
		}
	
		this.getLutador().getProgressBar().setValue(this.getLutador().progressLife());
		for(int i=0;i<this.getInimigos().size();i++){
			this.getInimigos().get(i).getProgressBarEnemy().setValue(this.getInimigos().get(i).progressLifeEnemy());
			this.getInimigos().get(i).getProgressBarEnemy().setBounds(this.getInimigos().get(i).getX(), this.getInimigos().get(i).getY()-8, 30, 10);;
		}
		
		if(this.getLutador().isFlagEspecial()==true){
			if(this.getLutador().tipoDeEspeciais==0){
//				this.getLutador().setY(50);
				this.getLutador().setY(409);
				ImageIcon referencia = new ImageIcon("Feature//MegamanEspecial1.gif");
				this.getLutador().setImagem(referencia.getImage());
			}
			else if(this.getLutador().tipoDeEspeciais==1){
//				this.getLutador().setY(-100);
				this.getLutador().setY(409);
				ImageIcon referencia = new ImageIcon("Feature//Especial3.gif");
				this.getLutador().setImagem(referencia.getImage());
				
			}
			else if(this.getLutador().tipoDeEspeciais==2){
				this.getLutador().setY(0);
				ImageIcon referencia = new ImageIcon("Feature//Especial4.gif");
				this.getLutador().setImagem(referencia.getImage());
			}
			
			
		}
		else if(this.getLutador().isFlagChute()==true){
				ImageIcon referencia = new ImageIcon("Feature//MegamanMeteoro.gif");
				this.getLutador().setImagem(referencia.getImage());
		}
		else if(this.getLutador().isFlagAtira()==true && this.getLutador().isFlagMovimentar()==true){
			ImageIcon referencia = new ImageIcon("Feature//MegamanAtirandoCorrendo2.gif");
			this.lutador.setImagem(referencia.getImage());
		}
		else if(this.getLutador().isFlagAtira()==true && this.getLutador().isFlagMovimentar()==false){
			ImageIcon referencia = new ImageIcon("Feature//MegamanAtirando2.gif");
			this.lutador.setImagem(referencia.getImage());
		}
		else if(this.getLutador().isFlagMovimentar()==false){
			ImageIcon referencia = new ImageIcon("Feature//MegamanParado.gif");
			this.lutador.setImagem(referencia.getImage());
		}
		if(this.getLutador().isFlagMovimentar()==true && this.getLutador().isFlagSaltar()==false && this.getLutador().isFlagAtira()==false ){
			ImageIcon referencia = new ImageIcon("Feature//MegamanAndando.gif");
			this.lutador.setImagem(referencia.getImage());
			this.getLutador().movimentar();
		}
		else{	
				if(this.getLutador().isFlagSaltar()){
					ImageIcon referencia = new ImageIcon("Feature//MegamanVoando.gif");
					this.lutador.setImagem(referencia.getImage());
				}
				this.getLutador().saltar();
		}
	
		for(int j=0;j<this.getInimigos().size();j++){//AQUI
			Random aleatorio = new Random();
			int num=aleatorio.nextInt(2000);
			if(num==500 || num==100 || num==321){
				this.getInimigos().get(j).atiraAleatorio();
			}
		}
		for(int j=0;j<this.getInimigos().size();j++){//AQUI
			List<Armament> armamentoInimigo = this.getInimigos().get(j).getArmamentoEnemy();
			for(int i=0;i<armamentoInimigo.size();i++){
				Armament arm = (Armament)armamentoInimigo.get(i);
				if(arm.isVisible()==true){
					arm.mexerArmaDoInimigo();
				}
				else{
					armamentoInimigo.remove(i);
				}
			}
		}
	
		List<Armament> armamento = this.getLutador().getArmamento();
		for(int i=0;i<armamento.size();i++){
			Armament arm = (Armament)armamento.get(i);
			if(arm.isVisible()==true){
				if(controlMove==1){
					arm.mexer();
				}
				else if(controlMove==2){
					arm.mexer2();
				}
			}
			else{
				armamento.remove(i);
			}
		}
		
		for(int i=0;i<this.getInimigos().size();i++){
			Enemy aux = this.getInimigos().get(i);
			if(aux.isVisible()==true){
				aux.movimentoAleatorio();
				//System.out.println("quantidade inimigos: "+this.getInimigos().size());
			}
			else{
				this.getInimigos().remove(i);
			}
		}
		
		this.checarColisoes();
			
		repaint();
	}	
	}
	public void iniciarFase(){
		this.setEmJogo(true);
		this.getLutador().setLife(4000);
		while(this.getLutador().getLista().isEmpty()==false){
			this.getLutador().getLista().removerInicio();
		}
		this.getLutador().getProgressBar().setVisible(true);
		this.getLutador().setX(20);
		this.getLutador().setY(409);
		this.getLutador().setVisible(true);
		this.getInimigos().removeAll(getInimigos());
		this.inicializarInimigos();
		
	}
	public void desativarBarrasDeProgresso(){
		this.getLutador().getProgressBar().setVisible(false);
			for(int i=0;i<this.getInimigos().size();i++){
				this.getInimigos().get(i).getProgressBarEnemy().setVisible(false);
			}
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D graficos =(Graphics2D)g;
		//graficos.drawImage(this.getImagemfundo(),0,0,null);
		if(this.getLutador().isVisible()==false ){
			this.setEmJogo(false);
			controlTrocaFase=6;
			this.desativarBarrasDeProgresso();
			
		}
		if(this.getInimigos().size()==0){
			this.setEmJogo(false);
			this.desativarBarrasDeProgresso();
			controlTrocaFase++;
		}
		if(emJogo){
			graficos.drawImage(this.getLutador().getImagem(),this.getLutador().getX(),this.getLutador().getY(),this);
			for(int j=0;j<this.getInimigos().size();j++){//AQUI
				List<Armament> armamentoInimigo = this.getInimigos().get(j).getArmamentoEnemy();
				for(int i=0;i<armamentoInimigo.size();i++){
					Armament arm = (Armament)armamentoInimigo.get(i);
					graficos.drawImage(arm.getImagem(),arm.getX(),arm.getY(),this);
				}
			}
			
			List<Armament> armamento = this.getLutador().getArmamento();
			for(int i=0;i<armamento.size();i++){
				Armament arm = (Armament)armamento.get(i);
				graficos.drawImage(arm.getImagem(),arm.getX(),arm.getY(),this);
			}
			for(int i=0;i<this.getInimigos().size();i++){
				Enemy aux = this.getInimigos().get(i);
				graficos.drawImage(aux.getImagem(),aux.getX(),aux.getY(),this);
			}
		}
		else if(controlTrocaFase<=5){
			System.out.println("controlador:"+controlTrocaFase);
			System.out.println("quant inimigos:"+this.getInimigos().size());
			switch(controlTrocaFase){
				case 2: //ImageIcon referencia = new ImageIcon("Feature//fase2.png");
						//this.setImagemfundo(referencia.getImage());
						this.getImagemfundo().setIcon(new ImageIcon("Feature//fase2.png"));
						this.iniciarFase();
						break;
				case 3: //referencia = new ImageIcon("Feature//fase3.png");
						//this.setImagemfundo(referencia.getImage());
						this.getImagemfundo().setIcon(new ImageIcon("Feature//fase3.png"));
						this.iniciarFase();
						break;
				case 4: //referencia = new ImageIcon("Feature//fase4.png");
						//this.setImagemfundo(referencia.getImage());
						this.getImagemfundo().setIcon(new ImageIcon("Feature//fase4.png"));
						this.iniciarFase();
						break;
				case 5: //referencia = new ImageIcon("Feature//fase5.png");
						//this.setImagemfundo(referencia.getImage());
						this.getImagemfundo().setIcon(new ImageIcon("Feature//fase5.png"));
						this.iniciarFase();
						break;
			}
		}
		else{
			this.setVisible(false);
			frame.remove(this);
			frame.remove(this);
			frame.setVisible(false);;
			frame.validate();
			frame.add(new GameOver(frame,this.getLutador().getName(),this.getLutador().getPontuacao(),this.getInimigos().size()));
			frame.setVisible(true);
			
			
			//this.getImagemfundo().setIcon(new ImageIcon("Feature//END.gif"));
			
			
		}
		g.dispose();
	}
	public void inicializarInimigos(){
		this.setInimigos(new ArrayList<Enemy>());
		for(int i=0;i<coordenadas.length;i++){
			this.getInimigos().add(new Enemy(coordenadas[i][0],coordenadas[i][1]));
			this.add(this.getInimigos().get(i).getProgressBarEnemy());
		}
			this.add(this.getImagemfundo());
			
	}
	public void checarColisoes(){
		Rectangle formaLutador = this.getLutador().getBound();
		Rectangle formaInimigo;
		Rectangle formaArmamento;
		Rectangle formaArmamento2;
		if(this.getLutador().isFlagEspecial()==true && this.getLutador().tipoDeEspeciais==2){
			for(int i=0;i<this.getInimigos().size();i++){//lutador x inimigo
				Enemy tempInimigo = this.getInimigos().get(i);
				formaInimigo = tempInimigo.getBound();
				if(formaInimigo.intersects(formaLutador)){
					this.getLutador().setPontuacao(1000);
					this.getLutador().hadouken(tempInimigo);
				}
			}
		}
		else{
			for(int i=0;i<this.getInimigos().size();i++){//lutador x inimigo
				Enemy tempInimigo = this.getInimigos().get(i);
				formaInimigo = tempInimigo.getBound();
				if(formaInimigo.intersects(formaLutador)){
					this.getLutador().setVisible(false);
					tempInimigo.setVisible(false);
					this.setEmJogo(false);
					
				}
			}
		}
		
		List<Armament> armamento = this.getLutador().getArmamento();//checa armamentoLutador x inimigos
		for(int i=0;i<armamento.size();i++){
			Armament tempArmamento = armamento.get(i);
			formaArmamento = tempArmamento.getBound();
			for(int j=0;j<this.getInimigos().size();j++){
				Enemy tempInimigo = this.getInimigos().get(j);
				formaInimigo = tempInimigo.getBound();
				if(formaArmamento.intersects(formaInimigo)){
					if(tempInimigo.getLife()==0){
						RunAudioTiro audio = new RunAudioTiro("Feature//morteinimigo.wav");
						Thread thread_audio_tiro = new Thread(audio);
						thread_audio_tiro.start();
						if(this.getLutador().isFlagEspecial()){
							this.getLutador().setPontuacao(1000);
							this.getLutador().hadouken(tempInimigo);
						}
						else if(this.getLutador().isFlagChute()){
							this.getLutador().setPontuacao(400);
							this.getLutador().acertouChute(tempInimigo, 0);
						}
						else{
							this.getLutador().setPontuacao(200);
							this.getLutador().acertouTiro(tempInimigo, 0);
						}
						tempInimigo.setVisible(false);
						tempInimigo.getProgressBarEnemy().setVisible(false);
						this.getInimigos().remove(tempInimigo);
					}
					else{
						if(this.getLutador().isFlagEspecial()){
							this.getLutador().setPontuacao(1000);
							this.getLutador().hadouken(tempInimigo);
						}
						else if(this.getLutador().isFlagChute()){
							this.getLutador().setPontuacao(400);
							this.getLutador().acertouChute(tempInimigo, 0);
						}
						else{
							this.getLutador().setPontuacao(200);
							this.getLutador().acertouTiro(tempInimigo, 0);
						}
					}
					
					tempArmamento.setVisible(false);
				}
			}
		}
		
		for(int k=0;k<this.getInimigos().size();k++){//AQUI chega armamentoInimigo x Lutador
			List<Armament> armamentoInimigo = this.getInimigos().get(k).getArmamentoEnemy();
			for(int i=0;i<armamentoInimigo.size();i++){
				Armament tempArmamentoInimigo = armamentoInimigo.get(i);
				formaArmamento2 = tempArmamentoInimigo.getBound();
				if(formaArmamento2.intersects(formaLutador)){
					if(this.getLutador().getLife()==0){
						this.getLutador().setVisible(false);
						this.setEmJogo(false);
					}
					else{
						if(this.getLutador().isFlagEspecial()==false){
							ImageIcon referencia = new ImageIcon("Feature//AcertouMegaman.gif");
							this.getLutador().setImagem(referencia.getImage());
						}
						if(this.getLutador().isFlagEspecial()==true && (this.getLutador().tipoDeEspeciais==0 || this.getLutador().tipoDeEspeciais==2)){
							System.out.println("Nao tirou life do lutador e o armamento ficou invisivel");
							tempArmamentoInimigo.setVisible(false);
						}
						else{
							switch(controlTrocaFase){
							case 1: this.getLutador().tirarLife(30);
								  	break;
							case 2: this.getLutador().tirarLife(40);
							  	break;
							case 3: this.getLutador().tirarLife(50);
							  	break;
							case 4: this.getLutador().tirarLife(60);
							  	break;
							case 5: this.getLutador().tirarLife(100);
							  	break;
						}
						this.getLutador().tirarLife(1);
						}
					}
				}
			}
		}
		List<Armament> armamento1 = this.getLutador().getArmamento();
		for(int i=0;i<armamento1.size();i++){//checa armamento x armamentoInimigo
			Armament tempArmamento1 = armamento1.get(i);
			formaArmamento = tempArmamento1.getBound();
			for(int k=0;k<this.getInimigos().size();k++){
				List<Armament> armamentoInimigo2 = this.getInimigos().get(k).getArmamentoEnemy();
				for(int j=0;j<armamentoInimigo2.size();j++){
					Armament tempArmamentoInimigo2 = armamentoInimigo2.get(j);
					formaArmamento2 = tempArmamentoInimigo2.getBound();
					if(formaArmamento.intersects(formaArmamento2)){
						//System.out.println("Eta pow");
						tempArmamento1.setVisible(false);
						tempArmamentoInimigo2.setVisible(false);
					}
				}
			}
		}
	}
	public class TecladoAdapter extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int codigo=e.getKeyCode();
			if(codigo==KeyEvent.VK_Z||codigo==KeyEvent.VK_X||codigo==KeyEvent.VK_C){
				lutador.getLista().Inserir(codigo);
				if(lutador.getLista().lenght()==1){
					if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_Z){
						Fase.teclas[0]='Z';
					}
					else if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_X){
						Fase.teclas[0]='X';
					}
					else if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_C){
						Fase.teclas[0]='C';
					}
					Fase.teclas[1]='Ø';
					Fase.teclas[2]='Ø';
				}
				else if(lutador.getLista().lenght()==2){
					if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_Z){
						Fase.teclas[0]='Z';
					}
					else if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_X){
						Fase.teclas[0]='X';
					}
					else if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_C){
						Fase.teclas[0]='C';
					}
					
					if(lutador.getLista().CapturarElemento(1)==KeyEvent.VK_Z){
						Fase.teclas[1]='Z';
					}
					else if(lutador.getLista().CapturarElemento(1)==KeyEvent.VK_X){
						Fase.teclas[1]='X';
					}
					else if(lutador.getLista().CapturarElemento(1)==KeyEvent.VK_C){
						Fase.teclas[1]='C';
					}
					Fase.teclas[2]='Ø';
				}
				else if(lutador.getLista().lenght()==3){
					if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_Z){
						Fase.teclas[0]='Z';
					}
					else if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_X){
						Fase.teclas[0]='X';
					}
					else if(lutador.getLista().CapturarElemento(0)==KeyEvent.VK_C){
						Fase.teclas[0]='C';
					}
					
					if(lutador.getLista().CapturarElemento(1)==KeyEvent.VK_Z){
						Fase.teclas[1]='Z';
					}
					else if(lutador.getLista().CapturarElemento(1)==KeyEvent.VK_X){
						Fase.teclas[1]='X';
					}
					else if(lutador.getLista().CapturarElemento(1)==KeyEvent.VK_C){
						Fase.teclas[1]='C';
					}
					
					if(lutador.getLista().CapturarElemento(2)==KeyEvent.VK_Z){
						Fase.teclas[2]='Z';
					}
					else if(lutador.getLista().CapturarElemento(2)==KeyEvent.VK_X){
						Fase.teclas[2]='X';
					}
					else if(lutador.getLista().CapturarElemento(2)==KeyEvent.VK_C){
						Fase.teclas[2]='C';
					}
				}
			}
			lutador.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			lutador.keyReleased(e);
		}
		
	}
	
	
	
}
