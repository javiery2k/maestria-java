import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.Properties;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.text.SimpleDateFormat;


public class JDateDemo extends JFrame {
	private JDatePickerImpl datePicker;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JDateDemo frame = new JDateDemo();
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
	public JDateDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 150, 75);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBounds(100, 100, 150, 75);
		setContentPane(contentPane);
		
		//****************************************************
		UtilDateModel model = new UtilDateModel();
		model.setDate(2021, 05, 01);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.day", "Hoy");
		p.put("text.month", "Mes");
		p.put("text.year", "Año");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);		
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		contentPane.add(datePicker);
		System.out.println(datePicker.getJFormattedTextField().getText());
		//*****************************************************
	}

}
