package Cenario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PauseMenu extends JPanel{


	private JButton returnGame;
	private JButton controls;
	private JButton quitGame;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private String nomeJogador;
	private JFrame frame;
	private PauseMenu essePainel;
	private JLabel imagemHome;
	private JLabel label;
	private Fase fase;
	public PauseMenu(JFrame pai, Fase fase,String nomeJogador){
		this.setNomeJogador(nomeJogador);
		this.setFase(fase);
		this.setFrame(pai);
		this.setEssePainel(this);
	    this.setReturnGame(new JButton("Return Game"));
		this.getReturnGame().setBounds(290, 169, 100, 15);
		this.getReturnGame().setAction(action);
		this.getReturnGame().setVisible(true);
		
	    this.setQuitGame(new JButton("Quit game"));
		this.getQuitGame().setBounds(290, 302, 100, 15);
		this.getQuitGame().setAction(action_2);
		this.getQuitGame().setVisible(true);
		
	    this.setControls(new JButton("Controls"));
		this.getControls().setBounds(290, 235, 100, 15);
		this.getControls().setAction(action_1);
		this.getControls().setVisible(true);
		
		this.setLabel(new JLabel("PAUSED"));
		this.getLabel().setFont(new Font("Stencil", Font.PLAIN, 60));
		this.getLabel().setForeground(Color.black);
		this.getLabel().setBounds(10, 0, 400, 94);
		this.getLabel().setVisible(true);
		
		
		this.setImagemHome(new JLabel());
		this.getImagemHome().setIcon(new ImageIcon("Feature//PauseGame1.png"));
		this.getImagemHome().setBounds(0, -10,640,500);
		
		this.setSize(640,500);
		this.setLayout(null);
		this.setVisible(true);
		this.add(this.getReturnGame());
		this.add(this.getQuitGame());
		this.add(this.getControls());
		this.add(this.getLabel());
		this.add(this.getLabel());
		this.add(this.getImagemHome());

		
		
	}
	
	
	


	public Fase getFase() {
		return fase;
	}





	public void setFase(Fase fase) {
		this.fase = fase;
	}





	public JButton getControls() {
		return controls;
	}





	public void setControls(JButton controls) {
		this.controls = controls;
	}





	public JButton getQuitGame() {
		return quitGame;
	}





	public void setQuitGame(JButton quitGame) {
		this.quitGame = quitGame;
	}





	public JButton getReturnGame() {
		return returnGame;
	}




	public void setReturnGame(JButton returnGame) {
		this.returnGame = returnGame;
	}




	public String getNomeJogador() {
		return nomeJogador;
	}




	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}




	public JFrame getFrame() {
		return frame;
	}




	public void setFrame(JFrame frame) {
		this.frame = frame;
	}




	public PauseMenu getEssePainel() {
		return essePainel;
	}




	public void setEssePainel(PauseMenu essePainel) {
		this.essePainel = essePainel;
	}




	public JLabel getImagemHome() {
		return imagemHome;
	}




	public void setImagemHome(JLabel imagemHome) {
		this.imagemHome = imagemHome;
	}




	public JLabel getLabel() {
		return label;
	}




	public void setLabel(JLabel label) {
		this.label = label;
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Return game");
			putValue(SHORT_DESCRIPTION, "Press this button to return to play");
		}
		public void actionPerformed(ActionEvent e) {
			essePainel.setVisible(false);
			frame.remove(essePainel);
			frame.setVisible(false);;
			frame.validate();
			fase.setVisible(true);
			fase.setEmJogo(true);
			frame.setVisible(true);	
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Controls");
			putValue(SHORT_DESCRIPTION, "Press this button to display the commands of the game");
		}
		public void actionPerformed(ActionEvent e) {
			essePainel.setVisible(false);
			frame.setVisible(false);;
			frame.validate();
			frame.add(new Control(frame,essePainel,nomeJogador));
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
