package viewer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.medico.CtrlManterMedico;
import model.Medico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaManterMedico extends AbstractViewer {

	private JPanel           contentPane;
	private DefaultListModel listaObjetos;
	private JList 			 lstMedicos; 

	/**
	 * Create the frame.
	 */
	public JanelaManterMedico(CtrlManterMedico ctrl) {
		super(ctrl);
		setTitle("Cadastro de Médicos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lstMedicos = new JList();
		lstMedicos.setBounds(24, 11, 382, 191);
		contentPane.add(lstMedicos);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterMedico ctrl = (CtrlManterMedico)getMeuControlador();
				ctrl.iniciarIncluirMedico();
			}
		});
		btIncluir.setBounds(24, 213, 89, 23);
		contentPane.add(btIncluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico selecionado = (Medico) lstMedicos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um médico.");
					return;
				}
				CtrlManterMedico ctrl = (CtrlManterMedico)getMeuControlador();
				ctrl.iniciarAlterarMedico(selecionado);
			}
		});
		btAlterar.setBounds(123, 213, 89, 23);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medico selecionado = (Medico) lstMedicos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um médico.");
					return;
				}
				CtrlManterMedico ctrl = (CtrlManterMedico)getMeuControlador();
				ctrl.iniciarExcluirMedico(selecionado);
			}
		});
		btExcluir.setBounds(222, 213, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterMedico ctrl = (CtrlManterMedico)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(321, 213, 89, 23);
		contentPane.add(btSair);
	}
	
	public void exibirMedicos(Medico[] conjMedicos) {
		this.listaObjetos = new DefaultListModel();
		for(int i = 0; i < conjMedicos.length; i++)
			this.listaObjetos.addElement(conjMedicos[i]);
		this.lstMedicos.setModel(this.listaObjetos);
	}
}
