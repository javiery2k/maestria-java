import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Login extends JFrame {
	/**
	 * github
	 */
	private static final long serialVersionUID = 1L;
	Color color1 = new Color(234, 238, 241);
	Color color2 = new Color(42, 88, 173);
	Color color3 = new Color(34, 171, 233);
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
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
		/**
		 * Jpanel Principal
		 */
		JPanel contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/**
		 * Jpanel Izq
		 */
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(color1);
		panel.setBounds(0, 0, 325, 313);
		contentPane.add(panel);
		panel.setLayout(null);

		/**
		 * Jpanel Derecha
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(color2);
		panel_1.setBounds(324, 0, 312, 313);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		/**
		 * Etiquetas
		 */
		JLabel lblNewLabel_2 = new JLabel("Parking 1.0");
		lblNewLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(color2);
		lblNewLabel_2.setBounds(120, 259, 84, 21);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("SISTEMA DE ESTACIONAMIENTOS");
		lblNewLabel_2_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel_2_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1.setBounds(43, 234, 252, 21);
		panel.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/assets/parking-icon-150.png")));
		lblNewLabel_3.setBounds(84, 59, 150, 151);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("Todos los derechos reservados 2021");
		lblNewLabel_2_1_1.setForeground(new Color(42, 88, 173));
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(81, 288, 173, 14);
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
		textField.setBackground(color2);
		textField.setForeground(Color.WHITE);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		textField.setCaretColor(Color.WHITE);
		textField.setBounds(73, 106, 190, 20);
		panel_1.add(textField);

		/**
		 * Campo de Password
		 */
		passwordField = new JPasswordField();
		passwordField.setBackground(color2);
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
				String pass = passwordField.getText();

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
		btnNewButton.setBackground(color2);
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
		btnSalir.setBackground(color2);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBounds(175, 226, 89, 23);
		panel_1.add(btnSalir);

	}
}
