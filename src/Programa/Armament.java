package Programa;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Armament {
	private Image imagem;
	private int x,y;
	private boolean isVisible;
	private int altura, largura;
	private final int LARGURA_TELA=640;
	private final int VELOCIDADE=2; 
	public Armament(int x, int y){
		this.setX(x);
		this.setY(y);
		ImageIcon referencia = new ImageIcon("Feature//fireball.gif");
		this.setImagem(referencia.getImage());
		this.setAltura(this.getImagem().getHeight(null));
		this.setLargura(this.getImagem().getWidth(null));
		this.setVisible(true);
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
	public boolean isVisible() {
		return isVisible;
	}
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public void mexer(){
		this.setX(x+VELOCIDADE);
		if(this.getX()>LARGURA_TELA){
			this.setVisible(false);
		}
	}
	public void mexer2(){
		this.setX(this.getX()+VELOCIDADE);
		if(this.getX()>(LARGURA_TELA-150)/2)
			this.setVisible(false);
	}
	public void mexerArmaDoInimigo(){
			this.setX(x-VELOCIDADE);
			if(this.getX()<0){
				this.setVisible(false);
			}
	}
	public Rectangle getBound(){
		return new Rectangle(this.getX(),this.getY(),this.getLargura(),this.getAltura());
	}
	
}
