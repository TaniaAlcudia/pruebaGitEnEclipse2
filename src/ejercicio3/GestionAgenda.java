package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class GestionAgenda 
{

	private String nomFich;

	public GestionAgenda(String nomFich) 
	{
		this.nomFich = nomFich;
	}
	
	public void ver() throws IOException
	{
		File f = new File(this.nomFich);
		
		if(!f.exists())
		{
			System.out.println("ERROR. Archivo no encontrado.");
			return;
		}
		
		BufferedReader br = new BufferedReader(new FileReader(this.nomFich));
		
		String linea=br.readLine();
		while(linea!=null)
		{
			System.out.println(linea);
			linea=br.readLine();
		}
		
		br.close();
	
	}
	
	public void aniadePersona(Persona persona) throws IOException
	{
		File f = new File(this.nomFich);
		
		if(!f.exists())
		{
			System.out.println("ERROR. Archivo no encontrado.");
			return;
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.nomFich, true));
		
		bw.write(persona.toString());
		bw.newLine();
		
		bw.close();
		
	}
	
	public Persona buscaPersona(String nomPersona) throws IOException
	{
		
		File f = new File(this.nomFich);
		
		if(!f.exists())
		{
			System.out.println("ERROR. Archivo no encontrado.");
			return null;
		}
		
		BufferedReader br = new BufferedReader(new FileReader(this.nomFich));
		
		String linea=br.readLine();
		Persona p1 = null;
		
		while(linea!=null)
		{
			if(nombreEnLinea(linea, nomPersona)==true)
			{
				p1=transforma(linea);
				return p1;
			}
			else
				linea=br.readLine();
		}
		
		br.close();
		return null;
	}
	
	public boolean nombreEnLinea(String linea, String nombre)
	{
		String[] palabras=linea.split("\t");
		
		if(palabras[2].equals(nombre))
			return true;
		else
			return false;
	}
	
	public Persona transforma(String linea)
	{
		String[] palabras=linea.split("\t");
		
		Persona p1 = new Persona(palabras[2], palabras[1], palabras[0], palabras[3]);
		
		return p1;
	}
	
	public boolean eliminaPersona(Persona persona) throws IOException
	{
		
		File f = new File(this.nomFich);
		
		if(!f.exists())
		{
			System.out.println("ERROR. Archivo no encontrado.");
			return false;
		}
		
		BufferedReader br = new BufferedReader(new FileReader(this.nomFich));
		
		Persona p1;
		ArrayList<Persona> agenda = new ArrayList<Persona>();
		String linea=br.readLine();
		while(linea!=null)
		{	
			p1=transforma(linea);
			agenda.add(p1);
			linea=br.readLine();
		}
		
		if(agenda.contains(persona))
			agenda.remove(persona);
		else
			return false;
	
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(this.nomFich));
		
		Iterator<Persona> it = agenda.iterator();
		
		while(it.hasNext())
		{
			bw.write(it.next().toString());
			bw.newLine();
		}
		
		bw.close();	
		return true;
	}
	
	
	
	
	
	
	
	
}
