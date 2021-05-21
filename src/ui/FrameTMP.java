package ui;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

public class FrameTMP extends JFrame{


	public FrameTMP() {
		this.setSize(new Dimension(1280,720)); //PC
		//this.setSize(new Dimension(750,1334)); //Movil
		this.setTitle("WedderZ");
		this.setIconImage(new ImageIcon("icons/logo.png").getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(createPanel());
		this.setVisible(true);
	}
	
	private JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		
		JPanel currentWeatherPanel = new JPanel();
		GridBagConstraints gbc_currentWeatherPanel = new GridBagConstraints();
		gbc_currentWeatherPanel.insets = new Insets(30, 0, 5, 0);
		gbc_currentWeatherPanel.gridx = 0;
		gbc_currentWeatherPanel.gridy = 0;
		panel.add(currentWeatherPanel, gbc_currentWeatherPanel);
		GridBagLayout gbl_currentWeatherPanel = new GridBagLayout();
		gbl_currentWeatherPanel.columnWidths = new int[]{32, 0, 0};
		gbl_currentWeatherPanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0};
		gbl_currentWeatherPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_currentWeatherPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		currentWeatherPanel.setLayout(gbl_currentWeatherPanel);
		
		JLabel lblLocation = new JLabel("Madrid, ES");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLocation = new GridBagConstraints();
		gbc_lblLocation.gridwidth = 2;
		gbc_lblLocation.insets = new Insets(10, 60, 5, 60);
		gbc_lblLocation.gridx = 0;
		gbc_lblLocation.gridy = 0;
		currentWeatherPanel.add(lblLocation, gbc_lblLocation);
		
		JLabel lblCurTemperature = new JLabel("26 \u00BAC");
		lblCurTemperature.setFont(new Font("Tahoma", Font.PLAIN, 69));
		lblCurTemperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\a_3_very_sunny.png"));
		GridBagConstraints gbc_lblCurTemperature = new GridBagConstraints();
		gbc_lblCurTemperature.gridwidth = 2;
		gbc_lblCurTemperature.insets = new Insets(5, 10, 5, 10);
		gbc_lblCurTemperature.gridx = 0;
		gbc_lblCurTemperature.gridy = 1;
		currentWeatherPanel.add(lblCurTemperature, gbc_lblCurTemperature);
		
		JLabel lblCurMinTemp = new JLabel("Min. Temp.");
		lblCurMinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblCurMinTemp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurMinTemp = new GridBagConstraints();
		gbc_lblCurMinTemp.insets = new Insets(0, 10, 5, 10);
		gbc_lblCurMinTemp.gridx = 0;
		gbc_lblCurMinTemp.gridy = 2;
		currentWeatherPanel.add(lblCurMinTemp, gbc_lblCurMinTemp);
		
		JLabel lblCurMaxTemp = new JLabel("Max. Temp.");
		lblCurMaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblCurMaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurMaxTemp = new GridBagConstraints();
		gbc_lblCurMaxTemp.insets = new Insets(0, 0, 5, 20);
		gbc_lblCurMaxTemp.gridx = 1;
		gbc_lblCurMaxTemp.gridy = 2;
		currentWeatherPanel.add(lblCurMaxTemp, gbc_lblCurMaxTemp);
		
		JLabel lblCurMinTempValue = new JLabel("19 \u00BAC");
		lblCurMinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCurMinTempValue = new GridBagConstraints();
		gbc_lblCurMinTempValue.insets = new Insets(0, 0, 20, 5);
		gbc_lblCurMinTempValue.gridx = 0;
		gbc_lblCurMinTempValue.gridy = 3;
		currentWeatherPanel.add(lblCurMinTempValue, gbc_lblCurMinTempValue);
		
		JLabel lblCurMaxTempValue = new JLabel("31 \u00BAC");
		lblCurMaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCurMaxTempValue = new GridBagConstraints();
		gbc_lblCurMaxTempValue.insets = new Insets(0, 0, 20, 0);
		gbc_lblCurMaxTempValue.gridx = 1;
		gbc_lblCurMaxTempValue.gridy = 3;
		currentWeatherPanel.add(lblCurMaxTempValue, gbc_lblCurMaxTempValue);
		
		JLabel lblCurPressure = new JLabel("Pressure:");
		lblCurPressure.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\pressure.png"));
		lblCurPressure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurPressure = new GridBagConstraints();
		gbc_lblCurPressure.anchor = GridBagConstraints.WEST;
		gbc_lblCurPressure.insets = new Insets(0, 20, 5, 5);
		gbc_lblCurPressure.gridx = 0;
		gbc_lblCurPressure.gridy = 4;
		currentWeatherPanel.add(lblCurPressure, gbc_lblCurPressure);
		
		JLabel lblCurPressureValue = new JLabel("1018.3 mbar");
		lblCurPressureValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurPressureValue = new GridBagConstraints();
		gbc_lblCurPressureValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurPressureValue.anchor = GridBagConstraints.WEST;
		gbc_lblCurPressureValue.gridx = 1;
		gbc_lblCurPressureValue.gridy = 4;
		currentWeatherPanel.add(lblCurPressureValue, gbc_lblCurPressureValue);
		
		JLabel lblCurHumidity = new JLabel(" Humidity:");
		lblCurHumidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblCurHumidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurHumidity = new GridBagConstraints();
		gbc_lblCurHumidity.anchor = GridBagConstraints.WEST;
		gbc_lblCurHumidity.insets = new Insets(0, 20, 5, 5);
		gbc_lblCurHumidity.gridx = 0;
		gbc_lblCurHumidity.gridy = 5;
		currentWeatherPanel.add(lblCurHumidity, gbc_lblCurHumidity);
		
		JLabel lblCurHumidityValue = new JLabel("66.0 %");
		lblCurHumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurHumidityValue = new GridBagConstraints();
		gbc_lblCurHumidityValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurHumidityValue.anchor = GridBagConstraints.WEST;
		gbc_lblCurHumidityValue.gridx = 1;
		gbc_lblCurHumidityValue.gridy = 5;
		currentWeatherPanel.add(lblCurHumidityValue, gbc_lblCurHumidityValue);
		
		JLabel lblCurWind = new JLabel(" Wind Vel.:");
		lblCurWind.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\wind.png"));
		lblCurWind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurWind = new GridBagConstraints();
		gbc_lblCurWind.anchor = GridBagConstraints.WEST;
		gbc_lblCurWind.insets = new Insets(0, 20, 10, 5);
		gbc_lblCurWind.gridx = 0;
		gbc_lblCurWind.gridy = 6;
		currentWeatherPanel.add(lblCurWind, gbc_lblCurWind);
		
		JLabel lblMs = new JLabel("3.47 m/s");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMs = new GridBagConstraints();
		gbc_lblMs.insets = new Insets(0, 0, 10, 0);
		gbc_lblMs.anchor = GridBagConstraints.WEST;
		gbc_lblMs.gridx = 1;
		gbc_lblMs.gridy = 6;
		currentWeatherPanel.add(lblMs, gbc_lblMs);
		
		return panel;
	}

	public static void main(String[] args) {
		FrameTMP frameTMP = new FrameTMP();

	}

}
