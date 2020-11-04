package main;
import manipuladores.*;
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

public class Menu {

	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		
		LeitorArquivo leitor= new LeitorArquivo();
		leitor.LerArquivo();
		System.out.println("iniciando a fase dois");
		System.out.println(leitor.getVetorPalavras().size());
		
		BDSqlite bd= new BDSqlite(leitor.getVetorPalavras());
		bd.inserirPalavra();
		System.out.println("acabou");
		/*
		String suaString="shulambs";
		System.out.println(suaString);
		int tamanho = suaString.length();
		suaString = suaString.substring(0, tamanho-1);
		System.out.println(suaString);
		suaString+=";";
		System.out.println(suaString);
		
		
		/*
		String ArqMovieData="C:/Users/user/Desktop/Eclipese,java/ConversaoDeArqiuivo/src/words_alpha.txt";

		FileReader file= new FileReader(ArqMovieData);
		BufferedReader bw = new BufferedReader(file);
		
		GerenciadorAlteracaoDeArquivo gerenciador = new GerenciadorAlteracaoDeArquivo(bw);
	
	/* while((String linha=bw.readLine())!=null){
			System.out.println("('"+linha+"'),");
		}
	*/
	
		
		
		
		
		
		
		
	}

}
