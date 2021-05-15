import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;



import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ListarVehiculos extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable tabla1;

	
	
	public String[][] listarVehiculo(){
		
		String filas [][] = {{"101","AG1234","IVAN","SUV","12:30","1:25","0.30"},    
                {"102","AG1234","JAVIER","SEDAN","12:30","1:25","0.20"},    
                {"103","AG1234","MEDINA","MOTOCICLETA","12:30","1:25","0.10"}};
	return filas;
	}
	
	/**
	 * Create the panel.
	 */
	public ListarVehiculos() {
		

		setLayout(null);
		setBounds(282, 0, 695, 505);
		
		String data[][]={{"101","AG1234","IVAN","SUV","12:30","1:25","0.30"},    
                {"102","AG1234","JAVIER","SEDAN","12:30","1:25","0.20"},    
                {"103","AG1234","MEDINA","MOTOCICLETA","12:30","1:25","0.10"}};    
		String column[]={"ID","PLACA","PROPIETARIO","TIPOVEHICULO","HORAENTRADA","HORASALIDA","PAGO"}; 
		
		//Se Crea la Tabla
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 203, 671, 188);
		add(panel);
		panel.setLayout(null);
		tabla1=new JTable(data,column);
		JScrollPane scrollPane_1 = new JScrollPane(tabla1);
		scrollPane_1.setBounds(2, 2, 665, 183);
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
		lblNewLabel_1.setBounds(57, 47, 69, 20);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Propietario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(223, 49, 124, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(451, 49, 78, 20);
		add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField.setBounds(30, 78, 150, 40);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_1.setBounds(213, 78, 150, 40);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "AUTOMOVIL", "MOTOCICLETA"}));
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setBounds(180, 170, 100, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Parqueadero", "Fuera Parqueadero"}));
		
		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox_1.setBounds(392, 170, 150, 22);
		add(comboBox_1);
		
		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setForeground(SystemColor.textHighlight);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(167, 139, 113, 20);
		add(lblTipoVehiculo);
		
		JLabel lblUbicacionVehiculo = new JLabel("Ubicaci\u00F3n del Vehiculo");
		lblUbicacionVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacionVehiculo.setForeground(SystemColor.textHighlight);
		lblUbicacionVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblUbicacionVehiculo.setBounds(364, 139, 202, 20);
		add(lblUbicacionVehiculo);
		
		JButton btnNewButton_1 = new JButton("Buscar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabla1.getModel().setValueAt("prueba", 1, 1);
				
			}
		});
		btnNewButton_1.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton_1.setBounds(167, 403, 132, 39);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpiar");
		btnNewButton_2.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_2.setForeground(SystemColor.textHighlight);
		btnNewButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton_2.setBounds(392, 403, 132, 39);
		add(btnNewButton_2);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(239, 473, 285, 21);
		add(progressBar);
		
		JLabel lblProgreso = new JLabel("Progreso:");
		lblProgreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgreso.setForeground(SystemColor.textHighlight);
		lblProgreso.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblProgreso.setBounds(134, 473, 95, 21);
		add(lblProgreso);
		
		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(601, 473, 84, 21);
		add(label_version);
		
		//Agregamos el Componente de Fecha
		JDatePro jdate = new JDatePro();
		jdate.setBounds(400, 78, 210, 40);
		add(jdate);
		System.out.println("Fecha"+jdate.getDate());
		
	}
}
