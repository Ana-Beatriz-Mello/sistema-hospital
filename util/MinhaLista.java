package util;

import model.Cliente;
import model.Medico;
import model.Atendimento;
import model.ModelException;
import model.dao.DaoCliente;
import model.dao.DaoMedico;
import model.dao.DaoAtendimento;

public class MinhaLista {
	final public static int NAO_ACHEI = -1;
	final public static int FATOR_CRESCIMENTO = 1; 

	private Object[]   listaObjs;
	private int        numElementos;
	
	public MinhaLista() {
		
		this.listaObjs = new Object[FATOR_CRESCIMENTO];
		this.numElementos = 0;
		
	}
	
	public void incluir(Object novo) {
		
		if(this.numElementos == this.listaObjs.length) {
			
			Object[]  novoArray = new Object[this.listaObjs.length + FATOR_CRESCIMENTO];
			for(int i = 0; i < this.listaObjs.length; i++)
				novoArray[i] = this.listaObjs[i];
			this.listaObjs = novoArray;
			
		}
		
		this.listaObjs[ this.numElementos++ ] = novo;	
	}
	
	public int getNumElementos() {
		
		return this.numElementos;
		
	}
	
	public Object[] obterElementos() {
		
		Object[] copia = new Object[ this.numElementos ];
		for(int i = 0; i < this.numElementos; i++)
			
			copia[i] = this.listaObjs[i];
		
		return copia;
		
	}
	
	public Object elementoPos(int pos) throws ArrayIndexOutOfBoundsException {
		
		if(pos < this.numElementos)
			
			return this.listaObjs[ pos ];
		
		throw new ArrayIndexOutOfBoundsException(pos);
		
	}
	
	public int posicaoElemento(Object elem) {
		
		int pos = NAO_ACHEI ;
		for(int i = 0; i < this.numElementos; i++) {
			
			if(this.listaObjs[i] == elem) {
				
				pos = i;
				break;
				
			}	
			
		}
		
		return pos;		
		
	}

	public boolean excluir(Object elem) {
		
		int pos = this.posicaoElemento(elem);
		if(pos == NAO_ACHEI)
			
			return false;

		for(int i = pos; i < this.numElementos - 1; i++) {
			
			this.listaObjs[i] = this.listaObjs[i+1];
			
		}
		
		this.listaObjs[numElementos - 1] = null;
		this.numElementos--;
		return true;
		
	}
}
