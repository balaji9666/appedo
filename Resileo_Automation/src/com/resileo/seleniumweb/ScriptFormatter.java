package com.resileo.seleniumweb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScriptFormatter extends Utility{
 
	public static void main(String[] args) throws Exception
	{
		final String FILENAME = getProperty("sourcefile");	

		BufferedReader br = null;
		FileReader fr = null;
		String varname ="";
		try 
		{
			FileUtilities FE = new FileUtilities();
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			String sCurrentLine;
			br = new BufferedReader(new FileReader(FILENAME));
			FileUtilities Fe = new FileUtilities();
			String OR = Fe.getfilecontet();
			int lastchar = OR.trim().length();
			String Withoutbrace  =OR.substring(0,lastchar-1);
			Fe.Writefile(getProperty("OR"), Withoutbrace);
			Fe.Writefile(getProperty("Generatedfile"),"");
			Fe.appendfile(getProperty("OR"), "\n");
			while ((sCurrentLine = br.readLine()) != null) {
				if(!sCurrentLine.contains("driver.get"))
				{
					int strpos1 = sCurrentLine.indexOf("driver.findElement(By.");
					int tempos= strpos1+"driver.findElement(By.\"".length();
					int strpos2 = sCurrentLine.indexOf("\"))",tempos);
					String neededData = sCurrentLine.substring(tempos-1, strpos2);
					//System.out.println(neededData);
					String[] neededDataArray = neededData.split("\\(\"");
					String[] varnames=sCurrentLine.split(";");
					if(varnames.length>1)
					{
						varname = varnames[1];
					}
					else
					{
						varname = neededDataArray[1].replaceAll(" ","").replaceAll("[^\\dA-Za-z ]", "");
					}
					String ORContent = FE.getfilecontet();
					if(!ORContent.contains("\""+neededDataArray[0]+":"+neededDataArray[1]+"\""))
					{
						String ObjectVales = "String "+varname+"=\""+neededDataArray[0]+":"+neededDataArray[1]+"\";";
						String S1 = "By."+neededDataArray[0]+"(\""+neededDataArray[1]+"\")";
						String S2 = sCurrentLine.replace(S1,"getObject("+varname+")").replaceAll("driver", "browser").split(";")[0]+";";
						FE.appendfile(getProperty("OR"),ObjectVales+"\n");
						FE.appendfile(getProperty("Generatedfile"), S2+"\n");
					}
					else
					{
						varname = FE.getObjName("\""+neededDataArray[0]+":"+neededDataArray[1]+"\"");
						String S1 = "By."+neededDataArray[0]+"(\""+neededDataArray[1]+"\")";
						String S2 = sCurrentLine.replace(S1,"getObject("+varname+")").replaceAll("driver", "browser").split(";")[0]+";";
						FE.appendfile(getProperty("Generatedfile"), S2+"\n");
					}
				}
				else
				{
					FE.appendfile(getProperty("Generatedfile"), sCurrentLine.replaceAll("driver", "browser")+"\n");

				}
			}
			FE.appendfile(getProperty("OR"),"}"+"\n");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try
			{
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} 
			catch (IOException ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}
