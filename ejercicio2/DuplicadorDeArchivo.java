package ejercicio2;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class DuplicadorDeArchivo 
{

	protected String ruta="";
	final public static String RUTA = "prueba.txt";
	
	
	public DuplicadorDeArchivo(String ruta) 
	{
		this.ruta = ruta;
	}
	
	public DuplicadorDeArchivo()
	{
		this.ruta = RUTA;
	}
	
	public abstract boolean duplicar(String nomFich) throws FileNotFoundException, IOException;
		
}


