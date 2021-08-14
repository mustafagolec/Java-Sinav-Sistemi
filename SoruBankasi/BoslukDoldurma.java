package SoruBankasi;

import java.util.Scanner;
import java.util.Vector;

public class BoslukDoldurma extends ButunSorular{

	public BoslukDoldurma(String soruMetni, String dogruCevap, int puan, String zorluk) {
		super(soruMetni, dogruCevap, puan, zorluk);
		// TODO Auto-generated constructor stub
	}
	public static void Cikarma(String metin) {
			Scanner input = new Scanner (System.in);
			Main obj = new Main();
				for(int i = 0; i<obj.boslukdoldurma.size(); i++) {
						if(obj.boslukdoldurma.get(i).getSoruMetni().contains(metin)) {
							for( i= 0; i < obj.boslukdoldurma.size(); i++) {
								if(obj.boslukdoldurma.get(i).getSoruMetni().contains(metin))
									System.out.println(i+1+". Soru "+obj.boslukdoldurma.get(i).getSoruMetni());	
									}
				System.out.print("Silmek Ýstediðiniz Sorunun index :");
				int index = input.nextInt();
				for(i = 0; i<obj.karisik.size();i++) {
					if(obj.boslukdoldurma.get(index-1).getSoruMetni().contains(obj.karisik.get(i).getSoruMetni()))
						obj.karisik.remove(i);}
				obj.boslukdoldurma.remove(index -1);
					}
						else {
				System.out.println("Bulunamadý");
			}
	}
		}
	public static void Ekleme(String metin,String dogrucevap,int puan , String zorluk) {
		Scanner input = new Scanner (System.in);
		Main obj = new Main();
		BoslukDoldurma soru = new BoslukDoldurma(metin,dogrucevap,puan,zorluk);
		obj.boslukdoldurma.add(soru);
		ButunSorular sorular = new BoslukDoldurma(metin,dogrucevap,puan,zorluk);
		obj.karisik.add(sorular);
	}
	@Override
	public String toString() {return "Soru : "+getSoruMetni();}

	

}
