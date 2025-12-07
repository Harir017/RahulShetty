package com.RahulShetty.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static List<Map<String, String>> getData(String filepath, String sheetname) {

		List<Map<String, String>> sheetData = new ArrayList<>();
		DataFormatter formatter = new DataFormatter();

		try (InputStream is = new FileInputStream(filepath); 
				
			Workbook workbook = WorkbookFactory.create(is)) {
			Sheet sheet = workbook.getSheet(sheetname);
			if (sheet == null) {
				throw new RuntimeException("Sheet '" + sheetname + "' not found in file!");
			}
			Row headerrow = sheet.getRow(0);
			int totalColoumns = headerrow.getLastCellNum();
			int totalrows = sheet.getLastRowNum();

			for (int i = 1; i <= totalrows; i++) {
				Row row = sheet.getRow(i);
				if (row == null || row.getCell(0) == null || row.getCell(0).toString().trim().isEmpty())
			        continue;

				Map<String, String> rowData = new HashMap<>();
				for (int j = 0; j < totalColoumns; j++) {
					Cell headercell = headerrow.getCell(j);
					String key = formatter.formatCellValue(headercell);

					Cell cell = row.getCell(j);
					String value = formatter.formatCellValue(cell);

					rowData.put(key, value);
				}
				sheetData.add(rowData);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error reading Excel file: " + e.getMessage());

		}
		return sheetData;
	}
}
