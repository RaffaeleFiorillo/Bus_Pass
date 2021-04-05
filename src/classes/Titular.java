package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Titular {
		private DocumentoId DocId;
		private String nome;
		private Data dataNascimento;
		private String morada;
		private String email;
		private int telemovel;
		
		/**
		 * Metodo Titular
		 * @param doc
		 * @param no
		 * @param data
		 * @param mo
		 * @param em
		 * @param tel
		 * */
		public Titular(DocumentoId doc, String no,  Data data, String mo, String em, int tel) {
			this.DocId=doc;
			this.nome=no;
			this.dataNascimento=data;
			this.morada=mo;
			this.email=em;
			this.telemovel=tel;
			}
		
		/**
		 * Metodo getNome
		 * @return nome
		 * */
		public String getNome() {
			return nome;
			}
		
		/**
		 * Metodo getMorada
		 * @return morada
		 * */
		public String getMorada() {
			return morada;
			}
		
		/**
		 * Metodo getTelemovel
		 * @return telemovel
		 * */
		public int getTelemovel() {
			return telemovel;
			}
		
		/**
		 * Metodo getEmail
		 * @return email
		 * */
		public String getEmail() {
			return email;
			}
		
		/**
		 * Metodo getDataNascimento
		 * @return dataNascimento
		 * */
		public Data getDataNascimento() {
			return dataNascimento;
			}
		
		/**
		 * Metodo getDocId
		 * @return DocId
		 * */
		public DocumentoId getDocId() {
			return DocId;
			}
		
		/**
		 * Metodo setTelemovel
		 * @param t
		 * */
		public void setTelemovel(int t) {
			this.telemovel=t;
			}
		
		/**
		 * Metodo setEmail
		 * @param e
		 * */
		public void setEmail(String e) {
			this.email=e;
			}
		
		/**
		 * Metodo setMorada
		 * @param m
		 * */
		public void setMorada(String m) {
			this.morada=m;
			}
		
}
