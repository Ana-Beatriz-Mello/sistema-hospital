package model;

import java.io.Serializable;

public class Atendimento implements Serializable {

	private static final long serialVersionUID = -3658947314066238376L;
	public Cliente meuCpf;
	public Medico meuCrm;
	public String data;
	public String hora;
	
	public static final int NUM_MAX_ATENDIMENTOS = 1000;
	public static final int MAX_HORA = 24;
	public static final int MAX_MINUTOS = 59;
	public static final int TAM_HORA = 5;
	public static final int TAM_DATA = 10;
	public static final int TAM_CPF = 14;
	
	
	private static Atendimento[] listaAtendimentos = new Atendimento[NUM_MAX_ATENDIMENTOS];
	private static int numAtendimentos = 0;
	
	public Atendimento( Cliente c, Medico crm, String d, String h ) throws Exception {
		
		this.setMeuCpf ( c );
		this.setMeuCrm( crm );
		this.setData( d );
		this.setHora( h );
				
	}
	
	public String toString() {
		
		return this.data;
		
	}
	
	public String getHora() {
		
		return this.hora;
		
	}
	
	public String getData() {
		
		return this.data;
		
	}
	
	public Medico getMedico() {
		
		return this.meuCrm;
		
	}
	
	public Cliente getPaciente() {
		
		return this.meuCpf;
		
	}
	
/*
* 
* 
*
*/					
	public static Atendimento[] getListaAtendimentos() {
						
		return Atendimento.listaAtendimentos;
						
	}

/*
* 
* 
* 
* 
*/
	
	
	
	public void setHora( String h ) throws Exception {
		
		Atendimento.validarHora( h );
		this.hora = h;
	
	}

	public static void validarHora ( String h ) throws Exception {
	
		if (h.length() != TAM_HORA)
		
			throw new Exception("O formato do horário é 'XX:XX' ");
		
		if (h.charAt(2) != ':')
		
			throw new Exception("O formato da hora deve ser XX:XX");
	
		if ( !Character.isDigit(h.charAt(0)) || !Character.isDigit(h.charAt(1)) || !Character.isDigit(h.charAt(3)) || !Character.isDigit(h.charAt(4)) )
		
			throw new Exception("O formato da hora deve ser XX:XX");
		
		String aux = "";
		aux = aux + h.charAt(0); 
		aux = aux + h.charAt(1);
		if ( Integer.parseInt( aux ) > MAX_HORA || Integer.parseInt( aux )  < 0 )
			
			throw new Exception( "Hora ultrapassou o limite entre 0 e 24 horas. ");	
		
		aux = "";
		aux = aux + h.charAt(3);
		aux = aux + h.charAt(4);
		if (Integer.parseInt( aux ) < 0 || Integer.parseInt( aux ) > MAX_MINUTOS )
		
			throw new Exception( "Quantidade máxima de minutos ultrapassada." );
			
	}
	
	
	public void setData ( String d ) throws Exception {
		
		Atendimento.validarData( d );
		this.data = d;
		
	}
	
	public static void validarData ( String d ) throws Exception {
		
		if ( d.length() != TAM_DATA )
			
			throw new Exception( "A data deve ter formato XX/XX/XXXX, resultando em um tamanho de " + TAM_DATA + " caracteres." );
		
		for ( int i = 0; i > d.length(); i++ ) {
			
			char c = d.charAt(i);
			switch ( i ) {
			
			case 2:
				if ( c != '/' )
					
					throw new Exception( "Na posição " + i + " deve haver uma barra (/). Siga o formato XX/XX/XXXX" );
				break;
			case 5:
				if ( c != '/' )
					
					throw new Exception( "Na posição " + i + " deve haver uma barra (/). Siga o formato XX/XX/XXXX" );
				break;
			default:
				if ( !Character.isDigit( c ) ) {
					
					throw new Exception( "Na posição " + i +  " deve haver um número. Siga o formato XX/XX/XXXX" );			
				}
			
			}
			
		}
		
		String num = "";
		num = num + d.charAt(0); 
		num = num + d.charAt(1);
		if ( Integer.parseInt(num) <= 0 || Integer.parseInt(num) > 31 ) 
			
			throw new Exception("O dia do mês deve ser entre 1 e 31.");
		
		num = "";
		num = num + d.charAt(3); 
		num = num + d.charAt(4);
		if ( Integer.parseInt(num) <= 0 || Integer.parseInt(num) > 12 )
			
			
			throw new Exception("O mês deve ser entre 01 e 12. > num:" + num + "\nnum==11:" + (Integer.parseInt(num)==11) + "\nnum>12:" + (Integer.parseInt(num) > 12) + "\nnum<0:" + (Integer.parseInt(num) < 0 ));
		
	}
	
	public void setMeuCrm ( Medico crm ) throws Exception {
		
		Atendimento.validarMeuCrm( crm );
		this.meuCrm = crm;
		
	}
	
	public static void validarMeuCrm( Medico crm ) throws Exception {
		
		if ( crm == null )
			
			throw new Exception( "O CRM não pode ser nulo." );
		
	}
	
	public void setMeuCpf ( Cliente c ) throws Exception {
		
		Atendimento.validarMeuCpf( c );
		this.meuCpf = c;
		
	}
	
	public static void validarMeuCpf( Cliente cpf ) throws Exception {
		
		if( cpf == null )
			
			throw new Exception( "O cpf não pode ser nulo." );
		
		}
	
	
}
