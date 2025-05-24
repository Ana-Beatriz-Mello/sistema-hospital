package controller.atendimento;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Atendimento;
import model.ModelException;
import model.dao.DaoAtendimento;
import viewer.JanelaAtendimento;
import model.Medico;
import model.Cliente;

public class CtrlAlterarAtendimento extends AbstractCtrlAtendimento {
	
	private JanelaAtendimento janela;
	final private Atendimento atendimentoParaAlterar;

	public CtrlAlterarAtendimento(AbstractCtrl ctrlPai, Atendimento atendimento) throws ControllerException {
		
		super(ctrlPai);
		if(atendimento == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Alteração do Atendimento sem ter o objeto.");
		
		this.atendimentoParaAlterar = atendimento;		
		janela.exibirAtendimento(this.atendimentoParaAlterar);
		
	}

	public void iniciar() {

		janela = new JanelaAtendimento(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmAtendimento( Cliente cliente, Medico medico, String data, String hora ) {
		
		try {
			
			try {
				this.atendimentoParaAlterar.setMeuCpf( cliente );
			} catch (Exception e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			try {
				this.atendimentoParaAlterar.setMeuCrm( medico );
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				this.atendimentoParaAlterar.setData( data );
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.atendimentoParaAlterar.setHora( hora );
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			DaoAtendimento dao = new DaoAtendimento();
			dao.alterar(this.atendimentoParaAlterar);
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
