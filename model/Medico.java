package model;

import java.io.Serializable;

public class Medico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1862779996868556325L;
	public String cpf;
	public int crm;
	public String nome;
	public String endereco;
	
	public static final int NUM_MAX_MEDICOS = 100;
	public static final int TAM_CPF = 14;
	private static Medico[] listaMedicos = new Medico[NUM_MAX_MEDICOS];
	private static int numMedicos = 0;
	public static int TAM_MAX_ENDERECO = 40;
	public static int TAM_MIN_ENDERECO = 10;
	
	public Medico ( String c, int crm, String n, String endereco ) throws Exception {
		
		this.setCpf( c );
		this.setCrm ( crm );
		this.setNome ( n );
		this.setEndereco ( endereco );
		
	}
	
	public String toString() {
		
		String re;
		re = nome;
		re += " - ";
		re += this.crm;
		
		return re;
		
	}
	
	public String getEndereco() {
		
		return this.endereco;
		
	}
	
	public String getNome() {
		
		return this.nome;
		
	}
	
	public String getCpf() {
		
		return this.cpf;
		
	}
	
	public int getCrm() {
		
		return this.crm;
		
	}

/*
* 
* 
*
*/
					
	public static Medico[] getListaMedicos() {
					
		return Medico.listaMedicos;
					
	}
					

/*
* 
* 
* 
* 
*/
	
	
	public void setEndereco( String e ) throws Exception {
		
		Medico.validarEndereco( e );
		this.endereco = e;
		
	}
	
	public static void validarEndereco( String e ) throws Exception {
		
		if ( e == null )
			
			throw new Exception( "O endereço não pode ser nulo." );
		
		if ( e.length() < TAM_MIN_ENDERECO || e.length() > TAM_MAX_ENDERECO )
			
			throw new Exception( "O endereço deve ter entre " + TAM_MIN_ENDERECO + " e " + TAM_MAX_ENDERECO + " caracteres.");
		
	}
	
	public void setNome( String n ) throws Exception {
		
		validarNome( n );
		this.nome = n;
		
	}
	
	public static void validarNome( String n ) throws Exception {
		
		if ( n == null || n.length() == 0 )
			
			throw new Exception( "O nome não pode ser nulo." );
		
		for ( int i = 0; i < n.length(); i++ ) {
			
			char c = n.charAt( i );
			if ( !Character.isAlphabetic( c ) && c != ' ' )
				
				throw new Exception( "O nome deve conter apenas letras!" );
			
		}
		
	}
	
	public static int getNumMedicos() {
		
		return numMedicos;
		
	}
	
	public void setCrm(int crm ) throws Exception {
		
		Medico.validarCrm( crm );
		this.crm = crm;
		
	}
	
	public static void validarCrm( int crm ) throws Exception {
		
		if ( crm > 1000 || crm < 0 )
			
			throw new Exception( "O crm deve estar entre 0 e 1000." );
		
	}
	
	public void setCpf ( String c ) throws Exception {
		
		Medico.validarCpf( c );
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
	
}
