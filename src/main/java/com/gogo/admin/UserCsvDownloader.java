package com.gogo.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.gogo.admin.domain.User;

public class UserCsvDownloader {
   
	public void export(List<User> listUsers, HttpServletResponse httpResponse) throws IOException {
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String timestamp = dateFormatter.format(new Date());
		String fileName = "Gogo-users_" + timestamp + ".csv";
		
		httpResponse.setContentType("text/csv");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=" + fileName;
		httpResponse.setHeader(headerKey, headerValue);
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(httpResponse.getWriter(),
				                                                CsvPreference.STANDARD_PREFERENCE);
		
		String[] csvHeader = {"# ID","Email","First Name","Last Name","Roles","Enabled"};
		String[] mappedFields = {"id","email","firstName","lastName","roles","enabled"};
		csvWriter.writeHeader(csvHeader);
		for (User user : listUsers) {
			csvWriter.write(user, mappedFields);
		}
		csvWriter.close();
		
	}
}
