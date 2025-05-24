package controller.cliente;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.ModelException;
import model.PlanoDeSaude;
import model.dao.DaoCliente;
import viewer.JanelaCliente;
import model.Cliente;

public class CtrlAlterarCliente extends AbstractCtrlCliente {
	
	private JanelaCliente janela;
	final private Cliente clienteParaAlterar;

	public CtrlAlterarCliente(AbstractCtrl ctrlPai, Cliente cliente) throws ControllerException {
		
		super(ctrlPai);
		if(cliente == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Alteração do Cliente sem ter o objeto.");
		
		this.clienteParaAlterar = cliente;		
		janela.exibirCliente(this.clienteParaAlterar);
		
	}

	public void iniciar() {

		janela = new JanelaCliente(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmCliente( String nome, String cpf, PlanoDeSaude plano ) {
		
		try {
			
			try {
				
				this.clienteParaAlterar.setNome( nome );
				
			} catch (Exception e3) {
				
				e3.printStackTrace();
				
			}
			try {
				
				this.clienteParaAlterar.setCpf( cpf );
				
			} catch (Exception e2) {

				e2.printStackTrace();
				
			}
			try {
				this.clienteParaAlterar.setMeuPlano( plano );
			} catch (Exception e1) {

				e1.printStackTrace();
				
			}
	
			DaoCliente dao = new DaoCliente();
			dao.alterar(this.clienteParaAlterar);
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
