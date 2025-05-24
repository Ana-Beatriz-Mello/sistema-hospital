package controller.planoDeSaude;

import controller.AbstractCtrl;
import model.Medico;

abstract public class AbstractCtrlPlano extends AbstractCtrl {

	public AbstractCtrlPlano(AbstractCtrl ctrlPai)  {
		
		super(ctrlPai);
		
	}

	abstract public void efetivarOperacaoEmPlano( String nome, int telefone );

}
