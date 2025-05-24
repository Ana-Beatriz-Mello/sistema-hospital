package viewer;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.planoDeSaude.CtrlManterPlano;
import model.PlanoDeSaude;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaManterPlano extends AbstractViewer {

	private JPanel           contentPane;
	private DefaultListModel listaObjetos;
	private JList 			 lstPlanos; 

	/**
	 * Create the frame.
	 */
	public JanelaManterPlano(CtrlManterPlano ctrl) {
		super(ctrl);
		setTitle("Cadastro de PLanos de Saúde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		lstPlanos = new JList();
		lstPlanos.setBounds(24, 11, 382, 191);
		contentPane.add(lstPlanos);
		
		JButton btIncluir = new JButton("Incluir");
		btIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterPlano ctrl = (CtrlManterPlano)getMeuControlador();
				ctrl.iniciarIncluirPlano();
			}
		});
		btIncluir.setBounds(24, 213, 89, 23);
		contentPane.add(btIncluir);
		
		JButton btAlterar = new JButton("Alterar");
		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanoDeSaude selecionado = (PlanoDeSaude) lstPlanos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um plano de saúde.");
					return;
				}
				CtrlManterPlano ctrl = (CtrlManterPlano)getMeuControlador();
				ctrl.iniciarAlterarPlano(selecionado);
			}
		});
		btAlterar.setBounds(123, 213, 89, 23);
		contentPane.add(btAlterar);
		
		JButton btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanoDeSaude selecionado = (PlanoDeSaude) lstPlanos.getSelectedValue();
				if(selecionado == null) {
					JOptionPane.showMessageDialog(null, "Selecione um plano de saúde.");
					return;
				}
				CtrlManterPlano ctrl = (CtrlManterPlano)getMeuControlador();
				ctrl.iniciarExcluirPlano(selecionado);
			}
		});
		btExcluir.setBounds(222, 213, 89, 23);
		contentPane.add(btExcluir);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlManterPlano ctrl = (CtrlManterPlano)getMeuControlador();
				ctrl.encerrar();
			}
		});
		btSair.setBounds(321, 213, 89, 23);
		contentPane.add(btSair);
	}
	
	public void exibirPlanos(PlanoDeSaude[] conjPlanos) {
		this.listaObjetos = new DefaultListModel();
		for(int i = 0; i < conjPlanos.length; i++)
			this.listaObjetos.addElement(conjPlanos[i]);
		this.lstPlanos.setModel(this.listaObjetos);
	}
}
