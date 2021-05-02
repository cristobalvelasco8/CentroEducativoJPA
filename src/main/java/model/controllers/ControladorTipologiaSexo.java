package model.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


import model.Estudiante;
import model.Tipologiasexo;

public class ControladorTipologiaSexo {

	private static ControladorTipologiaSexo instance = null;

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA"); 
	
	/**
	 * 
	 * @return
	 */
	public static ControladorTipologiaSexo getInstance () {
		if (instance == null) {
			instance = new ControladorTipologiaSexo();
		}
		return instance;
	}
	
	/**
	 * 
	 */
	public ControladorTipologiaSexo() {
	}
	
	
	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findPrimero () {
		Tipologiasexo m = null;
	
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id limit 1", Tipologiasexo.class);
		m = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return m;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findUltimo () {
		Tipologiasexo m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo order by id desc limit 1", Tipologiasexo.class);
		m = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return m;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findSiguiente (int idActual) {
		Tipologiasexo m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id > ? order by id limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		m = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return m;
	}
	

	/**
	 * 
	 * @return
	 */
	public Tipologiasexo findAnterior (int idActual) {
		Tipologiasexo m = null;
		
		EntityManager em = factory.createEntityManager();
		Query q = em.createNativeQuery("select * from centroeducativo.tipologiasexo where id < ? order by id desc limit 1", Tipologiasexo.class);
		q.setParameter(1, idActual);
		m = (Tipologiasexo) q.getSingleResult();
		em.close();
		
		return m;		
	}
	

	
	/**
	 * 
	 * @return
	 */
	public boolean guardar (Tipologiasexo m) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (m.getIdtipologiaSexo() == 0) {
				em.persist(m);
			}
			else {
				em.merge(m);
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
	public void borrar(Tipologiasexo m) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		m=em.merge(m);
		em.remove(m);
		em.getTransaction().commit();
		em.close();
	}
	public List<Tipologiasexo> findAll () {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createNativeQuery("SELECT * FROM tipologiasexo", Tipologiasexo.class);
		
		List<Tipologiasexo> list = (List<Tipologiasexo>) q.getResultList();
		em.close();
		return list;
	}

	
	

}
