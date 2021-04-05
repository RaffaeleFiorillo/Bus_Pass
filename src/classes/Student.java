package classes;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Student extends Standard {
	private String anoEscolar;
	private String estabelecimentoEnsino;
	private ArrayList<String> zonasIndicadas;
	private int viagensLivres;
	private Data dataCarregamento;
	
	/**
	 * Metodo Student
	 * @param c
	 * @param t
	 * @param aE
	 * @param zonas
	 * */
	public Student(int c,Titular t,String aE,String eE,ArrayList<String> zonas){
		this.codigo=c;
		this.titular=t;
		this.pontos=0;
		this.numViagens=0;
		this.saldo=0;
		this.precoViagem=20;
		this.dataLimite=dataPadrao.clone();
		this.dataCarregamento=dataPadrao.clone();
		this.dataEmissao=dataPadrao.clone(); dataEmissao.toDataAtual();
		this.chave=gerarChave();
		this.tipo="Standard: Student";
		this.anoEscolar=aE;
		this.estabelecimentoEnsino=eE;
		this.zonasIndicadas=zonas;
		this.viagensLivres=4;
		}
	
	/**
	 * Metodo getAnoEscolar
	 * return anoEscolar
	 * */
	public String getAnoEscolar(){
		return anoEscolar;
		}
	
	/**
	 * Metodo getEstabelecimentoEnsino
	 * return estabelecimentoEnsino
	 * */
	public String getEstabelecimentoEnsino(){
		return estabelecimentoEnsino;
		}
	
	/**
	 * Metodo getZonasIndicadas
	 * return zonasIndicadas
	 * */
	public ArrayList<String> getZonasIndicadas(){
		return zonasIndicadas;
		}
	
	/**
	 * Metodo getViagensLivres
	 * return viagensLivres
	 * */
	public int getViagensLivres() {
		return viagensLivres;
		}
	
	/**
	 * Metodo getDataCarregamento
	 * return dataCarregamento
	 * */
	public Data getDataCarregamento() {
		return dataCarregamento;
		}
	
	/**
	 * Metodo pagarViagem
	 * efetua o pagamento de uma viagem
	 * */
	@Override
	public void pagarViagem() {
		Scanner leitura=new Scanner(System.in);
		System.out.println("Introduza o nome desta zona: ");
		String zonaAtual=leitura.nextLine();
		Data dAtual=dataPadrao.clone(); dAtual.toDataAtual();
		if (saldo>0 && dataLimite.vemDepois(dAtual)) {
			this.saldo-=precoViagem;
			System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Saldo. Saldo restante: "+this.saldo);
			atualizarPontos();
			}
		else if(this.zonasIndicadas.contains(zonaAtual) && this.viagensLivres>0) {
			viagensLivres--;
			atualizarPontos();
			System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Viagem Livres disponiveis. Viagens Livres restante: "+this.viagensLivres);
			}
		else if(pontos>100) {
			pontos-=40;
			System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Pontos. Numero de pontos restantes: "+this.pontos);
			atualizarPontos();
			}
		System.out.println("Lamentamos informar que a data de validade escedeu,nao dispoe de pontos suficientes e as viagens livres esgotaram-se. Por favor, efetuar a recarga para continuar.");
		}
	
	/**
	 * Metodo carregarPasse
	 * recarrega o passe com uma certa quantia
	 * */
	@Override
	public void carregarPasse(int quantia) {
		if (quantia>0) {
			this.saldo=quantia;
			this.viagensLivres=4;
			this.dataCarregamento.toDataAtual();
			this.dataLimite=dataCarregamento;dataLimite.somaDias(30);
			System.out.println("Recarga do Passe"+this.tipo+"efetuada com sucesso!");
			}
		System.out.println("Lamentamos informar, mas a quantia introduzida nao � valida para realizar a recarga do Passe.");
		}
	
	/**
	 * Metodo addZonaIndicada
	 * adiciona uma zona lista de zonas indicadas
	 * */
	public void addZonaIndicada(String zona) {
		this.zonasIndicadas.add(zona);
		}
	
	/**
	 * Metodo addZonaIndicada
	 * remove uma zona da lista de zonas indicadas
	 * */
	public void removeZonaIndicada(String zona) {
		this.zonasIndicadas.remove(zona);
		}
	
	/**
	 * Metodo modificar
	 * */
	@Override
	public void modificar() {
		Scanner leitura=new Scanner(System.in);
		int escolha;
		int valid=0;
		do {
			if (valid==1)
				System.out.println("Erro: Escolha incorreta. Por favor, tente novamente.");
			System.out.println("Atualizar Estabelecimento Escolar ......1\n"+
							   "Adicionar zona de viagem livre .........2\n"+
							   "Remover zona de viagem livre ...........3\n"+
							   "Atualizar ano escolar ..................4\n"+
							   "Atualizar telefone do titular ..........5\n"+
							   "Atualizar email do titular .............6\n"+
							   "Atualizar morada do titular ............7\n"+
							   "Sair ...................................8"
							   );	
			escolha=leitura.nextInt();leitura.nextLine(); // a segunda leitura para libertar o buffer
			valid=1;
		}while(escolha<1&&escolha>8);
		int atu1; String atu2;
		if (escolha==1) {
			System.out.println("Insira o atual estabelecimento escolar:");
			this.estabelecimentoEnsino=leitura.nextLine();
			}
		else if (escolha==2) {
			System.out.println("A zona de viagem livre que deseja adicionar:");
			atu2=leitura.nextLine();
			addZonaIndicada(atu2);
			}
		else if (escolha==3) {
			System.out.println("A zona de viagem livre que deseja remover:");
			atu2=leitura.nextLine();
			removeZonaIndicada(atu2);
			}
		else if (escolha==4) {
			System.out.println("Insira o atual ano escolar:");
			this.anoEscolar=leitura.nextLine();
			}
		else if (escolha==5) {
			System.out.println("Insira o telefone atual do titular: ");
			atu1=leitura.nextInt();leitura.nextLine();
			this.titular.setTelemovel(atu1);
			}
		else if (escolha==6) {
			System.out.println("Insira o email atual do titular: ");
			atu2=leitura.nextLine();
			this.titular.setEmail(atu2);
			}
		else if (escolha==7) {
			System.out.println("Insira a morada atual do titular: ");
			atu2=leitura.nextLine();
			this.titular.setMorada(atu2);
			}

		}

}
