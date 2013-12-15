package com.importexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.eval.ConcatEval;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportPOI {
	
	
	public static ContactPOJO mountContactFromRow(Row row){
		ContactPOJO contactPOJO = new ContactPOJO();
		contactPOJO.setName( row.getCell(0).getStringCellValue() );
		contactPOJO.setEmail( row.getCell(1).getStringCellValue() );
		contactPOJO.setPhone( row.getCell(2).toString() );
		contactPOJO.setCellphone(  row.getCell(3).toString() );
		return contactPOJO;
	}
	
	/**
	 * Will iterate over the rows and insert in the list the created objects
	 * @param rows
	 * @param listContacts
	 */
	public static void iterateAndCreateContacts( Iterator<Row> rows , List<ContactPOJO> listContacts){
		while( rows.hasNext() ){
			Row row = rows.next();
			//Ignore the first line, normally is used to the header line
			if(row.getRowNum() == 0)
				continue;
			listContacts.add( mountContactFromRow( row ) );
		}
	}
	
	public static void main(String[] args) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter( new ExcelFileFilter() );
		fileChooser.showOpenDialog(null);
		
		if (fileChooser.getSelectedFile() != null) {
			File file = fileChooser.getSelectedFile();
			String ext = FileUtil.getExtencion(file);
			try (FileInputStream fileInputStream = new FileInputStream(file)) {
				
				List<ContactPOJO> listContacts = new ArrayList<>();
				ContactPOJO pojo = null;
				if(ext.equals("xls")){
					HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
					HSSFSheet sheet =  workbook.getSheetAt(0);
					iterateAndCreateContacts( sheet.rowIterator() , listContacts);
				}else if(ext.equals("xlsx") ){
					XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
					XSSFSheet sheet = workbook.getSheetAt(0);
					iterateAndCreateContacts( sheet.rowIterator() , listContacts);
				}
				
				System.out.println( listContacts );
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
