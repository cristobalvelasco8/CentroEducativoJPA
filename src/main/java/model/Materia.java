package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String acronimo;

	private String nombre;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	private Curso curso;

	//bi-directional many-to-one association to ValoracionMateria
	@OneToMany(mappedBy="materia")
	private List<ValoracionMateria> valoracionmaterias;

	public Materia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAcronimo() {
		return this.acronimo;
	}

	public void setAcronimo(String acronimo) {
		this.acronimo = acronimo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<ValoracionMateria> getValoracionmaterias() {
		return this.valoracionmaterias;
	}

	public void setValoracionmaterias(List<ValoracionMateria> valoracionmaterias) {
		this.valoracionmaterias = valoracionmaterias;
	}

	public ValoracionMateria addValoracionmateria(ValoracionMateria valoracionmateria) {
		getValoracionmaterias().add(valoracionmateria);
		valoracionmateria.setMateria(this);

		return valoracionmateria;
	}

	public ValoracionMateria removeValoracionmateria(ValoracionMateria valoracionmateria) {
		getValoracionmaterias().remove(valoracionmateria);
		valoracionmateria.setMateria(null);

		return valoracionmateria;
	}

	@Override
	public String toString() {
		return nombre ;
	}
	

}