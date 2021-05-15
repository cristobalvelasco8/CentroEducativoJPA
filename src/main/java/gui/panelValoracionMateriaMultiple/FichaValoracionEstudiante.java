package gui.panelValoracionMateriaMultiple;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;
import model.controllers.ControladorValoracionMateria;

import java.awt.Insets;
import java.awt.Font;

public class FichaValoracionEstudiante extends JPanel {
	JLabel lblEstudiante;
	private JTextField jtfValoracion;
	
	private Profesor profesor;
	private Materia materia;
	private Estudiante estudiante;
	private ValoracionMateria vActual;

	/**
	 * Create the panel.
	 */
	public FichaValoracionEstudiante(Profesor profesor, Materia materia, Estudiante estudiante) {
		
		this.profesor = profesor;
		this.materia = materia;
		this.estudiante = estudiante;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblEstudiante = new JLabel("Estudiante:");
		lblEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblEstudiante = new GridBagConstraints();
		gbc_lblEstudiante.insets = new Insets(0, 0, 0, 5);
		gbc_lblEstudiante.anchor = GridBagConstraints.EAST;
		gbc_lblEstudiante.gridx = 0;
		gbc_lblEstudiante.gridy = 0;
		add(lblEstudiante, gbc_lblEstudiante);
		
		jtfValoracion = new JTextField();
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 0;
		add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		configuraFicha();
	}
	
	
	/**
	 * 
	 */
	private void configuraFicha() {
		// configuro el texto del JLabel para mostrar apellidos y nombre del estudiante
		if (this.estudiante != null) {
			lblEstudiante.setText(this.estudiante.getApellido1() + " " + this.estudiante.getApellido2() + ", " +
					this.estudiante.getNombre());
		}
		
		// Busco en la BBDD si ya existe una valoración para el estudiante, materia y profesor seleccionados.
		this.vActual = ControladorValoracionMateria.getInstancia().findEstProfMat(profesor, materia, estudiante);
		if (this.vActual != null) {
			this.jtfValoracion.setText("" + this.vActual.getValoracion());
		}
		else {
			this.vActual = new ValoracionMateria();
			this.vActual.setMateria(materia);
			this.vActual.setProfesor(profesor);
			this.vActual.setEstudiante(estudiante);
		}
	}

	
	/**
	 * 
	 */
	public void guardaValoracion() {
		String strValoracion = this.jtfValoracion.getText();
		if (!strValoracion.equals("")) {
			this.vActual.setValoracion(Float.parseFloat(this.jtfValoracion.getText()));
			ControladorValoracionMateria.getInstancia().guardar(vActual);
		}
	}
}
