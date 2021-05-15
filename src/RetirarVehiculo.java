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

		placa = new JTextField();
		placa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		placa.setBounds(267, 219, 177, 40);
		placa.setColumns(10);
		add(placa);
		
		setBounds(282, 0, 695, 505);

		JLabel label_placa = new JLabel("Placa");
		label_placa.setForeground(SystemColor.textHighlight);
		label_placa.setHorizontalAlignment(SwingConstants.CENTER);
		label_placa.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_placa.setBounds(175, 222, 65, 32);
		add(label_placa);

		JLabel lblModuloDeSalida = new JLabel("Modulo de Salida del Vehiculo");
		lblModuloDeSalida.setHorizontalAlignment(SwingConstants.CENTER);
		lblModuloDeSalida.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblModuloDeSalida.setForeground(SystemColor.textHighlight);
		lblModuloDeSalida.setBounds(10, 148, 675, 28);
		add(lblModuloDeSalida);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(564, 457, 84, 21);
		add(label_version);

		JButton btn_retirar = new JButton("RETIRAR");
		btn_retirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Hacemos nuestra coneccion de BD
				AppConection conn = new AppConection();
				// Leemos los campos
				String field1 = placa.getText();
				if (!field1.isEmpty()) {
					Double total = conn.retirarVehiculo(field1);
					System.out.println(total);
					if (total > 0.0) {
						JOptionPane.showMessageDialog(null, "Registro Ingresado");
					} else {
						JOptionPane.showMessageDialog(null, "La placa no fue encontrada");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor llene los campos requeridos");
				}
				

				//conn.insertar(field1, field2, field3, field4, "INGRESO");
			}
		});
		btn_retirar.setBounds(286, 301, 122, 39);
		btn_retirar.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btn_retirar.setForeground(Color.WHITE);
		btn_retirar.setBorder(new LineBorder(Color.WHITE));
		btn_retirar.setBackground(new Color(42, 88, 173));
		add(btn_retirar);
		setLayout(null);
	}
}
