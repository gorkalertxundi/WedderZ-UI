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
		panel.setBackground(Color.WHITE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gridBagLayout);
		
		JPanel currentWeatherPanel = new JPanel();
		currentWeatherPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_currentWeatherPanel = new GridBagConstraints();
		gbc_currentWeatherPanel.gridwidth = 5;
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
		
		JPanel day7 = new JPanel();
		day7.setBackground(Color.WHITE);
		GridBagConstraints gbc_day7 = new GridBagConstraints();
		gbc_day7.anchor = GridBagConstraints.SOUTH;
		gbc_day7.insets = new Insets(0, 50, 40, 5);
		gbc_day7.fill = GridBagConstraints.HORIZONTAL;
		gbc_day7.gridx = 0;
		gbc_day7.gridy = 1;
		panel.add(day7, gbc_day7);
		GridBagLayout gbl_day7 = new GridBagLayout();
		gbl_day7.columnWidths = new int[]{41, 0, 0};
		gbl_day7.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day7.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_day7.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day7.setLayout(gbl_day7);
		
		JLabel lblDayWeek7 = new JLabel("Lunes");
		lblDayWeek7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek7 = new GridBagConstraints();
		gbc_lblDayWeek7.gridwidth = 3;
		gbc_lblDayWeek7.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek7.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek7.gridx = 0;
		gbc_lblDayWeek7.gridy = 0;
		day7.add(lblDayWeek7, gbc_lblDayWeek7);
		
		JLabel lblDay7Temperature = new JLabel("14 \u00BAC");
		lblDay7Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\b_3_very_cloudy.png"));
		lblDay7Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay7Temperature = new GridBagConstraints();
		gbc_lblDay7Temperature.gridwidth = 3;
		gbc_lblDay7Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay7Temperature.gridx = 0;
		gbc_lblDay7Temperature.gridy = 1;
		day7.add(lblDay7Temperature, gbc_lblDay7Temperature);
		
		JLabel lblDay7MinTemp = new JLabel("Min. Temp.");
		lblDay7MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay7MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay7MinTemp = new GridBagConstraints();
		gbc_lblDay7MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay7MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay7MinTemp.gridx = 0;
		gbc_lblDay7MinTemp.gridy = 2;
		day7.add(lblDay7MinTemp, gbc_lblDay7MinTemp);
		
		JLabel lblDay7MinTempValue = new JLabel("9 \u00BAC");
		lblDay7MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay7MinTempValue = new GridBagConstraints();
		gbc_lblDay7MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay7MinTempValue.gridx = 1;
		gbc_lblDay7MinTempValue.gridy = 2;
		day7.add(lblDay7MinTempValue, gbc_lblDay7MinTempValue);
		
		JLabel lblDay7MaxTemp = new JLabel("Max. Temp.");
		lblDay7MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay7MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay7MaxTemp = new GridBagConstraints();
		gbc_lblDay7MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay7MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay7MaxTemp.gridx = 0;
		gbc_lblDay7MaxTemp.gridy = 3;
		day7.add(lblDay7MaxTemp, gbc_lblDay7MaxTemp);
		
		JLabel lblDay7MaxTempValue = new JLabel("15 \u00BAC");
		lblDay7MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay7MaxTempValue = new GridBagConstraints();
		gbc_lblDay7MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay7MaxTempValue.gridx = 1;
		gbc_lblDay7MaxTempValue.gridy = 3;
		day7.add(lblDay7MaxTempValue, gbc_lblDay7MaxTempValue);
		
		JLabel lblDay7Humidity = new JLabel(" Humidity:");
		lblDay7Humidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay7Humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay7Humidity = new GridBagConstraints();
		gbc_lblDay7Humidity.anchor = GridBagConstraints.WEST;
		gbc_lblDay7Humidity.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay7Humidity.gridx = 0;
		gbc_lblDay7Humidity.gridy = 4;
		day7.add(lblDay7Humidity, gbc_lblDay7Humidity);
		
		JLabel lblDay7HumidityValue = new JLabel("54.0 %");
		lblDay7HumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay7HumidityValue = new GridBagConstraints();
		gbc_lblDay7HumidityValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay7HumidityValue.gridx = 1;
		gbc_lblDay7HumidityValue.gridy = 4;
		day7.add(lblDay7HumidityValue, gbc_lblDay7HumidityValue);
		
		JPanel day6 = new JPanel();
		day6.setBackground(Color.WHITE);
		GridBagConstraints gbc_day6 = new GridBagConstraints();
		gbc_day6.anchor = GridBagConstraints.SOUTH;
		gbc_day6.fill = GridBagConstraints.HORIZONTAL;
		gbc_day6.insets = new Insets(0, 50, 40, 5);
		gbc_day6.gridx = 1;
		gbc_day6.gridy = 1;
		panel.add(day6, gbc_day6);
		GridBagLayout gbl_day6 = new GridBagLayout();
		gbl_day6.columnWidths = new int[]{41, 0, 0, 0};
		gbl_day6.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day6.columnWeights = new double[]{0.0, 0.0, 4.9E-324, Double.MIN_VALUE};
		gbl_day6.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day6.setLayout(gbl_day6);
		
		JLabel lblDayWeek6 = new JLabel("Martes");
		lblDayWeek6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek6 = new GridBagConstraints();
		gbc_lblDayWeek6.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek6.gridwidth = 3;
		gbc_lblDayWeek6.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek6.gridx = 0;
		gbc_lblDayWeek6.gridy = 0;
		day6.add(lblDayWeek6, gbc_lblDayWeek6);
		
		JLabel lblDay6Temperature = new JLabel("9 \u00BAC");
		lblDay6Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\c_3_thunderstorm.png"));
		lblDay6Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay6Temperature = new GridBagConstraints();
		gbc_lblDay6Temperature.gridwidth = 3;
		gbc_lblDay6Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay6Temperature.gridx = 0;
		gbc_lblDay6Temperature.gridy = 1;
		day6.add(lblDay6Temperature, gbc_lblDay6Temperature);
		
		JLabel lblDay6MinTemp = new JLabel("Min. Temp.");
		lblDay6MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay6MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay6MinTemp = new GridBagConstraints();
		gbc_lblDay6MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay6MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay6MinTemp.gridx = 0;
		gbc_lblDay6MinTemp.gridy = 2;
		day6.add(lblDay6MinTemp, gbc_lblDay6MinTemp);
		
		JLabel lblDay6MinTempValue = new JLabel("4 \u00BAC");
		lblDay6MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay6MinTempValue = new GridBagConstraints();
		gbc_lblDay6MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay6MinTempValue.gridx = 1;
		gbc_lblDay6MinTempValue.gridy = 2;
		day6.add(lblDay6MinTempValue, gbc_lblDay6MinTempValue);
		
		JLabel lblDay6MaxTemp = new JLabel("Max. Temp.");
		lblDay6MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay6MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay6MaxTemp = new GridBagConstraints();
		gbc_lblDay6MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay6MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay6MaxTemp.gridx = 0;
		gbc_lblDay6MaxTemp.gridy = 3;
		day6.add(lblDay6MaxTemp, gbc_lblDay6MaxTemp);
		
		JLabel lblDay6MaxTempValue = new JLabel("11 \u00BAC");
		lblDay6MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay6MaxTempValue = new GridBagConstraints();
		gbc_lblDay6MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay6MaxTempValue.gridx = 1;
		gbc_lblDay6MaxTempValue.gridy = 3;
		day6.add(lblDay6MaxTempValue, gbc_lblDay6MaxTempValue);
		
		JLabel lblDay7Humidity_1 = new JLabel(" Humidity:");
		lblDay7Humidity_1.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay7Humidity_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay7Humidity_1 = new GridBagConstraints();
		gbc_lblDay7Humidity_1.anchor = GridBagConstraints.WEST;
		gbc_lblDay7Humidity_1.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay7Humidity_1.gridx = 0;
		gbc_lblDay7Humidity_1.gridy = 4;
		day6.add(lblDay7Humidity_1, gbc_lblDay7Humidity_1);
		
		JLabel lblDay7HumidityValue_1 = new JLabel("78.0 %");
		lblDay7HumidityValue_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay7HumidityValue_1 = new GridBagConstraints();
		gbc_lblDay7HumidityValue_1.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay7HumidityValue_1.gridx = 1;
		gbc_lblDay7HumidityValue_1.gridy = 4;
		day6.add(lblDay7HumidityValue_1, gbc_lblDay7HumidityValue_1);
		
		return panel;
	}

	public static void main(String[] args) {
		FrameTMP frameTMP = new FrameTMP();

	}

}
