package viewer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.cliente.AbstractCtrlCliente;
import model.Cliente;
import model.ModelException;
import model.PlanoDeSaude;
import model.dao.DaoCliente;
import model.dao.DaoPlano;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaCliente extends AbstractViewer {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JComboBox cbPlano;

	public JanelaCliente(AbstractCtrlCliente meuCtrl) {
		super(meuCtrl);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(189, 23, 235, 28);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setColumns(10);
		tfCpf.setBounds(189, 64, 235, 28);
		contentPane.add(tfCpf);
		
		cbPlano = new JComboBox();
		cbPlano.setBounds(189, 142, 235, 28);
		contentPane.add(cbPlano);
		
		try {
			
			DaoPlano daoPlano = new DaoPlano();
			PlanoDeSaude[] lista = (PlanoDeSaude[])daoPlano.consultarTodos();
			for (int i = 0; i < daoPlano.getNumPlanos(); i++) {
				
				cbPlano.addItem(lista[i]);
				
			}
			
		} catch (ModelException e1) {
			
			System.out.println("Ocorreu algum problema na montagem da caixa de seleção: " + e1);
			
		}	
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(26, 30, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 71, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Plano de Saúde");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(26, 149, 100, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbstractCtrlCliente meuControlador = (AbstractCtrlCliente)getMeuControlador();
				meuControlador.encerrar();
				
			}
		});
		btCancelar.setBounds(36, 199, 128, 33);
		contentPane.add(btCancelar);
		
		JButton btOkay = new JButton("Okay");
		btOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = tfNome.getText();
				String cpf = tfCpf.getText();
				PlanoDeSaude plano = (PlanoDeSaude)cbPlano.getSelectedItem();
				
				AbstractCtrlCliente meuControlador = (AbstractCtrlCliente)getMeuControlador();
				meuControlador.efetivarOperacaoEmCliente( nome, cpf, plano );
					
			}

		});
		btOkay.setBounds(276, 200, 128, 30);
		contentPane.add(btOkay);
	}
		
	public void exibirCliente(Cliente c) {
		this.tfNome.setText(c.getNome());
		this.tfCpf.setText(c.getCpf());
		this.cbPlano.setSelectedItem(c.getPlano());
	}
	
	public void inabilitarCampos() {
		
		this.tfCpf.setEnabled(false);
		this.tfNome.setEnabled(false);
		this.cbPlano.setEnabled(false);
	
	}
	
	public void colocarMsgDeExclusao() {
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.RED);
		panel.setBounds(192, 82, 219, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Deseja efetivar");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 11, 199, 21);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("essa Exclusão?");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(10, 43, 199, 14);
		panel.add(lblNewLabel_4_1);
	}

}
