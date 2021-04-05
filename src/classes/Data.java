package classes;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Period;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Data {
	private int ano;
	private int mes;
	private int dia;
	private int hora;
	private int minuto;
	private int segundo;
	
	/**
	 * Metodo Data
	 * @param a
	 * @param M
	 * @param d
	 * @param h
	 * @param m
	 * @param s
	 * */
	public Data (int a,int M, int d, int h, int m, int s){
		this.ano=a;
		this.mes=M;
		this.dia= d;
		this.hora=h;
		this.minuto=m;
		this.segundo=s;
		}
	/**
	 * Metodo setAno
	 * @param a
	 * */
	public void setAno(int a) {
		this.ano=a;
		}
	
	/**
	 * Metodo getAno
	 * @return ano
	 * */
	public int getAno() {
		return this.ano;
		}
	
	/**
	 * Metodo setMes
	 * @param M
	 * */
	public void setMes(int M) {
		this.mes=M;
		}
	
	/**
	 * Metodo getMes
	 * @return mes
	 * */
	public int getMes() {
		return this.mes;
		}
	
	/**
	 * Metodo setDia
	 * @param d
	 * */
	public void setDia(int d) {
		this.dia=d;
		}
	
	/**
	 * Metodo getDia
	 * @return dia
	 * */
	public int getDia() {
		return this.dia;
		}
	
	/**
	 * Metodo setHora
	 * @param h
	 * */
	public void setHora(int h) {
		this.hora=h;
		}
	
	/**
	 * Metodo getHora
	 * @return hora
	 * */
	public int getHora() {
		return this.hora;
		}
	
	/**
	 * Metodo setMinuto
	 * @param m
	 * */
	public void setMinuto(int m) {
		this.minuto=m;
		}
	
	/**
	 * Metodo getMinuto
	 * @return minuto
	 * */
	public int getMinuto() {
		return this.minuto;
		}
	
	/**
	 * Metodo setSegundo
	 * @param s
	 * */
	public void setSegundo(int s) {
		this.segundo=s;
		}
	
	/**
	 * Metodo getSegundo
	 * @return segundo
	 * */
	public int getSegundo() {
		return this.segundo;
		}
	
	/**
	 * Metodo bissexto
	 * recebe um ano e controla se o ano é bissexto
	 * @param a
	 * @return boolean
	 * */
	private boolean bissexto(int a) {
		if (a%4==0){
			if (a%100==0){
				if (a%400==0){
					return true;}
			}else{
				return true;}}
		return false;
		}
	
	/**
	 * Metodo validarData
	 * verifica se a data que o chama é valida
	 * @return boolean
	 * */
	public boolean validarData() {
		if (ano>=0)
			if (mes>=0 && mes<13) {
				if (mes==0 || mes==1 ||mes==3 ||mes==5 ||mes==7 ||mes==8 ||mes==10 ||mes==12) {
						if (dia>=0 && dia<32)
							if (hora<24 && hora>=0)
								if (minuto<60 && minuto>=0)
									if(segundo<60 && segundo>=0)
										return true;}
				else if (mes==4 || mes==6 ||mes==9 || mes==11){
						if (dia>=0 && dia<31)
							if (hora<24 && hora>=0)
								if (minuto<60 && minuto>=0)
									if(segundo<60 && segundo>=0)
										return true;}
				else if (mes==2 && bissexto(ano)){
						if (dia>=0 && dia<30)
							if (hora<24 && hora>=0)
								if (minuto<60 && minuto>=0)
									if(segundo<60 && segundo>=0)
										return true;}
				else
					if (dia>=0 && dia<29)
						if (hora<24 && hora>=0)
							if (minuto<60 && minuto>=0)
								if(segundo<60 && segundo>=0)
									return true;}		
		return false;
		}
	
	/**
	 * Metodo printData
	 * mostra no ecra os atributos da classe e suas legendas
	 * */
	public void printData() {
		System.out.println("Ano: "+ano+"; Mes: "+mes+"; Dia: "+dia+"; Hora: "+hora+"; Minuto: "+minuto+"; Segundo: "+segundo+";");
		}
	
	/**
	 * Metodo dataToString
	 * cria uma string com os atibutos ano mes e dia em uma string
	 * @return 
	 * */
	public String dataToString() {
		String dS;
		dS= ano+"-"+mes+"-"+dia;
		return dS;
	}
	
	/**
	 * Metodo somaDias
	 * atualiza a data que o chama para a mesma com um valor adicional de dias
	 * @param dias2
	 * */
	public void somaDias(int dias2) {
		LocalDate l=LocalDate.of(ano, mes, dia);
		l=l.plusDays(dias2);
		this.ano=l.getYear();
		this.mes=l.getMonth().getValue();
		this.dia=l.getDayOfMonth();
		}
	
	/**
	 * Metodo diferencaDatas
	 * cria uma data com a diferença entre duas datas
	 * @param data2
	 * @return Data
	 * */
	public Data diferencaDatas(Data data2) {
		Data dataAtual=new Data(0,0,0,0,0,0);dataAtual.toDataAtual();
		LocalDate l = LocalDate.of(data2.getAno(), data2.getMes(), data2.getDia());
		LocalDate now= l.now();
		Period diff = Period.between(l, now);
		data2.setAno(diff.getYears());
		data2.setMes(diff.getMonths());
		data2.setDia(diff.getDays());
		data2.setHora(0);
		data2.setMinuto(0);
		data2.setSegundo(0);
		return data2;
		}

	/**
	 * Metodo vemDepois
	 * verifica se uma data vem antes ou depois da data que faz a chamada
	 * @param data2
	 * @return boolean
	 * */
	public boolean vemDepois(Data data2) {
		if (data2.validarData()) {
			if (data2.getAno()<ano) {
				return true;}
			if (ano==data2.getAno()) {
				if (mes>data2.getMes())
					return true;}
			else
				return false;
			if (mes==data2.getMes()) {
				if (dia>data2.getDia())
					return true;}
			else 
				return false;
			if (dia==data2.getDia()) {
				if (hora>data2.getHora()) 
					return true;}
			else 
				return false;
			if (hora==data2.getHora()) {
				if (minuto>data2.getMinuto())
					return true;}
			else 
				return false;
			if (minuto==data2.getMinuto()) {
				if(segundo>data2.getSegundo())
					return true;}
			else 
				return false;
			}
		return false;
		}
	
	/**
	 * Metodo toDataAtual
	 * transforma a data que o chama na data atual
	 * */
	public void toDataAtual() {
		LocalDateTime now= LocalDateTime.now();
		this.ano=now.getYear();
		this.mes=now.getMonth().getValue();
		this.dia=now.getDayOfMonth();
		this.hora =now.getHour();
		this.minuto = now.getMinute();
		this.segundo = now.getSecond();
		}
	
	/**
	 * Metodo clone
	 * cria um clone da data que o chama
	 * */
	public Data clone() {
		Data dataClone= new Data(ano,mes,dia,hora,minuto,segundo);
		return dataClone;
		}
}
