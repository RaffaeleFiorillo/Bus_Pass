package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Fest extends Sazonal {
	private Evento evento;
	private int saldoFestival;
	private boolean bilheteDeEntrada;
	
	/**
	 * Metodo Fest
	 * @param c
	 * @param ev
	 * @param bilhete
	 * */
	public Fest (int c, Evento ev, boolean bilhete) {
		this.codigo=c;
		this.dataEmissao=dataPadrao.clone();dataEmissao.toDataAtual();
		this.saldo=0;
		this.saldoFestival=0;
		this.precoViagem=40;
		this.evento=ev;
		this.dataLimite=this.evento.getDataFim();
		this.chave=gerarChave();
		this.tipo="Sazonal: Fest";
		this.bilheteDeEntrada=bilhete;
		}
	
	/**
	 * Metodo carregarPasse
	 * recarrega o passe com uma certa quantia
	 * */
	@Override
	public void carregarPasse(int quantia){
		Data dataAtual=new Data(0,0,0,0,0,0); dataAtual.toDataAtual();
		if (dataLimite.vemDepois(dataAtual)){
			System.out.println("Lamentamos informar que este Passe passou da sua validade. Impossivel recarregar o Passe.");
			}
		else {
			if (quantia>0) {
				this.saldo+=quantia;
				System.out.println("Passe "+this.tipo+" recarregado com sucesso! Saldo atual:"+ this.saldo);
				}
			else {
				System.out.println("Lamentamos informar, mas a quantia introduzida nao permite realizar a recarga.");
				}
			}
		}
	
	/**
	 * Metodo pagarViagem
	 * efetua o pagamento de uma viagem
	 * */
	@Override
	public void pagarViagem() {
		if (saldo<precoViagem) {
			System.out.println("Lamentamos informar que o saldo disponivel nao permite realizar o pagamento.");
			}
		else {
			saldo-=precoViagem;
			System.out.println("Pagamento efetuado com sucesso! Saldo restante: "+this.saldo);
			}
		}
	
	/**
	 * Metodo carregarSaldoFestival
	 * recarrega o saldo usavel no evento  com uma quantia 
	 * @param quantia
	 * */
	public void carregarSaldoFestival(int quantia){
		Data dataAtual=new Data(0,0,0,0,0,0); dataAtual.toDataAtual();
		if (dataLimite.vemDepois(dataAtual)){
			System.out.println("Lamentamos informar que este Passe passou da sua validade. Impossivel recarregar o Saldo Festival.");
			}
		else {
			if (quantia>0) {
				this.saldoFestival+=quantia;
				System.out.println("Saldo Festival recarregado com sucesso! Saldo Festival atual:"+ this.saldoFestival);
				}
			else
				System.out.println("Lamentamos informar, mas a quantia introduzida nao permite realizar a recarga.");
			}
		}
	
	/**
	 * Metodo usarSaldoFestival
	 * usa o saldo usavel no evento
	 * @param quantia
	 * */
	public void usarSaldoFestival(int quantia) {
		Data dataAtual=new Data(0,0,0,0,0,0); dataAtual.toDataAtual();
		if (dataLimite.vemDepois(dataAtual)){
			System.out.println("Lamentamos informar que este Passe passou da sua validade. Impossivel utilizar o recurso: Saldo Festival.");
			}
		else {
			if (quantia<=saldoFestival && quantia>0) {
				System.out.println("Pagamento efetuado com sucesso! Saldo Festival restante: "+this.saldoFestival);
				this.saldoFestival-=quantia;
				}
			else
				System.out.println("Saldo insuficiente para realizar o pagamento.");
			}
		}
	
	/**
	 * Metodo getSaldoFestival
	 * @return saldoFestival
	 * */
	public int getSaldoFestival() {
		return this.saldoFestival;
		}
	
	/**
	 * Metodo temBilhete
	 * diz se o dono do passe comprou ou nao o bilhete para o evento
	 * */
	public boolean temBilhete() {
		return this.bilheteDeEntrada;
		}
	
	/**
	 * Metodo getEvento
	 * @return evento
	 * */
	public Evento getEvento() {
		return this.evento;
		}
	
	/**
	 * Metodo modificar
	 * */
	@Override
	public void modificar() {
		System.out.println("Este passe nao pode ser modificado");
		}
	
}
