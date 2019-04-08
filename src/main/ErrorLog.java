package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ErrorLog {

	private BufferedWriter bw;
	
	public ErrorLog(){
		try 
		{
			File file = new File("errlog.txt");
			FileOutputStream fos = new FileOutputStream(file);
			
			bw = new BufferedWriter(new OutputStreamWriter(fos));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
	}
	
	public void newLine(String log)
	{
		try 
		{			
			bw.write(log);
			bw.newLine();
			bw.flush();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
