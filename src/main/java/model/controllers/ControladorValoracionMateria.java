package model.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;

public class ControladorValoracionMateria {

	private static ControladorValoracionMateria instancia = null;
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
	
	/**
	 * 
	 * @return
	 */
	public static ControladorValoracionMateria getInstancia() {
		if (instancia == null) {
			instancia = new ControladorValoracionMateria();
		}
		return instancia;
	}
	
	
	public ValoracionMateria findEstProfMat (Profesor profesor, Materia materia, Estudiante estudiante) {
		ValoracionMateria resultado = null;
		EntityManager em = factory.createEntityManager();
		 
		try {
			Query q = em.createNativeQuery("Select * from valoracionmateria where idProfesor = ? and "
					+ "idMateria = ? and idEstudiante = ?", ValoracionMateria.class);
			q.setParameter(1, profesor.getId());
			q.setParameter(2, materia.getId());
			q.setParameter(3, estudiante.getId());
			resultado = (ValoracionMateria) q.getSingleResult();
		}
		catch (Exception ex) {
		}
		em.close();
		return resultado;
	}
	
	public boolean guardar(ValoracionMateria f) {
		try {
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			if (f.getId() == 0) {
				em.persist(f);
			} else {
				em.merge(f);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public void borrar(ValoracionMateria f) {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		f = em.merge(f);
		em.remove(f);
		em.getTransaction().commit();
		em.close();
	}
}
