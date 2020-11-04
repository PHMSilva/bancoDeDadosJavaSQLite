package manipuladores;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class LeitorArquivo {
	
	private BufferedReader bufferArq;
	private ArrayList<String> vetorPalavras;
	

	public LeitorArquivo() throws FileNotFoundException{
		
		String ArqDicData="C:/Users/user/Desktop/Eclipese,java/ImportandoRegistrosNoBDSqlite/src/words_alpha.txt";
		System.out.println("encontrou o arquivo :) ");
		FileReader file= new FileReader(ArqDicData);
		
		BufferedReader bw = new BufferedReader(file);
		
		this.setBufferArq(bw);
		
	}
	
	
	public void LerArquivo() throws IOException{
		
		ArrayList <String> conjPalavra= new ArrayList<String>();
		
		String palavra="";
		
		BufferedReader arquivo= this.getBufferArq();
		
		while((palavra=arquivo.readLine())!=null){
			conjPalavra.add(palavra);
		}
		
		//System.out.println("processo finalizado");
		
		this.setVetorPalavras(conjPalavra);
	}
	
	
	public void imprimirArray(ArrayList<String> conjPalavra){
		
		for (String palavra : conjPalavra ){
			System.out.println(palavra);
		}
		
	}
	
	
	public BufferedReader getBufferArq() {
		return bufferArq;
	}
	

	public void setBufferArq(BufferedReader bufferArq) {
		this.bufferArq = bufferArq;
	}
	
	
	public ArrayList<String> getVetorPalavras() {
		return vetorPalavras;
	}

	
	public void setVetorPalavras(ArrayList<String> vetorPalavras) {
		this.vetorPalavras = vetorPalavras;
	}
}
