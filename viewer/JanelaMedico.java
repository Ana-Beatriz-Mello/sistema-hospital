package viewer;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.medico.AbstractCtrlMedico;
import model.Medico;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaMedico extends AbstractViewer {

	private JPanel contentPane;
	private JTextField tfCpf;
	private JTextField tfCrm;
	private JTextField tfNome;
	private JTextField tfEndereco;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public JanelaMedico(AbstractCtrlMedico meuCtrl) {
		super(meuCtrl);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AbstractCtrlMedico meuControlador = (AbstractCtrlMedico)getMeuControlador();				
				meuControlador.encerrar();
				
			}
		});
		btCancelar.setBounds(51, 213, 110, 37);
		contentPane.add(btCancelar);
		
		JButton btOkay = new JButton("Okay");
		btOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = tfCpf.getText();
				String aux = tfCrm.getText();
				String nome = tfNome.getText();
				int crm;
				String endereco = tfEndereco.getText();
				
				try {
					
					crm = Integer.parseInt( aux );
					
				}
				catch ( NumberFormatException e1 ) {
					
					JOptionPane.showMessageDialog(btOkay, "O campo CRM deve ser um número.");
					return;
					
				}
				
				AbstractCtrlMedico meuControlador = (AbstractCtrlMedico)getMeuControlador();				
				meuControlador.efetivarOperacaoEmMedico(cpf, crm, nome, endereco);
			}
		});
		btOkay.setBounds(271, 213, 110, 37);
		contentPane.add(btOkay);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(247, 5, 155, 33);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		tfCrm = new JTextField();
		tfCrm.setBounds(247, 49, 155, 33);
		contentPane.add(tfCrm);
		tfCrm.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(247, 93, 155, 33);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(28, 14, 61, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CRM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(28, 58, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(28, 102, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Endereço");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(28, 146, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(247, 137, 155, 33);
		contentPane.add(tfEndereco);
				
	}			
	
	public void exibirMedico(Medico m) {
		this.tfCpf.setText(m.getCpf());
		this.tfCrm.setText(Integer.toString(m.getCrm()));
		this.tfNome.setText(m.getNome());
		this.tfEndereco.setText(m.getEndereco());
	}
	
	public void inabilitarCampos() {
		
		this.tfCpf.setEnabled(false);
		this.tfCrm.setEnabled(false);
		this.tfNome.setEnabled(false);
		this.tfEndereco.setEnabled(false);
	
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

