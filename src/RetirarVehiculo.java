import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

public class RetirarVehiculo extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField placa;

	/**
	 * Create the panel.
	 */
	public RetirarVehiculo() {
		setBackground(new Color(42, 88, 173));

		placa = new JTextField();
		placa.setBorder(new LineBorder(new Color(0, 0, 0)));
		placa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		placa.setBounds(207, 243, 177, 25);
		placa.setColumns(10);
		add(placa);

		setBounds(282, 0, 600, 505);

		JLabel lblplaca = new JLabel("*Placa");
		lblplaca.setForeground(Color.WHITE);
		lblplaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblplaca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblplaca.setBounds(261, 150, 65, 32);
		add(lblplaca);

		JLabel lblModuloDeSalida = new JLabel("Modulo de Salida del Vehiculo");
		lblModuloDeSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblModuloDeSalida.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblModuloDeSalida.setForeground(Color.WHITE);
		lblModuloDeSalida.setBounds(86, 61, 428, 28);
		add(lblModuloDeSalida);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(564, 457, 84, 21);
		add(label_version);

		JButton btn_retirar = new JButton("RETIRAR");
		btn_retirar.setFocusPainted(false);
		btn_retirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Leemos los campos
				String field1 = placa.getText();
				if (!field1.isEmpty()) {
					// Hacemos nuestra coneccion de BD
					AppConection conn = new AppConection();

					if (!conn.retirarVehiculo(field1)) {
						JOptionPane.showMessageDialog(null, "La placa " + field1 + " no fue encontrada");
					}
					placa.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "Por favor llene los campos requeridos");
				}

				// conn.insertar(field1, field2, field3, field4, "INGRESO");
			}
		});

		btn_retirar.setBounds(241, 329, 122, 39);
		btn_retirar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btn_retirar.setBorder(new LineBorder(Color.WHITE));
		btn_retirar.setBackground(new Color(42, 88, 173));
		btn_retirar.setForeground(Color.WHITE);

		add(btn_retirar);
		setLayout(null);

		JLabel lblNewLabel_2_1_1 = new JLabel("*Todos los campos son requeridos.");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(207, 429, 185, 14);
		add(lblNewLabel_2_1_1);
	}
}
