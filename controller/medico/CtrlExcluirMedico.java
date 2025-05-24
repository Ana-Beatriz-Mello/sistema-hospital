package controller.medico;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Medico;
import model.ModelException;
import model.dao.DaoMedico;
import viewer.JanelaMedico;

public class CtrlExcluirMedico extends AbstractCtrlMedico {
	
	private JanelaMedico janela;
	final private Medico medicoParaExcluir;

	public CtrlExcluirMedico(AbstractCtrl ctrlPai, Medico medico) throws ControllerException {
		
		super(ctrlPai);
		if(medico == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Exclusão do Médico sem ter o objeto");
		
		this.medicoParaExcluir = medico;		
		janela.exibirMedico(this.medicoParaExcluir);
		janela.inabilitarCampos();
		janela.colocarMsgDeExclusao();
		
	}
	
	public void iniciar() {

		janela = new JanelaMedico(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmMedico( String cpf, int crm, String nome, String endereco ) {
		try {
			
			DaoMedico dao = new DaoMedico();
			dao.excluir(this.medicoParaExcluir);
			dao.commit();

			this.encerrar();
			
		} catch (ModelException e1) {
			
			janela.notificar(e1.getMessage());
			
		}

	}

	public void encerrar() {
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
	}
}
