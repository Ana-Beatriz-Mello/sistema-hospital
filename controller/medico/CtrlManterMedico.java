package controller.medico;

import controller.AbstractCtrl;
import controller.ControllerException;
import controller.CtrlPrograma;
import model.Medico;
import model.ModelException;
import model.dao.DaoMedico;
import viewer.JanelaManterMedico;
import controller.medico.CtrlExcluirMedico;

public class CtrlManterMedico extends AbstractCtrl {
	
	private JanelaManterMedico janela;

	public CtrlManterMedico(CtrlPrograma ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {
		
		janela = new JanelaManterMedico(this);
		this.atualizarListaDeMedico();
		janela.setVisible(true);
		
	}

	public void encerrar() {
		
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
		
	}
	
	public void atualizarListaDeMedico() {
		
		DaoMedico dao = new DaoMedico();
		Medico[] conjMedicos;
		try {
			
			conjMedicos = (Medico[])dao.consultarTodos();
			
		} catch (ModelException e) {
			
			e.printStackTrace();
			return;
			
		}
		
		janela.exibirMedicos(conjMedicos);	
		
	}
	
	public void retomarExecucao() {
		
		this.atualizarListaDeMedico();	
		
	}

	public void iniciarIncluirMedico() {
		
		new CtrlIncluirMedico(this);
		
	}

	public void iniciarAlterarMedico(Medico selecionado) {
		
		try {
			
			new CtrlAlterarMedico(this, selecionado);
			
		} catch (ControllerException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void iniciarExcluirMedico(Medico selecionado) {
		
			try {
				
				new CtrlExcluirMedico(this, selecionado);
				
			} catch (ControllerException e) {
				
				e.printStackTrace();
				
			}
			
	}

}
