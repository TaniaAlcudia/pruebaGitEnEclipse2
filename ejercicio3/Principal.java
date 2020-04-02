package ejercicio3;

import java.io.IOException;

public class Principal 
{

	public static void main(String[] args) throws IOException 
	{
		
		GestionAgenda ga1 = new GestionAgenda("agenda.txt");
		ga1.ver();
		
		Persona p1 = new Persona("Eloy", "54", "945134644", "Izarra");
		ga1.aniadePersona(p1);
		
		String nombre="Eloy";
		Persona p2=ga1.buscaPersona(nombre);
		
		if(p2!=null)
		{
			System.out.println("--------------------");
			System.out.println(p2.toString());
		}
		else
			System.out.println("No hay ningun/a "+nombre+" en la agenda");
		
		if(ga1.eliminaPersona(p1)==true)
			System.out.println("Persona eliminada");
		else
			System.out.println("No se pudo eliminar la persona");
		

	}

}
