package br.com.aw_agencia_digital;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.aw_agencia_digital.entidades.Cliente;
import br.com.aw_agencia_digital.entidades.Lojas;

public class Aplicacao {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AW-DIGITAL");
		
		EntityManager em = emf.createEntityManager();
		System.out.println("Criado");

		Cliente cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setNomeCliente("André");
		cliente.setCnpj("9999999");
		cliente.setNumeroContato("81921312312");
		cliente.setQntdLojas(2);
		cliente.setIdLoja(1);
		cliente.setValorGestão(500);
		cliente.setDiaPagamento("20/07/2023");
		
		Lojas lojas = new Lojas();
		lojas.setIdLoja(1);
		lojas.setNomeLoja("Sabores a mesa");
		lojas.setNumeroLoja("819546354");
		lojas.setInvestimentoLoja(600);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.persist(lojas);
		em.getTransaction().commit();
		
		em.detach(cliente);
		em.detach(lojas);
		
		var mostrarClientes = cliente = em.find(Cliente.class, cliente.getIdLoja());
		System.out.println("Nome do cliente: " + cliente.getNomeCliente() + " " + cliente.getIdCliente());
		
		var mostrarLojas = lojas = em.find(Lojas.class, lojas.getIdLoja());
		System.out.println("Nome da loja: " + lojas.getNomeLoja() + " " + lojas.getIdLoja());
		
		
		var contemCliente = em.contains(mostrarClientes);
		var contemLojas = em.contains(mostrarLojas);
		
		System.out.println("Contem cliente : " + contemCliente);
		System.out.println("Contem lojas : " + contemLojas);
		
		
		
	}

}
