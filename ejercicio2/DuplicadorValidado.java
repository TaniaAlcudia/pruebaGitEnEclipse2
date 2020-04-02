package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicadorValidado extends DuplicadorDeArchivo
{

	@Override
	public boolean duplicar(String nomFich) throws FileNotFoundException, IOException 
	{
		
		if(this.ruta.equals(nomFich))
			return false;
		
		File f = new File(this.ruta);
		
		if(!f.exists())
			return false;
		
		FileReader fr = new FileReader (this.ruta);
		FileWriter fw = new FileWriter(nomFich);
		
		int caracter=fr.read();
		while(caracter!=-1)
		{
			if(caracterNoValido(caracter)==true)
				caracter=fr.read();
			else
			{
				fw.write(caracter);
				caracter=fr.read();
			}
			
		}
		
		fr.close();
		fw.close();
		
		return true;
	}
	
	private boolean caracterNoValido(int caracter)
	{
		char[] caracteresNoValid = new char[] {'a','e','i','o','u'};
		
		for (int i=0; i<caracteresNoValid.length; i++) 
		{
			if(caracter==caracteresNoValid[i])
				return true;
		}
		
		return false;
	}

	
	
	
	
	
}
