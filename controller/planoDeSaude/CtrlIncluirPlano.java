package controller.planoDeSaude;

import model.ModelException;
import model.dao.DaoPlano;
import viewer.JanelaPlanoDeSaude;
import model.PlanoDeSaude;

public class CtrlIncluirPlano extends AbstractCtrlPlano {
	
	private JanelaPlanoDeSaude janela;

	//------------------------------------------------------------------------//

	public CtrlIncluirPlano(CtrlManterPlano ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {

		janela = new JanelaPlanoDeSaude(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmPlano( String nome, int telefone ) {
		
		try {
			
			PlanoDeSaude p = new PlanoDeSaude( nome, telefone );

			DaoPlano dao = new DaoPlano();
			dao.incluir(p);
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
