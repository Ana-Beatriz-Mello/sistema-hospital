package viewer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.atendimento.CtrlManterAtendimento;
import model.Atendimento;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaManterAtendimento extends AbstractViewer {

	private JPanel           contentPane;
	private DefaultListModel listaObjetos;
	private JList 			 lstAtendimentos; 

	/**
	 * Create the frame.
	 */
	public JanelaManterAtendimento(CtrlManterAtendimento ctrl) {
		super(ctrl);
		setTitle("Cadastro de Atendimentos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lstAtendimentos = new JList();
		lstAtendimentos.setBounds(24, 11, 382, 191);
		contentPane.add(lstAtendimentos);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterAtendimento ctrl = (CtrlManterAtendimento)getMeuControlador();
				ctrl.iniciarIncluirAtendimento();
			}
		});
		btIncluir.setBounds(24, 213, 89, 23);
		contentPane.add(btIncluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atendimento selecionado = (Atendimento) lstAtendimentos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um atendimento.");
					return;
				}
				CtrlManterAtendimento ctrl = (CtrlManterAtendimento)getMeuControlador();
				ctrl.iniciarAlterarAtendimento(selecionado);
			}
		});
		btAlterar.setBounds(123, 213, 89, 23);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atendimento selecionado = (Atendimento) lstAtendimentos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um atendimento.");
					return;
				}
				CtrlManterAtendimento ctrl = (CtrlManterAtendimento)getMeuControlador();
				ctrl.iniciarExcluirAtendimento(selecionado);
			}
		});
		btExcluir.setBounds(222, 213, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterAtendimento ctrl = (CtrlManterAtendimento)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(321, 213, 89, 23);
		contentPane.add(btSair);
	}
	
	public void exibirAtendimentos(Atendimento[] conjAtendimentos) {
		this.listaObjetos = new DefaultListModel();
		for(int i = 0; i < conjAtendimentos.length; i++)
			this.listaObjetos.addElement(conjAtendimentos[i]);
		this.lstAtendimentos.setModel(this.listaObjetos);
	}
}
