package controller.planoDeSaude;

import controller.AbstractCtrl;
import controller.ControllerException;
import controller.CtrlPrograma;
import model.PlanoDeSaude;
import model.ModelException;
import model.dao.DaoPlano;
import viewer.JanelaManterPlano;
import controller.planoDeSaude.CtrlExcluirPlano;

public class CtrlManterPlano extends AbstractCtrl {
	
	private JanelaManterPlano janela;

	public CtrlManterPlano(CtrlPrograma ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {
		
		janela = new JanelaManterPlano(this);
		this.atualizarListaDePlanos();
		janela.setVisible(true);
		
	}

	public void encerrar() {
		
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
		
	}
	
	public void atualizarListaDePlanos() {
		
		DaoPlano dao = new DaoPlano();
		PlanoDeSaude[] conjPlanos;
		try {
			
			conjPlanos = (PlanoDeSaude[])dao.consultarTodos();
			
		} catch (ModelException e) {
			
			e.printStackTrace();
			return;
			
		}
		
		janela.exibirPlanos(conjPlanos);	
		
	}
	
	public void retomarExecucao() {
		
		this.atualizarListaDePlanos();	
		
	}

	public void iniciarIncluirPlano() {
		
		new CtrlIncluirPlano(this);
		
	}

	public void iniciarAlterarPlano(PlanoDeSaude selecionado) {
		
		try {
			
			new CtrlAlterarPlano(this, selecionado);
			
		} catch (ControllerException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void iniciarExcluirPlano(PlanoDeSaude selecionado) {
		
			try {
				
				new CtrlExcluirPlano(this, selecionado);
				
			} catch (ControllerException e) {
				
				e.printStackTrace();
				
			}
			
	}

}
