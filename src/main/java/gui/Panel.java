package gui;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import model.Tipologiasexo;
import model.controllers.ControladorTipologiaSexo;

import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JScrollPane;
import java.awt.Component;

public class Panel extends JPanel {
	
	JPanel p = new JPanel();

	public JTextField jtfNombre;
	public JTextField jtfprimerAp;
	public JTextField jtfSegundoApellido;
	public JTextField jtfDni;
	public JTextField jtfDireccion;
	public JTextField jtfEmail;
	public JTextField jtfTelefono;
	public JLabel lblSexo;
	public JComboBox<Tipologiasexo>jcbSexo;
	public JLabel lblcolor;
	public JTextField jtfcolor;
	public JButton btnSELECIONARCOLOR;
	JColorChooser jcolor;
	String strcolor;
	Color color;
	JFileChooser jfc;
	File fichero;
	public byte imagen[] = new byte[] {};
	public JScrollPane scrollPane;
	public JButton btnNewButton;
	private JPopupMenu popupMenu;
	private JLabel lblDimensiones;
	
	
	

	/**
	 * Create the application.
	 */
	public Panel() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 400, 180, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 25, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		scrollPane = new JScrollPane();
		
		popupMenu = new JPopupMenu();
		addPopup(scrollPane, popupMenu);
		
		lblDimensiones = new JLabel("");
        popupMenu.add(lblDimensiones);
		popupMenu.addSeparator();
        popupMenu.add(crearNuevoMenuItem("Cambiar imagen"));
        addPopup(scrollPane, popupMenu);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
	JPopupMenu popup = getPopUpMenu();
		
		// Evento para mostrar el men� en las coordenadas que correspondan
//		scrollPane.addMouseListener(new MouseAdapter() {
// 
//            @Override
//            public void mousePressed(MouseEvent e) {
//                showPopup(e);
//            }
// 
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                showPopup(e);
//            }
// 
//            /**
//             * M�todo llamado cuando se detecta el evento de rat�n, mostrar� el men�
//             * @param e
//             */
//            private void showPopup(MouseEvent e) {
//                if (e.isPopupTrigger()) {
//                    popup.show(e.getComponent(),
//                            e.getX(), e.getY());
//                }
//            }
//        });
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblPrimerAp = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblPrimerAp = new GridBagConstraints();
		gbc_lblPrimerAp.anchor = GridBagConstraints.EAST;
		gbc_lblPrimerAp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrimerAp.gridx = 0;
		gbc_lblPrimerAp.gridy = 2;
		add(lblPrimerAp, gbc_lblPrimerAp);
		
		jtfprimerAp = new JTextField();
		GridBagConstraints gbc_jtfprimerAp = new GridBagConstraints();
		gbc_jtfprimerAp.insets = new Insets(0, 0, 5, 5);
		gbc_jtfprimerAp.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfprimerAp.gridx = 1;
		gbc_jtfprimerAp.gridy = 2;
		add(jtfprimerAp, gbc_jtfprimerAp);
		jtfprimerAp.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblSegundoApellido = new GridBagConstraints();
		gbc_lblSegundoApellido.anchor = GridBagConstraints.EAST;
		gbc_lblSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblSegundoApellido.gridx = 0;
		gbc_lblSegundoApellido.gridy = 3;
		add(lblSegundoApellido, gbc_lblSegundoApellido);
		
		jtfSegundoApellido = new JTextField();
		GridBagConstraints gbc_jtfSegundoApellido = new GridBagConstraints();
		gbc_jtfSegundoApellido.insets = new Insets(0, 0, 5, 5);
		gbc_jtfSegundoApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSegundoApellido.gridx = 1;
		gbc_jtfSegundoApellido.gridy = 3;
		add(jtfSegundoApellido, gbc_jtfSegundoApellido);
		jtfSegundoApellido.setColumns(10);
		
		lblSexo = new JLabel("Sexo:");
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 0;
		gbc_lblSexo.gridy = 4;
		add(lblSexo, gbc_lblSexo);
		
		jcbSexo = new JComboBox();
		GridBagConstraints gbc_Sexo = new GridBagConstraints();
		gbc_Sexo.insets = new Insets(0, 0, 5, 5);
		gbc_Sexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_Sexo.gridx = 1;
		gbc_Sexo.gridy = 4;
		add(jcbSexo, gbc_Sexo);
		
		JLabel lblDNI = new JLabel("DNI:");
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 0;
		gbc_lblDNI.gridy = 5;
		add(lblDNI, gbc_lblDNI);
		
		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);
		
		btnNewButton = new JButton("Cambiar Imagen:");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionaFichero();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 5;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		GridBagConstraints gbc_lblDireccion = new GridBagConstraints();
		gbc_lblDireccion.anchor = GridBagConstraints.EAST;
		gbc_lblDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDireccion.gridx = 0;
		gbc_lblDireccion.gridy = 6;
		add(lblDireccion, gbc_lblDireccion);
		
		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 7;
		add(lblEmail, gbc_lblEmail);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 8;
		add(lblTelefono, gbc_lblTelefono);
		
		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);
		
		lblcolor = new JLabel("Color Preferido:");
		GridBagConstraints gbc_lblcolor = new GridBagConstraints();
		gbc_lblcolor.anchor = GridBagConstraints.EAST;
		gbc_lblcolor.insets = new Insets(0, 0, 0, 5);
		gbc_lblcolor.gridx = 0;
		gbc_lblcolor.gridy = 9;
		add(lblcolor, gbc_lblcolor);
		
		jtfcolor = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 9;
		add(jtfcolor, gbc_textField);
		jtfcolor.setColumns(10);
		
		btnSELECIONARCOLOR = new JButton("Selecionar Color:");
		btnSELECIONARCOLOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnSELECIONARCOLOR = new GridBagConstraints();
		gbc_btnSELECIONARCOLOR.gridx = 2;
		gbc_btnSELECIONARCOLOR.gridy = 9;
		add(btnSELECIONARCOLOR, gbc_btnSELECIONARCOLOR);
		cargarDatos();
		
	}
	
	private void seleccionaFichero() {
        this.jfc = new JFileChooser();

        // Configurando el componente

        // Establecimiento de la carpeta de inicio
        this.jfc.setCurrentDirectory(new File("C:\\"));

        // Tipo de selecci�n que se hace en el di�logo
        this.jfc.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros

        this.jfc.setFileFilter(new FileFilter() {

            @Override
            public String getDescription() {
                return "Archivos de texto *.jpg";
            }

            @Override
            public boolean accept(File f) {
                if (f.isFile() && f.getAbsolutePath().endsWith(".jpg"))
                    return true;
                return false;
            }
        });


        // Abro el di�logo para la elecci�n del usuario
        int seleccionUsuario = jfc.showOpenDialog(null);

        if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
            fichero =jfc.getSelectedFile();
            try {
                this.imagen = Files.readAllBytes(fichero.toPath());
            } catch (IOException e) {
                System.out.println("Error al leer el contenido del fichero binario");
                e.printStackTrace();
            }

            try {

                ImageIcon img = new ImageIcon(fichero.toString());
                JLabel lbl = new JLabel(img);
                this.scrollPane.setViewportView(lbl);




            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Error al abrir la imagen " + ex);

            }

        }

    }
	private void cargarDatos() {
        List<Tipologiasexo> sexo = ControladorTipologiaSexo.getInstance().findAll();

        for (Tipologiasexo t : sexo) {
            this.jcbSexo.addItem(t);
        }
    }
	private void seleccionaColor () {
		
		 color = jcolor.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
			strcolor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfcolor.setText(strcolor);
			setBackground(color);
		}
	}
	private JPopupMenu getPopUpMenu () {
		JPopupMenu menu = new JPopupMenu();
		
		menu.add(crearNuevoMenuItem("Dimensiones"));
		menu.addSeparator();
		menu.add(crearNuevoMenuItem("Cambiar Imagen"));
		
		return menu;
	}
	
	
	
	/**
	 * Men� Item para salir de la aplicaci�n
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem (String titulo) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if (titulo=="Cambiar Imagen") {
            	   seleccionaFichero();
            	   
               }
            }
        });
        
        return item;
	}
	
	
	
	public String getNombre() {
        return jtfNombre.getText();
    }

    public void setNombre(String nombre) {
        this.jtfNombre.setText(nombre);
    }

    public String getPrimerApellido() {
        return jtfprimerAp.getText();
    }

    public void setPrimerApellido(String primerApellido) {
        this.jtfprimerAp.setText(primerApellido);
    }

    public String getSegundoApellido() {
        return jtfSegundoApellido.getText();
    }

    public void setSegundoApellido(String segundoApellido) {
        this.jtfSegundoApellido.setText(segundoApellido);
    }

    public JComboBox<Tipologiasexo>getJcbSexo(){
        return jcbSexo;
    }

    public void setJcbSexo(JComboBox<Tipologiasexo>jcbSexo) {
        this.jcbSexo=jcbSexo;
    }

    public String getDni() {
        return jtfDni.getText();
    }

    public void setDni(String dni) {
        this.jtfDni.setText(dni);
    }

    public String getDireccion() {
        return jtfDireccion.getText();
    }

    public void setDireccion(String direccion) {
        this.jtfDireccion.setText(direccion);
    }

    public String getEmail() {
        return jtfEmail.getText();
    }

    public void setEmail(String email) {
        this.jtfEmail.setText(email);
    }

    public String getTelefono() {
        return jtfTelefono.getText();
    }

    public void setTelefono(String telefono) {
        this.jtfTelefono.setText(telefono);;
    }

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		ImageIcon icon = new ImageIcon(imagen);
        JLabel lbl = new JLabel(icon);
        this.scrollPane.setViewportView(lbl);
        this.scrollPane.revalidate();
        this.scrollPane.repaint();
	}

	public String getColor() {
		return this.jtfcolor.getText();
	}

		public void setColor(String color) {
	        if (color != null) {
	            this.jtfcolor.setText(color);
	            this.setBackground(Color.decode(color));
	        }
	        else {
	            this.setBackground(Color.gray);
	        }

	    }
		
		public void setstrColor(String color) {
			this.jtfcolor.setText(color);
			
		}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public JLabel getlblDimensiones() {
        return lblDimensiones;
    }
    public void setlblDimensiones(String lblDimensiones) {
        this.lblDimensiones.setText(lblDimensiones);
    }
	}
	
	
    
    


