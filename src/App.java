import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
				setBounds(100, 100, 896, 536);
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
