package especialistaDados;

public class FormatarLinhas {
	private String palavras[];
	
	public void SepararCamposEmEspaco(String campo){
		String[] palavras =campo.split("[ ]");
		this.palavras=palavras;
	}
	
	public void AdicionarParentese(){
		
	}
	
}
