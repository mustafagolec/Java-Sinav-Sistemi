package SoruBankasi;

import java.util.Vector;

public class CevapKontrol {
	public static int dogruMu(int i2,  String gelenCevap,int puan) {
		int i;
		int index;
		Main obj = new Main();
			for(i=i2;i<obj.test.size();i++) {
				index= (obj.test.get(i).getDogruCevap().compareToIgnoreCase(gelenCevap));
				if(index==0) {
					
					return puan= obj.test.get(i).getPuan();
					}
				else if(index==1) {
					
					return 0;
				}
				
				else 
					return 0;
			}
			return 0;	
}}