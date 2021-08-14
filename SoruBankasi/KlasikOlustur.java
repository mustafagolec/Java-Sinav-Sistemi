package SoruBankasi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class KlasikOlustur {
	public static void klasikSinav () {
	try {
		FileWriter f = new FileWriter ("klasik.txt");
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Scanner input= new Scanner(System.in);
	Main obj = new Main();
	Collections.shuffle(obj.klasik);
	int i ,toplamPuan=0;
	 int j =0;
	String cevap = null ;
	while(toplamPuan>100 && toplamPuan<=110) {				
		for(i=0;i<obj.klasik.size();i++) {	
			toplamPuan =0;
			toplamPuan+=obj.klasik.get(i).getPuan();	
			if(toplamPuan>100 && toplamPuan<=110)
				break;
			else 
				Collections.shuffle(obj.klasik);
			}		
	}
	for (i=0;i<obj.klasik.size();i++) {
		
		if( toplamPuan+obj.klasik.get(i).getPuan()<=110 && i<=obj.klasik.size()) {
			toplamPuan+=obj.klasik.get(i).getPuan();				
			System.out.println((++j)+"."+obj.klasik.get(i));
			System.out.print("Cevabý giriniz  : ");
			cevap = input.nextLine();
			System.out.println("------------------------");
			   try{      
				  
		           FileWriter fw=new FileWriter("klasik.txt",true);    
		           	fw.write((j)+".Soru :"+obj.klasik.get(i).getSoruMetni()+" ("+obj.klasik.get(i).getPuan()+" puan )"+"\nCevabýnýz : "+cevap+
		           "\n------------------------------------\n");   				           
		           	fw.close();    
		          }catch(Exception e){
		        	  e.printStackTrace();
		          }    				          
		     } }  
	try {
		FileWriter fw = new FileWriter("klasik.txt",true);
		fw.write("\n Toplam Sýnav Puaný :"+toplamPuan);				
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}}
