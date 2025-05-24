package controller.cliente;

import model.ModelException;
import model.PlanoDeSaude;
import model.dao.DaoCliente;
import viewer.JanelaCliente;
import model.Cliente;

public class CtrlIncluirCliente extends AbstractCtrlCliente {
	
	private JanelaCliente janela;

	//------------------------------------------------------------------------//

	public CtrlIncluirCliente(CtrlManterCliente ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {

		janela = new JanelaCliente(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmCliente( String nome, String cpf, PlanoDeSaude plano ) {
		
		try {
			
			Cliente a = new Cliente( nome, cpf, plano );

			DaoCliente dao = new DaoCliente();
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
