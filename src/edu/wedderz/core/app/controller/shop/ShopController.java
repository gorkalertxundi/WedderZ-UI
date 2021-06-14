package edu.wedderz.core.app.controller.shop;

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

import edu.wedderz.core.app.view.shop.ShopPanel;
import edu.wedderz.core.dataaccess.repo.impl.OrderServiceImpl;
import edu.wedderz.core.dataaccess.repo.impl.UserServiceImpl;
import edu.wedderz.core.model.Order;
import edu.wedderz.core.model.User;

public class ShopController implements ChangeListener, ActionListener {

	ShopPanel shoppingPanel;
	OrderServiceImpl orderService;
	UserServiceImpl userServiceImpl;
	
	String email;
	String nombre;
	String apellido;
	String telefono;
	String direccion;
	String ciudad;
	String provincia;
	String codigoPostal;
	String pais;
	String numeroTarjeta;
	String fechaExpiracion;
	String cvc;
	String titularTarjeta;
	
	public ShopController(ShopPanel panelCompras) {
		this.shoppingPanel = panelCompras;
		orderService = new OrderServiceImpl();
		userServiceImpl = new UserServiceImpl();
	}
	
	public void setSubtotal(int cantidad) {
		JLabel lblSubtotal = shoppingPanel.getlblSubtotal();
		double subtotal = orderService.getCurrentPrice()*cantidad;
		double gastosEnvio = getPrecioEnvio(cantidad);
		DecimalFormat df2 = new DecimalFormat("#.##");
		lblSubtotal.setText("Subtotal: " + df2.format(subtotal) + " \u20AC sin IVA + " 
		+ df2.format(gastosEnvio) + " \u20AC de gastos de envio est\u00E1ndar");
	}
	
	private double getPrecioEnvio(int cantidad) {
		
		double pesoTotal = cantidad * orderService.getStationWeight();
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
		JLabel lblEntregaPrevista = shoppingPanel.getlblEntregaPrevista();
		Date date = new Date(System.currentTimeMillis() + nDay*24*60*60*1000);
		DateFormat formatMonth = new SimpleDateFormat("MMMM");
		DateFormat formatDay = new SimpleDateFormat("dd");
		
		lblEntregaPrevista.setText("Entrega prevista el " + formatDay.format(date).toString() + " de " + formatMonth.format(date).toString() + " o antes");
	}

	public void setPrecioEstacion() {
		JLabel lblPrecioEstacion = shoppingPanel.getlblPrice();
		lblPrecioEstacion.setText(String.valueOf(orderService.getCurrentPrice()) + " \u20AC sin IVA");
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
			checkCompra();
		}
	}

	private void checkCompra() {
		getDatosDelCliente();
		if (checkDatosDelCliente()) {
			generarCompra();
		} else {
			JOptionPane.showMessageDialog(shoppingPanel, "¡Por favor rellena todos los campos!",
					"Rellena los campos", JOptionPane.CLOSED_OPTION);
		}
	}

	private void generarCompra() {
		if (checkStock()) {
			guardarCompra();
		} else {
			String stock = String.valueOf(orderService.getStationStock());
			JOptionPane.showMessageDialog(shoppingPanel, "¡Solo hay "+stock+
					" estaciones disponibles!", "No hay stock disponible", JOptionPane.CLOSED_OPTION);
		}
	}

	private void guardarCompra() {
		/*
		 * Deberiamos de hacer otro incremento para poder coger el ID 
		 * del usuario logeado en nuestra aplicación. Como ejemplo
		 * 
		 */
		User user = userServiceImpl.getUserById(15); 
		int cantidad = shoppingPanel.getSelectedCantity();
		Order order = orderService.makeOrder(user, cantidad, Integer.valueOf(codigoPostal), direccion, provincia, ciudad, pais);
		if (order != null) {
			JOptionPane.showMessageDialog(shoppingPanel, "¡Gracias por tu compra!", 
					"Compra realizada", JOptionPane.CLOSED_OPTION);
		} else {
			JOptionPane.showMessageDialog(shoppingPanel, "Lo sentimos mucho, "
					+ "por algun error en la red tu compra no ha sido procesada", 
					"Error en la compra", JOptionPane.CLOSED_OPTION);
		}
		
	}

	private boolean checkStock() {
		int cantidad = shoppingPanel.getSelectedCantity();
		int stock = orderService.getStationStock();
		if (cantidad <= stock) {
			return true;
		} else {
			return false;
		}
	}

	private void getDatosDelCliente() {
		email = shoppingPanel.getTfEmail().getText();
		nombre = shoppingPanel.getTfNombre().getText();
		apellido = shoppingPanel.getTfApellido().getText();
		telefono = shoppingPanel.getTfTelefono().getText();
		direccion = shoppingPanel.getTfDireccion().getText();
		ciudad = shoppingPanel.getTfCiudad().getText();
		provincia = shoppingPanel.getTfProvincia().getText();
		codigoPostal = shoppingPanel.getTfCodigoPostal().getText();
		pais = shoppingPanel.getTfPais().getText();	
		numeroTarjeta = shoppingPanel.getTfNumeroTarjeta().getText();
		fechaExpiracion = shoppingPanel.getTfFechaExpiracion().getText();
		cvc = shoppingPanel.getTfCVV().getText();
		titularTarjeta = shoppingPanel.getTfTitular().getText();
	}
	
	private boolean checkDatosDelCliente() {
		if (email.equals("") || nombre.equals("") || apellido.equals("") || telefono.equals("") ||
			direccion.equals("") || ciudad.equals("") || provincia.equals("") || codigoPostal.equals("") ||
			pais.equals("") || numeroTarjeta.equals("") || fechaExpiracion.equals("") || cvc.equals("") ||
			titularTarjeta.equals("")) {
			return false; 
		} else {
			return true;
		}
	}
}
