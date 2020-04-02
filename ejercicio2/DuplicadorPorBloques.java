package ejercicio2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicadorPorBloques extends DuplicadorDeArchivo
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
		
		char[] bloque = new char[20];
		int nCaracteres = fr.read(bloque);
		
		while(nCaracteres>0)
		{
			fw.write(bloque, 0, nCaracteres);
			nCaracteres=fr.read(bloque);
		}
		
		fr.close();
		fw.close();
		
		return true;
	}

}
