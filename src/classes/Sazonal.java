package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public abstract class Sazonal extends ePass {
		
	/**
	 * Metodo gerarChave
	 * cria uma chave valida para este tipo de passe
	 * @return chave
	 * */
		protected String gerarChave() {
			this.chave= dataEmissao.dataToString()+this.codigo;
			return this.chave;
			}
}
