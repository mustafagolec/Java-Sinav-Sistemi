package SoruBankasi;
import java.io.Serializable;
import java.util.Vector;
public class ButunSorular  implements Comparable <ButunSorular>,Serializable {
	private static final long serialVersionUID = 1L;
	 private String soruMetni;
	 private String A;
	 private String B;
	 private String C;
	 private String D;
	 private String dogruCevap;
	 private int puan;
	 private String zorluk;
	 
	 public ButunSorular(String soruMetni, String a, String b, String c, String d, String dogruCevap, int puan,
				String zorluk) {
			this.soruMetni = soruMetni;
			A = a;
			B = b;
			C = c;
			D = d;
			this.dogruCevap = dogruCevap;
			this.puan = puan;
			this.zorluk = zorluk;
		}

	 public ButunSorular(String soruMetni, String dogruCevap, int puan, String zorluk) {
		super();
		this.soruMetni = soruMetni;
		this.dogruCevap = dogruCevap;
		this.puan = puan;
		this.zorluk = zorluk;
	}
	 

	public ButunSorular(String soruMetni, int puan, String zorluk) {
		super();
		this.soruMetni = soruMetni;
		this.puan = puan;
		this.zorluk = zorluk;
	}


	public String getSoruMetni() {
		return soruMetni;
	}

	public void setSoruMetni(String soruMetni) {
		this.soruMetni = soruMetni;
	}

	public String getA() {
		return A;
	}


	public void setA(String a) {
		A = a;
	}


	public String getB() {
		return B;
	}


	public void setB(String b) {
		B = b;
	}


	public String getC() {
		return C;
	}


	public void setC(String c) {
		C = c;
	}


	public String getD() {
		return D;
	}


	public void setD(String d) {
		D = d;
	}


	public String getDogruCevap() {
		return dogruCevap;
	}


	public void setDogruCevap(String dogruCevap) {
		this.dogruCevap = dogruCevap;
	}


	public int getPuan() {
		return puan;
	}


	public void setPuan(int puan) {
		this.puan = puan;
	}


	public String getZorluk() {
		return zorluk;
	}


	public void setZorluk(String zorluk) {
		this.zorluk = zorluk;
	}
	  public String toString() {
	 		
			if(this.A !=null)
				return	"Soru: "+soruMetni+"\nA: "+A+"\nB: " +B+"\nC: "+C+"\nD: "+D+
							"\nDoðru Cevap: "+dogruCevap+"\nPuan: "+puan+
								"\nZorluk derecesi : "+zorluk+"\n-------------------------";
			else if(this.A == null && this.dogruCevap == null)
				return "Soru: "+soruMetni+"\nPuan: "+puan+"\nZorluk derecesi: "+zorluk+"\n-------------------------";
			else
				return "Soru: "+soruMetni+"\nDoðru Cevap: "+dogruCevap+"\nPuan: "+puan+
						"\nZorluk derecesi: "+zorluk+"\n-------------------------";
	  }
	@Override
	public int compareTo(ButunSorular o) {
		if (this.puan >o.getPuan())
			return 1;
		else if(this.puan<o.getPuan())
			return -1;
		else
		   return 0;
	}


	

	

}
