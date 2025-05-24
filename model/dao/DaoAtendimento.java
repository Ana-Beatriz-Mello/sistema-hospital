package model.dao;

import model.Atendimento;
import model.Cliente;
import model.ModelException;
import util.MinhaLista;

public class DaoAtendimento extends AbstractDao {
	
	private static MinhaLista listaAtendimentos = new MinhaLista();
	
	public void incluirTodos( Object[] novaLista ) throws ModelException {
		
		for ( int i = 0; i < novaLista.length; i++ ) {
			
			if ( !( novaLista[i] instanceof Atendimento ) )
				
				throw new ModelException( "Há um objeto que não é Atendimento na lista." );
			
			DaoAtendimento.listaAtendimentos.incluir( novaLista[i] );
			
		}
		
	}


	

	public static int getNumAtendimento() {
		
		return DaoAtendimento.listaAtendimentos.getNumElementos();
		
	}

	public void incluir(Object novo) throws ModelException {
		
		if(! (novo instanceof Atendimento) )
			
			throw new ModelException("Você solicitou a persistência de um objeto que não é Atendimento.");
		
		DaoAtendimento.listaAtendimentos.incluir( novo );	
		
	}
	
	public void alterar(Object obj) throws ModelException {
		
		if(! (obj instanceof Atendimento) )
			
			throw new ModelException("Você solicitou a alteração de um objeto que não é Atendimento.");

		if (DaoAtendimento.listaAtendimentos.posicaoElemento( obj ) == MinhaLista.NAO_ACHEI )
			
			throw new ModelException( "Você solicitou a alteração de um objeto que não existe." );
			
	}

	public void excluir(Object obj) throws ModelException {

		if(! ( obj instanceof Atendimento ) )
			
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Atendimento.");

		if ( this.listaAtendimentos.excluir( obj ) == false )
			
			throw new ModelException( "Você solicitou a exclusão de um objeto que não existe." );
		
	}

	public Atendimento[] consultarTodos() throws ModelException {
		
		Object[] conj = DaoAtendimento.listaAtendimentos.obterElementos();
		Atendimento[] copia = new Atendimento[ conj.length ];
		for ( int i = 0; i < conj.length; i++ )
			
			copia[i] = (Atendimento)conj[i];
		
		return copia;		
	}

	public Atendimento consultarPeloPaciente(Cliente c) throws ModelException {
		for(int i = 0; i < DaoAtendimento.listaAtendimentos.getNumElementos(); i++) {
			
			Atendimento e = (Atendimento)DaoAtendimento.listaAtendimentos.elementoPos(i);			
			if( e.getPaciente().equals( c ) ) {
				
				return e;
				
			}		
			
		}	
		
		return null;
		
	}
	
}