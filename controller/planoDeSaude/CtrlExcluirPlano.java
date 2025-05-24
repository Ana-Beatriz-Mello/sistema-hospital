package controller.planoDeSaude;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.PlanoDeSaude;
import model.ModelException;
import model.dao.DaoPlano;
import viewer.JanelaPlanoDeSaude;

public class CtrlExcluirPlano extends AbstractCtrlPlano {
	
	private JanelaPlanoDeSaude janela;
	final private PlanoDeSaude planoParaExcluir;

	public CtrlExcluirPlano(AbstractCtrl ctrlPai, PlanoDeSaude plano) throws ControllerException {
		
		super(ctrlPai);
		if(plano == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Exclusão do Plano de Saúde sem ter o objeto");
		
		this.planoParaExcluir = plano;		
		janela.exibirPlano(this.planoParaExcluir);
		janela.inabilitarCampos();
		janela.colocarMsgDeExclusao();
		
	}
	
	public void iniciar() {

		janela = new JanelaPlanoDeSaude(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmPlano( String nome, int telefone ) {
		try {
			
			DaoPlano dao = new DaoPlano();
			dao.excluir(this.planoParaExcluir);
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
