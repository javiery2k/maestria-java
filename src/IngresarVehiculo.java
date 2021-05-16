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
import javax.swing.SwingConstants;

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
		setBounds(282, 0, 600, 500);
		setBackground(new Color(42, 88, 173));

		placa = new JTextField();
		placa.setBorder(new LineBorder(new Color(0, 0, 0)));
		placa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		placa.setBounds(108, 79, 150, 25);
		placa.setColumns(10);
		add(placa);

		JLabel lblPlaca = new JLabel("*Placa:");
		lblPlaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPlaca.setBounds(23, 80, 62, 20);
		add(lblPlaca);

		propietario = new JTextField();
		propietario.setBorder(new LineBorder(new Color(0, 0, 0)));
		propietario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		propietario.setBounds(149, 174, 301, 25);
		propietario.setColumns(10);
		add(propietario);

		JLabel lblNombrePropietario = new JLabel("Nombre Propietario:");
		lblNombrePropietario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePropietario.setForeground(Color.WHITE);
		lblNombrePropietario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombrePropietario.setBounds(212, 127, 173, 20);
		add(lblNombrePropietario);

		JLabel lblTipoVehiculo = new JLabel("*Tipo Vehiculo:");
		lblTipoVehiculo.setForeground(Color.WHITE);
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(281, 80, 122, 20);
		add(lblTipoVehiculo);

		JComboBox<Object> tipo_vehiculo = new JComboBox<Object>();
		tipo_vehiculo.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "AUTOMOVIL", "MOTOCICLETA" }));
		tipo_vehiculo.setSelectedIndex(0);
		tipo_vehiculo.setBounds(426, 81, 150, 25);
		add(tipo_vehiculo);

		JLabel label_titulo = new JLabel("Ingresando el Vehiculo al Sistema");
		label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		label_titulo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_titulo.setForeground(Color.WHITE);
		label_titulo.setBounds(113, 27, 370, 26);
		add(label_titulo);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(506, 473, 84, 21);
		add(label_version);

		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentario.setForeground(Color.WHITE);
		lblComentario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblComentario.setBounds(246, 226, 107, 20);
		add(lblComentario);

		JTextArea comentario = new JTextArea();
		comentario.setBorder(new LineBorder(new Color(0, 0, 0)));
		comentario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comentario.setBounds(149, 273, 301, 85);
		add(comentario);

		btn_registrar = new JButton("REGISTRAR");
		btn_registrar.setFocusPainted(false);
		btn_registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Leemos los campos
				String field1 = placa.getText();
				String field2 = propietario.getText();
				String field3 = tipo_vehiculo.getSelectedItem().toString();
				String field4 = comentario.getText();
				if (!field1.isEmpty() && !field3.isEmpty()) {
					// Hacemos nuestra coneccion de BD
					AppConection conn = new AppConection();
					if (conn.insertar(field1, field2, field3, field4)) {
						placa.setText("");
						propietario.setText("");
						comentario.setText("");
						tipo_vehiculo.setSelectedIndex(0);
						JOptionPane.showMessageDialog(null, "El vehiculo fue ingresado al Sistema.");
					} else {
						JOptionPane.showMessageDialog(null, "Hubo problemas al ingresar el registro");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Los campos con * son requeridos");
				}

			}
		});
		btn_registrar.setBounds(246, 385, 122, 39);
		btn_registrar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btn_registrar.setBorder(new LineBorder(Color.WHITE));
		btn_registrar.setBackground(new Color(42, 88, 173));
		btn_registrar.setForeground(Color.WHITE);
		add(btn_registrar);
		setLayout(null);

		JLabel lblNewLabel_2_1_1 = new JLabel("*Todos los campos son requeridos.");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblNewLabel_2_1_1.setBounds(212, 451, 185, 14);
		add(lblNewLabel_2_1_1);
	}
}
