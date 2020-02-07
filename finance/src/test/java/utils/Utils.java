package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Utils {

	public static void main(String[] args) {

	}

	public static ArrayList<String> readLinesInFile(String pathFile) {

		
			ArrayList<String> lines = new ArrayList<String>();
			File f = new File(pathFile);
			if(f.exists() && !f.isDirectory())
			{
				
			}
			else
			{
				System.out.println(f.getName() + " is a folder!");
				return lines;
			}
			
			
			FileInputStream fstream=null;
			try {
				fstream = new FileInputStream(pathFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream,StandardCharsets.ISO_8859_1));

			String strLine;

			//Read File Line By Line
			try {
				while ((strLine = br.readLine()) != null)   
				{
				  lines.add(strLine);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			System.out.println(lines.size() + " lines readed!");
			return lines;
		}




	}
