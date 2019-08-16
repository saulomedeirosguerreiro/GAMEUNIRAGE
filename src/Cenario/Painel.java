package Cenario;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Painel extends JPanel{
	private JButton start;
	private Image ImagemHome;
	private JLabel label;
	private JLabel label2;
	private JTextField text;
	private final SwingAction action = new SwingAction();
	private String nomeJogador;
	private JFrame frame;
	private Painel essePainel;
	private JLabel imagemHome;
	
	public Painel(JFrame pai){
		
		this.setFrame(pai);
		this.setEssePainel(this);
		JButton start = new JButton("Start");
		this.setStart(start);
		this.getStart().setBounds(320, 180, 80, 20);
		start.setAction(action);
		this.getStart().setVisible(true);
		
		this.setLabel(new JLabel("UNIRAGE"));
		this.getLabel().setFont(new Font("Verdana", Font.PLAIN, 40));
		this.getLabel().setBounds(137, 10, 400, 94);
		this.getLabel().setVisible(true);
		
		this.setLabel2(new JLabel("FIGHTER"));
		this.getLabel2().setFont(new Font("Verdana", Font.PLAIN, 40));
		this.getLabel2().setBounds(137, 50, 400, 94);
		this.getLabel2().setVisible(true);
		
		this.setText(new JTextField("Player name"));
		this.getText().setBounds(137,180, 180, 20);
		this.getText().setDocument(new LimitaNroCaracteres(14));
		this.getText().setText("Player name");
		this.getText().setVisible(true);
		
		this.setImagemHome(new JLabel());
		this.getImagemHome().setIcon(new ImageIcon("Feature//Homeofthegame.png"));
		this.getImagemHome().setBounds(0, -10,640,500);
		
		this.setSize(640,500);
		this.setLayout(null);
		this.setVisible(true);
		this.add(this.getStart());
		this.add(this.getLabel());
		this.add(this.getLabel2());
		this.add(this.getText());
		this.add(this.getImagemHome());
		
		
	}
	
	
	public JLabel getImagemHome() {
		return imagemHome;
	}
	public void setImagemHome(JLabel imagemHome) {
		this.imagemHome = imagemHome;
	}
	public Painel getEssePainel() {
		return essePainel;
	}


	public void setEssePainel(Painel essePainel) {
		this.essePainel = essePainel;
	}


	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JTextField getText() {
		return text;
	}


	public void setText(JTextField text) {
		this.text = text;
	}


	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Start");
			putValue(SHORT_DESCRIPTION, "Click this button to start playing");
		}
		public void actionPerformed(ActionEvent e) {
			nomeJogador=text.getText();
			essePainel.setVisible(false);
			frame.remove(essePainel);
			frame.setVisible(false);;
			frame.validate();
			frame.add(new Control(frame,null,nomeJogador));
			frame.setVisible(true);	
		}
}
	
}
