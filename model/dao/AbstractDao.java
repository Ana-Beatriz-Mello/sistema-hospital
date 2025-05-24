package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Cliente;
import model.Medico;
import model.ModelException;
import model.PlanoDeSaude;
import model.Atendimento;

abstract public class AbstractDao {
	
	public static boolean objetosRecuperados = false;

	final public void commit() {
		try {
			FileOutputStream arquivo = new FileOutputStream("C:/Temp/Hospital.bin");
			ObjectOutputStream oos = new ObjectOutputStream(arquivo);

			DaoCliente daoCliente = new DaoCliente();
			oos.writeObject( daoCliente.consultarTodos() );

			DaoMedico daoMedico = new DaoMedico();
			oos.writeObject( daoMedico.consultarTodos() );
			
			DaoAtendimento daoAtendimento = new DaoAtendimento();
			oos.writeObject( daoAtendimento.consultarTodos() );
			
			DaoPlano daoPlano = new DaoPlano();
			oos.writeObject( daoPlano.consultarTodos() );
			
			oos.close();
		}
		catch (ModelException e) {
			
			System.out.println("Erro: " + e.getMessage());
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Erro: " + e.getMessage());
			
		} catch (IOException e) {
			
			System.out.println("Erro: " + e.getMessage());
			
		}
	}

	public static void recuperarObjetos() {
		if(AbstractDao.objetosRecuperados)
			return;
		try {
			FileInputStream arquivo = new FileInputStream("C:/Temp/Hospital.bin");
			ObjectInputStream ois = new ObjectInputStream(arquivo);

			DaoCliente daoCliente = new DaoCliente();
			daoCliente.incluirTodos( (Cliente[]) ois.readObject() );
			
			DaoMedico daoMedico = new DaoMedico();
			daoMedico.incluirTodos( (Medico[]) ois.readObject() );
			
			DaoAtendimento daoAtendimento = new DaoAtendimento();
			Object obj = ois.readObject();
			daoAtendimento.incluirTodos(  (Atendimento[])obj );
			
			DaoPlano daoPlano = new DaoPlano();
			daoPlano.incluirTodos( (PlanoDeSaude[]) ois.readObject() );
			
			ois.close();
			AbstractDao.objetosRecuperados = true;
		}
		catch (ModelException e) {
			
			System.out.println("Erro: " + e.getMessage());	
			
		} catch (FileNotFoundException e) {
			
			System.out.println("Erro: " + e.getMessage());	
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Erro: " + e.getMessage());	
			
		} catch (IOException e) {
			
			System.out.println("Erro: " + e.getMessage());	
			
		}
	}
	
	abstract public void incluirTodos(Object[] lista) throws ModelException;

	abstract public void incluir(Object novo) throws ModelException;
	
	abstract public void alterar(Object obj) throws ModelException;

	abstract public void excluir(Object obj) throws ModelException;

	abstract public Object[] consultarTodos() throws ModelException;
	
}
