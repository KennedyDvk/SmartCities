package br.com.cidadesinteligentes.teste;

import java.time.LocalTime;
import java.util.List;

import br.com.cidadesinteligentes.domain.Trafego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TesteTrafeco {

	public static void main(String[] args) {

		EntityManagerFactory var = Persistence.createEntityManagerFactory("cidadesinteligentes");

		EntityManager em = var.createEntityManager();

		Trafego trafego = new Trafego();
		trafego.setHoraLeitura(LocalTime.of(8, 40));
		trafego.setVolumeTrafego("150");
		try {
			// Iniciando uma transação
			em.getTransaction().begin();

			// Salvando a classe
			em.persist(trafego);

			// Finalizando a transação
			em.getTransaction().commit();

			// Consultando
			Query query = em.createQuery("SELECT p FROM Trafego p WHERE p.volumeTrafego = :volumeTrafego");
			query.setParameter("volumeTrafego", "2500");
			List<Trafego> funcs = query.getResultList();

			if (!funcs.isEmpty()) {

				Trafego funcsAt = funcs.get(0);
				funcsAt.setVolumeTrafego("2500");

				// Iniciando
				 em.getTransaction().begin();

				// Atualizando
				 em.merge(funcsAt);

				// Finalizando
				 em.getTransaction().commit();

				// Consultando atualizado
				 funcsAt = em.find(Trafego.class, funcsAt.getVolumeTrafego());
				 System.out.println("Trafego atualizado: " + funcsAt);

				// Excluindo
	//			 em.getTransaction().begin();
	//			 em.remove(funcsAt);
	//			 em.getTransaction().commit();
			}

		} catch (Exception e) {

			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {

			em.close();
		}

		var.close();

	}
}
