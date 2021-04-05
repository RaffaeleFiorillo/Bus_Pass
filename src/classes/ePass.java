package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public abstract class ePass {
	    protected final Data dataPadrao=new Data(0,0,0,0,0,0); //nao foi pedido, mas tem utilidade em algumas operaçoes nas subclasses
		protected int codigo;
		protected int saldo;
		protected String chave;
		protected Data dataLimite;
		protected Data dataEmissao;
		protected int precoViagem;
		protected String tipo;
		
		/**
		 * Metodo getCodigo
		 * @return codigo
		 * */
		public int getCodigo() {
			return codigo;
			}
		
		/**
		 * Metodo getPrecoViagem
		 * @return precoViagem
		 * */
		public int getPrecoViagem() {
			return precoViagem;
			}
		
		/**
		 * Metodo getSaldo
		 * @return saldo
		 * */
		public int getSaldo() {
			return saldo;
			}
		
		/**
		 * Metodo getDataEmicao
		 * @return dataEmicao
		 * */
		public Data getDataEmissao() {
			return dataEmissao;
			}
		
		/**
		 * Metodo getDataLimite
		 * @return dataLimite
		 * */
		public Data getDataLimite() {
			return dataLimite;
			}
		
		/**
		 * Metodo getChave
		 * @return chave
		 * */
		public String getChave() {
			return chave;
			}
		
		/**
		 * Metodo getTipo
		 * @return tipo
		 * */
		public String getTipo() {
			return tipo;
			}
		
		/**
		 * Metodo setSaldo
		 * @param quantidade
		 * */
		public void setSaldo(int quantidade) {
			this.saldo=quantidade;
			}
		
		/**
		 * Metodo pagarViagem
		 * */
		public abstract void pagarViagem();
		
		/**
		 * Metodo carregarPasse
		 * */
		public abstract void carregarPasse(int quantia);
		
		/**
		 * Metodo modificar
		 * */
		public abstract void modificar();
}
