package controller.atendimento;

import controller.AbstractCtrl;
import model.Cliente;
import model.Medico;

abstract public class AbstractCtrlAtendimento extends AbstractCtrl {

	public AbstractCtrlAtendimento(AbstractCtrl ctrlPai)  {
		
		super(ctrlPai);
		
	}

	abstract public void efetivarOperacaoEmAtendimento( Cliente cliente, Medico medico, String data, String hora );

}
