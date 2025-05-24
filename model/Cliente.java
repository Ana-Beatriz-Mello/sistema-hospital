package model;

import java.io.Serializable;

public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4917043766271962257L;
	public String nome;
	public String cpf;
	private PlanoDeSaude meuPlano;
	
	public static final int TAM_CPF = 14;
	public static final int TAM_NOME = 70;
	public static final int MIN_NOME = 3;
	public static final int NUM_MAX_CLIENTES = 100;
	
	private static Cliente[] listaClientes = new Cliente[NUM_MAX_CLIENTES];
	private static int numClientes = 0;
	
	public Cliente( String n, String c, PlanoDeSaude p ) throws Exception {
		
		this.setNome( n );
		this.setCpf ( c );
		this.setMeuPlano ( p );
		
	}
	
	public String toString() {
		
		String re;
		re = this.nome;
		re += " - ";
		re += this.cpf;
		
		return re;
		
	}
	
	public static int getNumClientes() {
		
		return Cliente.numClientes;
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}
	
	public String getCpf() {
		
		return this.cpf;
		
	}
	
	public PlanoDeSaude getPlano() {
		
		return this.meuPlano;
		
	}
	
/*
 * 
 * 
 * 
 * 
 */
		
public static Cliente[] getListaClientes() {
			
	return Cliente.listaClientes;
			
}
		

/*
 * 
 * 
 * 
 * 
 */
	
	
public static void validarMeuPlano ( PlanoDeSaude p ) throws Exception { 
		
}
	
public void setMeuPlano ( PlanoDeSaude p ) throws Exception {
		
	Cliente.validarMeuPlano( p );
	this.meuPlano = p;
		
}
	
public void setCpf( String c ) throws Exception {
		
	Cliente.validarCpf( c );
	this.cpf = c;
		
}
	
public static void validarCpf( String cpf ) throws Exception {
		
	if( cpf == null || cpf.length() == 0 )
			
		throw new Exception("O cpf não pode ser nulo!");
		
	if( cpf.length() != TAM_CPF )
			
		throw new Exception("O cpf deve ter " + TAM_CPF + " caracteres!");
		
	for ( int i = 0; i < TAM_CPF; i++ ) {
			
		char c = cpf.charAt(i);
		switch(i) {
			case 3:
			case 7: 
				if(c != '.')
						
					throw new Exception("Na posição " + i + " deve aparecer um '.' no cpf!");
					break;
						
			case 11:
				if(c != '-')
						
					throw new Exception("Na posição " + i + " deve aparecer um '-' no cpf!");;
					break;
					
			default: 
				if(!Character.isDigit(c))
						
					throw new Exception("Na posição " + i + " deve aparecer dígito !");;
						
		}
		
	}	
	
}
	
public void setNome( String n ) throws Exception {
		
	validarNome( n );
	this.nome = n;
		
}
	
public static void validarNome( String n ) throws Exception {
		
	if ( n.length() > TAM_NOME || n.length() < MIN_NOME ) {
			
		throw new Exception( "Nome deve ter tamanho entre " + MIN_NOME + " e " + TAM_NOME + "." );
			
	}
		
	for ( int i = 0; i < n.length(); i++ ) {
			
		char c = n.charAt( i );
		if ( !Character.isAlphabetic( c ) && c != ' ' )
				
			throw new Exception( "O nome deve conter apenas letras!" );
			
		}
		
	}
		
}
