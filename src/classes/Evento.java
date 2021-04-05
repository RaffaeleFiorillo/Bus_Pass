package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Evento {
	private Data dataInicio;
	private Data dataFim;
	private String nome;
	
	/**
	 * Metodo Evento
	 * @param daI
	 * @param daF
	 * @param n
	 * */
	public Evento(Data daI,Data daF, String n) {
		dataInicio=daI;
		dataFim= daF;
		nome=n;
		}
	
	/**
	 * Metodo getDataInicio
	 * @return dataInicio
	 * */
	public Data getDataInicio(){
		return dataInicio;
		}
	/**
	 * Metodo getDataFim
	 * @return dataFim
	 * */
	public Data getDataFim(){
		return dataFim;
		}
	
	/**
	 * Metodo getNome
	 * @return nome
	 * */
	public String getNome(){
		return nome;
		}
}
