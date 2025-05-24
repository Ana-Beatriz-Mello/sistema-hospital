package model.dao;

import model.PlanoDeSaude;
import model.ModelException;
import util.MinhaLista;

public class DaoPlano extends AbstractDao {
	
	private static MinhaLista listaPlanos = new MinhaLista();
	
	public void incluirTodos( Object[] novaLista ) throws ModelException {
		
		for ( int i = 0; i < novaLista.length; i++ ) {
			
			if ( !( novaLista[i] instanceof PlanoDeSaude ) )
				
				throw new ModelException( "Há um objeto que não é Plano de Saúde na lista." );
			
			DaoPlano.listaPlanos.incluir( novaLista[i] );
			
		}
		
	}


	

	public static int getNumPlanos() {
		
		return DaoPlano.listaPlanos.getNumElementos();
		
	}

	public void incluir(Object novo) throws ModelException {
		
		if(! (novo instanceof PlanoDeSaude) )
			
			throw new ModelException("Você solicitou a persistência de um objeto que não é Plano de Saúde.");
		
		DaoPlano.listaPlanos.incluir( novo );	
		
	}
	
	public void alterar(Object obj) throws ModelException {
		
		if(! (obj instanceof PlanoDeSaude) )
			
			throw new ModelException("Você solicitou a alteração de um objeto que não é Plano de Saúde.");

		if (DaoPlano.listaPlanos.posicaoElemento( obj ) == MinhaLista.NAO_ACHEI )
			
			throw new ModelException( "Você solicitou a alteração de um objeto que não existe." );
			
	}

	public void excluir(Object obj) throws ModelException {

		if(! ( obj instanceof PlanoDeSaude ) )
			
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Plano de Saúde.");

		if ( this.listaPlanos.excluir( obj ) == false )
			
			throw new ModelException( "Você solicitou a exclusão de um objeto que não existe." );
		
	}

	public PlanoDeSaude[] consultarTodos() throws ModelException {
		
		Object[] conj = DaoPlano.listaPlanos.obterElementos();
		PlanoDeSaude[] copia = new PlanoDeSaude[ conj.length ];
		for ( int i = 0; i < conj.length; i++ )
			
			copia[i] = (PlanoDeSaude)conj[i];
		
		return copia;		
	}

	public PlanoDeSaude consultarPeloNome(String t) throws ModelException {
		for(int i = 0; i < DaoPlano.listaPlanos.getNumElementos(); i++) {
			
			PlanoDeSaude e = (PlanoDeSaude)DaoPlano.listaPlanos.elementoPos(i);			
			if( e.getNome().equals(t) ) {
				
				return e;
				
			}		
			
		}	
		
		return null;
		
	}
	
}