package SoruBankasi;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class TestOlustur {
		
		public static void testOlustur() {
			try {
				FileWriter f = new FileWriter ("test.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Scanner input= new Scanner(System.in);
			Main obj = new Main();
			Collections.shuffle(obj.test);
			int i ,toplamPuan=0;
			 int j =0;
			int puan= 0;
			String cevap = null ;
			while(toplamPuan>100 && toplamPuan<=110) {				
				for(i=0;i<obj.test.size();i++) {	
					toplamPuan =0;
					toplamPuan+=obj.test.get(i).getPuan();	
					if(toplamPuan>100 && toplamPuan<=110)
						break;
					else 
						Collections.shuffle(obj.test);
					}		
			}
			for (i=0;i<obj.test.size();i++) {
				
				if( toplamPuan+obj.test.get(i).getPuan()<=110 && i<=obj.test.size()) {
					toplamPuan+=obj.test.get(i).getPuan();				
					System.out.println((++j)+"."+obj.test.get(i));
					do{
						System.out.print("Cevabý giriniz  : ");
						cevap = input.nextLine();
					}while(!cevap.equalsIgnoreCase("a") && !cevap.equalsIgnoreCase("b")&&!cevap.equalsIgnoreCase("c") && !cevap.equalsIgnoreCase("d"));
				
					puan +=CevapKontrol.dogruMu(i, cevap,puan);
					   try{      
						  
				           FileWriter fw=new FileWriter("test.txt",true);    
				           	fw.write((j)+".Soru :"+obj.test.get(i).getSoruMetni()+" ("+obj.test.get(i).getPuan()+" puan )"+
				        		   "\nA) "+obj.test.get(i).getA()+"\nB) "+obj.test.get(i).getB()+
				        		   		"\nC) "+obj.test.get(i).getC()+"\nD) "+obj.test.get(i).getD()+"\nIsaretlediginiz Sik :"+cevap+"\n"+
				        		   			"Dogru Cevap :"+obj.test.get(i).getDogruCevap()+"\n------------------------------------\n");   				           
				           				fw.close();    
				          }catch(Exception e){
				        	  e.printStackTrace();
				          }    				          
				     } }  
			try {
				FileWriter fw = new FileWriter("test.txt",true);
				fw.write("\n Toplam Sýnav Puaný :"+toplamPuan);
				fw.write("\n Puanýnýz : "+puan);				
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
					
				}
							
			}
		