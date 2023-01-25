package ej1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.io.OutputStream;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException{
		
		File directorio1=new File("D:\\eclipse\\workspace\\MultiProcesoExamen2\\bin");
		
		Scanner sc=new Scanner(System.in);
		
		String numeros="0";
		String letra="";
			
		System.out.println("Introduce el numero de dni:");
		
		numeros=sc.nextLine();
		
		System.out.println("Introduce la letra de dni:");
		
		letra=sc.nextLine();
		
		ProcessBuilder pb=new ProcessBuilder("java","ej1.Comprobar",numeros,letra);
		pb.directory(directorio1);
		
		Process p = pb.start();		
		
//		OutputStream os= p.getOutputStream();
//		os.write(letra.getBytes());
//		os.flush();
//		os.write(numeros.getBytes());
//		os.flush();
//		os.close();
		
		int exitVal = -1;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (exitVal==0){
			try {
			
				InputStream is = p.getInputStream();
				// mostramos en pantalla caracter a caracter
				 int c;
				 while ((c = is.read()) != -1)
					System.out.print((char) c);
				// is.close();
				System.exit(0);
		
			} catch (Exception e) {
				System.exit(-1);
				e.printStackTrace();
			}		
		}
		
		sc.close();
	}
	
}
