package com.pe.solicitud.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateFormat {

	public Date dateActual() {
		Date creation = null;
		try {
			Date date = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			String datestring = dateformat.format(date);
			creation = dateformat.parse(datestring);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return creation;
	}

}
