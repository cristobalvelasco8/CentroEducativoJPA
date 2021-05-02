package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.ValoracionMateria;
import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValoracionMateria;

import java.awt.event.ActionListener;

public class PanelSeleccion extends JPanel {

	private JComboBox<Materia> jcbMateria;
	private JComboBox<Profesor> jcbProfesor;
	private JScrollPane scrollPane;
	JTextField jtfNota;

	public PanelSeleccion() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 268, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 61, 23, 130, 41, 59, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 80, 183, 200, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel_1);

		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(jcbMateria, gbc_comboBox);

		JLabel lblProfesor = new JLabel("Profesor:");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.insets = new Insets(0, 0, 0, 5);
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);

		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 1;
		panel.add(jcbProfesor, gbc_comboBox_1);

		JButton btnRefrescar = new JButton("Botón refrescar alumnado");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				scrollPane.setViewportView(getP());

			}
		});
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
		scrollPane.setPreferredSize(new Dimension(300, 300));
		add(scrollPane, gbc_scrollAlumnos);

		JButton btnNotas = new JButton("Guardar las notas de todos los alumnos");
		GridBagConstraints gbc_btnNotas = new GridBagConstraints();
		gbc_btnNotas.gridwidth = 2;
		gbc_btnNotas.insets = new Insets(0, 0, 5, 5);
		gbc_btnNotas.gridx = 1;
		gbc_btnNotas.gridy = 3;
		add(btnNotas, gbc_btnNotas);

		btnNotas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				List<Estudiante> estudiantes = ControladorEstudiante.getInstance().findAll();
				Profesor p = (Profesor) jcbProfesor.getSelectedItem();
				Materia m = (Materia) jcbMateria.getSelectedItem();

				for (Estudiante estudiante : estudiantes) {
					ValoracionMateria vm = ControladorValoracionMateria.getInstancia().findEstProfMat(p, m, estudiante);

					if (vm != null) {
						vm.setValoracion(Float.parseFloat(jtfNota.getText()));
						ControladorValoracionMateria.getInstancia().borrar(vm);
					} else {
						ValoracionMateria v = new ValoracionMateria();
						v.setEstudiante(estudiante);
						v.setMateria(m);
						v.setProfesor(p);
						ControladorValoracionMateria.getInstancia().guardar(v);
					}
				}
			}

		});
		
		cargarDatos();

	}
	
	public JPanel getP() {

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		int i = 1;
		List<Estudiante> estudiantes = ControladorEstudiante.getInstance().findAll();
		for (Estudiante estudiante : estudiantes) {

			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 0 + i;
			c.gridwidth = 1;
			c.anchor = GridBagConstraints.EAST;
			c.insets = new Insets(2, 2, 2, 2);
			panel.add(new JLabel(estudiante.toString()), c);

			c.gridx = 1;
			c.gridy = 0 + i;
			c.anchor = GridBagConstraints.WEST;
			panel.add(new JTextField(), c);

			ValoracionMateria vm = ControladorValoracionMateria.getInstancia().findEstProfMat(
					(Profesor) this.jcbProfesor.getSelectedItem(), (Materia) this.jcbMateria.getSelectedItem(),
					estudiante);

			i++;
		}

		return panel;
	}

	/**
	 * 
	 */
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

	/**
	 * 
	 */
	private void cargarEnPantalla() {

	}

}