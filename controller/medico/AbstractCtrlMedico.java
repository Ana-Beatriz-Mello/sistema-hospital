package controller.medico;

import controller.AbstractCtrl;
import model.Medico;

abstract public class AbstractCtrlMedico extends AbstractCtrl {

	public AbstractCtrlMedico(AbstractCtrl ctrlPai)  {
		
		super(ctrlPai);
		
	}

	abstract public void efetivarOperacaoEmMedico( String cpf, int crm, String nome, String endereço );

}
