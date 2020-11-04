package objetos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ArquivoWordList {
	private RandomAccessFile file;
	private int numReg;
	private int tamReg;
	private int tamHead;
	private static final int STRING_MAX_TAM = 15;
	
	public ArquivoWordList() {
		this.file = null;
		this.numReg = -1; // número de registro (-1: não há registros)
		this.tamReg = 	STRING_MAX_TAM;
		this.tamHead = 0;
	}

	public void openFile(String path) {
		File f = new File(path);
		// se arquivo no existe definie numReg como 0. Se o arquivo já existe,mantenha
		// como -1
			if (!f.exists())
				this.numReg = 0;
			try {
				file = new RandomAccessFile(f, "rw");

			}
				catch (FileNotFoundException e) {
					System.out.println("File not found");
					System.exit(0);
		}
		// se numReg é igual a -1, há registros dentro do arquivo, então verifica a
		// quantidade de registros
			if (this.numReg == -1)
				this.setNumReg();
			}
		
		private void setNumReg() {
			try {
				System.out.println("wew"+this.file.readInt());
				this.numReg = file.readInt();
				System.out.println("wew"+this.numReg);
				
			} 
			catch (IOException e) {
				System.out.println("Error  !");
				System.exit(0);
			}
		}
		
		public void openFileReadOnly(String path) {
			try {
				file = new RandomAccessFile(new File(path), "r");
			} 
			catch (FileNotFoundException e) {
				System.out.println("File not found");
				System.exit(0);
			}
			this.setNumReg();
		}
		
		public int getNumReg() {
			return numReg;
			}
	
	public void setData(String palavra) {
		int pos = this.tamHead + (this.numReg * this.tamReg); // calcula ponteiro para a primeira posição vazia do arquivo
		try {
			file.seek(pos);
			file.writeUTF(palavra);
			file.seek(0);
			this.numReg += 1;
			file.writeInt(this.numReg);
		} 
		catch (IOException e) {
			System.out.println("Error !");
			System.exit(0);
		}
	}
		
		public String getData(int key) {
			if (key >= this.numReg)
				return null;
			int pos = this.tamHead + (key * this.tamReg);
			String palavra=" ";
			
			try {
				file.seek(pos);
				
				palavra=(file.readUTF());		
			
				} 
			catch (IOException e) {
			
			System.out.println("Error ");
			System.exit(0);
				}
			return palavra;
		}
		
		

	public void closeFile(String path) {
		try {
		file.close();
		} 
		catch (IOException e) {
		System.out.println("Error ");
		System.exit(0);
		}
	}

}
