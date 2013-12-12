package com.importexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ImportPOI {

	public static void main(String[] args) {

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setFileFilter( new ExcelFileFilter() );
		fileChooser.showOpenDialog(null);
		
		if (fileChooser.getSelectedFile() != null) {
			File file = fileChooser.getSelectedFile();
			String ext = FileUtil.getExtencion(file);
			try (FileInputStream fileInputStream = new FileInputStream(file)) {
				if(ext.equals("xls")){
					HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
					HSSFSheet sheet =  workbook.getSheetAt(0);
					int totalRows = sheet.getLastRowNum();
					HSSFRow row = null;
					for( int index = 0 ; index < totalRows ; index++ ){
						row = sheet.getRow(index);
						int totalColumns = row.getPhysicalNumberOfCells();
						if( totalColumns == 14){
							
							System.out.println( Integer.valueOf( row.getCell(0).getStringCellValue() ) + ";"  );
						}
					}
				}else if(ext.equals("xlsx") ){
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
