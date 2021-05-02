package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;



public class PanelSeleccion extends JPanel {
	
	Estudiante est = new Estudiante();
    private JLabel lblNombre;
    private JTextField jtfNota;

	/**
	 * Create the panel.
	 */
	public PanelSeleccion() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{87, 451, 97, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 51, 22, 41, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{174, 97, 0};
		gbl_panel_1.rowHeights = new int[]{27, 35, 33, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblNombre = new JLabel(this.est.getNombre() + " " + this.est.getApellido1() + " " + this.est.getApellido2() + " : ");
		GridBagConstraints gbc_lblJulio = new GridBagConstraints();
		gbc_lblJulio.insets = new Insets(0, 0, 5, 5);
		gbc_lblJulio.gridx = 0;
		gbc_lblJulio.gridy = 0;
		panel_1.add(lblNombre, gbc_lblJulio);
		
		jtfNota = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_1.add(jtfNota, gbc_textField);
		jtfNota.setColumns(10);

	}
	


}
