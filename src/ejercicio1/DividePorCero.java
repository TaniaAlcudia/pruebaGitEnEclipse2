package ejercicio1;

import java.io.IOException;

public class DividePorCero 
{

	public static void main(String[] args) 
	{
		int dividendo, divisor;
		float cociente;
		
		try 
		{
			System.out.println("Introdude dividendo:");
			dividendo=Consola.leeInt();
			System.out.println("Introduce divisor:");
			divisor=Consola.leeInt();
			cociente=dividendo/divisor;
			System.out.println("El resultado es "+cociente);
		}
		catch(NumberFormatException | IOException e)
		{
			e.printStackTrace();
		}
		catch(ArithmeticException e)
		{
			System.out.println("Error: division por cero");
			return;
		}
	}

}
