import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePickerImpl;
import java.awt.Rectangle;

public class JDatePro extends JPanel {
	private JDatePickerImpl datePicker;
	private String dateText;
	

	/**
	 * Create the panel.
	 */
	public JDatePro() {
		this.setBounds(440, 115, 250, 40);
		UtilDateModel model = new UtilDateModel();
		model.setDate(2021, 04, 01);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.day", "Hoy");
		p.put("text.month", "Mes");
		p.put("text.year", "Año");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.add(datePicker);
		dateText=datePicker.getJFormattedTextField().getText();
	}

	protected String getDate() {
		return dateText;
	}
	
	public static void main(String []args) {
		JDatePro jdp = new JDatePro();
		jdp.setVisible(true);
	}
}
