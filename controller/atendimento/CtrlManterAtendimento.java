package controller.atendimento;

import controller.AbstractCtrl;
import controller.ControllerException;
import controller.CtrlPrograma;
import model.Atendimento;
import model.ModelException;
import model.dao.DaoAtendimento;
import viewer.JanelaManterAtendimento;
import controller.atendimento.CtrlExcluirAtendimento;

public class CtrlManterAtendimento extends AbstractCtrl {
	
	private JanelaManterAtendimento janela;

	public CtrlManterAtendimento(CtrlPrograma ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {
		
		janela = new JanelaManterAtendimento(this);
		this.atualizarListaDeAtendimento();
		janela.setVisible(true);
		
	}

	public void encerrar() {
		
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
		
	}
	
	public void atualizarListaDeAtendimento() {
		
		DaoAtendimento dao = new DaoAtendimento();
		Atendimento[] conjAtendimentos;
		try {
			
			conjAtendimentos = (Atendimento[])dao.consultarTodos();
			
		} catch (ModelException e) {
			
			e.printStackTrace();
			return;
			
		}
		
		janela.exibirAtendimentos(conjAtendimentos);	
		
	}
	
	public void retomarExecucao() {
		
		this.atualizarListaDeAtendimento();	
		
	}

	public void iniciarIncluirAtendimento() {
		
		new CtrlIncluirAtendimento(this);
		
	}

	public void iniciarAlterarAtendimento(Atendimento selecionado) {
		
		try {
			
			new CtrlAlterarAtendimento(this, selecionado);
			
		} catch (ControllerException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void iniciarExcluirAtendimento(Atendimento selecionado) {
		
			try {
				
				new CtrlExcluirAtendimento(this, selecionado);
				
			} catch (ControllerException e) {
				
				e.printStackTrace();
				
			}
			
	}

}
