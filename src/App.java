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

		JLabel lblNewLabel = new JLabel("Parking v1.0");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(42, 88, 173));
		lblNewLabel.setBounds(10, 11, 277, 44);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(App.class.getResource("/assets/parking-logo.png")));
		lblNewLabel_1.setBounds(74, 193, 128, 128);
		panel.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Ingresar Vehiculo");
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVehiculos.setVisible(false);
				retirarVehiculo.setVisible(false);
				setBounds(100, 100, 896, 536);
				ingresarVehiculo.setVisible(true);
				getContentPane().add(ingresarVehiculo);
			}
		});

		btnNewButton.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.setForeground(new Color(42, 88, 173));
		btnNewButton.setBounds(19, 341, 115, 60);
		panel.add(btnNewButton);

		// ***************************************************

		JButton btnNewButton_1 = new JButton("Retirar Vehiculo");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVehiculos.setVisible(false);
				ingresarVehiculo.setVisible(false);
				setBounds(100, 100, 896, 536);
				retirarVehiculo.setVisible(true);
				getContentPane().add(retirarVehiculo);
			}
		});
		btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_1.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_1.setForeground(new Color(42, 88, 173));
		btnNewButton_1.setBounds(153, 341, 115, 60);
		panel.add(btnNewButton_1);

		// ****************************************************

		JButton btnNewButton_3 = new JButton("Listar Vehiculos");
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retirarVehiculo.setVisible(false);
				ingresarVehiculo.setVisible(false);
				setBounds(100, 100, 896, 536);
				listarVehiculos.setVisible(true);
				getContentPane().add(listarVehiculos);
				listarVehiculos.ActualizarTabla();
			}
		});
		btnNewButton_3.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_3.setForeground(new Color(42, 88, 173));
		btnNewButton_3.setBounds(19, 407, 115, 60);
		panel.add(btnNewButton_3);

		// ****************************************************

		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnNewButton_2.setForeground(new Color(42, 88, 173));
		btnNewButton_2.setBounds(153, 407, 115, 60);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Todos los derechos reservados 2021");
		lblNewLabel_2_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(52, 475, 185, 14);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Javier Moran");
		lblNewLabel_2_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1_1.setBounds(153, 92, 96, 14);
		panel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Urania Rivas");
		lblNewLabel_2_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1_1_1.setBounds(33, 92, 85, 14);
		panel.add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Ivan Medina");
		lblNewLabel_2_1_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1_1_1_1.setBounds(38, 117, 70, 14);
		panel.add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Gustavo Gomez");
		lblNewLabel_2_1_1_1_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_1_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(148, 117, 96, 14);
		panel.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_2 = new JLabel("DEVELOPERS");
		lblNewLabel_2_1_1_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1_1_2.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1_1_2.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1_2.setBounds(84, 66, 119, 14);
		panel.add(lblNewLabel_2_1_1_1_2);
	}
}
