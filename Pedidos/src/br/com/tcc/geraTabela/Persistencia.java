package br.com.tcc.geraTabela;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Persistencia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("usuario");
		
		factory.close();
		
	}

}
