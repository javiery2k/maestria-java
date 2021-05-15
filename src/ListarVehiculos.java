import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextPane;

public class ListarVehiculos extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable tabla1;

	/**
	 * Create the panel.
	 */
	public ListarVehiculos() {
		setLayout(null);
		setBounds(282, 0, 695, 505);
		
		String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};    
		String column[]={"ID","NAME","SALARY"}; 
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 172, 671, 219);
		add(panel);
		panel.setLayout(null);
		tabla1=new JTable(data,column);
		JScrollPane scrollPane_1 = new JScrollPane(tabla1);
		scrollPane_1.setBounds(6, 16, 665, 203);
		panel.add(scrollPane_1);
		
		
		//panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Buscar Vehiculo");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(213, 8, 257, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(57, 36, 69, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Propietario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(223, 36, 124, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(433, 36, 78, 20);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(24, 67, 150, 40);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 67, 150, 40);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(399, 67, 150, 40);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Fecha");
		btnNewButton.setBounds(552, 68, 122, 39);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 139, 100, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(403, 139, 100, 22);
		add(comboBox_1);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setForeground(SystemColor.textHighlight);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(167, 118, 113, 20);
		add(lblTipoVehiculo);
		
		JLabel lblUbicacionVehiculo = new JLabel("Ubicaci\u00F3n del Vehiculo");
		lblUbicacionVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacionVehiculo.setForeground(SystemColor.textHighlight);
		lblUbicacionVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblUbicacionVehiculo.setBounds(399, 120, 104, 20);
		add(lblUbicacionVehiculo);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.setBounds(167, 403, 132, 39);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpiar");
		btnNewButton_2.setBounds(392, 403, 132, 39);
		add(btnNewButton_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(239, 473, 285, 21);
		add(progressBar);
		
		JLabel lblProgreso = new JLabel("Progreso:");
		lblProgreso.setBounds(186, 480, 52, 14);
		add(lblProgreso);
		
		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(601, 473, 84, 21);
		add(label_version);

	}
}
