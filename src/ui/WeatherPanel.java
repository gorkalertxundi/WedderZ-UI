package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WeatherPanel extends JPanel {

	JLabel lblDayWeek1;
	JLabel lblDay1Temperature;
	JLabel lblDay1MinTempValue;
	JLabel lblDay1MaxTempValue;
	JLabel lblDay1HumidityValue;

	JLabel lblDayWeek2;
	JLabel lblDay2Temperature;
	JLabel lblDay2MinTempValue;
	JLabel lblDay2MaxTempValue;
	JLabel lblDay2HumidityValue;

	JLabel lblDayWeek3;
	JLabel lblDay3Temperature;
	JLabel lblDay3MinTempValue;
	JLabel lblDay3MaxTempValue;
	JLabel lblDay3HumidityValue;

	JLabel lblDayWeek4;
	JLabel lblDay4Temperature;
	JLabel lblDay4MinTempValue;
	JLabel lblDay4MaxTempValue;
	JLabel lblDay4HumidityValue;

	JLabel lblDayWeek5;
	JLabel lblDay5Temperature;
	JLabel lblDay5MinTempValue;
	JLabel lblDay5MaxTempValue;
	JLabel lblDay5HumidityValue;

	JLabel lblLocation;
	JLabel lblCurTemperature;
	JLabel lblCurMinTempValue;
	JLabel lblCurMaxTempValue;
	JLabel lblCurPressureValue;
	JLabel lblCurHumidityValue;
	JLabel lblWindValue;
	
	
	public WeatherPanel() {
		this.setBackground(Color.WHITE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gridBagLayout);
		
		currentDayWeatherPanel(this);
		day5Panel(this);
		day4Panel(this);
		day3Panel(this);
		day2Panel(this);
		day1Panel(this);
	}
	
	private void day1Panel(JPanel panel) {
		//Day1
		JPanel day1 = new JPanel();
		day1.setBackground(Color.WHITE);
		GridBagConstraints gbc_day1 = new GridBagConstraints();
		gbc_day1.anchor = GridBagConstraints.SOUTH;
		gbc_day1.fill = GridBagConstraints.HORIZONTAL;
		gbc_day1.insets = new Insets(0, 50, 40, 5);
		gbc_day1.gridx = 4;
		gbc_day1.gridy = 1;
		panel.add(day1, gbc_day1);
		GridBagLayout gbl_day1 = new GridBagLayout();
		gbl_day1.columnWidths = new int[]{41, 0, 0, 0};
		gbl_day1.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day1.columnWeights = new double[]{0.0, 0.0, 4.9E-324, Double.MIN_VALUE};
		gbl_day1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day1.setLayout(gbl_day1);
		
		lblDayWeek1 = new JLabel("Viernes");
		lblDayWeek1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek1 = new GridBagConstraints();
		gbc_lblDayWeek1.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek1.gridwidth = 3;
		gbc_lblDayWeek1.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek1.gridx = 0;
		gbc_lblDayWeek1.gridy = 0;
		day1.add(lblDayWeek1, gbc_lblDayWeek1);
		
		lblDay1Temperature = new JLabel("24 \u00BAC");
		lblDay1Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\b_1_partly_cloudy.png"));
		lblDay1Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay1Temperature = new GridBagConstraints();
		gbc_lblDay1Temperature.gridwidth = 3;
		gbc_lblDay1Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay1Temperature.gridx = 0;
		gbc_lblDay1Temperature.gridy = 1;
		day1.add(lblDay1Temperature, gbc_lblDay1Temperature);
		
		JLabel lblDay1MinTemp = new JLabel("Min. Temp.");
		lblDay1MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay1MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay1MinTemp = new GridBagConstraints();
		gbc_lblDay1MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay1MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay1MinTemp.gridx = 0;
		gbc_lblDay1MinTemp.gridy = 2;
		day1.add(lblDay1MinTemp, gbc_lblDay1MinTemp);
		
		lblDay1MinTempValue = new JLabel("20 \u00BAC");
		lblDay1MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay1MinTempValue = new GridBagConstraints();
		gbc_lblDay1MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay1MinTempValue.gridx = 1;
		gbc_lblDay1MinTempValue.gridy = 2;
		day1.add(lblDay1MinTempValue, gbc_lblDay1MinTempValue);
		
		JLabel lblDay1MaxTemp = new JLabel("Max. Temp.");
		lblDay1MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay1MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay1MaxTemp = new GridBagConstraints();
		gbc_lblDay1MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay1MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay1MaxTemp.gridx = 0;
		gbc_lblDay1MaxTemp.gridy = 3;
		day1.add(lblDay1MaxTemp, gbc_lblDay1MaxTemp);
		
		lblDay1MaxTempValue = new JLabel("27 \u00BAC");
		lblDay1MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay1MaxTempValue = new GridBagConstraints();
		gbc_lblDay1MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay1MaxTempValue.gridx = 1;
		gbc_lblDay1MaxTempValue.gridy = 3;
		day1.add(lblDay1MaxTempValue, gbc_lblDay1MaxTempValue);
		
		JLabel lblDay1Humidity = new JLabel(" Humidity:");
		lblDay1Humidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay1Humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay1Humidity = new GridBagConstraints();
		gbc_lblDay1Humidity.anchor = GridBagConstraints.WEST;
		gbc_lblDay1Humidity.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay1Humidity.gridx = 0;
		gbc_lblDay1Humidity.gridy = 4;
		day1.add(lblDay1Humidity, gbc_lblDay1Humidity);
		
		lblDay1HumidityValue = new JLabel("12.0 %");
		lblDay1HumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay1HumidityValue = new GridBagConstraints();
		gbc_lblDay1HumidityValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay1HumidityValue.gridx = 1;
		gbc_lblDay1HumidityValue.gridy = 4;
		day1.add(lblDay1HumidityValue, gbc_lblDay1HumidityValue);
	}

	private void day2Panel(JPanel panel) {
		//Day2
		JPanel day2 = new JPanel();
		day2.setBackground(Color.WHITE);
		GridBagConstraints gbc_day2 = new GridBagConstraints();
		gbc_day2.anchor = GridBagConstraints.SOUTH;
		gbc_day2.fill = GridBagConstraints.HORIZONTAL;
		gbc_day2.insets = new Insets(0, 50, 40, 5);
		gbc_day2.gridx = 3;
		gbc_day2.gridy = 1;
		panel.add(day2, gbc_day2);
		GridBagLayout gbl_day2 = new GridBagLayout();
		gbl_day2.columnWidths = new int[]{41, 0, 0, 0};
		gbl_day2.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day2.columnWeights = new double[]{0.0, 0.0, 4.9E-324, Double.MIN_VALUE};
		gbl_day2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day2.setLayout(gbl_day2);
		
		lblDayWeek2 = new JLabel("Jueves");
		lblDayWeek2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek2 = new GridBagConstraints();
		gbc_lblDayWeek2.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek2.gridwidth = 3;
		gbc_lblDayWeek2.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek2.gridx = 0;
		gbc_lblDayWeek2.gridy = 0;
		day2.add(lblDayWeek2, gbc_lblDayWeek2);
		
		lblDay2Temperature = new JLabel("19 \u00BAC");
		lblDay2Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\b_2_cloudy.png"));
		lblDay2Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay2Temperature = new GridBagConstraints();
		gbc_lblDay2Temperature.gridwidth = 3;
		gbc_lblDay2Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay2Temperature.gridx = 0;
		gbc_lblDay2Temperature.gridy = 1;
		day2.add(lblDay2Temperature, gbc_lblDay2Temperature);
		
		JLabel lblDay2MinTemp = new JLabel("Min. Temp.");
		lblDay2MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay2MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay2MinTemp = new GridBagConstraints();
		gbc_lblDay2MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay2MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay2MinTemp.gridx = 0;
		gbc_lblDay2MinTemp.gridy = 2;
		day2.add(lblDay2MinTemp, gbc_lblDay2MinTemp);
		
		lblDay2MinTempValue = new JLabel("17 \u00BAC");
		lblDay2MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay2MinTempValue = new GridBagConstraints();
		gbc_lblDay2MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay2MinTempValue.gridx = 1;
		gbc_lblDay2MinTempValue.gridy = 2;
		day2.add(lblDay2MinTempValue, gbc_lblDay2MinTempValue);
		
		JLabel lblDay2MaxTemp = new JLabel("Max. Temp.");
		lblDay2MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay2MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay2MaxTemp = new GridBagConstraints();
		gbc_lblDay2MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay2MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay2MaxTemp.gridx = 0;
		gbc_lblDay2MaxTemp.gridy = 3;
		day2.add(lblDay2MaxTemp, gbc_lblDay2MaxTemp);
		
		lblDay2MaxTempValue = new JLabel("22 \u00BAC");
		lblDay2MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay2MaxTempValue = new GridBagConstraints();
		gbc_lblDay2MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay2MaxTempValue.gridx = 1;
		gbc_lblDay2MaxTempValue.gridy = 3;
		day2.add(lblDay2MaxTempValue, gbc_lblDay2MaxTempValue);
		
		JLabel lblDay2Humidity = new JLabel(" Humidity:");
		lblDay2Humidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay2Humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay2Humidity = new GridBagConstraints();
		gbc_lblDay2Humidity.anchor = GridBagConstraints.WEST;
		gbc_lblDay2Humidity.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay2Humidity.gridx = 0;
		gbc_lblDay2Humidity.gridy = 4;
		day2.add(lblDay2Humidity, gbc_lblDay2Humidity);
		
		lblDay2HumidityValue = new JLabel("27.0 %");
		lblDay2HumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay2HumidityValue = new GridBagConstraints();
		gbc_lblDay2HumidityValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay2HumidityValue.gridx = 1;
		gbc_lblDay2HumidityValue.gridy = 4;
		day2.add(lblDay2HumidityValue, gbc_lblDay2HumidityValue);
	}

	private void day3Panel(JPanel panel) {
		//Day3
		JPanel day3 = new JPanel();
		day3.setBackground(Color.WHITE);
		GridBagConstraints gbc_day3 = new GridBagConstraints();
		gbc_day3.anchor = GridBagConstraints.SOUTH;
		gbc_day3.fill = GridBagConstraints.HORIZONTAL;
		gbc_day3.insets = new Insets(0, 50, 40, 5);
		gbc_day3.gridx = 2;
		gbc_day3.gridy = 1;
		panel.add(day3, gbc_day3);
		GridBagLayout gbl_day3 = new GridBagLayout();
		gbl_day3.columnWidths = new int[]{41, 0, 0, 0};
		gbl_day3.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day3.columnWeights = new double[]{0.0, 0.0, 4.9E-324, Double.MIN_VALUE};
		gbl_day3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day3.setLayout(gbl_day3);
		
		lblDayWeek3 = new JLabel("Mi�rcoles");
		lblDayWeek3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek3 = new GridBagConstraints();
		gbc_lblDayWeek3.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek3.gridwidth = 3;
		gbc_lblDayWeek3.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek3.gridx = 0;
		gbc_lblDayWeek3.gridy = 0;
		day3.add(lblDayWeek3, gbc_lblDayWeek3);
		
		lblDay3Temperature = new JLabel("13 \u00BAC");
		lblDay3Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\c_1_rainy.png"));
		lblDay3Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay3Temperature = new GridBagConstraints();
		gbc_lblDay3Temperature.gridwidth = 3;
		gbc_lblDay3Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay3Temperature.gridx = 0;
		gbc_lblDay3Temperature.gridy = 1;
		day3.add(lblDay3Temperature, gbc_lblDay3Temperature);
		
		JLabel lblDay3MinTemp = new JLabel("Min. Temp.");
		lblDay3MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay3MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay3MinTemp = new GridBagConstraints();
		gbc_lblDay3MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay3MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay3MinTemp.gridx = 0;
		gbc_lblDay3MinTemp.gridy = 2;
		day3.add(lblDay3MinTemp, gbc_lblDay3MinTemp);
		
		lblDay3MinTempValue = new JLabel("10 \u00BAC");
		lblDay3MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay3MinTempValue = new GridBagConstraints();
		gbc_lblDay3MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay3MinTempValue.gridx = 1;
		gbc_lblDay3MinTempValue.gridy = 2;
		day3.add(lblDay3MinTempValue, gbc_lblDay3MinTempValue);
		
		JLabel lblDay3MaxTemp = new JLabel("Max. Temp.");
		lblDay3MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay3MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay3MaxTemp = new GridBagConstraints();
		gbc_lblDay3MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay3MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay3MaxTemp.gridx = 0;
		gbc_lblDay3MaxTemp.gridy = 3;
		day3.add(lblDay3MaxTemp, gbc_lblDay3MaxTemp);
		
		lblDay3MaxTempValue = new JLabel("16 \u00BAC");
		lblDay3MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay3MaxTempValue = new GridBagConstraints();
		gbc_lblDay3MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay3MaxTempValue.gridx = 1;
		gbc_lblDay3MaxTempValue.gridy = 3;
		day3.add(lblDay3MaxTempValue, gbc_lblDay3MaxTempValue);
		
		JLabel lblDay3Humidity = new JLabel(" Humidity:");
		lblDay3Humidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay3Humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay3Humidity = new GridBagConstraints();
		gbc_lblDay3Humidity.anchor = GridBagConstraints.WEST;
		gbc_lblDay3Humidity.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay3Humidity.gridx = 0;
		gbc_lblDay3Humidity.gridy = 4;
		day3.add(lblDay3Humidity, gbc_lblDay3Humidity);
		
		lblDay3HumidityValue = new JLabel("43.0 %");
		lblDay3HumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay3HumidityValue = new GridBagConstraints();
		gbc_lblDay3HumidityValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay3HumidityValue.gridx = 1;
		gbc_lblDay3HumidityValue.gridy = 4;
		day3.add(lblDay3HumidityValue, gbc_lblDay3HumidityValue);
	}

	private void day4Panel(JPanel panel) {
		//Day4
		JPanel day4 = new JPanel();
		day4.setBackground(Color.WHITE);
		GridBagConstraints gbc_day4 = new GridBagConstraints();
		gbc_day4.anchor = GridBagConstraints.SOUTH;
		gbc_day4.fill = GridBagConstraints.HORIZONTAL;
		gbc_day4.insets = new Insets(0, 50, 40, 5);
		gbc_day4.gridx = 1;
		gbc_day4.gridy = 1;
		panel.add(day4, gbc_day4);
		GridBagLayout gbl_day4 = new GridBagLayout();
		gbl_day4.columnWidths = new int[]{41, 0, 0, 0};
		gbl_day4.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day4.columnWeights = new double[]{0.0, 0.0, 4.9E-324, Double.MIN_VALUE};
		gbl_day4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day4.setLayout(gbl_day4);
		
		lblDayWeek4 = new JLabel("Martes");
		lblDayWeek4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek4 = new GridBagConstraints();
		gbc_lblDayWeek4.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek4.gridwidth = 3;
		gbc_lblDayWeek4.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek4.gridx = 0;
		gbc_lblDayWeek4.gridy = 0;
		day4.add(lblDayWeek4, gbc_lblDayWeek4);
		
		lblDay4Temperature = new JLabel("9 \u00BAC");
		lblDay4Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\c_3_thunderstorm.png"));
		lblDay4Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay4Temperature = new GridBagConstraints();
		gbc_lblDay4Temperature.gridwidth = 3;
		gbc_lblDay4Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay4Temperature.gridx = 0;
		gbc_lblDay4Temperature.gridy = 1;
		day4.add(lblDay4Temperature, gbc_lblDay4Temperature);
		
		JLabel lblDay4MinTemp = new JLabel("Min. Temp.");
		lblDay4MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay4MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay4MinTemp = new GridBagConstraints();
		gbc_lblDay4MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay4MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay4MinTemp.gridx = 0;
		gbc_lblDay4MinTemp.gridy = 2;
		day4.add(lblDay4MinTemp, gbc_lblDay4MinTemp);
		
		lblDay4MinTempValue = new JLabel("3 \u00BAC");
		lblDay4MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay4MinTempValue = new GridBagConstraints();
		gbc_lblDay4MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay4MinTempValue.gridx = 1;
		gbc_lblDay4MinTempValue.gridy = 2;
		day4.add(lblDay4MinTempValue, gbc_lblDay4MinTempValue);
		
		JLabel lblDay4MaxTemp = new JLabel("Max. Temp.");
		lblDay4MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay4MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay4MaxTemp = new GridBagConstraints();
		gbc_lblDay4MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay4MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay4MaxTemp.gridx = 0;
		gbc_lblDay4MaxTemp.gridy = 3;
		day4.add(lblDay4MaxTemp, gbc_lblDay4MaxTemp);
		
		lblDay4MaxTempValue = new JLabel("11 \u00BAC");
		lblDay4MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay4MaxTempValue = new GridBagConstraints();
		gbc_lblDay4MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay4MaxTempValue.gridx = 1;
		gbc_lblDay4MaxTempValue.gridy = 3;
		day4.add(lblDay4MaxTempValue, gbc_lblDay4MaxTempValue);
		
		JLabel lblDay4Humidity = new JLabel(" Humidity:");
		lblDay4Humidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay4Humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay4Humidity = new GridBagConstraints();
		gbc_lblDay4Humidity.anchor = GridBagConstraints.WEST;
		gbc_lblDay4Humidity.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay4Humidity.gridx = 0;
		gbc_lblDay4Humidity.gridy = 4;
		day4.add(lblDay4Humidity, gbc_lblDay4Humidity);
		
		lblDay4HumidityValue = new JLabel("78.0 %");
		lblDay4HumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay4HumidityValue_1 = new GridBagConstraints();
		gbc_lblDay4HumidityValue_1.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay4HumidityValue_1.gridx = 1;
		gbc_lblDay4HumidityValue_1.gridy = 4;
		day4.add(lblDay4HumidityValue, gbc_lblDay4HumidityValue_1);
		
	}

	private void day5Panel(JPanel panel) {
		//Day5
		JPanel day5 = new JPanel();
		day5.setBackground(Color.WHITE);
		GridBagConstraints gbc_day5 = new GridBagConstraints();
		gbc_day5.anchor = GridBagConstraints.SOUTH;
		gbc_day5.insets = new Insets(0, 0, 40, 5);
		gbc_day5.fill = GridBagConstraints.HORIZONTAL;
		gbc_day5.gridx = 0;
		gbc_day5.gridy = 1;
		panel.add(day5, gbc_day5);
		GridBagLayout gbl_day5 = new GridBagLayout();
		gbl_day5.columnWidths = new int[]{41, 0, 0};
		gbl_day5.rowHeights = new int[]{20, 0, 0, 0, 0, 0};
		gbl_day5.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_day5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		day5.setLayout(gbl_day5);
		
		lblDayWeek5 = new JLabel("Lunes");
		lblDayWeek5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDayWeek5 = new GridBagConstraints();
		gbc_lblDayWeek5.gridwidth = 3;
		gbc_lblDayWeek5.insets = new Insets(5, 40, 5, 40);
		gbc_lblDayWeek5.anchor = GridBagConstraints.NORTH;
		gbc_lblDayWeek5.gridx = 0;
		gbc_lblDayWeek5.gridy = 0;
		day5.add(lblDayWeek5, gbc_lblDayWeek5);
		
		lblDay5Temperature = new JLabel("14 \u00BAC");
		lblDay5Temperature.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\b_3_very_cloudy.png"));
		lblDay5Temperature.setFont(new Font("Tahoma", Font.PLAIN, 22));
		GridBagConstraints gbc_lblDay5Temperature = new GridBagConstraints();
		gbc_lblDay5Temperature.gridwidth = 3;
		gbc_lblDay5Temperature.insets = new Insets(0, 10, 5, 10);
		gbc_lblDay5Temperature.gridx = 0;
		gbc_lblDay5Temperature.gridy = 1;
		day5.add(lblDay5Temperature, gbc_lblDay5Temperature);
		
		JLabel lblDay5MinTemp = new JLabel("Min. Temp.");
		lblDay5MinTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_1_low_temperature.png"));
		lblDay5MinTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay5MinTemp = new GridBagConstraints();
		gbc_lblDay5MinTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay5MinTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay5MinTemp.gridx = 0;
		gbc_lblDay5MinTemp.gridy = 2;
		day5.add(lblDay5MinTemp, gbc_lblDay5MinTemp);
		
		lblDay5MinTempValue = new JLabel("9 \u00BAC");
		lblDay5MinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay5MinTempValue = new GridBagConstraints();
		gbc_lblDay5MinTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay5MinTempValue.gridx = 1;
		gbc_lblDay5MinTempValue.gridy = 2;
		day5.add(lblDay5MinTempValue, gbc_lblDay5MinTempValue);
		
		JLabel lblDay5MaxTemp = new JLabel("Max. Temp.");
		lblDay5MaxTemp.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\e_3_high_temp.png"));
		lblDay5MaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay5MaxTemp = new GridBagConstraints();
		gbc_lblDay5MaxTemp.anchor = GridBagConstraints.WEST;
		gbc_lblDay5MaxTemp.insets = new Insets(0, 5, 5, 5);
		gbc_lblDay5MaxTemp.gridx = 0;
		gbc_lblDay5MaxTemp.gridy = 3;
		day5.add(lblDay5MaxTemp, gbc_lblDay5MaxTemp);
		
		lblDay5MaxTempValue = new JLabel("15 \u00BAC");
		lblDay5MaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay5MaxTempValue = new GridBagConstraints();
		gbc_lblDay5MaxTempValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay5MaxTempValue.gridx = 1;
		gbc_lblDay5MaxTempValue.gridy = 3;
		day5.add(lblDay5MaxTempValue, gbc_lblDay5MaxTempValue);
		
		JLabel lblDay5Humidity = new JLabel(" Humidity:");
		lblDay5Humidity.setIcon(new ImageIcon("C:\\Users\\gorka\\OneDrive\\Documentos\\Repostiorios\\WedderZ\\icons\\humidity.png"));
		lblDay5Humidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblDay5Humidity = new GridBagConstraints();
		gbc_lblDay5Humidity.anchor = GridBagConstraints.WEST;
		gbc_lblDay5Humidity.insets = new Insets(0, 10, 10, 5);
		gbc_lblDay5Humidity.gridx = 0;
		gbc_lblDay5Humidity.gridy = 4;
		day5.add(lblDay5Humidity, gbc_lblDay5Humidity);
		
		lblDay5HumidityValue = new JLabel("54.0 %");
		lblDay5HumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDay5HumidityValue = new GridBagConstraints();
		gbc_lblDay5HumidityValue.insets = new Insets(0, 5, 5, 15);
		gbc_lblDay5HumidityValue.gridx = 1;
		gbc_lblDay5HumidityValue.gridy = 4;
		day5.add(lblDay5HumidityValue, gbc_lblDay5HumidityValue);
		
	}

	private void currentDayWeatherPanel(JPanel panel) {
		//Current Day Wheather Panel
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
		
		lblLocation = new JLabel("Madrid, ES");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GridBagConstraints gbc_lblLocation = new GridBagConstraints();
		gbc_lblLocation.gridwidth = 2;
		gbc_lblLocation.insets = new Insets(10, 60, 5, 60);
		gbc_lblLocation.gridx = 0;
		gbc_lblLocation.gridy = 0;
		currentWeatherPanel.add(lblLocation, gbc_lblLocation);
		
		lblCurTemperature = new JLabel("26 \u00BAC");
		lblCurTemperature.setFont(new Font("Tahoma", Font.PLAIN, 69));
		lblCurTemperature.setIcon(new ImageIcon("icons\\a_3_very_sunny.png"));
		GridBagConstraints gbc_lblCurTemperature = new GridBagConstraints();
		gbc_lblCurTemperature.gridwidth = 2;
		gbc_lblCurTemperature.insets = new Insets(5, 10, 5, 10);
		gbc_lblCurTemperature.gridx = 0;
		gbc_lblCurTemperature.gridy = 1;
		currentWeatherPanel.add(lblCurTemperature, gbc_lblCurTemperature);
		
		JLabel lblCurMinTemp = new JLabel("Min. Temp.");
		lblCurMinTemp.setIcon(new ImageIcon("icons\\e_1_low_temperature.png"));
		lblCurMinTemp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurMinTemp = new GridBagConstraints();
		gbc_lblCurMinTemp.insets = new Insets(0, 10, 5, 10);
		gbc_lblCurMinTemp.gridx = 0;
		gbc_lblCurMinTemp.gridy = 2;
		currentWeatherPanel.add(lblCurMinTemp, gbc_lblCurMinTemp);
		
		JLabel lblCurMaxTemp = new JLabel("Max. Temp.");
		lblCurMaxTemp.setIcon(new ImageIcon("icons\\e_3_high_temp.png"));
		lblCurMaxTemp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCurMaxTemp = new GridBagConstraints();
		gbc_lblCurMaxTemp.insets = new Insets(0, 0, 5, 20);
		gbc_lblCurMaxTemp.gridx = 1;
		gbc_lblCurMaxTemp.gridy = 2;
		currentWeatherPanel.add(lblCurMaxTemp, gbc_lblCurMaxTemp);
		
		lblCurMinTempValue = new JLabel("19 \u00BAC");
		lblCurMinTempValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCurMinTempValue = new GridBagConstraints();
		gbc_lblCurMinTempValue.insets = new Insets(0, 0, 20, 5);
		gbc_lblCurMinTempValue.gridx = 0;
		gbc_lblCurMinTempValue.gridy = 3;
		currentWeatherPanel.add(lblCurMinTempValue, gbc_lblCurMinTempValue);
		
		lblCurMaxTempValue = new JLabel("31 \u00BAC");
		lblCurMaxTempValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblCurMaxTempValue = new GridBagConstraints();
		gbc_lblCurMaxTempValue.insets = new Insets(0, 0, 20, 0);
		gbc_lblCurMaxTempValue.gridx = 1;
		gbc_lblCurMaxTempValue.gridy = 3;
		currentWeatherPanel.add(lblCurMaxTempValue, gbc_lblCurMaxTempValue);
		
		JLabel lblCurPressure = new JLabel("Pressure:");
		lblCurPressure.setIcon(new ImageIcon("icons\\pressure.png"));
		lblCurPressure.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurPressure = new GridBagConstraints();
		gbc_lblCurPressure.anchor = GridBagConstraints.WEST;
		gbc_lblCurPressure.insets = new Insets(0, 20, 5, 5);
		gbc_lblCurPressure.gridx = 0;
		gbc_lblCurPressure.gridy = 4;
		currentWeatherPanel.add(lblCurPressure, gbc_lblCurPressure);
		
		lblCurPressureValue = new JLabel("1018.3 mbar");
		lblCurPressureValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurPressureValue = new GridBagConstraints();
		gbc_lblCurPressureValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurPressureValue.anchor = GridBagConstraints.WEST;
		gbc_lblCurPressureValue.gridx = 1;
		gbc_lblCurPressureValue.gridy = 4;
		currentWeatherPanel.add(lblCurPressureValue, gbc_lblCurPressureValue);
		
		JLabel lblCurHumidity = new JLabel(" Humidity:");
		lblCurHumidity.setIcon(new ImageIcon("icons\\humidity.png"));
		lblCurHumidity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurHumidity = new GridBagConstraints();
		gbc_lblCurHumidity.anchor = GridBagConstraints.WEST;
		gbc_lblCurHumidity.insets = new Insets(0, 20, 5, 5);
		gbc_lblCurHumidity.gridx = 0;
		gbc_lblCurHumidity.gridy = 5;
		currentWeatherPanel.add(lblCurHumidity, gbc_lblCurHumidity);
		
		lblCurHumidityValue = new JLabel("66.0 %");
		lblCurHumidityValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurHumidityValue = new GridBagConstraints();
		gbc_lblCurHumidityValue.insets = new Insets(0, 0, 5, 0);
		gbc_lblCurHumidityValue.anchor = GridBagConstraints.WEST;
		gbc_lblCurHumidityValue.gridx = 1;
		gbc_lblCurHumidityValue.gridy = 5;
		currentWeatherPanel.add(lblCurHumidityValue, gbc_lblCurHumidityValue);
		
		JLabel lblCurWind = new JLabel(" Wind Vel.:");
		lblCurWind.setIcon(new ImageIcon("icons\\wind.png"));
		lblCurWind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCurWind = new GridBagConstraints();
		gbc_lblCurWind.anchor = GridBagConstraints.WEST;
		gbc_lblCurWind.insets = new Insets(0, 20, 10, 5);
		gbc_lblCurWind.gridx = 0;
		gbc_lblCurWind.gridy = 6;
		currentWeatherPanel.add(lblCurWind, gbc_lblCurWind);
		
		lblWindValue = new JLabel("3.47 m/s");
		lblWindValue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblMs = new GridBagConstraints();
		gbc_lblMs.insets = new Insets(0, 0, 10, 0);
		gbc_lblMs.anchor = GridBagConstraints.WEST;
		gbc_lblMs.gridx = 1;
		gbc_lblMs.gridy = 6;
		currentWeatherPanel.add(lblWindValue, gbc_lblMs);
	}
	
	public void setCurrentWeatherValues(String location, double wetherType, double temp, double minTemp, double maxTemp, double pressure, double windVel, double humidity) {
		lblLocation.setText(location);
		lblCurTemperature.setText(String.valueOf(temp) + " \u00BAC");
		lblCurMinTempValue.setText(String.valueOf(minTemp) + " \u00BAC");
		lblCurMaxTempValue.setText(String.valueOf(maxTemp) + " \u00BAC");
		lblCurPressureValue.setText(String.valueOf(pressure) + " mbar");
		lblCurHumidityValue.setText(String.valueOf(humidity) + " %");
		lblWindValue.setText(String.valueOf(windVel) + " m/s");
		setWeatherType(lblCurTemperature, wetherType);
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
	
	public void setDay1Values(String dayOfWeek, double temp, double minTemp, double maxTemp, double humidity) {
		lblDayWeek1.setText(dayOfWeek);
		lblDay1Temperature.setText(String.valueOf(temp) + " \u00BAC");
		lblDay1MinTempValue.setText(String.valueOf(minTemp) + " \u00BAC");
		lblDay1MaxTempValue.setText(String.valueOf(maxTemp) + " \u00BAC");
		lblDay1HumidityValue.setText(String.valueOf(humidity) + " %");
	}
	
	
}
