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
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

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
		placa.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		placa.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		placa.setBounds(175, 100, 150, 40);
		placa.setColumns(10);
		add(placa);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaca.setForeground(SystemColor.textHighlight);
		lblPlaca.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblPlaca.setBounds(105, 108, 62, 20);
		add(lblPlaca);

		propietario = new JTextField();
		propietario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		propietario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		propietario.setBounds(223, 191, 301, 40);
		propietario.setColumns(10);
		add(propietario);

		JLabel lblNombrePropietario = new JLabel("Nombre Propietario:");
		lblNombrePropietario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombrePropietario.setForeground(SystemColor.textHighlight);
		lblNombrePropietario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNombrePropietario.setBounds(267, 160, 173, 20);
		add(lblNombrePropietario);

		JLabel lblTipoVehiculo = new JLabel("Tipo Vehiculo:");
		lblTipoVehiculo.setForeground(SystemColor.textHighlight);
		lblTipoVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoVehiculo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblTipoVehiculo.setBounds(359, 106, 122, 20);
		add(lblTipoVehiculo);

		JComboBox<Object> tipo_vehiculo = new JComboBox<Object>();

		tipo_vehiculo.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));


		tipo_vehiculo.setModel(new DefaultComboBoxModel<Object>(new String[] { "","AUTOMOVIL", "MOTOCICLETA" }));

		tipo_vehiculo.setSelectedIndex(0);
		tipo_vehiculo.setBounds(484, 106, 100, 22);
		add(tipo_vehiculo);

		JLabel label_titulo = new JLabel("Ingresando el Vehiculo al Sistema");
		label_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		label_titulo.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		label_titulo.setForeground(SystemColor.textHighlight);
		label_titulo.setBounds(172, 31, 370, 26);
		add(label_titulo);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(584, 461, 84, 21);
		add(label_version);

		JLabel lblComentario = new JLabel("Comentario:");
		lblComentario.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentario.setForeground(SystemColor.textHighlight);
		lblComentario.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblComentario.setBounds(321, 247, 107, 20);
		add(lblComentario);

		JTextArea comentario = new JTextArea();
		comentario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		comentario.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comentario.setBounds(223, 276, 301, 85);
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
		btn_registrar.setBounds(306, 403, 122, 39);
		btn_registrar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btn_registrar.setForeground(SystemColor.textHighlight);
		btn_registrar.setBorder(UIManager.getBorder("CheckBox.border"));
		btn_registrar.setBackground(UIManager.getColor("Button.background"));
		add(btn_registrar);
		setLayout(null);
	}
}
