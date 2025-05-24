package controller.cliente;

import controller.AbstractCtrl;
import controller.ControllerException;
import controller.CtrlPrograma;
import model.Cliente;
import model.ModelException;
import model.dao.DaoCliente;
import viewer.JanelaManterCliente;
import controller.cliente.CtrlExcluirCliente;

public class CtrlManterCliente extends AbstractCtrl {
	
	private JanelaManterCliente janela;

	public CtrlManterCliente(CtrlPrograma ctrlPai) {
		
		super(ctrlPai);
		
	}

	public void iniciar() {
		
		janela = new JanelaManterCliente(this);
		this.atualizarListaDeCliente();
		janela.setVisible(true);
		
	}

	public void encerrar() {
		
		this.janela.setVisible(false);
		this.notificarEncerramentoAoCtrlPai();
		
	}
	
	public void atualizarListaDeCliente() {
		
		DaoCliente dao = new DaoCliente();
		Cliente[] conjClientes;
		try {
			
			conjClientes = (Cliente[])dao.consultarTodos();
			
		} catch (ModelException e) {
			
			e.printStackTrace();
			return;
			
		}
		
		janela.exibirClientes(conjClientes);	
		
	}
	
	public void retomarExecucao() {
		
		this.atualizarListaDeCliente();	
		
	}

	public void iniciarIncluirCliente() {
		
		new CtrlIncluirCliente(this);
		
	}

	public void iniciarAlterarCliente(Cliente selecionado) {
		
		try {
			
			new CtrlAlterarCliente(this, selecionado);
			
		} catch (ControllerException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void iniciarExcluirCliente(Cliente selecionado) {
		
			try {
				
				new CtrlExcluirCliente(this, selecionado);
				
			} catch (ControllerException e) {
				
				e.printStackTrace();
				
			}
			
	}

}
