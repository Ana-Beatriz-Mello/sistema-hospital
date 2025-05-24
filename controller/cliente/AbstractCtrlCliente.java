package controller.cliente;

import controller.AbstractCtrl;
import model.Cliente;
import model.PlanoDeSaude;

abstract public class AbstractCtrlCliente extends AbstractCtrl {

	public AbstractCtrlCliente(AbstractCtrl ctrlPai)  {
		
		super(ctrlPai);
		
	}

	abstract public void efetivarOperacaoEmCliente( String nome, String cpf, PlanoDeSaude plano );

}
