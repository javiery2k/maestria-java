import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class ListarVehiculos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static JTable tabla1 = new JTable();
	/**
	 * Create the panel.
	 * 
	 * @throws SQLException
	 */
	public static void ActualizarTabla() {
		AppConection conn = new AppConection();
		ResultSet rs = conn.getAll();
			
		DefaultTableModel modelo = new DefaultTableModel();// Creo un modelo de datos para un jtable
		tabla1.setModel(modelo);// le asigno a la tabla el modelo de //datos
		try {
			// creo 3 columnas con sus etiquetas
			// estas son las columnas del JTable
			modelo.addColumn("PLACA");
			modelo.addColumn("PROPIETARIO");
			modelo.addColumn("TIPO");
			modelo.addColumn("ENTRADA");
			modelo.addColumn("SALIDA");
			modelo.addColumn("VALOR");
			modelo.addColumn("ESTADO");
			// Recorro el ResultSet que contiene los resultados.
			while (rs.next()) {
				Object[] ob = new Object[7];// Crea un vector
				// para almacenar los valores del ResultSet
				ob[0] = (rs.getString(2));
				ob[1] = (rs.getString(3));
				ob[2] = (rs.getString(4));
				if (rs.getString(5) != null) {
					ob[3] = rs.getString(5).substring(10).substring(0, 6);
				} else {
					ob[3] = "--";
				}
				if (rs.getString(6) != null) {
					ob[4] = rs.getString(6).substring(10).substring(0, 6);
					;
				} else {
					ob[4] = "--";
				}

				ob[5] = ("$" + rs.getString(7));
				ob[6] = (rs.getString(8));
				// a�ado el modelo a la tabla
				modelo.addRow(ob);
				ob = null;// limpia los datos de el vector de la memoria
			}
			rs.close(); // Cierra el ResultSet
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public ListarVehiculos() {
		setLayout(null);
		setBackground(new Color(42, 88, 173));
		setBounds(282, 0, 600, 500);

		String[][] data = { { "", "", "" } }; // Object[][] data = tabla;
		String column[] = { "ID", "PLACA", "PROPIETARIO" };

		JLabel lblNewLabel = new JLabel("Buscar Vehiculo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(171, 32, 257, 30);

		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(57, 89, 69, 20);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Propietario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(167, 89, 124, 20);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(328, 91, 78, 20);
		add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField.setBounds(40, 120, 100, 25);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_1.setBounds(180, 120, 100, 25);
		add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBorder(new LineBorder(new Color(171, 173, 179)));
		textField_2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		textField_2.setBounds(320, 120, 100, 25);
		add(textField_2);
		textField_2.setColumns(10);

		JButton btnNewButton = new JButton("Fecha");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(460, 120, 100, 25);
		add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "AUTOMOVIL", "MOTOCICLETA" }));
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox.setBounds(100, 190, 150, 25);
		add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "", "PARQUEADERO", "FUERA PARQUEADERO" }));

		comboBox_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox_1.setBounds(350, 190, 150, 25);
		add(comboBox_1);

		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setForeground(Color.WHITE);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(116, 159, 113, 20);
		add(lblTipoVehiculo);

		JLabel lblUbicacionVehiculo = new JLabel("Ubicaci\u00F3n del Vehiculo");
		lblUbicacionVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacionVehiculo.setForeground(Color.WHITE);
		lblUbicacionVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblUbicacionVehiculo.setBounds(322, 159, 202, 20);
		add(lblUbicacionVehiculo);

		JButton btnNewButton_1 = new JButton("BUSCAR");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton_1.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_1.setBackground(new Color(42, 88, 173));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(112, 397, 132, 39);
		add(btnNewButton_1);
		
		//----------------------------------------------
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// Obtenemos los valores ingresados
				Object combotipo = comboBox.getSelectedItem();
				Object comboestado = comboBox_1.getSelectedItem();				
				String Placa = textField.getText();
				String Propietario = textField_1.getText();				 
				String Fecha = textField_2.getText();
				String TipoVehiculo = combotipo.toString();	
				String Estado = comboestado.toString();	
				
				AppConection conn = new AppConection();
				ResultSet rs = conn.getSearch(Placa,Propietario,Fecha,TipoVehiculo,Estado);
				
				DefaultTableModel modelo = new DefaultTableModel();// Creo un modelo de datos para un jtable
				tabla1.setModel(modelo);// le asigno a la tabla el modelo de //datos
				try {
					// creo 3 columnas con sus etiquetas
					// estas son las columnas del JTable
					//modelo.addColumn("Id");
					modelo.addColumn("PLACA");
					modelo.addColumn("PROPIETARIO");
					modelo.addColumn("TIPO");
					modelo.addColumn("ENTRADA");
					modelo.addColumn("SALIDA");
					modelo.addColumn("VALOR");
					modelo.addColumn("ESTADO");
					// Recorro el ResultSet que contiene los resultados.
					while (rs.next()) {
						Object[] ob = new Object[7];// Crea un vector
						// para almacenar los valores del ResultSet
						ob[0] = (rs.getString(2));
						ob[1] = (rs.getString(3));
						ob[2] = (rs.getString(4));
						if (rs.getString(5) != null) {
							ob[3] = rs.getString(5).substring(10).substring(0, 6);
						} else {
							ob[3] = "--";
						}
						if (rs.getString(6) != null) {
							ob[4] = rs.getString(6).substring(10).substring(0, 6);
							;
						} else {
							ob[4] = "--";
						}

						ob[5] = ("$" + rs.getString(7));
						ob[6] = (rs.getString(8));
						// a�ado el modelo a la tabla
						modelo.addRow(ob);
						ob = null;// limpia los datos de el vector de la memoria
					}
					rs.close(); // Cierra el ResultSet
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
				
			}
		});
		
		//----------------------------------------------
		JButton btnNewButton_2 = new JButton("LIMPIAR");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton_2.setBorder(new LineBorder(Color.WHITE));
		btnNewButton_2.setBackground(new Color(42, 88, 173));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(356, 397, 132, 39);
		add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
		// Limpiar resultados
		public void actionPerformed(ActionEvent e) {				
				
				try {
					
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
		
			}
		});
					
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(157, 466, 285, 21);
		add(progressBar);

		JLabel lblProgreso = new JLabel("Progreso:");
		lblProgreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgreso.setForeground(Color.WHITE);
		lblProgreso.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblProgreso.setBounds(252, 438, 95, 21);
		add(lblProgreso);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(601, 473, 84, 21);
		add(label_version);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 228, 580, 150);
		add(scrollPane_1);
		scrollPane_1.setAutoscrolls(true);

		
		scrollPane_1.setViewportView(tabla1);
		tabla1.setAlignmentY(Component.TOP_ALIGNMENT);
		tabla1.setAlignmentX(Component.LEFT_ALIGNMENT);

		
		ActualizarTabla();
		
		
	}
}
