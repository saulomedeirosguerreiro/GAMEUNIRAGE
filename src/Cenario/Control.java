package Cenario;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.sound.sampled.DataLine;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Control extends JPanel{


	private JButton skip;
	private final SwingAction action = new SwingAction();
	private String nomeJogador;
	private JFrame frame;
	private Control essePainel;
	private JLabel imagemHome;
	private JLabel label;
	private PauseMenu pauseMenu;
	public Control(JFrame pai,PauseMenu pauseMenu, String nomeJogador){
		this.setNomeJogador(nomeJogador);
		this.setPauseMenu(pauseMenu);
		this.setFrame(pai);
		this.setEssePainel(this);
		
	    this.setSkip(new JButton("Skip"));
		this.getSkip().setBounds(550, 420, 80, 30);
		this.getSkip().setAction(action);
		this.getSkip().setVisible(true);
		
		
		this.setLabel(new JLabel("CONTROLS"));
		this.getLabel().setFont(new Font("Stencil", Font.PLAIN, 60));
		this.getLabel().setForeground(Color.white);
		this.getLabel().setBounds(160, 200, 400, 94);
		this.getLabel().setVisible(true);
		
		
		this.setImagemHome(new JLabel());
		this.getImagemHome().setIcon(new ImageIcon("Feature//TecladoCompleto.png"));
		this.getImagemHome().setBounds(0, -10,640,500);
		
		this.setSize(640,500);
		this.setLayout(null);
		this.setVisible(true);
		this.add(this.getSkip());
		this.add(this.getLabel());
		this.add(this.getImagemHome());

		
		
	}
	
	

	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}



	public void setPauseMenu(PauseMenu pauseMenu) {
		this.pauseMenu = pauseMenu;
	}



	public JButton getSkip() {
		return skip;
	}



	public void setSkip(JButton skip) {
		this.skip = skip;
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


	public Control getEssePainel() {
		return essePainel;
	}



	public void setEssePainel(Control essePainel) {
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
			putValue(NAME, "Skip");
			putValue(SHORT_DESCRIPTION, "Click this button to be directed to the next part");
		}
		public void actionPerformed(ActionEvent e) {
			if(pauseMenu==null){
				essePainel.setVisible(false);
				frame.remove(essePainel);
				frame.setVisible(false);;
				frame.validate();
				frame.add(new Fase(frame,nomeJogador));
				frame.setVisible(true);	
			}
			else{
				essePainel.setVisible(false);
				frame.remove(essePainel);
				frame.setVisible(false);;
				frame.validate();
				pauseMenu.setVisible(true);
				frame.setVisible(true);	
			}
		}
	}
	
}
