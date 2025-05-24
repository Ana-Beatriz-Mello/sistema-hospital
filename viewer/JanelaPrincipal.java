package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends AbstractViewer {

	private JPanel contentPane;

	public JanelaPrincipal(CtrlPrograma meuCtrl) {
		super(meuCtrl);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Janela Principal do Programa");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btAtendimento = new JButton("Atendimento");
		btAtendimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarManterAtendimento();
				
			}
		});
		btAtendimento.setBounds(10, 40, 114, 33);
		contentPane.add(btAtendimento);
		
		JButton btCliente = new JButton("Cliente");
		btCliente.setBounds(59, 126, 114, 33);
		contentPane.add(btCliente);
		btCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarManterCliente();
				
			}
		});
		
		JButton btPlanoDeSaude = new JButton("Plano de Saúde");
		btPlanoDeSaude.setBounds(293, 40, 114, 33);
		contentPane.add(btPlanoDeSaude);
		btPlanoDeSaude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarManterPlano();
				
			}
		});
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.encerrar();
				
			}
		});
		btSair.setBounds(151, 202, 114, 33);
		contentPane.add(btSair);
		
		JButton btMedico = new JButton("Médico");
		btMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CtrlPrograma ctrl = (CtrlPrograma)getMeuControlador();
				ctrl.iniciarManterMedico();
				
			}
		});
		btMedico.setBounds(240, 126, 114, 33);
		contentPane.add(btMedico);
	}

}