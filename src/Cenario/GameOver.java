package Cenario;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//import Programa.RankingTopFive;
import Threads.RunAudioTiro;


public class GameOver extends JPanel{


	private JButton tryagain;
	private JButton quitGame;
	private final Action action = new SwingAction();
	private final Action action_2 = new SwingAction_2();
	private String nomeJogador;
	private JFrame frame;
	private GameOver essePainel;
	private JLabel imagemHome;
	private JTextArea textArea;
	private JLabel labelEnd;
	private JLabel label;
	private JLabel label2;
	public GameOver(JFrame pai,String nomeJogador, int pontuacao,int qtdinimigosVivos){
		this.setNomeJogador(nomeJogador);
		this.setFrame(pai);
		this.setEssePainel(this);
		
	    this.setTryagain(new JButton("Try again"));
//		this.getTryagain().setBounds(320, 200, 80, 20);
		this.getTryagain().setAction(action);
		this.getTryagain().setVisible(true);
		
		this.setQuitGame(new JButton("Quit game"));
		this.getQuitGame().setAction(action_2);
//		this.getQuitGame().setBounds(410, 200, 80, 20);
		this.getQuitGame().setVisible(true);
		
		this.setImagemHome(new JLabel());
		if(qtdinimigosVivos==0){
			this.setLabelEnd(new JLabel("Victory"));
			RunAudioTiro audio = new RunAudioTiro("Feature//Aplausos.wav");
			Thread thread_audio_tiro = new Thread(audio);
			thread_audio_tiro.start();
			this.getLabelEnd().setFont(new Font("Chalkduster", Font.PLAIN, 40));
			this.getLabelEnd().setForeground(Color.black);
			this.getLabelEnd().setBounds(220, -20, 400, 94);
			this.getLabelEnd().setVisible(true);
			
			this.getImagemHome().setIcon(new ImageIcon("Feature//Victory.png"));
			this.getImagemHome().setBounds(0, -10,640,500);
			this.getQuitGame().setBounds(260, 415, 80, 20);
			this.getTryagain().setBounds(160, 415, 80, 20);
			
			this.setLabel(new JLabel(nomeJogador));
			this.getLabel().setFont(new Font("Verdana", Font.PLAIN, 13));
			this.getLabel().setForeground(Color.green);
			this.getLabel().setBounds(90, 200, 400, 94);
			this.getLabel().setVisible(true);
			
			String aux = " "+pontuacao;
			this.setLabel2(new JLabel(aux));
			this.getLabel2().setFont(new Font("Verdana", Font.PLAIN, 13));
			this.getLabel2().setForeground(Color.green);
			this.getLabel2().setBounds(175, 300, 400, 94);
			this.getLabel2().setVisible(true);
			
			this.add(this.getLabelEnd());
			this.add(this.getLabel());
			this.add(this.getLabel2());
		}
		else{
			//this.setLabelEnd(new JLabel("GAME OVER"));
			RunAudioTiro audio = new RunAudioTiro("Feature//GameOver.wav");
			Thread thread_audio_tiro = new Thread(audio);
			thread_audio_tiro.start();
			this.getImagemHome().setIcon(new ImageIcon("Feature//finish.png"));
			this.getImagemHome().setBounds(0, -12,640,500);
			this.getQuitGame().setBounds(280, 368, 125, 25);
			this.getTryagain().setBounds(280, 300, 125, 25);
		}
		
		
		this.setSize(640,500);
		this.setLayout(null);
		this.setVisible(true);
		this.add(this.getTryagain());
		this.add(this.getQuitGame());
		this.add(this.getImagemHome());

		
		
	}
	
	
	public JLabel getLabel2() {
		return label2;
	}


	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}


	public String getNomeJogador() {
		return nomeJogador;
	}


	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}


	public JButton getQuitGame() {
		return quitGame;
	}


	public void setQuitGame(JButton quitGame) {
		this.quitGame = quitGame;
	}


	public JLabel getLabel() {
		return label;
	}


	public void setLabel(JLabel label) {
		this.label = label;
	}


	public JLabel getLabelEnd() {
		return labelEnd;
	}


	public void setLabelEnd(JLabel labelEnd) {
		this.labelEnd = labelEnd;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JButton getTryagain() {
		return tryagain;
	}


	public void setTryagain(JButton tryagain) {
		this.tryagain = tryagain;
	}


	public GameOver getEssePainel() {
		return essePainel;
	}


	public void setEssePainel(GameOver essePainel) {
		this.essePainel = essePainel;
	}


	public JLabel getImagemHome() {
		return imagemHome;
	}
	public void setImagemHome(JLabel imagemHome) {
		this.imagemHome = imagemHome;
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Try again");
			putValue(SHORT_DESCRIPTION, "Click this button to be able to play again");
		}
		public void actionPerformed(ActionEvent e) {
			essePainel.setVisible(false);
			frame.remove(essePainel);
			frame.setVisible(false);;
			frame.validate();
			frame.add(new Fase(frame,nomeJogador));
			frame.setVisible(true);	
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Quit game");
			putValue(SHORT_DESCRIPTION, "Press this button to exit of the game");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
}