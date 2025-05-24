package controller.atendimento;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Atendimento;
import model.Cliente;
import model.Medico;
import model.ModelException;
import model.dao.DaoAtendimento;
import viewer.JanelaAtendimento;

public class CtrlExcluirAtendimento extends AbstractCtrlAtendimento {
	
	private JanelaAtendimento janela;
	final private Atendimento atendimentoParaExcluir;

	public CtrlExcluirAtendimento(AbstractCtrl ctrlPai, Atendimento atendimento) throws ControllerException {
		
		super(ctrlPai);
		if(atendimento == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Exclusão do Atendimento sem ter o objeto");
		
		this.atendimentoParaExcluir = atendimento;		
		janela.exibirAtendimento(this.atendimentoParaExcluir);
		janela.inabilitarCampos();
		janela.colocarMsgDeExclusao();
		
	}
	
	public void iniciar() {

		janela = new JanelaAtendimento(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmAtendimento( Cliente cliente, Medico medico, String data, String hora ) {
		try {
			
			DaoAtendimento dao = new DaoAtendimento();
			dao.excluir(this.atendimentoParaExcluir);
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
