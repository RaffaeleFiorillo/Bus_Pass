package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public class DocumentoId {
	private TipoDoc tipo;
	private String codigo;
	
	/**
	 * Metodo DocumentoId
	 * @param t
	 * @param cod
	 * */
	public DocumentoId(TipoDoc t,String cod) {
		tipo=t;
		codigo= cod;
		}
	
	/**
	 * Metodo getTipo
	 * @return tipo
	 * */
	public String getTipo() {
		return tipo.toString();
		}
	
	/**
	 * Metodo getCodigo
	 * @return codigo
	 * */
	public String getCodigo() {
		return codigo;
		}	
}
