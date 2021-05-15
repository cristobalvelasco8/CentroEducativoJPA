package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;

public class ControladorEstudiante {

	private static ControladorEstudiante instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorEstudiante getInstance () {
		if (instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorEstudiante() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findPrimero () {
		Estudiante e = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id limit 1", Estudiante.class);
		e = (Estudiante) q.getSingleResult();
		em.close();
		
		return e;
	}
	

	/**
	 * 
	 * @return
	 */
	public Estudiante findUltimo () {
		Estudiante e = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante order by id desc limit 1", Estudiante.class);
		e = (Estudiante) q.getSingleResult();
		em.close();
		
		return e;
	}
	

	/**
	 * 
	 * @return
	 */
	public Estudiante findSiguiente (int idActual) {
		Estudiante e = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id > ? order by id limit 1", Estudiante.class);
		q.setParameter(1, idActual);
		e = (Estudiante) q.getSingleResult();
		em.close();
		
		return e;
	}
	

	/**
	 * 
	 * @return
	 */
	public Estudiante findAnterior (int idActual) {
		Estudiante e = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.estudiante where id < ? order by id desc limit 1", Estudiante.class);
		q.setParameter(1, idActual);
		e = (Estudiante) q.getSingleResult();
		em.close();
		
		return e;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Estudiante e) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (e.getId() == 0) {
				em.persist(e);
			}
			else {
				em.merge(e);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception e1) {
			e1.printStackTrace();
			return false;
		}
	}



	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(Estudiante e) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		e = em.merge(e);
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}

	public List<Estudiante> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM estudiante", Estudiante.class);
		
		List<Estudiante> list = (List<Estudiante>) q.getResultList();
		em.close();
		return list;
	}
	

	
	

}
