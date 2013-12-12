package com.importexcel;

import java.io.File;
import java.util.Arrays;

import javax.swing.filechooser.FileFilter;

/**
 * 
 * @author Efraim Gentil
 * @date Dec 11, 2013
 */
public class ExcelFileFilter extends FileFilter {
	
	@Override
	public String getDescription() {
		return null;
	}
	
	@Override
	public boolean accept(File file) {
		String ext = FileUtil.getExtencion(file); 
		return ext == null || Arrays.asList("xls" , "xlsx").contains( ext );
	}
	
	
	
}
