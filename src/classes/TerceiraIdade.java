package classes;
import java.util.Scanner;
/**
 * @author RAFFAELE FIORILLO
 * */
public class TerceiraIdade extends Standard{

	/**
	 * Metodo TerceiraIdadde
	 * @param c
	 * @param t
	 * */
	public TerceiraIdade(int c,Titular t) {
		this.codigo=c;
		this.dataEmissao=dataPadrao.clone();dataEmissao.toDataAtual();
		this.titular=t;
		this.pontos=0;
		this.numViagens=0;
		this.saldo=0;
		this.precoViagem=40;
		this.dataLimite=null;
		this.chave=gerarChave();
		this.tipo="Standard: TerceiraIdade";
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
			System.out.println("Atualizar telefone do titular ..........1\n"+
							   "Atualizar email do titular .............2\n"+
							   "Atualizar morada do titular ............3\n"+
							   "Sair ...................................4"
							   );	
			escolha=leitura.nextInt();leitura.nextLine(); // a segunda leitura para libertar o buffer
			valid=1;
		}while(escolha<1&&escolha>4);
		int atu1;String atu2;
		if (escolha==1) {
			System.out.println("Insira o telefone atual do titular: ");
			atu1=leitura.nextInt();leitura.nextLine(); // a segunda leitura  para libertar o buffer
			this.titular.setTelemovel(atu1);
			}
		else if (escolha==2) {
			System.out.println("Insira o email atual do titular: ");
			atu2=leitura.nextLine();
			this.titular.setEmail(atu2);
			}
		else if (escolha==3) {
			System.out.println("Insira a morada atual do titular: ");
			atu2=leitura.nextLine();
			this.titular.setMorada(atu2);
			}
		}
}
