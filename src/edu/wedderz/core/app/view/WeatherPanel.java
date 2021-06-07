package edu.wedderz.core.app.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.JTable;


public class WeatherPanel extends JPanel {
	private JTable table;
	
	
	public WeatherPanel() {
		this.setBackground(Color.WHITE);
		
		currentDayWeatherPanel(this);
		day5Panel(this);
		day4Panel(this);
		day3Panel(this);
		day2Panel(this);
		day1Panel(this);
		setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		add(table, BorderLayout.CENTER);
		
		
	}
	
	private void day1Panel(JPanel panel) {
	}

	private void day2Panel(JPanel panel) {
	}

	private void day3Panel(JPanel panel) {
	}

	private void day4Panel(JPanel panel) {
		
	}

	private void day5Panel(JPanel panel) {
		
	}

	private void currentDayWeatherPanel(JPanel panel) {
	}
	
	public void setCurrentWeatherValues(String location, String countryCode, double weatherType, double temp, double minTemp, double maxTemp, double pressure, double humidity, double windVel) {
		lblLocation.setText(location + ", " + countryCode);
		lblCurTemperature.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblCurMinTempValue.setText(String.valueOf(Math.round(minTemp)) + " \u00BAC");
		lblCurMaxTempValue.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblCurPressureValue.setText(String.valueOf(pressure) + " mbar");
		lblCurHumidityValue.setText(String.valueOf(humidity) + " %");
		lblWindValue.setText(String.valueOf(windVel) + " m/s");
		setWeatherType(lblCurTemperature, weatherType);
	}
	
	public void setWeatherType(JLabel label, double wetherType) {
		
		String iconPath = "icons/";
		
		switch ((int) wetherType) {
		case 0:
			iconPath += "sunny.png";
			break;
		case 1:
			iconPath += "partly-cloud.png";
			break;
		case 2:
			iconPath += "low-cloud.png";
			break;
		case 3:
			iconPath += "mid-cloud.png";
			break;
		case 4:
			iconPath += "heavy-cloud.png";
			break;
		case 5:
			iconPath += "rainy.png";
			break;
		case 6:
			iconPath += "thunderstorm.png";
			break;
		default:
			iconPath += "sunny.png";
			break;
		}
		label.setIcon(new ImageIcon(iconPath));
	}
	
	public void setPast1DaysValues(String dayOfWeek, double weatherType, double temp, double minTemp, double maxTemp, double humidity) {
		lblDayWeek1.setText(dayOfWeek);
		lblDay1Temperature.setText(String.valueOf(Math.round(temp)) + " \u00BAC");
		lblDay1MinTempValue.setText(String.valueOf(Math.round(minTemp)) + " \u00BAC");
		lblDay1MaxTempValue.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblDay1HumidityValue.setText(String.valueOf(humidity) + " %");
		setWeatherType(lblDay1Temperature, weatherType);
	}
	
	public void setPast2DaysValues(String dayOfWeek, double weatherType, double temp, double minTemp, double maxTemp, double humidity) {
		lblDayWeek2.setText(dayOfWeek);
		lblDay2Temperature.setText(String.valueOf(Math.round(temp)) + " \u00BAC");
		lblDay2MinTempValue.setText(String.valueOf(Math.round(minTemp)) + " \u00BAC");
		lblDay2MaxTempValue.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblDay2HumidityValue.setText(String.valueOf(humidity) + " %");
		setWeatherType(lblDay2Temperature, weatherType);
	}
	
	public void setPast3DaysValues(String dayOfWeek, double weatherType, double temp, double minTemp, double maxTemp, double humidity) {
		lblDayWeek3.setText(dayOfWeek);
		lblDay3Temperature.setText(String.valueOf(Math.round(temp)) + " \u00BAC");
		lblDay3MinTempValue.setText(String.valueOf(Math.round(minTemp)) + " \u00BAC");
		lblDay3MaxTempValue.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblDay3HumidityValue.setText(String.valueOf(humidity) + " %");
		setWeatherType(lblDay3Temperature, weatherType);
	}
	
	public void setPast4DaysValues(String dayOfWeek, double weatherType, double temp, double minTemp, double maxTemp, double humidity) {
		lblDayWeek4.setText(dayOfWeek);
		lblDay4Temperature.setText(String.valueOf(Math.round(temp)) + " \u00BAC");
		lblDay4MinTempValue.setText(String.valueOf(Math.round(minTemp)) + " \u00BAC");
		lblDay4MaxTempValue.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblDay4HumidityValue.setText(String.valueOf(humidity) + " %");
		setWeatherType(lblDay4Temperature, weatherType);
	}
	
	public void setPast5DaysValues(String dayOfWeek, double weatherType, double temp, double minTemp, double maxTemp, double humidity) {
		lblDayWeek5.setText(dayOfWeek);
		lblDay5Temperature.setText(String.valueOf(Math.round(temp)) + " \u00BAC");
		lblDay5MinTempValue.setText(String.valueOf(Math.round(minTemp)) + " \u00BAC");
		lblDay5MaxTempValue.setText(String.valueOf(Math.round(maxTemp)) + " \u00BAC");
		lblDay5HumidityValue.setText(String.valueOf(humidity) + " %");
		setWeatherType(lblDay5Temperature, weatherType);
	}

}

