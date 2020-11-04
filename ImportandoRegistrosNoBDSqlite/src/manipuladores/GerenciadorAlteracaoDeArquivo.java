package manipuladores;
import objetos.ArquivoWordList;
import especialistaDados.FormatarLinhas;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthSeparatorUI;


public class GerenciadorAlteracaoDeArquivo {
	private BufferedReader arquivo;


	public GerenciadorAlteracaoDeArquivo(BufferedReader arquivoLeitura) throws IOException, SQLException{
		this.arquivo = arquivoLeitura;
		BDSqlite importarDados = new BDSqlite();
		importarDados.coletarPalavras(this.arquivo);
		//this.coletarPalavras();
		
	}
	
	public void coletarPalavras () throws IOException{
	
}

public BufferedReader getArquivo() {
	return arquivo;
}

public void setArquivo(BufferedReader arquivo) {
	this.arquivo = arquivo;
}
}
