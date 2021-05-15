package gui.panelValoracionMateriaMultiple;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValoracionEstudiantes extends JPanel {

	JComboBox<Profesor> jcbProfesor;
	JComboBox<Materia> jcbMaterias;
	List<FichaValoracionEstudiante> fichasValoracion = new ArrayList<FichaValoracionEstudiante>();
	JScrollPane scrollPaneEstudiantes;
	
	/**
	 * Create the panel.
	 */
	public PanelValoracionEstudiantes() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Profesor:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 0;
		panel.add(jcbProfesor, gbc_jcbProfesor);
		
		JLabel lblNewLabel_1 = new JLabel("Materia");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbMaterias = new JComboBox<Materia>();
		GridBagConstraints gbc_jcbMaterias = new GridBagConstraints();
		gbc_jcbMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMaterias.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMaterias.gridx = 1;
		gbc_jcbMaterias.gridy = 1;
		panel.add(jcbMaterias, gbc_jcbMaterias);
		
		JButton btnRefrescar = new JButton("Refrescar estudiantes");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.anchor = GridBagConstraints.EAST;
		gbc_btnRefrescar.gridwidth = 2;
		gbc_btnRefrescar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRefrescar.gridx = 0;
		gbc_btnRefrescar.gridy = 2;
		panel.add(btnRefrescar, gbc_btnRefrescar);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardaValoraciones();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.weightx = 1.0;
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 0;
		panel_1.add(btnGuardar, gbc_btnGuardar);
		
		scrollPaneEstudiantes = new JScrollPane();
		add(scrollPaneEstudiantes, BorderLayout.CENTER);

		
		cargarMaterias();
		cargarProfesores();
	}
	
	/**
	 * 
	 */
	private void cargarMaterias() {
		List<Materia> materias = ControladorMateria.getInstance().findAll();
		for (Materia m : materias) {
			this.jcbMaterias.addItem(m);
		}
	}
	
	/**
	 * 
	 */
	private void cargarProfesores() {
		List<Profesor> profesores = ControladorProfesor.getInstance().findAll();
		for (Profesor p : profesores) {
			this.jcbProfesor.addItem(p);
		}
	}
	
	/**
	 * 
	 */
	private void cargarEstudiantes () {
		// Obtengo un listado de estudiantes y el profesor y materia seleccionada
		List<Estudiante> estudiantes = ControladorEstudiante.getInstance().findAll();
		Profesor profSeleccionado = (Profesor) this.jcbProfesor.getSelectedItem();
		Materia matSeleccionada = (Materia) this.jcbMaterias.getSelectedItem();
		
		// Creo todas las fichas de valoración de cada estudiante
		this.fichasValoracion.clear();
		for (Estudiante e : estudiantes) {
			this.fichasValoracion.add(new FichaValoracionEstudiante(profSeleccionado, matSeleccionada, e));
		}
		
		// Creo un panel, con BoxLayout vertical y se lo asigno al scrollpane
		JPanel pnl = new JPanel();
		pnl.setLayout(new GridBagLayout());
		
		for (int i = 0; i < this.fichasValoracion.size(); i++) {
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = i;
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1;
			pnl.add(this.fichasValoracion.get(i), c);
		}
		
		// Finalmente asigno el JPanel al scrollpane
		this.scrollPaneEstudiantes.setViewportView(pnl);
		this.scrollPaneEstudiantes.revalidate();
		this.scrollPaneEstudiantes.repaint();
	}
	
	
	/**
	 * 
	 */
	private void guardaValoraciones () {
		for (FichaValoracionEstudiante f : this.fichasValoracion) {
			f.guardaValoracion();
		}
		JOptionPane.showMessageDialog(null, "Valoraciones guardadas correctamente");
	}
}
