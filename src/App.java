import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

public class App extends JFrame {
	Color color1 = new Color(234, 238, 241);
	Color color2 = new Color(42, 88, 173);
	Color color3 = new Color(34, 171, 233);
	private JPanel contentPane;

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
		setBounds(100, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(color2);
		panel.setForeground(color3);
		panel.setBounds(0, 0, 289, 513);
		contentPane.add(panel);
		panel.setLayout(null);

		Button button = new Button("Ingresar Vehiculo");
		button.setBackground(Color.WHITE);
		button.setBounds(27, 369, 115, 60);
		panel.add(button);

		Button button_1 = new Button("Retirar Vehiculo");
		button_1.setBounds(148, 369, 115, 60);
		panel.add(button_1);

		Button button_1_1 = new Button("Listar Vehiculos");
		button_1_1.setBounds(27, 435, 115, 60);
		panel.add(button_1_1);

		Button button_1_1_1 = new Button("Salir");
		button_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_1_1_1.setBounds(148, 435, 115, 60);
		panel.add(button_1_1_1);

		JLabel lblNewLabel = new JLabel("Parking v1.0");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 27));
		lblNewLabel.setBounds(65, 87, 160, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(App.class.getResource("/assets/parking-logo.png")));
		lblNewLabel_1.setBounds(80, 174, 128, 128);
		panel.add(lblNewLabel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBounds(286, 0, 1, 513);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setVisible(false);
		panel_2_1.setBounds(0, 0, 700, 513);
		contentPane.add(panel_2_1);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setVisible(false);
		panel_2_2.setBounds(0, 0, 700, 513);
		contentPane.add(panel_2_2);
	}
}
