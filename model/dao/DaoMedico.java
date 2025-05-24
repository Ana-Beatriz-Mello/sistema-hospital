package model.dao;

import model.Medico;
import model.ModelException;
import util.MinhaLista;

public class DaoMedico extends AbstractDao {
	
	private static MinhaLista listaMedicos = new MinhaLista();
	
	public void incluirTodos( Object[] novaLista ) throws ModelException {
		
		for ( int i = 0; i < novaLista.length; i++ ) {
			
			if ( !( novaLista[i] instanceof Medico ) )
				
				throw new ModelException( "Há um objeto que não é Médico na lista." );
			
			DaoMedico.listaMedicos.incluir( novaLista[i] );
			
		}
		
	}


	

	public static int getNumMedico() {
		
		return DaoMedico.listaMedicos.getNumElementos();
		
	}

	public void incluir(Object novo) throws ModelException {
		
		if(! (novo instanceof Medico) )
			
			throw new ModelException("Você solicitou a persistência de um objeto que não é Médico.");
		
		DaoMedico.listaMedicos.incluir( novo );	
		
	}
	
	public void alterar(Object obj) throws ModelException {
		
		if(! (obj instanceof Medico) )
			
			throw new ModelException("Você solicitou a alteração de um objeto que não é Médico.");

		if (DaoMedico.listaMedicos.posicaoElemento( obj ) == MinhaLista.NAO_ACHEI )
			
			throw new ModelException( "Você solicitou a alteração de um objeto que não existe." );
			
	}

	public void excluir(Object obj) throws ModelException {

		if(! ( obj instanceof Medico ) )
			
			throw new ModelException("Você solicitou a exclusão de um objeto que não é Médico.");

		if ( this.listaMedicos.excluir( obj ) == false )
			
			throw new ModelException( "Você solicitou a exclusão de um objeto que não existe." );
		
	}

	public Medico[] consultarTodos() throws ModelException {
		
		Object[] conj = DaoMedico.listaMedicos.obterElementos();
		Medico[] copia = new Medico[ conj.length ];
		for ( int i = 0; i < conj.length; i++ )
			
			copia[i] = (Medico)conj[i];
		
		return copia;		
	}

	public Medico consultarPeloCrm(int t) throws ModelException {
		for(int i = 0; i < DaoMedico.listaMedicos.getNumElementos(); i++) {
			
			Medico e = (Medico)DaoMedico.listaMedicos.elementoPos(i);			
			if( e.getCrm() ==  t ) {
				
				return e;
				
			}		
			
		}	
		
		return null;
		
	}
	
}