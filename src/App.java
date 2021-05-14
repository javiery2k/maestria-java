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
		setBounds(100, 100, 297, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(color2);
		panel.setForeground(color3);
		panel.setBounds(0, 0, 281, 513);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label_titulo = new JLabel("Parking v1.0");
		label_titulo.setForeground(Color.WHITE);
		label_titulo.setFont(new Font("Century Gothic", Font.BOLD, 27));
		label_titulo.setBounds(60, 50, 160, 34);
		panel.add(label_titulo);
		
		JLabel icon_logo = new JLabel("");
		icon_logo.setIcon(new ImageIcon(App.class.getResource("/assets/parking-logo.png")));
		icon_logo.setBounds(76, 147, 128, 128);
		panel.add(icon_logo);
		
		JButton btn_ingresar = new JButton("INGREGAR");
		btn_ingresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Codigo Para Abrir el Panel de Ingresar el Vehiulo
				
			}
		});
		btn_ingresar.setForeground(SystemColor.textHighlight);
		btn_ingresar.setBounds(27, 369, 115, 60);
		panel.add(btn_ingresar);
		
		JButton btn_retirar = new JButton("RETIRAR");
		btn_retirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				//Codigo Para Abrir el Panel de Retirar el Vehiculo
			}
		});
		btn_retirar.setForeground(SystemColor.textHighlight);
		btn_retirar.setBounds(148, 369, 115, 60);
		panel.add(btn_retirar);
		
		JButton btn_salir = new JButton("SALIR");
		btn_salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btn_salir.setForeground(SystemColor.textHighlight);
		btn_salir.setBounds(148, 435, 115, 60);
		panel.add(btn_salir);
		
		JButton btn_listar = new JButton("LISTAR");
		btn_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Codigo Para Abrir el Panel de Listar los vehiculos
			}
		});
		btn_listar.setForeground(SystemColor.textHighlight);
		btn_listar.setBounds(27, 435, 115, 60);
		panel.add(btn_listar);
		
		JLabel label_opciones = new JLabel("OPCIONES");
		label_opciones.setForeground(Color.WHITE);
		label_opciones.setFont(new Font("Century Gothic", Font.BOLD, 18));
		label_opciones.setBounds(94, 335, 92, 23);
		panel.add(label_opciones);

		JPanel panel_secundario1 = new JPanel();
		panel_secundario1.setVisible(false);
		panel_secundario1.setBounds(286, 0, 1, 513);
		contentPane.add(panel_secundario1);
		panel_secundario1.setLayout(null);
		
		JPanel panel_secundario2 = new JPanel();
		panel_secundario2.setLayout(null);
		panel_secundario2.setVisible(false);
		panel_secundario2.setBounds(0, 0, 700, 513);
		contentPane.add(panel_secundario2);
		
		JPanel panel_secundario3 = new JPanel();
		panel_secundario3.setLayout(null);
		panel_secundario3.setVisible(false);
		panel_secundario3.setBounds(0, 0, 700, 513);
		contentPane.add(panel_secundario3);
	}
}
