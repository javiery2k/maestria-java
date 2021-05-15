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
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.UIManager;

public class App extends JFrame {
	Color color1 = new Color(234, 238, 241);
	Color color2 = new Color(42, 88, 173);
	Color color3 = new Color(34, 171, 233);
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
		setBounds(500, 100, 285, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(color2);
		panel.setForeground(color3);
		panel.setBounds(0, 0, 276, 513);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Parking v1.0");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 27));
		lblNewLabel.setBounds(65, 87, 160, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(App.class.getResource("/assets/parking-logo.png")));
		lblNewLabel_1.setBounds(80, 174, 128, 128);
		panel.add(lblNewLabel_1);
		
		
		
		
		JButton btnNewButton = new JButton("Ingresar Vehiculo");
		btnNewButton.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVehiculos.setVisible(false);
				retirarVehiculo.setVisible(false);
				setBounds(100, 100, 1000, 550);
				ingresarVehiculo.setVisible(true);
				getContentPane().add(ingresarVehiculo);				
			}
		});
		
		btnNewButton.setForeground(SystemColor.textHighlight);
		btnNewButton.setBounds(15, 369, 115, 60);
		panel.add(btnNewButton);
		
		//***************************************************
		
		JButton btnNewButton_1 = new JButton("Retirar Vehiculo");
		btnNewButton_1.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarVehiculos.setVisible(false);
				ingresarVehiculo.setVisible(false);
				setBounds(100, 100, 1000, 550);
				retirarVehiculo.setVisible(true);
				getContentPane().add(retirarVehiculo);
			}
		});
		btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_1.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setBounds(142, 369, 115, 60);
		panel.add(btnNewButton_1);
		
		//****************************************************
		
		JButton btnNewButton_3 = new JButton("Listar Vehiculos");
		btnNewButton_3.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retirarVehiculo.setVisible(false);
				ingresarVehiculo.setVisible(false);
				setBounds(100, 100, 1000, 550);
				listarVehiculos.setVisible(true);
				getContentPane().add(listarVehiculos);	
				
			}
		});	
		btnNewButton_3.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_3.setForeground(SystemColor.textHighlight);
		btnNewButton_3.setBounds(15, 435, 115, 60);
		panel.add(btnNewButton_3);
		
		//****************************************************
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.setBorder(UIManager.getBorder("CheckBox.border"));
		btnNewButton_2.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnNewButton_2.setForeground(SystemColor.textHighlight);
		btnNewButton_2.setBounds(142, 435, 115, 60);
		panel.add(btnNewButton_2);
		

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
