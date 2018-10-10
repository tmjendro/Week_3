package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ListVehicle;

public class PartenerInCrime {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PoliceImpoundLot");
	
	public void cleanUp() {
		emfactory.close();
	}
	public void incomingCar(ListVehicle car) {

		EntityManager em2 = emfactory.createEntityManager();
		em2.getTransaction().begin();
		em2.persist(car);
		em2.getTransaction().commit();
		em2.close();

	}
	public void releaseCar(ListVehicle toDelete) {

		EntityManager em2 = emfactory.createEntityManager();
		em2.getTransaction().begin();
		
		TypedQuery<ListVehicle> typedQuery = em2.createQuery(
				"select car from ListVehicle car where car.license = :selectedLicense and car.make = :selectedMake and car.model = :selectedModel and car.productionYear = :selectedProductionYear",
				ListVehicle.class);
		typedQuery.setParameter("selectedLicense", toDelete.getLicense());
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedProductionYear", toDelete.getProductionYear());
		
		
		typedQuery.setMaxResults(1);
		ListVehicle result = typedQuery.getSingleResult();
		em2.remove(result);
		em2.getTransaction().commit();
		em2.close();

	}
	
	
	public List<ListVehicle> showAllCars() {

		EntityManager em2 = emfactory.createEntityManager();
		TypedQuery<ListVehicle> typedQuery = em2.createQuery("select car from ListVehicle car", ListVehicle.class);
		List<ListVehicle> allCars = typedQuery.getResultList();
		em2.close();

		return allCars;

	}

	
}
