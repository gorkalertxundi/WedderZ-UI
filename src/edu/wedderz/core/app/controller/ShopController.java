package edu.wedderz.core.app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import edu.wedderz.core.app.view.ShopPanel;

public class ShopController implements ChangeListener, ActionListener {

	ShopPanel panelCompras;
	double pesoEstacion;
	double precioEstacion;
	
	public ShopController(ShopPanel panelCompras) {
		this.panelCompras = panelCompras;
		
		////////// Esto lo cogemos de la BBDD
		pesoEstacion = 0.25;
		precioEstacion = 49.99;
		//////////
	}
	
	public void setSubtotal(int cantidad) {
		JLabel lblSubtotal = panelCompras.getlblSubtotal();
		double subtotal = precioEstacion*cantidad;
		double gastosEnvio = getPrecioEnvio(cantidad); //Esto en en controlador
		DecimalFormat df2 = new DecimalFormat("#.##");
		lblSubtotal.setText("Subtotal: " + df2.format(subtotal) + " \u20AC sin IVA + " + df2.format(gastosEnvio) + " \u20AC de gastos de envio est\u00E1ndar");
	}
	
	private double getPrecioEnvio(int cantidad) {
		
		double pesoTotal = cantidad * pesoEstacion;
		double pesoRestante = pesoTotal;
		double gastoEnvio = 0;
		
		while (pesoRestante > 0) {
			if (pesoRestante > 2) { // 30 Kg 32,05 €
				gastoEnvio += 32.05;
				pesoRestante -= 30;
			} else if (pesoRestante > 1 && pesoRestante <= 2) { // 2 Kg 24,21 €
				gastoEnvio += 21.21;
				pesoRestante -= 2;
			} else if (pesoRestante > 0.5 && pesoRestante <= 1) { // 1 Kg 12,04 €
				gastoEnvio += 12.04;
				pesoRestante -= 1;
			} else if (pesoRestante > 0 && pesoRestante <= 0.5) { // 0.5 Kg 9.86 €
				gastoEnvio += 9.98;
				pesoRestante -= 0.5;
			}
		}
		
		return gastoEnvio;
	}

	public void setEntregaPrevista(int nDay) {
		JLabel lblEntregaPrevista = panelCompras.getlblEntregaPrevista();
		Date date = new Date(System.currentTimeMillis() + nDay*24*60*60*1000);
		DateFormat formatMonth = new SimpleDateFormat("MMMM");
		DateFormat formatDay = new SimpleDateFormat("dd");
		
		lblEntregaPrevista.setText("Entrega prevista el " + formatDay.format(date).toString() + " de " + formatMonth.format(date).toString() + " o antes");
	}

	public void setPrecioEstacion() {
		JLabel lblPrecioEstacion = panelCompras.getlblPrice();
		lblPrecioEstacion.setText(String.valueOf(precioEstacion) + " \u20AC sin IVA");
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
		int cantidad = (int) spinner.getValue();
		setSubtotal(cantidad);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equals("comprar")) {
			generarCompra();
		}
	}

	private void generarCompra() {
		// TODO Hacer un check de datos
		getDatosDelCliente();
		// QUERY
		JOptionPane.showMessageDialog(panelCompras, "¡Gracias por tu compra!", "Compra realizada", JOptionPane.CLOSED_OPTION);
//		JOptionPane.showMessageDialog(panelCompras, "¡Solo hay 54 estaciones disponibles!", "No hay stock disponible", JOptionPane.CLOSED_OPTION);
		
	}

	private void getDatosDelCliente() {
		String email = panelCompras.getTfEmail().getText();
		String nombre = panelCompras.getTfNombre().getText();
		String apellido = panelCompras.getTfApellido().getText();
		String telefono = panelCompras.getTfTelefono().getText();
		String direccion = panelCompras.getTfDireccion().getText();
		String ciudad = panelCompras.getTfCiudad().getText();
		String provincia = panelCompras.getTfProvincia().getText();
		String codigoPostal = panelCompras.getTfCodigoPostal().getText();
		String pais = panelCompras.getTfPais().getText();
		
		// QUERY
		
	}
	
}
