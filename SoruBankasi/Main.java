package SoruBankasi;
import java.util.Vector;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Main {

	static Scanner input = new Scanner(System.in);
	static Vector<CoktanSecmeli>test = new Vector<CoktanSecmeli>();
	static Vector<DogruYanlis>dogruyanlis = new Vector<DogruYanlis>();
	static Vector<BoslukDoldurma>boslukdoldurma = new Vector<BoslukDoldurma>();
	static Vector<Klasik>klasik = new Vector<Klasik>();
	static Vector<ButunSorular>karisik = new Vector<ButunSorular>();
	
	
	
	static final int SORUBANKASINASORUEKLE = 1;
	static final int SORUBANKASINDANSORUCIKARMA = 2;
	static final int SORULARILISTELE = 3;
	static final int SINAV = 4;
	static final int KAYDET = 5;
	static final int CIKIS = 6;
	
	
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("sorular.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);			
				 karisik = (Vector<ButunSorular>)ois.readObject();
				 klasik = (Vector<Klasik>)ois.readObject();
				 boslukdoldurma = (Vector<BoslukDoldurma>)ois.readObject();
				 dogruyanlis = (Vector<DogruYanlis>)ois.readObject();
				 test = (Vector<CoktanSecmeli>)ois.readObject();
	
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int secim = -1;
	       do 
		{ 
			 secim = printMenu();
			 switch(secim) {
			 case SORUBANKASINASORUEKLE: soruEklemeIslemleri();break;
			 case SORUBANKASINDANSORUCIKARMA:soruCikarmaIslemleri();break;
			 case SORULARILISTELE:sorulariListeleme();break;
			 case SINAV: SýnavOlusturma(); ;break;
			 case KAYDET: Cikti.cikti();
			 }
			 
			 }while(secim != CIKIS);
		}

	private static void SýnavOlusturma() { 
		int  secim = -1;
		do {
		System.out.println("1. Test Sinavi Olustur  ");
		System.out.println("2. Klasik Sinav Olustur  ");
		System.out.println("3. Karisik Sinav Olustur  ");
		System.out.println("4. Ana Menü ");
		System.out.print(" Seçiminiz : ");
		secim = input.nextInt();				
		switch(secim) {
		case 1 :TestOlustur.testOlustur() ; break;
		case 2 :KlasikOlustur.klasikSinav();break;
		case 3 :KarisikOlustur.karisikOlustur(); break;
		}

	}while (secim!= 4);
		}

	private static void sorulariListeleme() {
		int  secim = -1;
		do {
		System.out.println("1. Tüm Sorularý Listele  ");
		System.out.println("2. Soru Metnine Göre Listele   ");
		System.out.println("3. Cevap Þýklarýna Göre Listele  ");
		System.out.println("4. Doðru Þýklar Üzerinden Listele  ");
		System.out.println("5. Puana Göre  Listele  ");
		System.out.println("6. Zorluk Derecesine Göre  Listele  ");
		System.out.println("7. Ana Menüye Dön  ");
		System.out.print(" Seçiminiz : ");
		secim = input.nextInt();
		
		
		switch(secim) {
		 case 1: TumSorularýListe();break;
		 case 2: SoruMetnineGoreListe();break;
		 case 3: CevapSiklarinaGoreListe();break;
		 case 4: DogruSiklaraGoreListe();break;
		 case 5: PuanaGoreListe();break;
		 case 6: ZorlukDerecesineGoreListe();break;
		}
		}while(secim != 7);
	}


	
	private static void PuanaGoreListe() {
		Scanner input = new Scanner (System.in);
		System.out.print("Arama yapmak istediðiniz puan giriniz:");
		int not = input.nextInt();
		Collections.sort(karisik);
		for(int i=0;i<karisik.size();i++) {
			if(karisik.get(i).getPuan()== not)		
				System.out.println(i+1+" "+karisik.get(i));
		}
	}
	private static void DogruSiklaraGoreListe() 
		{
		Scanner input = new Scanner (System.in);
		System.out.print("Arama yapmak istediðiniz Doðru þýkký giriniz:");
		String metin = input.nextLine();
		Collections.sort(test);
		for(int i=0;i<test.size();i++) {
			int index = (test.get(i).getDogruCevap().compareToIgnoreCase(metin));
					if (index == 0)
						System.out.println(i+1+" "+test.get(i));
		}
					}
					
	private static void ZorlukDerecesineGoreListe() {
		Scanner input = new Scanner (System.in);
		int secim = -1;
		String zorluk= null ;
		do {
		System.out.println("Arama yapmak istediðiniz zorluk dercesini Seciniz :");
		System.out.println("1- kolay");
		System.out.println("2- orta");
		System.out.println("3- zor");
		secim = input.nextInt();
		switch(secim) {
		case 1 : zorluk ="kolay";break;
		case 2 : zorluk ="orta";break;
		case 3 : zorluk ="zor";break;
		}
		}while(secim<1 || secim>3 );
		Collections.sort(karisik);
		for(int i=0;i<karisik.size();i++) {
			int index = ( karisik.get(i).getZorluk().compareToIgnoreCase(zorluk));
				if(index == 0)
						System.out.println(i+1+" "+karisik.get(i));
			
		}
		
	}

	
	private static void CevapSiklarinaGoreListe() 
	{
		Scanner input = new Scanner (System.in);
		System.out.print("Arama yapmak istediðiniz metni giriniz:");
		String metin = input.nextLine();
		Collections.sort(test);
	    for(int i=0; i<test.size();i++) {
	    	if(test.get(i).getA().contains(metin)) 
	    		System.out.println(i+1+" " + test.get(i));
	    	else if (test.get(i).getB().contains(metin)) 
	    		System.out.println(i+1+" " + test.get(i));	    		
	    	else if (test.get(i).getC().contains(metin)) 
	    		System.out.println(i+1+" " + test.get(i));	
	    	else if (test.get(i).getD().contains(metin)) 
	    		System.out.println(i+1+" " + test.get(i));
	    	
	    }			
	}

	private static void SoruMetnineGoreListe() {
		Scanner input = new Scanner (System.in);
		System.out.print("Arama yapmak istediðiniz metni giriniz:");
		String metin = input.nextLine();
		Collections.sort(karisik);
		for(int i=0;i<karisik.size();i++) {
			if(karisik.get(i).getSoruMetni().equalsIgnoreCase(metin))
				System.out.println(i+1+" "+karisik.get(i));
			}}

	private static void TumSorularýListe() {
		Collections.sort(karisik);
		for(int i= 0; i < karisik.size(); i++) 
			System.out.println(i+1+". "+karisik.get(i));}

	
	private static void soruCikarmaIslemleri() {
		int  secim = -1;
		do {
		System.out.println("1. Çoktan Seçmeli Soru Çýkar  ");
		System.out.println("2. Doðru/Yanlýþ Soru Çýkar  ");
		System.out.println("3. Boþluk Doldurmalý Soru Çýkar  ");
		System.out.println("4. Klasik Soru Çýkar  ");
		System.out.println("5. Ana Menüye Dön  ");
		System.out.print(" Seçiminiz : ");
		secim = input.nextInt();
		
		
		switch(secim) {
		 case 1: {
				Scanner input = new Scanner(System.in);
				System.out.print("Metin Giriniz :");
				String metin = input.nextLine();
				CoktanSecmeli.Cikarma(test, metin);break;}
		 case 2: {
			 	Scanner input = new Scanner(System.in);
				System.out.print("Metin Giriniz :");
				String metin = input.nextLine();
				DogruYanlis.Cikarma(metin);break;}
			
		 case 3: {
			 	Scanner input = new Scanner(System.in);
				System.out.print("Metin Giriniz :");
				String metin = input.nextLine();
				BoslukDoldurma.Cikarma(metin) ;break;}
		 case 4: {
				Scanner input = new Scanner(System.in);
			 	System.out.print("Metin Giriniz :");
				String metin = input.nextLine();
				Klasik.Cikarma( metin) ;break;}
		
		}
		}while(secim != 5);
		
	}

	public static void soruEklemeIslemleri() {
		int  secim = -1;
		int secim1 = -1;
		int secim2;
		do {
		System.out.println("-----------------------------------");
		System.out.println("1. Çoktan Seçmeli Soru Ekle  ");
		System.out.println("2. Doðru/Yanlýþ Soru Ekle  ");
		System.out.println("3. Boþluk Doldurmalý Soru Ekle  ");
		System.out.println("4. Klasik Soru Ekle  ");
		System.out.println("5. Ana Menüye Dön  ");
		System.out.println("-----------------------------------");
		System.out.print(" Seçiminiz ---->  ");
		secim = input.nextInt();
		
		
		switch(secim) {
		 case 1: {
			 Scanner input = new Scanner(System.in);
			System.out.print("\nSoru Metnini Giriniz:");
			String soruMetni = input.nextLine();
			System.out.println("Sorunun Cevap Þýklarýný Giriniz:");
	        String A,B,C,D ;
			System.out.print("A Þýkkýný Giriniz :");
			A=input.nextLine();
			System.out.print("B Þýkkýný Giriniz :");
			B=input.nextLine();
			System.out.print("C Þýkkýný Giriniz :");
			C=input.nextLine();
			System.out.print("D Þýkkýný Giriniz :");
			D=input.nextLine();
			String dogruCevap = null ;
			do {
				System.out.println("Sorunun Dogru Sikkini Seciniz:");
				System.out.println("1. A");
				System.out.println("2. B");
				System.out.println("3. C");
				System.out.println("4. D");
				secim2= input.nextInt();
				switch(secim2) {
				 case 1: System.out.println("Dogru Cevabiniz A olarak Secilmistir.");dogruCevap= "A";break;
				 case 2: System.out.println("Dogru Cevabiniz B olarak Secilmistir.");dogruCevap= "B";break;
				 case 3: System.out.println("Dogru Cevabiniz C olarak Secilmistir.");dogruCevap= "C";break;
				 case 4: System.out.println("Dogru Cevabiniz D olarak Secilmistir.");dogruCevap= "D";break;
				}
				}while(secim2 < 1 || secim2 >4);
			
			System.out.print("Sorunun Puanýný Giriniz:");
			int puan = input.nextInt();	
			String zorluk = null ;
			do {
				System.out.println("Sorunun Zorluk Derecesini Seciniz:");
				System.out.println("1. Kolay  ");
				System.out.println("2. Orta   ");
				System.out.println("3. Zor ");
				 secim1= input.nextInt();
				switch(secim1) {
				 case 1: System.out.println("Zorluk derecesi kolay olarak secilmistir");zorluk= "kolay";break;
				 case 2: System.out.println("Zorluk derecesi orta olarak secilmistir");zorluk= "orta" ;break;
				 case 3: System.out.println("Zorluk derecesi zor olarak secilmistir");zorluk= "zor";break;
				}
				}while(secim1 < 1 || secim1 >3);
			
			CoktanSecmeli.Ekleme(soruMetni, A, B, C, D, dogruCevap, puan, zorluk);break;}
		 	
		 case 2: {
			 	Scanner input = new Scanner(System.in);
			 	System.out.print("Soru Metnini Giriniz:");
			 	String soruMetni = input.nextLine();
			 	String dogruCevap = null ;
                do {
                    System.out.println("Soru Dogru'mu/Yanlis'mi Seciniz:");
                    System.out.println("1. D");
                    System.out.println("2. Y");
                    secim2= input.nextInt();

                    switch(secim2) {
                     case 1: System.out.println(" Cevabiniz D  olarak Secilmistir.");;dogruCevap= "D";break;
                     case 2: System.out.println(" Cevabiniz Y olarak Secilmistir.");dogruCevap= "Y";break;
                    }
                    }while(secim2 < 1 || secim2 >2);
				System.out.print("Sorunun Puanýný Giriniz:");
				int puan = input.nextInt();
				String zorluk = null ;
				do {
					System.out.println("Sorunun Zorluk Derecesini Seciniz:");
					System.out.println("1. Kolay  ");
					System.out.println("2. Orta   ");
					System.out.println("3. Zor ");
					secim1= input.nextInt();
					switch(secim1) {
					 case 1: zorluk= "kolay";break;
					 case 2: zorluk= "orta" ;break;
					 case 3: zorluk= "zor";break;
					}
					}while(secim1 < 1 || secim1 >3);
				
				DogruYanlis.Ekleme(soruMetni, dogruCevap, puan, zorluk);break;
				}
		 case 3: {
			 	Scanner input = new Scanner(System.in);
				System.out.print("Soru Metnini Giriniz:");
				String soruMetni = input.nextLine();
				System.out.print("Sorunun Doðru Cevabýný Giriniz:");
				String dogruCevap = input.nextLine();
				System.out.print("Sorunun Puanýný Giriniz:");
				int puan = input.nextInt();
				String zorluk = null ;
				do {
					System.out.println("Sorunun Zorluk Derecesini Seciniz:");
					System.out.println("1. Kolay  ");
					System.out.println("2. Orta   ");
					System.out.println("3. Zor ");
					secim1= input.nextInt();
					switch(secim1) {
					 case 1: zorluk= "kolay";break;
					 case 2: zorluk= "orta" ;break;
					 case 3: zorluk= "zor";break;
					}
					}while(secim1 < 1 || secim1 > 3);
				
				BoslukDoldurma.Ekleme(soruMetni, dogruCevap, puan, zorluk);break;}
		 case 4: {
			 	Scanner input = new Scanner(System.in);
				System.out.print("Soru Metnini Giriniz: ");
				String soruMetni = input.nextLine();
				System.out.print("Sorunun Puanýný Giriniz:");
				int puan = input.nextInt();
				String zorluk = null ;
				do {
					System.out.println("Sorunun Zorluk Derecesini Seciniz:");
					System.out.println("1. Kolay  ");
					System.out.println("2. Orta   ");
					System.out.println("3. Zor ");
					secim1= input.nextInt();
					switch(secim1) {
					 case 1: zorluk= "kolay";break;
					 case 2: zorluk= "orta" ;break;
					 case 3: zorluk= "zor";break;
					}
					}while(secim1 < 1 || secim1 >3);
				
				Klasik.Ekleme(soruMetni, puan, zorluk);break;}
						
		}
		}while(secim != 5);
	}


	private static int printMenu() {
		
		System.out.println("----MENU-----");
		System.out.println("1. Soru Bankasýna Soru Ekle");
		System.out.println("2. Soru Bankasýndan Soru Silme");
		System.out.println("3. Sorularý Listele");
		System.out.println("4.Sýnav");
		System.out.println("5.Kaydet");
		System.out.println("6.Cikis");
		System.out.print("Seçiminiz : ");
		int secim = input.nextInt();
		return secim;
	}
}
