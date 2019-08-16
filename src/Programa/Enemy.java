package Programa;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

//classe do Inimigo
public class Enemy {
	private Image imagem;
	private int x,y;
	private int dx,dy;
	private int life;
	private int altura, largura;
	private boolean isVisible;
	private List<Armament> armamentoEnemy;//AQUI
	private JProgressBar progressBarEnemy;
	public Enemy(int x, int y){
		ImageIcon referencia = new ImageIcon("Feature//Inimigo.gif");
		this.setImagem(referencia.getImage());
		this.setAltura(this.getImagem().getHeight(null));
		this.setLargura(this.getImagem().getWidth(null));
		this.setX(x);
		this.setY(y);
		this.setLife(4000);
		this.setVisible(true);
		this.setArmamentoEnemy(new ArrayList<Armament>());
		
		this.setProgressBarEnemy(new JProgressBar());
		this.getProgressBarEnemy().setBounds(x, y-8, 30, 10);
		this.getProgressBarEnemy().setValue(100);
	}
	
	
	public JProgressBar getProgressBarEnemy() {
		return progressBarEnemy;
	}


	public void setProgressBarEnemy(JProgressBar progressBarEnemy) {
		this.progressBarEnemy = progressBarEnemy;
	}


	public List<Armament> getArmamentoEnemy() {//AQUI
		return armamentoEnemy;
	}


	public void setArmamentoEnemy(List<Armament> armamentoEnemy) {//AQUI
		this.armamentoEnemy = armamentoEnemy;
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

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
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

	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int progressLifeEnemy(){
		return this.getLife()/20;
	}
	public void atiraAleatorio(){//AQUI
		Armament aux_arma=new Armament(this.getX()-50,this.getY());//this.getLargura()/2//this.getAltura()/80
		Random aleatorio = new Random();
		int num=aleatorio.nextInt(500);
		Random aleatorio2 = new Random();
		int num2=aleatorio.nextInt(1000);
//		if(num%2==0 &&(num2>100 && num<350)){
		if(num%2==0 &&(num2>100 && num<350)){
			ImageIcon referencia = new ImageIcon("Feature//flame1.gif");
			aux_arma.setImagem(referencia.getImage());
			this.getArmamentoEnemy().add(aux_arma);
		}
//		else if(num%2!=0 && (num>200 && num2<500)){
		else if(num%2!=0 && (num>200 && num2<500)){
			ImageIcon referencia = new ImageIcon("Feature//Pedra.gif");
			aux_arma.setImagem(referencia.getImage());
			this.getArmamentoEnemy().add(aux_arma);
		}
		else{
			ImageIcon referencia = new ImageIcon("Feature//ArmaInimigo3.gif");
			aux_arma.setImagem(referencia.getImage());
			this.getArmamentoEnemy().add(aux_arma);
		}
	}
	public void movimentoAleatorio(){
		Random aleatorio = new Random();
		int num=aleatorio.nextInt(500);
		//System.out.println("num:"+num);
		if(this.getY()>432){//375
			this.setY(432);
		}
		if(this.getX()<1){//2
			this.setX(1);
		}
		if(this.getX()>600){//561
			this.setX(600);
		}
		if(this.getY()<350){//344
			this.setY(350);
		}
		if(num>=0 && num<=100){
			 this.setX(this.getX()-1);//esquerda
		}
		else if(num>=101 && num<=200){
			this.setX(this.getX()+1);
		}
		else if(num>=201 && num<=300){
			 this.setY(this.getY()+1);//pra baixo
		}
		else if(num>=301 && num<=400){
			 this.setY(this.getY()-1);
		}	
			
	}
	public void tirarLife(int life){
		if((this.getLife()-life)<0){
			if((this.getLife()-life)<0){
				this.setLife(this.getLife()-this.getLife());
			}
			else{
				this.setLife(this.getLife()-life);
			}
			System.out.println("Inimigo morreu");
		}
		else{
			this.setLife(this.getLife()-life);
		}
		System.out.println("life inimigo:"+this.getLife());
	}
	public Rectangle getBound(){
		return new Rectangle(this.getX(),this.getY(),this.getLargura(),this.getAltura());
	}
	
}
