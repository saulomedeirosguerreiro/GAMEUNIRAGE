package Cenario;




import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ContainerDeJanelas extends JFrame{
	public ContainerDeJanelas(){
			this.add(new Painel(this));
//			this.add(new Fase(this,"saulo"));
			//this.add(new teste());
//			this.add(new GameOver(this,"SAULO MEDEIROS GUERREIRO",105000,1));
//			this.add(new PauseMenu(this));
//			this.add(new Control(this,null,"saulo"));
		
			
			
			
			this.setTitle("UNIRAGE FIGHTER");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
			this.setSize(640,500);
			setLocationRelativeTo(null);
			this.setResizable(false);
			this.setVisible(true);	
			
	}
	
}

