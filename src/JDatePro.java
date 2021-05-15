import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;
import org.jdatepicker.impl.JDatePickerImpl;

public class JDatePro extends JPanel {
	private JDatePickerImpl datePicker;

	/**
	 * Create the panel.
	 */
	public JDatePro() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		UtilDateModel model = new UtilDateModel();
		model.setDate(2021, 05, 01);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.day", "Hoy");
		p.put("text.month", "Mes");
		p.put("text.year", "Año");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);		
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.add(datePicker);
		System.out.println(datePicker.getJFormattedTextField().getText());
	}

}
