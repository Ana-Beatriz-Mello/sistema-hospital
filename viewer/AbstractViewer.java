package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.AbstractCtrl;

public class AbstractViewer extends JFrame {
	
	final private AbstractCtrl meuControlador;
	
	public AbstractViewer(AbstractCtrl meuControlador) {
		
		this.meuControlador = meuControlador;
		
	}

	public AbstractCtrl getMeuControlador() {
		
		return this.meuControlador;
		
	}
	
	public void notificar(String txt) {
		
		JOptionPane.showMessageDialog(null, txt);	
		
	}
	
}
