package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicadorCar extends DuplicadorDeArchivo
{

	@Override
	public boolean duplicar(String nomFich) throws IOException 
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
			fw.write(caracter);
			caracter=fr.read();
		}
		
		fr.close();
		fw.close();
		
		return true;
	}
	
	
	
	
	
}
