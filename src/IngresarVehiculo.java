import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngresarVehiculo frame = new IngresarVehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the panel.
	 */
	public IngresarVehiculo() {

		placa = new JTextField();
		placa.setBounds(128, 134, 347, 20);
		placa.setColumns(10);
		add(placa);

		JLabel label_placa = new JLabel("Placa");
		label_placa.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_placa.setBounds(52, 135, 33, 17);
		add(label_placa);

		propietario = new JTextField();
		propietario.setBounds(196, 183, 280, 20);
		propietario.setColumns(10);
		add(propietario);

		JLabel label_propietario = new JLabel("Nombre Propietario");
		label_propietario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_propietario.setBounds(52, 184, 113, 16);
		add(label_propietario);

		JLabel label_tipo = new JLabel("Tipo Vehiculo");
		label_tipo.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_tipo.setBounds(52, 231, 79, 16);
		add(label_tipo);

		JComboBox<Object> tipo_vehiculo = new JComboBox<Object>();
		tipo_vehiculo.setModel(new DefaultComboBoxModel<Object>(new String[] { "SEDAN", "SUV", "MOTOCICLETA" }));
		tipo_vehiculo.setSelectedIndex(1);
		tipo_vehiculo.setBounds(184, 229, 291, 22);
		add(tipo_vehiculo);

		JLabel label_titulo = new JLabel("Ingresando el Vehiculo al Sistema");
		label_titulo.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_titulo.setForeground(new Color(42, 88, 173));
		label_titulo.setBounds(128, 55, 269, 21);
		add(label_titulo);

		JLabel label_version = new JLabel("Parking 1.0");
		label_version.setForeground(new Color(42, 88, 173));
		label_version.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		label_version.setBounds(392, 449, 84, 21);
		add(label_version);

		JLabel label_comentario = new JLabel("Comentario");
		label_comentario.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		label_comentario.setBounds(52, 288, 79, 16);
		add(label_comentario);

		JTextArea comentario = new JTextArea();
		comentario.setBounds(174, 285, 301, 85);
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

				 if ( conn.insertar(field1, field2, field3, field4, "INGRESO") ) {
					 JOptionPane.showMessageDialog(null, "Registro Ingresado");
				 }else {
					 JOptionPane.showMessageDialog(null, "Hubo problemas al ingresar el registro");
				 }
				 
			}
		});
		btn_registrar.setBounds(210, 402, 122, 39);
		btn_registrar.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btn_registrar.setForeground(Color.WHITE);
		btn_registrar.setBorder(new LineBorder(Color.WHITE));
		btn_registrar.setBackground(new Color(42, 88, 173));
		add(btn_registrar);
		setLayout(null);
	}
}
