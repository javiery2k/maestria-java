import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

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
		placa.setBounds(205, 236, 177, 20);
		placa.setColumns(10);
		add(placa);
		
		setBounds(282, 0, 695, 505);

		JLabel label_placa = new JLabel("Placa");
		label_placa.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_placa.setBounds(162, 237, 33, 17);
		add(label_placa);

		JLabel lblModuloDeSalida = new JLabel("Modulo de Salida del Vehiculo");
		lblModuloDeSalida.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblModuloDeSalida.setForeground(new Color(42, 88, 173));
		lblModuloDeSalida.setBounds(101, 157, 328, 28);
		add(lblModuloDeSalida);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(392, 449, 84, 21);
		add(label_version);

		JButton btn_retirar = new JButton("RETIRAR");
		btn_retirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Hacemos nuestra coneccion de BD
				AppConection conn = new AppConection();
				// Leemos los campos
				String field1 = placa.getText();
				

				//conn.insertar(field1, field2, field3, field4, "INGRESO");
			}
		});
		btn_retirar.setBounds(216, 285, 122, 39);
		btn_retirar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btn_retirar.setForeground(Color.WHITE);
		btn_retirar.setBorder(new LineBorder(Color.WHITE));
		btn_retirar.setBackground(new Color(42, 88, 173));
		add(btn_retirar);
		setLayout(null);
	}
}
