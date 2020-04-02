package ejercicio2;

import java.io.IOException;

public class Principal 
{

	public static void main(String[] args) throws IOException 
	{
		
		DuplicadorCar pruebaCar = new DuplicadorCar();
		pruebaCar.duplicar("duplicadoCar.txt");
		
		DuplicadorPorBloques pruebaBloques = new DuplicadorPorBloques();
		pruebaBloques.duplicar("duplicadoBloque.txt");
		
		DuplicadorValidado pruebaValidado = new DuplicadorValidado();
		pruebaValidado.duplicar("duplicadoValidado.txt");

	}

}
