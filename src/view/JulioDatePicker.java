package view;

import java.util.Properties;


import org.jdatepicker.impl.*;


public class JulioDatePicker {

	public static JDatePickerImpl criar(int ano, boolean x) {
		
		Properties p = new Properties();
		p.put("text.today", "Hoje");
		p.put("text.month", "Mês");
		p.put("text.year", "Ano");
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(ano, 0, 1);
		model.setSelected(x);
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		return datePicker;
		
	}
	

}
