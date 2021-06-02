package vista;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextPane;
import java.awt.Insets;

public class LocalityNotFound extends JPanel{
	
	public LocalityNotFound() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon imageIcon = new ImageIcon("icons/No-se-encontraron-resultados.png");
		Image conversion = imageIcon.getImage();
		Image tamaño = conversion.getScaledInstance(450, 400, Image.SCALE_SMOOTH);
		ImageIcon finIcon = new ImageIcon(tamaño);
		lblNewLabel.setIcon(finIcon);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(50, 0, 5, 0);
		gbc_lblNewLabel.gridx = 7;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("No se han encontrado resultados");
		textPane.setFont(new Font("Montserrat", Font.BOLD, 50));
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(25, 0, 0, 0);
		gbc_textPane.fill = GridBagConstraints.VERTICAL;
		gbc_textPane.gridx = 7;
		gbc_textPane.gridy = 5;
		add(textPane, gbc_textPane);
	}

}
