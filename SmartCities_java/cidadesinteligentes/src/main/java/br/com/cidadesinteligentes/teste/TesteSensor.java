package br.com.cidadesinteligentes.teste;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import br.com.cidadesinteligentes.domain.Sensor;
import br.com.cidadesinteligentes.domain.Trafego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TesteSensor {

	public static void main(String[] args) {

		EntityManagerFactory var = Persistence.createEntityManagerFactory("cidadesinteligentes");

		EntityManager em = var.createEntityManager();

		Sensor sensor = new Sensor();
		sensor.setLocalizacao("Rua dos Alfeneiros");
		sensor.setTipoSensor("Temperatura");
		LocalDate dtInstalacao = LocalDate.of(2005, 4, 6);
		sensor.setDtInstalacao(dtInstalacao);
		try {
			// Iniciando uma transação
			em.getTransaction().begin();

			// Salvando a classe
			em.persist(sensor);

			// Finalizando a transação
			em.getTransaction().commit();

			// Consultando
			Query query = em.createQuery("SELECT p FROM tipoSensor p WHERE p.tipoSensor = :tipoSensor");
			query.setParameter("tipoSensor", "2500");
			List<Sensor> funcs = query.getResultList();

			if (!funcs.isEmpty()) {

				Sensor funcsAt = funcs.get(0);
				funcsAt.setTipoSensor("Qualidade do Ar");

				// Iniciando
				em.getTransaction().begin();

				// Atualizando
				em.merge(funcsAt);

				// Finalizando
				em.getTransaction().commit();

				// Consultando atualizado
				funcsAt = em.find(Sensor.class, funcsAt.getTipoSensor());
				System.out.println("Sensor atualizado: " + funcsAt);

				// Excluindo
				// em.getTransaction().begin();
				// em.remove(funcsAt);
				// em.getTransaction().commit();
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
