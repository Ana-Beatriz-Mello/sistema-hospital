package viewer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.medico.AbstractCtrlMedico;
import controller.planoDeSaude.AbstractCtrlPlano;
import model.Medico;
import model.PlanoDeSaude;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPlanoDeSaude extends AbstractViewer {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfTelefone;

	public JanelaPlanoDeSaude(AbstractCtrlPlano meuCtrl) {
		super(meuCtrl);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(221, 47, 203, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(221, 117, 203, 26);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 123, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 51, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible( false );
				
			}
		});
		btCancelar.setBounds(34, 196, 130, 34);
		contentPane.add(btCancelar);
		
		JButton btOkay = new JButton("Okay");
		btOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = tfNome.getText();
				String aux = tfTelefone.getText();
				int telefone;
				
				try {
					
					telefone = Integer.parseInt( aux );
					
				}
				catch (  NumberFormatException e1 ) {
					
					JOptionPane.showMessageDialog(btOkay, "O campo telefone deve ser um número.");
					return;
					
				}
				
				AbstractCtrlPlano meuControlador = (AbstractCtrlPlano)getMeuControlador();				
				meuControlador.efetivarOperacaoEmPlano(nome, telefone);
				
			}
		});
		btOkay.setBounds(274, 196, 130, 34);
		contentPane.add(btOkay);
	}
	
	public void exibirPlano(PlanoDeSaude p) {
		this.tfNome.setText(p.getNome());
		this.tfTelefone.setText(Integer.toString(p.getTelefone()));
	}
	
	public void inabilitarCampos() {
		
		this.tfNome.setEnabled(false);
		this.tfTelefone.setEnabled(false);
	
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
