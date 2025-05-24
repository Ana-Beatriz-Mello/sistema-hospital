package controller.cliente;

import controller.AbstractCtrl;
import controller.ControllerException;
import model.Cliente;
import model.ModelException;
import model.PlanoDeSaude;
import model.dao.DaoCliente;
import viewer.JanelaCliente;

public class CtrlExcluirCliente extends AbstractCtrlCliente {
	
	private JanelaCliente janela;
	final private Cliente clienteParaExcluir;

	public CtrlExcluirCliente(AbstractCtrl ctrlPai, Cliente cliente) throws ControllerException {
		
		super(ctrlPai);
		if(cliente == null)
			
			throw new ControllerException("Não posso iniciar a funcionalidade de Exclusão do Cliente sem ter o objeto");
		
		this.clienteParaExcluir = cliente;		
		janela.exibirCliente(this.clienteParaExcluir);
		janela.inabilitarCampos();
		janela.colocarMsgDeExclusao();
		
	}
	
	public void iniciar() {

		janela = new JanelaCliente(this);
		janela.setVisible(true);
		
	}

	public void efetivarOperacaoEmCliente( String nome, String cpf, PlanoDeSaude plano ) {
		try {
			
			DaoCliente dao = new DaoCliente();
			dao.excluir(this.clienteParaExcluir);
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
