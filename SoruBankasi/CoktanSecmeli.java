package SoruBankasi;
import java.util.Scanner;
import java.util.Vector;
import java.util.Scanner;

public class CoktanSecmeli extends ButunSorular{
	private char dogru;
public CoktanSecmeli(String soruMetni, String a, String b, String c, String d, String dogruCevap, int puan,
			String zorluk) {
		super(soruMetni, a, b, c, d, dogruCevap, puan, zorluk);
		// TODO Auto-generated constructor stub
	}

public static void Cikarma(Vector<CoktanSecmeli> test ,String metin) {
	Scanner input = new Scanner (System.in);
	Main obj = new Main();
	for(int i = 0; i<test.size(); i++) {
		if(test.get(i).getSoruMetni().contains(metin)) {
			for( i= 0; i < test.size(); i++) {
				if(test.get(i).getSoruMetni().contains(metin))
				System.out.println(i+1+". Soru "+test.get(i).getSoruMetni());	
			}
			System.out.print("Silmek Ýstediðiniz Sorunun index :");
			int index = input.nextInt();
			for(i = 0; i<obj.karisik.size();i++) {
				if(test.get(index-1).getSoruMetni().contains(obj.karisik.get(i).getSoruMetni()))
					obj.karisik.remove(i);}
			test.remove(index -1);
		}
	
	}
}
	public static void Ekleme(String metin,String a ,String b,String c,String d,
			String dogrucevap,int puan , String zorluk) {
		Scanner input = new Scanner (System.in);
		Main obj = new Main();
		CoktanSecmeli soru = new CoktanSecmeli(metin, a, b, c, d, dogrucevap, puan, zorluk);
		obj.test.add(soru);
		ButunSorular sorular = new CoktanSecmeli(metin, a, b, c, d, dogrucevap, puan, zorluk);
		obj.karisik.add(sorular);
	}
	public String toString() {return "Soru : "+getSoruMetni()+"\nA: "+getA()+"\nB: " +getB()+"\nC: "+getC()+"\nD: "+getD()+"\n-------------------------";}



	
		 	

}
    

