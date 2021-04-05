package classes;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Turista extends Sazonal {
	
	/**
	 * Metodo Turista
	 * @param c
	 * @param s
	 * */
	public Turista(int c,int s) {
		int diasDeValidade;
		if (s==500)
			 diasDeValidade=1;
		else if(s==700)
			diasDeValidade=3;
		else
			diasDeValidade=7;
		this.codigo=c;
		this.dataEmissao=dataPadrao.clone();dataEmissao.toDataAtual();
		this.saldo=s;
		this.precoViagem=50;
		this.dataLimite=dataEmissao.clone(); dataLimite.somaDias(diasDeValidade);
		this.chave=gerarChave();
		this.tipo="Sazonal: Turista";
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
			System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Saldo. Saldo restante: "+this.saldo);
			}
		}
	
	/**
	 * Metodo carregarPasse
	 * informa que impossivel recarregar este passe
	 * */
	@Override
	public void carregarPasse(int quantia) {
		System.out.println("Lamentamos informar que este passe nao pode ser carregado.");
		}
	
	/**
	 * Metodo modificar
	 * */
	@Override
	public void modificar() {
		System.out.println("Este passe nao pode ser modificado");
		}

}
