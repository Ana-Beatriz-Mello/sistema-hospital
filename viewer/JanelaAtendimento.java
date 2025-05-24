package viewer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import model.Atendimento;
import model.Cliente;
import model.Medico;
import model.ModelException;
import model.dao.DaoAtendimento;
import model.dao.DaoCliente;
import model.dao.DaoMedico;
import controller.atendimento.AbstractCtrlAtendimento;
import controller.atendimento.CtrlIncluirAtendimento;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaAtendimento extends AbstractViewer {

	private JPanel contentPane;
	private JTextField tfHora;
	private JTextField tfData;
	private JComboBox cbCpf;
	private JComboBox cbCrm;

	public JanelaAtendimento(AbstractCtrlAtendimento meuCtrl) {
		super(meuCtrl);
		
		setTitle("Atendimento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Médico");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 16, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 56, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hora");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 91, 69, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 133, 69, 21);
		contentPane.add(lblNewLabel_3);
		
		tfHora = new JTextField();
		tfHora.setBounds(167, 91, 240, 29);
		contentPane.add(tfHora);
		tfHora.setColumns(10);
		
		tfData = new JTextField();
		tfData.setColumns(10);
		tfData.setBounds(167, 131, 240, 29);
		contentPane.add(tfData);
		
		cbCpf = new JComboBox();
		cbCpf.setBounds(167, 51, 240, 29);
		contentPane.add(cbCpf);	
		
		try {
			
			DaoCliente daoCliente = new DaoCliente();
			Cliente[] lista = (Cliente[])daoCliente.consultarTodos();
			for (int i = 0; i < daoCliente.getNumCliente(); i++) {
				
				cbCpf.addItem(lista[i]);
				
			}
			
		} catch (ModelException e1) {
			
			System.out.println("Ocorreu algum problema na montagem da caixa de seleção: " + e1);
			
		}
		
		cbCrm = new JComboBox();
		cbCrm.setBounds(167, 11, 240, 29);
		contentPane.add(cbCrm);
		
		try {
			
			DaoMedico daoMedico = new DaoMedico();
			Medico[] lista = (Medico[])daoMedico.consultarTodos();
			for (int i = 0; i < daoMedico.getNumMedico(); i++) {
				
				cbCrm.addItem(lista[i]);
				
			}
			
		} catch (ModelException e1) {
			
			System.out.println("Ocorreu algum problema na montagem da caixa de seleção: " + e1);
			
		}
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbstractCtrlAtendimento meuControlador = (AbstractCtrlAtendimento)getMeuControlador();
				meuControlador.encerrar();
				
			}
		});
		btCancelar.setBounds(28, 207, 106, 29);
		contentPane.add(btCancelar);
		
		JButton btOkay = new JButton("Okay");
		btOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String data = tfData.getText();
				String hora = tfHora.getText();
				Medico medico = (Medico)cbCrm.getSelectedItem();
				Cliente cliente = (Cliente)cbCpf.getSelectedItem();
				
				AbstractCtrlAtendimento meuControlador = (AbstractCtrlAtendimento)getMeuControlador();
				meuControlador.efetivarOperacaoEmAtendimento( cliente, medico, data, hora );
				
			}
		});
		btOkay.setBounds(301, 210, 106, 29);
		contentPane.add(btOkay);
	}
	
	public void exibirAtendimento(Atendimento a) {
		this.cbCpf.setSelectedItem(a.getPaciente());
		this.cbCrm.setSelectedItem(a.getMedico());
		this.tfData.setText(a.getData());
		this.tfHora.setText( a.getHora() );

	}
	
	public void inabilitarCampos() {
		
		this.cbCpf.setEnabled(false);
		this.cbCrm.setEnabled(false);
		this.tfData.setEnabled(false);
		this.tfHora.setEnabled(false);
		
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
