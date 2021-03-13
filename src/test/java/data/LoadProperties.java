package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties 
{
      // load the properties from the file
	public static Properties UesrData=Load_Properties
			("F:\\eclipse-workspace\\POM\\src\\main\\java\\properties\\Userdata.properties");

	private static Properties Load_Properties(String path) 
	{
		Properties pro=new Properties();
		//stream for reading file 
		try {
			FileInputStream str= new FileInputStream(path);
			try {
				pro.load(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return pro; 
	}
}
