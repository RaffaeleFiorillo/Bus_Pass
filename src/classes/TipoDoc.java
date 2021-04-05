package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public enum TipoDoc {
	Passaporte,BI, CartaDeConducao;
	
	/**
	 * Metodo intValueOf
	 * retorna um valor inteiro correspondente ao campo do valor do Enum
	 * @param value
	 * @return int
	 * */
	public static int intValueOf(String value) {
		if (value.equals("Passaporte"))
			return 1;
		else if (value.equals("BI"))
			return 2;
		else if (value.equals("CartaDeConducao"))
			return 3;
		return -1;
		}
	
	/**
	 * Metodo valueByInt
	 * retorna o campo do Enum dado um inteiro
	 * @param value
	 * @return TipoDoc
	 * */
	public static TipoDoc valueByInt(int value) {
		if (value==1)
			return Passaporte;
		else if (value==2)
			return BI;
		else if (value==3)
			return CartaDeConducao;
		return null;
		}
	
}
