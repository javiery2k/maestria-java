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
		setBounds(282, 0, 695, 505);

		placa = new JTextField();
		placa.setBounds(198, 134, 347, 20);
		placa.setColumns(10);
		add(placa);

		JLabel label_placa = new JLabel("Placa*");
		label_placa.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_placa.setBounds(122, 135, 38, 16);
		add(label_placa);

		propietario = new JTextField();
		propietario.setBounds(266, 183, 280, 20);
		propietario.setColumns(10);
		add(propietario);

		JLabel lblNombrePropietario = new JLabel("Nombre Propietario*");
		lblNombrePropietario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblNombrePropietario.setBounds(122, 184, 118, 16);
		add(lblNombrePropietario);

		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo*");
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTipoVehiculo.setBounds(122, 231, 84, 16);
		add(lblTipoVehiculo);

		JComboBox<Object> tipo_vehiculo = new JComboBox<Object>();
		tipo_vehiculo.setModel(new DefaultComboBoxModel<Object>(new String[] { "SEDAN", "SUV", "MOTOCICLETA" }));
		tipo_vehiculo.setSelectedIndex(0);
		tipo_vehiculo.setBounds(254, 229, 291, 22);
		add(tipo_vehiculo);

		JLabel label_titulo = new JLabel("Ingresando el Vehiculo al Sistema");
		label_titulo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_titulo.setForeground(new Color(42, 88, 173));
		label_titulo.setBounds(174, 48, 329, 26);
		add(label_titulo);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(584, 461, 84, 21);
		add(label_version);

		JLabel label_comentario = new JLabel("Comentario");
		label_comentario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_comentario.setBounds(122, 288, 79, 16);
		add(label_comentario);

		JTextArea comentario = new JTextArea();
		comentario.setBounds(244, 285, 301, 85);
		add(comentario);

		btn_registrar = new JButton("REGISTRAR");
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Hacemos nuestra coneccion de BD
				AppConection conn = new AppConection();
				// Leemos los campos
				String field1 = placa.getText();
				String field2 = propietario.getText();
				String field3 = tipo_vehiculo.getSelectedItem().toString();
				String field4 = comentario.getText();
				if (!field1.isEmpty() && !field2.isEmpty()) {
					if (conn.insertar(field1, field2, field3, field4)) {
						placa.setText("");
						propietario.setText("");
						comentario.setText("");
						tipo_vehiculo.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "Registro Ingresado");
					} else {
						JOptionPane.showMessageDialog(null, "Hubo problemas al ingresar el registro");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor llene los campos requeridos");
				}

			}
		});
		btn_registrar.setBounds(280, 402, 122, 39);
		btn_registrar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btn_registrar.setForeground(Color.WHITE);
		btn_registrar.setBorder(new LineBorder(Color.WHITE));
		btn_registrar.setBackground(new Color(42, 88, 173));
		add(btn_registrar);
		setLayout(null);
	}
}
