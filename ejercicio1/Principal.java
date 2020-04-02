package ejercicio1;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Principal 
{

	public static void main(String[] args) throws IOException 
	{
		
		//-Cree un fichero binario de ints nums.bin 
		//(los que desee el usuario
		//pedir números hasta que se introduzca el 0)
		
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("nums.bin"));
		
		int n;
		do 
		{
			System.out.println("Estoy escribiendo solo para modificar el fichero");
			System.out.println("Introduce un numero:");
			n=Consola.leeInt();
			dos.writeInt(n);
			
		} while (n!=0);
		
		dos.close();
		
		
		//-A partir de dicho fichero, genere un fichero de texto nums.txt, 
		//con una línea por cada int de nums.bin
		
		DataInputStream dis = new DataInputStream(new FileInputStream("nums.bin"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("nums.txt"));
	
		int num;
		for (int i=0; i<dis.available(); i++) 
		{
			num=dis.readInt();
			bw.write(num+"");
			bw.newLine();
		}
		
		dis.close();
		bw.close();
		
		
		
		
		
		
		
		
	}

}
