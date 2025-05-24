package model;

import java.io.Serializable;

public class PlanoDeSaude implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7903489055362011617L;
	public String nome;
	public int telefone;
	
	final public static int TAM_NOME = 50;
	final public static int NUM_MAX_PLANOS = 30;
	
	private static PlanoDeSaude[] listaPlanosDeSaude = new PlanoDeSaude[NUM_MAX_PLANOS];
	private static int numPlanosDeSaude = 0;
	
	public PlanoDeSaude ( String n, int t ) throws Exception {
		
		this.setNome( n );
		this.setTelefone( t );
		
	}
	
	public String toString() {
		
		return this.nome;
		
	}
	
	public static int getNumPlanos() {
		
		return PlanoDeSaude.numPlanosDeSaude;
		
	}
	
	public int getTelefone() {
		
		return this.telefone;
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}
	
/*
 * 
 * 
 * 
 * 
 */
	
	public static PlanoDeSaude[] getListaPlanosDeSaude() {
		return PlanoDeSaude.listaPlanosDeSaude;
	}
	
	
/*
 * 
 * 
 * 
 * 
 */
	
	public void setTelefone ( int t ) throws Exception {
		
		PlanoDeSaude.validarTelefone( t );
		this.telefone = t;
				
	}
	
	public static void validarTelefone ( int t ) throws Exception {
		
		if ( t < 0 )
			
			throw new Exception ( "O telefone não pode ser negativo." );
				
	}
	
	public void setNome ( String n ) throws Exception {
		
		validarNome( n );
		this.nome = n;
		
	}
	
	public static void validarNome ( String n ) throws Exception {
		
		if ( n == null || n.length() == 0 )
			
			throw new Exception( "O nome não pode ser nulo." );
		
		for ( int i = 0; i < n.length(); i++ ) {
			
			char c = n.charAt( i );
			if ( !Character.isAlphabetic( n.charAt( i ) ) && c != ' ' )
				
				throw new Exception( "O nome deve conter apenas letras." );
			
		}
		
		if ( n.length() > TAM_NOME )
			
			throw new Exception( "O nome deve ter no máximo tamanho " + TAM_NOME + ".");
		
	}
	
}
