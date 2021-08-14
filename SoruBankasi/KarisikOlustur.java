package SoruBankasi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;

public class KarisikOlustur {
	public static void karisikOlustur() {
		try {
			FileWriter f = new FileWriter ("karisik.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner input= new Scanner(System.in);
		Main obj = new Main();
		Collections.shuffle(obj.karisik);
		int i ,toplamPuan=0;
		 int j =0;
		int puan= 0;
		String cevap = null ;
		while(toplamPuan>100 && toplamPuan<=110) {				
			for(i=0;i<obj.karisik.size();i++) {	
				toplamPuan =0;
				toplamPuan+=obj.karisik.get(i).getPuan();	
				if(toplamPuan>100 && toplamPuan<=110)
					break;
				else 
					Collections.shuffle(obj.karisik);
				}		
		}
		for (i=0;i<obj.karisik.size();i++) {
			
			if( toplamPuan+obj.karisik.get(i).getPuan()<=110 && i<=obj.karisik.size()) {

				toplamPuan+=obj.karisik.get(i).getPuan();				
				if(obj.karisik.get(i).getA()!=null) {
					do{
					
						System.out.println((++j)+ ". Soru : "+obj.karisik.get(i).getSoruMetni()+"\nA: "+obj.karisik.get(i).getA()+
							"\nB: " +obj.karisik.get(i).getB()
								+"\nC: "+obj.karisik.get(i).getC()+"\nD: "+obj.karisik.get(i).getD()+"\n-------------------------");

					System.out.print("Cevabý giriniz  : ");
					cevap = input.nextLine();
					}while(!cevap.equalsIgnoreCase("a") && !cevap.equalsIgnoreCase("b")&&!cevap.equalsIgnoreCase("c") && !cevap.equalsIgnoreCase("d"));
					  try{      
						  
				           FileWriter fw=new FileWriter("karisik.txt",true);    
				           	fw.write((j)+". Soru :"+obj.karisik.get(i).getSoruMetni()+" ("+obj.karisik.get(i).getPuan()+" puan )"+
				        		   "\nA) "+obj.karisik.get(i).getA()+"\nB) "+obj.karisik.get(i).getB()+
				        		   		"\nC) "+obj.karisik.get(i).getC()+"\nD) "+obj.karisik.get(i).getD()+"\nIsaretlediginiz Sik :"+cevap+"\n"+
				        		   			"Dogru Cevap :"+obj.karisik.get(i).getDogruCevap()+"\n------------------------------------\n");   				           
				           				fw.close();    
				          }catch(Exception e){
				        	  e.printStackTrace();
				          }	
				}
			
				else {
					
					System.out.println((++j)+ ". Soru : "+obj.karisik.get(i).getSoruMetni());
					System.out.print("Cevabý giriniz  : ");
					cevap = input.nextLine();
					try{      
					  
			           FileWriter fw=new FileWriter("karisik.txt",true);    
			           	fw.write((j)+".Soru :"+obj.karisik.get(i).getSoruMetni()+" ("+obj.karisik.get(i).getPuan()+" puan )"+"\nCevabýnýz : "+cevap+
			           "\n------------------------------------\n");   				           
			           	fw.close();    
			          }catch(Exception e){
			        	  e.printStackTrace();
			          }
				}
		
				     				          
			     } }  
		try {
			FileWriter fw = new FileWriter("karisik.txt",true);
			fw.write("\n Toplam Sýnav Puaný :"+toplamPuan);				
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
			}
}
