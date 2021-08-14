package SoruBankasi;

import java.util.Scanner;
import java.util.Vector;

public class Klasik extends ButunSorular {
	

	public Klasik(String soruMetni, int puan, String zorluk) {
		super(soruMetni, puan, zorluk);
		// TODO Auto-generated constructor stub
	}
	public static void Cikarma(String metin) {
		Scanner input = new Scanner (System.in);
		Main obj = new Main();
		for(int i = 0; i<obj.klasik.size(); i++) {
			if(obj.klasik.get(i).getSoruMetni().contains(metin)) {
				for( i= 0; i < obj.klasik.size(); i++) {
					if(obj.klasik.get(i).getSoruMetni().contains(metin))
					System.out.println(i+1+". Soru "+obj.klasik.get(i).getSoruMetni());	
				}
				}
				System.out.print("Silmek Ýstediðiniz Sorunun index :");
				int index = input.nextInt();
				for( i = 0; i<obj.karisik.size();i++) {
				if(obj.klasik.get(index-1).getSoruMetni().contains(obj.karisik.get(i).getSoruMetni()))
					obj.karisik.remove(i);}
				obj.klasik.remove(index -1);}
	}
	public static void Ekleme(String metin,int puan , String zorluk) {
		Scanner input = new Scanner (System.in);
		Main obj = new Main();
		Klasik soru = new Klasik(metin, puan, zorluk);
		obj.klasik.add(soru);
		ButunSorular sorular = new Klasik(metin, puan, zorluk);
		obj.karisik.add(sorular);
	}
	@Override
	public String toString() {return "Soru : "+getSoruMetni();}

	
	
}
