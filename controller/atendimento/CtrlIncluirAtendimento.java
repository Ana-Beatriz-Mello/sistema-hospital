package controller.atendimento;

import model.Atendimento;
import model.ModelException;
import model.dao.DaoAtendimento;
import viewer.JanelaAtendimento;
import model.Cliente;
import model.Medico;

public class CtrlIncluirAtendimento extends AbstractCtrlAtendimento {
	
	private JanelaAtendimento janela;

	//------------------------------------------------------------------------//

	public CtrlIncluirAtendimento(CtrlManterAtendimento ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {

		janela = new JanelaAtendimento(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmAtendimento( Cliente cliente, Medico medico, String data, String hora ) {
		
		try {
			
			Atendimento a = new Atendimento( cliente, medico, data, hora );

			DaoAtendimento dao = new DaoAtendimento();
			dao.incluir(a);
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
