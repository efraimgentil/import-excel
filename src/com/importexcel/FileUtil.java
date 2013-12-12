package com.importexcel;

import java.io.File;

public class FileUtil {
	
	public static String getExtencion(File file){
		String ext = null;
		String s = file.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
	}
	
}
