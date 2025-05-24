package model.dao;

import model.Cliente;
import model.ModelException;
import util.MinhaLista;

public class DaoCliente extends AbstractDao {
	
	private static MinhaLista listaClientes = new MinhaLista();
	
	public void incluirTodos( Object[] novaLista ) throws ModelException {
		
		for ( int i = 0; i < novaLista.length; i++ ) {
			
			if ( !( novaLista[i] instanceof Cliente ) )
				
				throw new ModelException( "Há um objeto que não é Cliente na lista." );
			
			DaoCliente.listaClientes.incluir( novaLista[i] );
			
		}
		
	}


	

	public static int getNumCliente() {
		
		return DaoCliente.listaClientes.getNumElementos();
		
	}

	public void incluir(Object novo) throws ModelException {
		
		if(! (novo instanceof Cliente) )
			
			throw new ModelException("Você solicitou a persistência de um objeto que não é Cliente.");
		
		DaoCliente.listaClientes.incluir( novo );	
		
	}
	
	public void alterar(Object obj) throws ModelException {
		
		if(! (obj instanceof Cliente) )
			
			throw new ModelException("Você solicitou a alteração de um objeto que não é Cliente.");

		if (DaoCliente.listaClientes.posicaoElemento( obj ) == MinhaLista.NAO_ACHEI )
			
			throw new ModelException( "Você solicitou a alteração de um objeto que não existe." );
			
	}

	public void excluir(Object obj) throws ModelException {

		if(! ( obj instanceof Cliente ) )
			
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Cliente.");

		if ( this.listaClientes.excluir( obj ) == false )
			
			throw new ModelException( "Você solicitou a exclusão de um objeto que não existe." );
		
	}

	public Cliente[] consultarTodos() throws ModelException {
		
		Object[] conj = DaoCliente.listaClientes.obterElementos();
		Cliente[] copia = new Cliente[ conj.length ];
		for ( int i = 0; i < conj.length; i++ )
			
			copia[i] = (Cliente)conj[i];
		
		return copia;		
	}

	public Cliente consultarPeloCpf(String t) throws ModelException {
		for(int i = 0; i < DaoCliente.listaClientes.getNumElementos(); i++) {
			
			Cliente e = (Cliente)DaoCliente.listaClientes.elementoPos(i);			
			if( e.getCpf().equals( t ) ) {
				
				return e;
				
			}		
			
		}	
		
		return null;
		
	}
	
}