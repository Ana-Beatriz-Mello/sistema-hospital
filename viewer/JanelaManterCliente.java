package viewer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.cliente.CtrlManterCliente;
import model.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaManterCliente extends AbstractViewer {

	private JPanel           contentPane;
	private DefaultListModel listaObjetos;
	private JList 			 lstClientes; 

	/**
	 * Create the frame.
	 */
	public JanelaManterCliente(CtrlManterCliente ctrl) {
		super(ctrl);
		setTitle("Cadastro de Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lstClientes = new JList();
		lstClientes.setBounds(24, 11, 382, 191);
		contentPane.add(lstClientes);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterCliente ctrl = (CtrlManterCliente)getMeuControlador();
				ctrl.iniciarIncluirCliente();
			}
		});
		btIncluir.setBounds(24, 213, 89, 23);
		contentPane.add(btIncluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente selecionado = (Cliente) lstClientes.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente.");
					return;
				}
				CtrlManterCliente ctrl = (CtrlManterCliente)getMeuControlador();
				ctrl.iniciarAlterarCliente(selecionado);
			}
		});
		btAlterar.setBounds(123, 213, 89, 23);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente selecionado = (Cliente) lstClientes.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um cliente.");
					return;
				}
				CtrlManterCliente ctrl = (CtrlManterCliente)getMeuControlador();
				ctrl.iniciarExcluirCliente(selecionado);
			}
		});
		btExcluir.setBounds(222, 213, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterCliente ctrl = (CtrlManterCliente)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(321, 213, 89, 23);
		contentPane.add(btSair);
	}
	
	public void exibirClientes(Cliente[] conjClientes) {
		this.listaObjetos = new DefaultListModel();
		for(int i = 0; i < conjClientes.length; i++)
			this.listaObjetos.addElement(conjClientes[i]);
		this.lstClientes.setModel(this.listaObjetos);
	}
}
