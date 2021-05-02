package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Estudiante;
import model.Profesor;

public class ControladorProfesor {

	private static ControladorProfesor instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorProfesor getInstance () {
		if (instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorProfesor() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Profesor findPrimero () {
		Profesor p = null;
	
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id limit 1", Profesor.class);
		p = (Profesor) q.getSingleResult();
		em.close();
		
		return p;
	}
	

	/**
	 * 
	 * @return
	 */
	public Profesor findUltimo () {
		Profesor p = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor order by id desc limit 1", Profesor.class);
		p = (Profesor) q.getSingleResult();
		em.close();
		
		return p;
	}
	

	/**
	 * 
	 * @return
	 */
	public Profesor findSiguiente (int idActual) {
		Profesor p = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id > ? order by id limit 1", Profesor.class);
		q.setParameter(1, idActual);
		p = (Profesor) q.getSingleResult();
		em.close();
		
		return p;
	}
	

	/**
	 * 
	 * @return
	 */
	public Profesor findAnterior (int idActual) {
		Profesor p = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.profesor where id < ? order by id desc limit 1", Profesor.class);
		q.setParameter(1, idActual);
		p = (Profesor) q.getSingleResult();
		em.close();
		
		return p;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Profesor p) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (p.getId() == 0) {
				em.persist(p);
			}
			else {
				em.merge(p);
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
	public void borrar(Profesor p) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		p=em.merge(p);
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
	public List<Profesor> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM profesor", Profesor.class);
		
		List<Profesor> list = (List<Profesor>) q.getResultList();
		em.close();
		return list;
	}

	
	

}
