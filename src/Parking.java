import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;



public class Login extends JFrame {
	/**
	 * github
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Login() {
		/**
		 * Configuracion Global
		 */
		setTitle("Sistemas de Estacionamientos en Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		setResizable(false);
		/**
		 * Jpanel Principal
		 */
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Jpanel Izq
		 */
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(0, 0, 325, 323);
		contentPane.add(panel);
		panel.setLayout(null);

		/**
		 * Jpanel Derecha
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(42, 88, 173));
		panel_1.setBounds(324, 0, 322, 323);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/**
		 * Etiquetas
		 */
		JLabel lblNewLabel_2 = new JLabel("Parking 1.0");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(42, 88, 173));
		lblNewLabel_2.setBounds(120, 259, 84, 21);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("SISTEMA DE ESTACIONAMIENTOS");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1.setBounds(30, 234, 265, 21);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/assets/parking-icon-150.png")));
		lblNewLabel_3.setBounds(84, 59, 150, 151);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("Todos los derechos reservados 2021");
		lblNewLabel_2_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(75, 288, 185, 14);
		panel.add(lblNewLabel_2_1_1);

		/**
		 * Mensaje de Validacion
		 */
		JLabel lblNewLabel_4 = new JLabel("Las Credenciales no coinciden");
		lblNewLabel_4.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel_4.setVisible(false);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(73, 186, 191, 14);
		panel_1.add(lblNewLabel_4);

		/**
		 * Campo de Usuario
		 */
		textField = new JTextField();
		textField.setBackground(new Color(42, 88, 173));
		textField.setForeground(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		textField.setCaretColor(Color.WHITE);
		textField.setBounds(73, 106, 190, 20);
		panel_1.add(textField);

		/**
		 * Campo de Password
		 */
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(42, 88, 173));
		passwordField.setForeground(Color.WHITE);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBounds(73, 154, 190, 20);
		panel_1.add(passwordField);

		/**
		 * Logos. estamos usando el path relativo a la clase
		 */
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/assets/username-icon.png")));
		lblNewLabel.setBounds(31, 101, 32, 32);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/assets/password-icon.png")));
		lblNewLabel_1.setBounds(31, 146, 32, 32);
		panel_1.add(lblNewLabel_1);

		/**
		 * Boton de Entrar
		 */
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos los valores ingresados
				String user = textField.getText();
				/* String pass = passwordField.getText(); */
				char pasArray[] = passwordField.getPassword();
				String pass = new String(pasArray);

				// Validamos las credenciales
				if (!user.isEmpty() && !pass.isEmpty()) {

					// Hacemos nuestra coneccion de BD
					AppConection conn = new AppConection();

					// Si las credenciales son validas, cerramos el login y abrimos el app
					if (conn.logearse(user, pass)) {
						setVisible(false);

						// Lanzamos nuestra app
						App app = new App();
						app.setVisible(true);

					} else {
						lblNewLabel_4.setVisible(true);
					}
				} else {
					lblNewLabel_4.setVisible(true);
				}

			}
		});
		btnNewButton.setBorder(new LineBorder(Color.WHITE));
		btnNewButton.setBackground(new Color(42, 88, 173));
		btnNewButton.setBounds(73, 226, 89, 23);
		panel_1.add(btnNewButton);

		/**
		 * Boton de Salir
		 */
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBorder(new LineBorder(Color.WHITE));
		btnSalir.setBackground(new Color(42, 88, 173));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBounds(175, 226, 89, 23);
		panel_1.add(btnSalir);

	}
}

public class ListarVehiculos extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField placa;
	private JTextField propietario;
	private JTextField fecha;
	private static JTable tabla1 = new JTable();
	AppConection conn = new AppConection();
	static DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm");

	/**
	 * Create the panel.
	 * 
	 * @param rs
	 * 
	 * @throws SQLException
	 */

	public ListarVehiculos() {
		this.init();
	}

	public static void ActualizarTabla(ResultSet rs) {

		DefaultTableModel modelo = new DefaultTableModel();// Creo un modelo de datos para un jtable
		tabla1.setModel(modelo);// le asigno a la tabla el modelo de //datos
		try {
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
					ob[3] = dateFormat.parse(rs.getString(5)); // rs.getString(5).substring(10).substring(0, 6);
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

	public void init() {
		setLayout(null);
		setBackground(new Color(42, 88, 173));
		setBounds(282, 0, 800, 500);

		String[][] data = { { "", "", "" } }; // Object[][] data = tabla;
		String column[] = { "ID", "PLACA", "PROPIETARIO" };

		JLabel lblNewLabel = new JLabel("Buscar Vehiculo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewLabel.setBounds(271, 32, 257, 30);

		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Placa");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(88, 89, 69, 20);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Propietario");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(245, 89, 124, 20);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fecha");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(450, 89, 78, 20);
		add(lblNewLabel_3);

		placa = new JTextField();
		placa.setBorder(new LineBorder(new Color(171, 173, 179)));
		placa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		placa.setBounds(80, 120, 100, 25);
		add(placa);
		placa.setColumns(10);

		propietario = new JTextField();
		propietario.setBorder(new LineBorder(new Color(171, 173, 179)));
		propietario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		propietario.setBounds(260, 120, 100, 25);
		add(propietario);
		propietario.setColumns(10);

		fecha = new JTextField();
		fecha.setBorder(new LineBorder(new Color(171, 173, 179)));
		fecha.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		fecha.setBounds(440, 120, 100, 25);
		add(fecha);
		fecha.setColumns(10);

		JButton btnNewButton = new JButton("Fecha");
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(620, 120, 100, 25);
		add(btnNewButton);

		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] { "", "AUTOMOVIL", "MOTOCICLETA" }));
		tipo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tipo.setBounds(166, 190, 150, 25);
		add(tipo);

		JComboBox disponibilidad = new JComboBox();
		disponibilidad.setModel(new DefaultComboBoxModel(new String[] { "", "DISPONIBLE", "NO DISPONIBLE" }));
		disponibilidad.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		disponibilidad.setBounds(482, 190, 150, 25);
		add(disponibilidad);

		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo");
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setForeground(Color.WHITE);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(161, 159, 113, 20);
		add(lblTipoVehiculo);

		JLabel lblUbicacionVehiculo = new JLabel("Disponibilidad");
		lblUbicacionVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacionVehiculo.setForeground(Color.WHITE);
		lblUbicacionVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblUbicacionVehiculo.setBounds(435, 159, 202, 20);
		add(lblUbicacionVehiculo);

		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFocusPainted(false);
		btnBuscar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnBuscar.setBorder(new LineBorder(Color.WHITE));
		btnBuscar.setBackground(new Color(42, 88, 173));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBounds(178, 397, 132, 39);
		add(btnBuscar);

		// ----------------------------------------------
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Obtenemos los valores ingresados
				String Placa = placa.getText();
				String Propietario = propietario.getText();
				String Fecha = fecha.getText();
				String TipoVehiculo = tipo.getSelectedItem().toString();
				String Estado = disponibilidad.getSelectedItem().toString();
				ResultSet rs = conn.getSearch(Placa, Propietario, Fecha, TipoVehiculo, Estado);

				ActualizarTabla(rs);

			}
		});

		// ----------------------------------------------
		JButton btnLimpiart = new JButton("LIMPIAR");
		btnLimpiart.setFocusPainted(false);
		btnLimpiart.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLimpiart.setBorder(new LineBorder(Color.WHITE));
		btnLimpiart.setBackground(new Color(42, 88, 173));
		btnLimpiart.setForeground(Color.WHITE);
		btnLimpiart.setBounds(488, 397, 132, 39);
		add(btnLimpiart);
		btnLimpiart.addActionListener(new ActionListener() {
			// Limpiar resultados
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = conn.getAll();
				ActualizarTabla(rs);
				placa.setText("");
				propietario.setText("");
				fecha.setText("");
				tipo.setSelectedIndex(0);
				disponibilidad.setSelectedIndex(0);
			}
		});

		// int i=0;
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(257, 466, 285, 21);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);
		add(progressBar);
		/*
		 * while(i<=20){ progressBar.setValue(i); i=i+20;
		 * try{Thread.sleep(150);}catch(Exception e){} }
		 */
		JLabel lblProgreso = new JLabel("Progreso:");
		lblProgreso.setHorizontalAlignment(SwingConstants.CENTER);
		lblProgreso.setForeground(Color.WHITE);
		lblProgreso.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblProgreso.setBounds(352, 438, 95, 21);
		add(lblProgreso);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(601, 473, 84, 21);
		add(label_version);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 228, 780, 150);
		add(scrollPane_1);
		scrollPane_1.setAutoscrolls(true);

		scrollPane_1.setViewportView(tabla1);
		tabla1.setAlignmentY(Component.TOP_ALIGNMENT);
		tabla1.setAlignmentX(Component.LEFT_ALIGNMENT);

		ResultSet rs = conn.getAll();
		ActualizarTabla(rs);
	}
}

public class IngresarVehiculo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField placa;
	private JTextField propietario;
	private JButton btn_registrar;

	/**
	 * Create the panel.
	 * 
	 * @return
	 */

	public IngresarVehiculo() {
		setBounds(282, 0, 600, 500);
		setBackground(new Color(42, 88, 173));

		placa = new JTextField();
		placa.setBorder(new LineBorder(new Color(0, 0, 0)));
		placa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		placa.setBounds(108, 79, 150, 25);
		placa.setColumns(10);
		add(placa);

		JLabel lblPlaca = new JLabel("*Placa:");
		lblPlaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPlaca.setBounds(23, 80, 62, 20);
		add(lblPlaca);

		propietario = new JTextField();
		propietario.setBorder(new LineBorder(new Color(0, 0, 0)));
		propietario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		propietario.setBounds(149, 174, 301, 25);
		propietario.setColumns(10);
		add(propietario);

		JLabel lblNombrePropietario = new JLabel("Nombre Propietario:");
		lblNombrePropietario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePropietario.setForeground(Color.WHITE);
		lblNombrePropietario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombrePropietario.setBounds(212, 127, 173, 20);
		add(lblNombrePropietario);

		JLabel lblTipoVehiculo = new JLabel("*Tipo Vehiculo:");
		lblTipoVehiculo.setForeground(Color.WHITE);
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(281, 80, 122, 20);
		add(lblTipoVehiculo);

		JComboBox<Object> tipo_vehiculo = new JComboBox<Object>();
		tipo_vehiculo.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "AUTOMOVIL", "MOTOCICLETA" }));
		tipo_vehiculo.setSelectedIndex(0);
		tipo_vehiculo.setBounds(426, 81, 150, 25);
		add(tipo_vehiculo);

		JLabel label_titulo = new JLabel("Ingresando el Vehiculo al Sistema");
		label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		label_titulo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_titulo.setForeground(Color.WHITE);
		label_titulo.setBounds(113, 27, 370, 26);
		add(label_titulo);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(506, 473, 84, 21);
		add(label_version);

		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentario.setForeground(Color.WHITE);
		lblComentario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblComentario.setBounds(246, 226, 107, 20);
		add(lblComentario);

		JTextArea comentario = new JTextArea();
		comentario.setBorder(new LineBorder(new Color(0, 0, 0)));
		comentario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comentario.setBounds(149, 273, 301, 85);
		add(comentario);

		btn_registrar = new JButton("REGISTRAR");
		btn_registrar.setFocusPainted(false);
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Leemos los campos
				String field1 = placa.getText();
				String field2 = propietario.getText();
				String field3 = tipo_vehiculo.getSelectedItem().toString();
				String field4 = comentario.getText();
				if (!field1.isEmpty() && !field3.isEmpty()) {
					// Hacemos nuestra coneccion de BD
					AppConection conn = new AppConection();
					if (conn.insertar(field1, field2, field3, field4)) {
						placa.setText("");
						propietario.setText("");
						comentario.setText("");
						tipo_vehiculo.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "El vehiculo fue ingresado al Sistema.");
					} else {
						JOptionPane.showMessageDialog(null, "Hubo problemas al ingresar el registro");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Los campos con * son requeridos");
				}

			}
		});
		btn_registrar.setBounds(246, 385, 122, 39);
		btn_registrar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btn_registrar.setBorder(new LineBorder(Color.WHITE));
		btn_registrar.setBackground(new Color(42, 88, 173));
		btn_registrar.setForeground(Color.WHITE);
		add(btn_registrar);
		setLayout(null);

		JLabel lblNewLabel_2_1_1 = new JLabel("*Todos los campos son requeridos.");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(212, 451, 185, 14);
		add(lblNewLabel_2_1_1);
	}
}

public class App extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private IngresarVehiculo ingresarVehiculo = new IngresarVehiculo();
	private RetirarVehiculo retirarVehiculo = new RetirarVehiculo();
	private ListarVehiculos listarVehiculos = new ListarVehiculos();

	/**
	 * Create the frame.
	 */
	public App() {
		setTitle("Control de Estacionamientos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 536);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBackground(new Color(234, 238, 241));
		panel.setBounds(0, 0, 287, 500);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTitle = new JLabel("Parking v1.0");
		lblTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Century Gothic", Font.PLAIN, 35));
		lblTitle.setForeground(new Color(42, 88, 173));
		lblTitle.setBounds(10, 11, 277, 44);
		panel.add(lblTitle);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(App.class.getResource("/assets/parking-logo.png")));
		lblNewLabel_1.setBounds(74, 193, 128, 128);
		panel.add(lblNewLabel_1);

		JButton btnIngresar = new JButton("Ingresar Vehiculo");
		btnIngresar.setFocusPainted(false);
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVehiculos.setVisible(false);
				retirarVehiculo.setVisible(false);
				setBounds(100, 100, 896, 536);
				ingresarVehiculo.setVisible(true);
				getContentPane().add(ingresarVehiculo);
			}
		});

		btnIngresar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnIngresar.setMargin(new Insets(2, 2, 2, 2));
		btnIngresar.setForeground(new Color(42, 88, 173));
		btnIngresar.setBounds(19, 341, 115, 60);
		panel.add(btnIngresar);

		// ***************************************************

		JButton btnRetirar = new JButton("Retirar Vehiculo");
		btnRetirar.setFocusPainted(false);
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVehiculos.setVisible(false);
				ingresarVehiculo.setVisible(false);
				setBounds(100, 100, 896, 536);
				retirarVehiculo.setVisible(true);
				getContentPane().add(retirarVehiculo);
			}
		});
		btnRetirar.setAlignmentY(Component.TOP_ALIGNMENT);
		btnRetirar.setMargin(new Insets(2, 2, 2, 2));
		btnRetirar.setForeground(new Color(42, 88, 173));
		btnRetirar.setBounds(153, 341, 115, 60);
		panel.add(btnRetirar);

		// ****************************************************

		JButton btnListar = new JButton("Listar Vehiculos");
		btnListar.setFocusPainted(false);
		btnListar.setBorder(UIManager.getBorder("CheckBox.border"));
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retirarVehiculo.setVisible(false);
				ingresarVehiculo.setVisible(false);
				setBounds(100, 100, 1096, 536);
				listarVehiculos.setVisible(true);
				getContentPane().add(listarVehiculos);

			}
		});
		btnListar.setMargin(new Insets(2, 2, 2, 2));
		btnListar.setForeground(new Color(42, 88, 173));
		btnListar.setBounds(19, 407, 115, 60);
		panel.add(btnListar);

		// ****************************************************

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFocusPainted(false);
		btnSalir.setMargin(new Insets(2, 2, 2, 2));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnSalir.setForeground(new Color(42, 88, 173));
		btnSalir.setBounds(153, 407, 115, 60);
		panel.add(btnSalir);

		JLabel lblCopyright = new JLabel("Todos los derechos reservados 2021");
		lblCopyright.setForeground(new Color(42, 88, 173));
		lblCopyright.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblCopyright.setBounds(52, 475, 185, 14);
		panel.add(lblCopyright);

		JLabel lblDeveloper2 = new JLabel("Javier Moran");
		lblDeveloper2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDeveloper2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeveloper2.setForeground(new Color(42, 88, 173));
		lblDeveloper2.setFont(new Font("Century Gothic", Font.BOLD, 10));
		lblDeveloper2.setBounds(153, 92, 96, 14);
		panel.add(lblDeveloper2);

		JLabel lblDeveloper1 = new JLabel("Urania Rivas");
		lblDeveloper1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeveloper1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDeveloper1.setForeground(new Color(42, 88, 173));
		lblDeveloper1.setFont(new Font("Century Gothic", Font.BOLD, 10));
		lblDeveloper1.setBounds(33, 92, 85, 14);
		panel.add(lblDeveloper1);

		JLabel lblDeveloper3 = new JLabel("Ivan Medina");
		lblDeveloper3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDeveloper3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeveloper3.setForeground(new Color(42, 88, 173));
		lblDeveloper3.setFont(new Font("Century Gothic", Font.BOLD, 10));
		lblDeveloper3.setBounds(38, 117, 70, 14);
		panel.add(lblDeveloper3);

		JLabel lblDeveloper4 = new JLabel("Gustavo Gomez");
		lblDeveloper4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDeveloper4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeveloper4.setForeground(new Color(42, 88, 173));
		lblDeveloper4.setFont(new Font("Century Gothic", Font.BOLD, 10));
		lblDeveloper4.setBounds(148, 117, 96, 14);
		panel.add(lblDeveloper4);

		JLabel lblTitle2 = new JLabel("DEVELOPERS");
		lblTitle2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTitle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle2.setForeground(new Color(42, 88, 173));
		lblTitle2.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblTitle2.setBounds(84, 66, 119, 14);
		panel.add(lblTitle2);
	}
}

public class Parking {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
