package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;


import model.Materia;
import model.Profesor;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;


public class PanelNotas extends JPanel {
	
	
	private JComboBox<Materia> jcbMateria;
    private JComboBox<Profesor> jcbProfesor;
    PanelSeleccion pnlNotaEstudiante = new PanelSeleccion();
    private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public PanelNotas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{87, 451, 97, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 51, 22, 41, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 185, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Materia");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(jcbMateria, gbc_comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Profesor");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel.add(jcbProfesor, gbc_comboBox_1);
		
		JButton btnRefrescar = new JButton("Botón refrescar alumnado");
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.anchor = GridBagConstraints.EAST;
		gbc_btnRefrescar.gridx = 2;
		gbc_btnRefrescar.gridy = 1;
		panel.add(btnRefrescar, gbc_btnRefrescar);
		
		   scrollPane = new JScrollPane();
	        GridBagConstraints gbc_scrollAlumnos = new GridBagConstraints();
	        gbc_scrollAlumnos.insets = new Insets(0, 0, 5, 0);
	        gbc_scrollAlumnos.gridwidth = 3;
	        gbc_scrollAlumnos.fill = GridBagConstraints.BOTH;
	        gbc_scrollAlumnos.gridx = 0;
	        gbc_scrollAlumnos.gridy = 2;
	        add(scrollPane, gbc_scrollAlumnos);


	        // se inserta un panel de un estudiante
	        this.scrollPane.setViewportView(pnlNotaEstudiante);
		

		JButton btnGuardarNotas = new JButton("Guardar las notas de todos los alumnos");
		GridBagConstraints gbc_btnGuardarNotas = new GridBagConstraints();
		gbc_btnGuardarNotas.gridwidth = 2;
		gbc_btnGuardarNotas.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardarNotas.gridx = 1;
		gbc_btnGuardarNotas.gridy = 4;
		add(btnGuardarNotas, gbc_btnGuardarNotas);
		 cargarDatos();

	}
	
	private void cargarDatos() {
        List<Materia> materia = ControladorMateria.getInstance().findAll();

        for (Materia t : materia) {
            this.jcbMateria.addItem(t);
        }

        List<Profesor> profesor = ControladorProfesor.getInstance().findAll();

        for (Profesor t : profesor) {
            this.jcbProfesor.addItem(t);
        }

    }

}
