package classes;
import java.util.Scanner;
/**
 * @author RAFFAELE FIORILLO
 * */
public class Funcionario extends Standard {
	int valorDeRecarga=3000;
	
	/**
	 * Metodo Funcionario
	 * @param c
	 * @param t
	 * */
	public Funcionario(int c, Titular t) {
		this.codigo=c;
		this.dataEmissao=dataPadrao.clone();dataEmissao.toDataAtual();
		this.titular=t;
		this.pontos=0;
		this.numViagens=0;
		this.saldo=0;
		this.precoViagem=0;
		this.dataLimite=dataPadrao.clone();
		this.chave=gerarChave();
		this.tipo="Standard: Funcionario";
		}
	
	/**
	 * Metodo carregarPasse
	 * recarrega o passe com uma certa quantia
	 * */
	@Override
	public void carregarPasse(int quantia) {
		if (quantia>valorDeRecarga) {
			saldo=valorDeRecarga; 
			System.out.println("Recarga do Passe "+ this.tipo+" efetuada com sucesso!");
			System.out.println("Seu troco é: "+(quantia-valorDeRecarga)+"$.");
			dataLimite.toDataAtual();dataLimite.somaDias(30);
			}
		else if(quantia==valorDeRecarga) {
			System.out.println("Recarga do Passe Funcionario efetuada com sucesso!");
			saldo=valorDeRecarga;
			dataLimite.toDataAtual();dataLimite.somaDias(30);
			}
		System.out.println("Lamentamos informar, mas a quantia introduzida nao permite realizar a recarga.");
		}
	
	/**
	 * Metodo pagarViagem
	 * efetua o pagamento de uma viagem
	 * */
	@Override
	public void pagarViagem() {
		Data dAtual=dataPadrao.clone(); dAtual.toDataAtual();
		if (saldo==valorDeRecarga) {
			if (dataLimite.vemDepois(dAtual)) {
					System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Saldo.");
					atualizarPontos();
					}
			}
		else if(pontos>100) {
				pontos-=40;
				System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Pontos. Numero de pontos restantes: "+this.pontos);
				atualizarPontos();
				}
		else {
			System.out.println("Lamentamos informar que a data de validade escedeu e que nao dispoe de pontos suficientes. Por favor, efetuar a recarga para continuar.");
			saldo=0;
			}
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
			System.out.println(" Preco de recarga .......................1\n"+
								"Atualizar telefone do titular ..........2\n"+
								"Atualizar email do titular .............3\n"+
								"Atualizar morada do titular ............4\n"+
							    "Sair ...................................5");	
			escolha=leitura.nextInt();leitura.nextLine(); // a segunda leitura para libertar o buffer
			valid=1;
		}while(escolha<1&&escolha>5);
		int atu1; String atu2;
		if (escolha==1) {
			System.out.println("Insira o novo preco de recarga:");
			this.valorDeRecarga=leitura.nextInt();
			}
		else if (escolha==2) {
			System.out.println("Insira o telefone atual do titular: ");
			atu1=leitura.nextInt();leitura.nextLine(); // a segunda leitura para libertar o buffer
			this.titular.setTelemovel(atu1);
			}
		else if (escolha==3) {
			System.out.println("Insira o email atual do titular: ");
			atu2=leitura.nextLine();
			this.titular.setEmail(atu2);
			}
		else if (escolha==4) {
			System.out.println("Insira a morada atual do titular: ");
			atu2=leitura.nextLine();
			this.titular.setMorada(atu2);
			}
		}
}