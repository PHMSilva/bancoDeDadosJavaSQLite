package manipuladores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.IOException;

public class BDSqlite {

	private ArrayList<String> vetPalavra;
	
	public BDSqlite(ArrayList<String> vetPalavra){
		this.setVetPalavra(vetPalavra);
	}
	

	public void inserirPalavra () throws IOException, SQLException{
		
		//ArquivoWordList novoArquivo= new ArquivoWordList();
		System.out.println("entrou aqui ");
		//Connect banco = new Connect();
		
		ArrayList<String> conjPalavra= this.getVetPalavra();
		
        Connection conecta = null;
        
        conecta= DriverManager.getConnection("jdbc:sqlite:tabela.db");
        
        Statement stmt = conecta.createStatement();
        
        String sql="";
        
        stmt.executeUpdate("create table lista_palavras (id integer, palavras string)");
        
        int i=1;
        //conjPalavrA
        //sql= "INSERT INTO lista_palavras(id,palavras) VALUES ('" + i + "','" + sql+ "');";
        String values="";
        String registro="";
		for(String palavra : conjPalavra ){
			if((i%1000)==0){
				values=values.substring(0,values.length()-1);
				sql="INSERT INTO lista_palavras(id,palavras) VALUES "+values+";";
				stmt.executeUpdate(sql);
				values="";
	
			}
			registro="('" + i + "','" +palavra+ "'),";
			values+=registro;
			i++;
	
			
		}
	
		values=values.substring(0,values.length()-1);
		sql="INSERT INTO lista_palavras(id,palavras) VALUES "+values+";";
		stmt.executeUpdate(sql);
		System.out.println("acabou :)");

	stmt.close();
	conecta.close();
	}
	
	
	public ArrayList<String> getVetPalavra() {
		return vetPalavra;
	}

	public void setVetPalavra(ArrayList<String> vetPalavra) {
		this.vetPalavra = vetPalavra;
	}
}
