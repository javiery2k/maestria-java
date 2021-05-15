import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ListarVehiculos extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public ListarVehiculos() {
		setLayout(null);
		
		String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};    
		String column[]={"ID","NAME","SALARY"}; 
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 200, 430, 151);
		add(panel);
		
		table = new JTable(data,column);
		 table.setBounds(30,40,200,300);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("Buscar Vehiculo");
		lblNewLabel.setBounds(203, 11, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setBounds(43, 52, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Propietario");
		lblNewLabel_2.setBounds(157, 52, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setBounds(273, 52, 46, 14);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(26, 77, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 77, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(250, 77, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(351, 76, 89, 23);
		add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(59, 139, 30, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(374, 139, 30, 22);
		add(comboBox_1);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		lblTipoVehiculo.setBounds(43, 120, 69, 14);
		add(lblTipoVehiculo);
		
		JLabel lblUbicacionVehiculo = new JLabel("Ubicaci\u00F3n del Vehiculo");
		lblUbicacionVehiculo.setBounds(295, 114, 104, 14);
		add(lblUbicacionVehiculo);

	}
}
