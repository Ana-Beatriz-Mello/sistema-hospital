package controller.planoDeSaude;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.ModelException;
import model.PlanoDeSaude;
import model.dao.DaoPlano;
import viewer.JanelaPlanoDeSaude;

public class CtrlAlterarPlano extends AbstractCtrlPlano {
	
	private JanelaPlanoDeSaude janela;
	final private PlanoDeSaude planoParaAlterar;

	public CtrlAlterarPlano(AbstractCtrl ctrlPai, PlanoDeSaude plano) throws ControllerException {
		
		super(ctrlPai);
		if(plano == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Alteração do Plano de Saúde sem ter o objeto.");
		
		this.planoParaAlterar = plano;		
		janela.exibirPlano(this.planoParaAlterar);
		
	}

	public void iniciar() {

		janela = new JanelaPlanoDeSaude(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmPlano( String nome, int telefone ) {
		
		try {
			
			try {
				
				this.planoParaAlterar.setNome( nome );
				
			} catch (Exception e3) {
				
				e3.printStackTrace();
				
			}
			try {
				
				this.planoParaAlterar.setTelefone( telefone );
				
			} catch (Exception e2) {

				e2.printStackTrace();
				
			}
	
			DaoPlano dao = new DaoPlano();
			dao.alterar(this.planoParaAlterar);
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
