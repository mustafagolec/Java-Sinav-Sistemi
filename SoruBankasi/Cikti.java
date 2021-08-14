package SoruBankasi;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;
public class Cikti {

	public static void cikti() {
		Main obj = new Main();
		
		try {
			FileOutputStream fos = new FileOutputStream("sorular.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);			
					oos.writeObject(obj.karisik);	
					oos.writeObject(obj.klasik);	
					oos.writeObject(obj.boslukdoldurma);	
					oos.writeObject(obj.dogruyanlis);	
					oos.writeObject(obj.test);	
					oos.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
