package controller.medico;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.ModelException;
import model.Medico;
import model.dao.DaoMedico;
import viewer.JanelaMedico;

public class CtrlAlterarMedico extends AbstractCtrlMedico {
	
	private JanelaMedico janela;
	final private Medico medicoParaAlterar;

	public CtrlAlterarMedico(AbstractCtrl ctrlPai, Medico medico) throws ControllerException {
		
		super(ctrlPai);
		if(medico == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Alteração do Médico sem ter o objeto.");
		
		this.medicoParaAlterar = medico;		
		janela.exibirMedico(this.medicoParaAlterar);
		
	}

	public void iniciar() {

		janela = new JanelaMedico(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmMedico( String cpf, int crm, String nome, String endereco ) {
		
		try {
			
			try {
				
				this.medicoParaAlterar.setCpf( cpf );
				
			} catch (Exception e3) {
				
				e3.printStackTrace();
				
			}
			try {
				
				this.medicoParaAlterar.setCrm( crm );
				
			} catch (Exception e2) {

				e2.printStackTrace();
				
			}
			try {
				this.medicoParaAlterar.setNome( nome );
			} catch (Exception e1) {

				e1.printStackTrace();
				
			}
			
			try {
				this.medicoParaAlterar.setEndereco( endereco );
			} catch (Exception e4) {

				e4.printStackTrace();
				
			}
	
			DaoMedico dao = new DaoMedico();
			dao.alterar(this.medicoParaAlterar);
			dao.commit();

			this.encerrar();
			
		} catch (ModelException e1) {
			
			janela.notificar(e1.getMessage());
			
		}

	}

	//------------------------------------------------------------------------//

	public void encerrar() {
		
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
		
	}
	
}
