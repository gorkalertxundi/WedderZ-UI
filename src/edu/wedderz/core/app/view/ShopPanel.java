package edu.wedderz.core.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import edu.wedderz.core.app.controller.ShopController;

public class ShopPanel extends JPanel{
	
	JTextField tfEmail;
	JTextField tfApellido;
	JTextField tfNombre;
	JTextField tfTelefono;
	JTextField tfDireccion;
	JTextField tfCiudad;
	JTextField tfProvincia;
	JTextField tfCodigoPostal;
	JTextField tfPais;
	JTextField tfNumeroTarjeta;
	JTextField tfTitular;
	JTextField tfFechaExpiracion;
	JTextField tfCVV;
	
	JLabel lblEntregaPrevista;
	JLabel lblPrice;
	JLabel lblSubtotal;
	
	JButton btnComprar;

	ShopController controller;
	
	public ShopPanel() {
		controller = new ShopController(this);
		createPanel();
		controller.setPrecioEstacion();
		controller.setEntregaPrevista(15);
		controller.setSubtotal(1);
	}
	
	public JLabel getlblEntregaPrevista() {
		return lblEntregaPrevista;
	}
	
	public JLabel getlblSubtotal() {
		return lblSubtotal;
	}
	
	public JLabel getlblPrice() {
		return lblPrice;
	}
	
	public void createPanel() {
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);
		
		JLabel lblImgProducto = new JLabel();
		lblImgProducto.setIcon(new ImageIcon("icons\\estacion.png"));
		GridBagConstraints gbc_lblImgProducto = new GridBagConstraints();
		gbc_lblImgProducto.anchor = GridBagConstraints.WEST;
		gbc_lblImgProducto.gridwidth = 2;
		gbc_lblImgProducto.insets = new Insets(0, 20, 5, 10);
		gbc_lblImgProducto.gridx = 0;
		gbc_lblImgProducto.gridy = 0;
		this.add(lblImgProducto, gbc_lblImgProducto);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.gridheight = 9;
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 2;
		gbc_infoPanel.gridy = 0;
		this.add(infoPanel, gbc_infoPanel);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_infoPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel lblDireccionEnvio = new JLabel("Direcci\u00F3n de envio");
		lblDireccionEnvio.setIcon(new ImageIcon("icons\\envio.png"));
		lblDireccionEnvio.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblDireccionEnvio = new GridBagConstraints();
		gbc_lblDireccionEnvio.insets = new Insets(15, 60, 5, 5);
		gbc_lblDireccionEnvio.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDireccionEnvio.gridx = 0;
		gbc_lblDireccionEnvio.gridy = 0;
		infoPanel.add(lblDireccionEnvio, gbc_lblDireccionEnvio);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfEmail.setBorder(BorderFactory.createTitledBorder("Email"));
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfEmail.insets = new Insets(30, 60, 5, 40);
		gbc_tfEmail.gridx = 0;
		gbc_tfEmail.gridy = 1;
		infoPanel.add(tfEmail, gbc_tfEmail);
		tfEmail.setColumns(10);
		
		tfNombre = new JTextField();
		tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNombre.setBorder(BorderFactory.createTitledBorder("Nombre"));
		tfNombre.setColumns(10);
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(10, 60, 5, 40);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 0;
		gbc_tfNombre.gridy = 2;
		infoPanel.add(tfNombre, gbc_tfNombre);
		
		tfApellido = new JTextField();
		tfApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfApellido.setBorder(BorderFactory.createTitledBorder("Apellido"));
		tfApellido.setColumns(10);
		GridBagConstraints gbc_tfApellido = new GridBagConstraints();
		gbc_tfApellido.insets = new Insets(10, 20, 5, 30);
		gbc_tfApellido.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellido.gridx = 1;
		gbc_tfApellido.gridy = 2;
		infoPanel.add(tfApellido, gbc_tfApellido);
		
		tfTelefono = new JTextField();
		tfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfTelefono.setBorder(BorderFactory.createTitledBorder("Telefono"));
		tfTelefono.setColumns(10);
		GridBagConstraints gbc_tfTelefono = new GridBagConstraints();
		gbc_tfTelefono.anchor = GridBagConstraints.NORTH;
		gbc_tfTelefono.insets = new Insets(10, 60, 5, 40);
		gbc_tfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTelefono.gridx = 0;
		gbc_tfTelefono.gridy = 3;
		infoPanel.add(tfTelefono, gbc_tfTelefono);
		
		tfDireccion = new JTextField();
		tfDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfDireccion.setBorder(BorderFactory.createTitledBorder("Direccion"));
		tfDireccion.setColumns(10);
		GridBagConstraints gbc_tfDireccion = new GridBagConstraints();
		gbc_tfDireccion.anchor = GridBagConstraints.NORTH;
		gbc_tfDireccion.insets = new Insets(10, 20, 5, 30);
		gbc_tfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDireccion.gridx = 1;
		gbc_tfDireccion.gridy = 3;
		infoPanel.add(tfDireccion, gbc_tfDireccion);
		
		tfCiudad = new JTextField();
		tfCiudad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCiudad.setBorder(BorderFactory.createTitledBorder("Ciudad"));
		tfCiudad.setColumns(10);
		GridBagConstraints gbc_tfCiudad = new GridBagConstraints();
		gbc_tfCiudad.anchor = GridBagConstraints.NORTH;
		gbc_tfCiudad.insets = new Insets(10, 60, 5, 40);
		gbc_tfCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCiudad.gridx = 0;
		gbc_tfCiudad.gridy = 4;
		infoPanel.add(tfCiudad, gbc_tfCiudad);
		
		tfProvincia = new JTextField();
		tfProvincia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfProvincia.setBorder(BorderFactory.createTitledBorder("Provincia"));
		tfProvincia.setColumns(10);
		GridBagConstraints gbc_tfProvincia = new GridBagConstraints();
		gbc_tfProvincia.insets = new Insets(10, 20, 5, 30);
		gbc_tfProvincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProvincia.gridx = 1;
		gbc_tfProvincia.gridy = 4;
		infoPanel.add(tfProvincia, gbc_tfProvincia);
		
		tfCodigoPostal = new JTextField();
		tfCodigoPostal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCodigoPostal.setBorder(BorderFactory.createTitledBorder("Codigo Postal"));
		tfCodigoPostal.setColumns(10);
		GridBagConstraints gbc_tfCodigoPostal = new GridBagConstraints();
		gbc_tfCodigoPostal.insets = new Insets(10, 60, 5, 40);
		gbc_tfCodigoPostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCodigoPostal.gridx = 0;
		gbc_tfCodigoPostal.gridy = 5;
		infoPanel.add(tfCodigoPostal, gbc_tfCodigoPostal);
		
		tfPais = new JTextField();
		tfPais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfPais.setBorder(BorderFactory.createTitledBorder("Pais"));
		tfPais.setColumns(10);
		GridBagConstraints gbc_tfPais = new GridBagConstraints();
		gbc_tfPais.insets = new Insets(10, 20, 5, 30);
		gbc_tfPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPais.gridx = 1;
		gbc_tfPais.gridy = 5;
		infoPanel.add(tfPais, gbc_tfPais);
		
		JLabel lblMetodoDePago = new JLabel("M\u00E9todo de pago");
		lblMetodoDePago.setIcon(new ImageIcon("icons\\tarjeta.png"));
		lblMetodoDePago.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblMetodoDePago = new GridBagConstraints();
		gbc_lblMetodoDePago.anchor = GridBagConstraints.WEST;
		gbc_lblMetodoDePago.insets = new Insets(30, 60, 5, 5);
		gbc_lblMetodoDePago.gridx = 0;
		gbc_lblMetodoDePago.gridy = 6;
		infoPanel.add(lblMetodoDePago, gbc_lblMetodoDePago);
		
		tfNumeroTarjeta = new JTextField();
		tfNumeroTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfNumeroTarjeta.setBorder(BorderFactory.createTitledBorder("Numero de tarjeta"));
		tfNumeroTarjeta.setColumns(10);
		GridBagConstraints gbc_tfNumeroTarjeta = new GridBagConstraints();
		gbc_tfNumeroTarjeta.gridwidth = 2;
		gbc_tfNumeroTarjeta.insets = new Insets(15, 60, 5, 200);
		gbc_tfNumeroTarjeta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNumeroTarjeta.gridx = 0;
		gbc_tfNumeroTarjeta.gridy = 7;
		infoPanel.add(tfNumeroTarjeta, gbc_tfNumeroTarjeta);
		
		tfFechaExpiracion = new JTextField();
		tfFechaExpiracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfFechaExpiracion.setBorder(BorderFactory.createTitledBorder("Fecha de expiración"));
		tfFechaExpiracion.setColumns(10);
		GridBagConstraints gbc_tfFechaExpiracion = new GridBagConstraints();
		gbc_tfFechaExpiracion.insets = new Insets(10, 60, 5, 35);
		gbc_tfFechaExpiracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFechaExpiracion.gridx = 0;
		gbc_tfFechaExpiracion.gridy = 8;
		infoPanel.add(tfFechaExpiracion, gbc_tfFechaExpiracion);
		
		tfCVV = new JTextField();
		tfCVV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfCVV.setBorder(BorderFactory.createTitledBorder("CVC/CVV"));
		tfCVV.setColumns(10);
		GridBagConstraints gbc_tfCVV = new GridBagConstraints();
		gbc_tfCVV.insets = new Insets(10, 0, 5, 200);
		gbc_tfCVV.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCVV.gridx = 1;
		gbc_tfCVV.gridy = 8;
		infoPanel.add(tfCVV, gbc_tfCVV);
		
		tfTitular = new JTextField();
		tfTitular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfTitular.setBorder(BorderFactory.createTitledBorder("Titular de la tarjeta"));
		tfTitular.setColumns(10);
		GridBagConstraints gbc_tfTitular = new GridBagConstraints();
		gbc_tfTitular.gridwidth = 2;
		gbc_tfTitular.insets = new Insets(10, 60, 5, 200);
		gbc_tfTitular.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTitular.gridx = 0;
		gbc_tfTitular.gridy = 9;
		infoPanel.add(tfTitular, gbc_tfTitular);
		
		lblEntregaPrevista = new JLabel();
		lblEntregaPrevista.setForeground(new Color(108,192,68));
		lblEntregaPrevista.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEntregaPrevista = new GridBagConstraints();
		gbc_lblEntregaPrevista.gridwidth = 2;
		gbc_lblEntregaPrevista.anchor = GridBagConstraints.WEST;
		gbc_lblEntregaPrevista.insets = new Insets(10, 60, 5, 5);
		gbc_lblEntregaPrevista.gridx = 0;
		gbc_lblEntregaPrevista.gridy = 10;
		infoPanel.add(lblEntregaPrevista, gbc_lblEntregaPrevista);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setIcon(new ImageIcon("icons\\carrito-icon.png"));
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnComprar.setActionCommand("comprar");
		btnComprar.addActionListener(controller);
		GridBagConstraints gbc_btnComprar = new GridBagConstraints();
		gbc_btnComprar.insets = new Insets(0, 0, 5, 20);
		gbc_btnComprar.gridx = 2;
		gbc_btnComprar.gridy = 11;
		infoPanel.add(btnComprar, gbc_btnComprar);
		
		lblSubtotal = new JLabel();
		lblSubtotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSubtotal = new GridBagConstraints();
		gbc_lblSubtotal.gridwidth = 2;
		gbc_lblSubtotal.anchor = GridBagConstraints.WEST;
		gbc_lblSubtotal.insets = new Insets(10, 60, 0, 5);
		gbc_lblSubtotal.gridx = 0;
		gbc_lblSubtotal.gridy = 11;
		infoPanel.add(lblSubtotal, gbc_lblSubtotal);
		
		lblPrice = new JLabel();
		lblPrice.setForeground(Color.RED);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 27));
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.gridwidth = 2;
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 1;
		this.add(lblPrice, gbc_lblPrice);
		
		JLabel lblNombreProducto = new JLabel("WedderZ - Ztation");
		lblNombreProducto.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblNombreProducto = new GridBagConstraints();
		gbc_lblNombreProducto.anchor = GridBagConstraints.WEST;
		gbc_lblNombreProducto.gridwidth = 2;
		gbc_lblNombreProducto.insets = new Insets(10, 50, 5, 5);
		gbc_lblNombreProducto.gridx = 0;
		gbc_lblNombreProducto.gridy = 2;
		this.add(lblNombreProducto, gbc_lblNombreProducto);
		
		JLabel lblDesc = new JLabel("- Sensor de temperatura LM35");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDesc = new GridBagConstraints();
		gbc_lblDesc.gridwidth = 2;
		gbc_lblDesc.anchor = GridBagConstraints.WEST;
		gbc_lblDesc.insets = new Insets(0, 70, 5, 5);
		gbc_lblDesc.gridx = 0;
		gbc_lblDesc.gridy = 3;
		this.add(lblDesc, gbc_lblDesc);
		
		JLabel lblDesc1 = new JLabel("- Sensor de Humedad");
		lblDesc1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDesc1 = new GridBagConstraints();
		gbc_lblDesc1.gridwidth = 2;
		gbc_lblDesc1.anchor = GridBagConstraints.WEST;
		gbc_lblDesc1.insets = new Insets(0, 70, 5, 5);
		gbc_lblDesc1.gridx = 0;
		gbc_lblDesc1.gridy = 4;
		this.add(lblDesc1, gbc_lblDesc1);
		
		JLabel lblDesc2 = new JLabel("- Sensor de luz UltraVioleta");
		lblDesc2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDesc2 = new GridBagConstraints();
		gbc_lblDesc2.gridwidth = 2;
		gbc_lblDesc2.anchor = GridBagConstraints.WEST;
		gbc_lblDesc2.insets = new Insets(0, 70, 5, 5);
		gbc_lblDesc2.gridx = 0;
		gbc_lblDesc2.gridy = 5;
		this.add(lblDesc2, gbc_lblDesc2);
		
		JLabel lblDesc3 = new JLabel("- Sensor de la velocidad del aire");
		lblDesc3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDesc3 = new GridBagConstraints();
		gbc_lblDesc3.gridwidth = 2;
		gbc_lblDesc3.anchor = GridBagConstraints.WEST;
		gbc_lblDesc3.insets = new Insets(0, 70, 5, 5);
		gbc_lblDesc3.gridx = 0;
		gbc_lblDesc3.gridy = 6;
		this.add(lblDesc3, gbc_lblDesc3);
		
		JLabel lblDesc4 = new JLabel("- Sensor de la calidad del aire");
		lblDesc4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDesc4 = new GridBagConstraints();
		gbc_lblDesc4.gridwidth = 2;
		gbc_lblDesc4.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDesc4.insets = new Insets(0, 70, 10, 5);
		gbc_lblDesc4.gridx = 0;
		gbc_lblDesc4.gridy = 7;
		this.add(lblDesc4, gbc_lblDesc4);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblCantidad = new GridBagConstraints();
		gbc_lblCantidad.anchor = GridBagConstraints.EAST;
		gbc_lblCantidad.insets = new Insets(20, 30, 40, 5);
		gbc_lblCantidad.gridx = 0;
		gbc_lblCantidad.gridy = 8;
		this.add(lblCantidad, gbc_lblCantidad);
		
		JSpinner spinnerCantity = new JSpinner(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerCantity.addChangeListener(controller);
		spinnerCantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(20, 10, 0, 80);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 8;
		this.add(spinnerCantity, gbc_textField);
	}


	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JTextField getTfApellido() {
		return tfApellido;
	}

	public JTextField getTfTelefono() {
		return tfTelefono;
	}

	public JTextField getTfDireccion() {
		return tfDireccion;
	}

	public JTextField getTfCiudad() {
		return tfCiudad;
	}

	public JTextField getTfProvincia() {
		return tfProvincia;
	}

	public JTextField getTfCodigoPostal() {
		return tfCodigoPostal;
	}

	public JTextField getTfPais() {
		return tfPais;
	}

	public JTextField getTfNumeroTarjeta() {
		return tfNumeroTarjeta;
	}

	public JTextField getTfTitular() {
		return tfTitular;
	}

	public JTextField getTfFechaExpiracion() {
		return tfFechaExpiracion;
	}

	public JTextField getTfCVV() {
		return tfCVV;
	}
}
