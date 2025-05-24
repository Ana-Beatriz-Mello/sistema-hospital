package controller.medico;

import model.ModelException;
import model.dao.DaoMedico;
import viewer.JanelaMedico;
import model.Medico;

public class CtrlIncluirMedico extends AbstractCtrlMedico {
	
	private JanelaMedico janela;

	//------------------------------------------------------------------------//

	public CtrlIncluirMedico(CtrlManterMedico ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {

		janela = new JanelaMedico(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmMedico( String cpf, int crm, String nome, String endereco ) {
		
		try {
			
			Medico a = new Medico( cpf, crm, nome, endereco );

			DaoMedico dao = new DaoMedico();
			dao.incluir(a);
			dao.commit();

			this.encerrar();
			
		} catch (Exception e1) {
			
			janela.notificar(e1.getMessage());
			
		}

	}

	public void encerrar() {
		
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
		
	}
}
