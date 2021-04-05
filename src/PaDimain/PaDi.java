package PaDimain;
import  classes.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author RAFFAELE FIORILLO
 * */
public class PaDi {
	/**
	 * Metodo main
	 * */
	public static void main(String[] args) {
		ArrayList<ePass> passes=new ArrayList<ePass>();
		int numeroPasses=0;
		Scanner leitura=new Scanner(System.in);
		String comando;
		while (true) {
			System.out.println("Insira aqui o comando: ");
			comando=leitura.nextLine();
			limparEcra();
			if (validarComando(comando)) {
				if(comando.equals("novoPasse")) {
					numeroPasses++;
					int tipoP1;
					int valid=0;
					do {
						if (valid==1)
							System.out.println("Erro: Escolha invalida. Por favor,tente novamente.");
						limparEcra();
						System.out.println("Standard........... 1\nSazonal............2");
						System.out.println("Insira a sua escolha: ");
						tipoP1=leitura.nextInt(); leitura.nextLine(); // a segunda leitura  para libertar o buffer
						valid=1;
					}while (tipoP1!=2 && tipoP1!=1);
					if (tipoP1==1) {
						Titular tit=criarTitular();
						String tipoP2=determinarTipoPasseStandard(tit);
						if(tipoP2.equals("S"))
							passes.add(criarPasseStudent(tit,numeroPasses));
						else if(tipoP2.equals("J"))
							passes.add(criarPasseJovem(tit,numeroPasses));
						else if(tipoP2.equals("F"))
							passes.add(criarPasseFuncionario(tit,numeroPasses));
						else
							passes.add(criarPasseTerceiraIdade(tit,numeroPasses));
						}
					else {
						int tipoP2;
						valid=0;
						do {
							if (valid==1)
								System.out.println("Erro: Escolha invalida. Por favor,tente novamente.");
							System.out.println("Fest ........1\nTurista .....2");
							System.out.println("Insira a sua escolha: ");
							tipoP2=leitura.nextInt();leitura.nextLine(); // a segunda leitura  para libertar o buffer
							valid=1;
						}while(tipoP2!=1 && tipoP2!=2);
						if (tipoP2==1)
							passes.add(criarPasseFest(numeroPasses));
						else
							passes.add(criarPasseTurista(numeroPasses));
						}
					System.out.println("Novo passe "+ passes.get(passes.size()-1).getTipo()+" criado com sucesso. Codigo do novo passe: "+passes.get(passes.size()-1).getCodigo()+"; Chave do novo passe: "+passes.get(passes.size()-1).getChave());
					continue;
					}
				
				if(comando.equals("validarPasse")) {
					limparEcra();
					System.out.println("Insira o codigo do passe que deseja validar: ");
					int cod=leitura.nextInt();leitura.nextLine(); // a segunda leitura  para libertar o buffer
					if (numeroPasses<cod || cod<=0) {
						System.out.println("O passe referenciado nao existe.");
						continue;
						}
					System.out.println("O passe referenciado é valido.");
					continue;
					}
				
				if(comando.equals("carregarPasse")) {
					limparEcra();
					System.out.println("Insira o codigo do passe que deseja carregar: ");
					int cod=leitura.nextInt();
					if (numeroPasses<cod|| cod<=0) {
						System.out.println("Erro: codigo inexistente!");
						continue;
						}
					System.out.println("Insira a quantidade a ser tranferida: ");
					int quantia=leitura.nextInt();leitura.nextLine(); // a segunda leitura  para libertar o buffer
					passes.get(cod-1).carregarPasse(quantia);
					continue;
					}
				
				if(comando.equals("pagarViagem")) {
					limparEcra();
					System.out.println("Insira o codigo do passe a ser usado para o pagamento: ");
					int cod=leitura.nextInt();leitura.nextLine(); // a segunda leitura  para libertar o buffer
					if (numeroPasses<cod|| cod<=0) {
						System.out.println("Erro: codigo inexistente!");
						continue;
						}
					passes.get(cod-1).pagarViagem();
					continue;
					}
				
				if(comando.equals("alterarPasse")) {
					limparEcra();
					System.out.println("Insira o codigo do passe a ser usado para o pagamento: ");
					int cod=leitura.nextInt();leitura.nextLine(); // a segunda leitura para libertar o buffer
					if (numeroPasses<cod|| cod<=0) {
						System.out.println("Erro: codigo inexistente!");
						continue;
						}
					passes.get(cod-1).modificar();
					continue;
					}
				
				if(comando.equals("transferirSaldo")) {
					limparEcra();
					int codEmiss;
					int codRecept;
					do {
						System.out.println("Insira o codigo do passe emissor: ");
						codEmiss=leitura.nextInt();
						if (numeroPasses<codEmiss || codEmiss<=0) {
							System.out.println("Erro: codigo inexistente!");
							continue;
							}
						System.out.println("Insira o codigo do passe receptor: ");
						codRecept=leitura.nextInt();
						if (numeroPasses<codRecept || codRecept<=0) {
							System.out.println("Erro: codigo inexistente!");
							continue;
							}
						break;
					}while(true);
					System.out.println("Insira a quantidade a ser tranferida: ");
					int quantidade=leitura.nextInt();leitura.nextLine(); // a segunda leitura  para libertar o buffer
					if (quantidade<= passes.get(codEmiss-1).getSaldo()) {
						ePass passeEmissor=passes.get(codEmiss-1);
						passeEmissor.setSaldo(passeEmissor.getSaldo() - quantidade);
						ePass passeReceptor=passes.get(codRecept-1);
						passeReceptor.setSaldo(passeReceptor.getSaldo() + quantidade);
						}
					else
						System.out.println("Erro: Saldo insuficiente para realizar a tarefa!");
					continue;
					}
				
				if(comando.equals("terminar")) {
					limparEcra();
					System.out.println("At� a proxima!");
					break;
					}
				}
			else {
				limparEcra();
				System.out.println("O comando inserido � invalido. Tente outra vez!");
				continue;
				}
			}
		leitura.close();
		}
	
	/**
	 * Metodo validarComando
	 * verifica se o comando inserido  um comando valido
	 * @param comando
	 * */
	static boolean validarComando(String comando) {
		if (comando.equals("novoPasse")   || comando.equals("validarPasse") || comando.equals("carregarPasse")   || 
			comando.equals("pagarViagem") || comando.equals("alterarPasse") || comando.equals("transferirSaldo") || comando.equals("terminar")
		   )
			return true;
		return false;
		}
	
	/**
	 * Metodo limparEcra
	 * limpa a console mas so funciona se o programa for executado no terminal
	 * */
	static void limparEcra() {
    	System. out. flush();
		}
	
	/**
	 * Metodo criarTitular
	 * ajuda o utilizador a criar um Titular passo-a-passo
	 * */
	static Titular criarTitular() {
		Scanner leitura;
		DocumentoId doc=criarDocumento();
		leitura=new Scanner(System.in);
		int valid=0;
		String nome;
		do {
			if (valid==1)
				System.out.println("Erro: Nome invalido. Por favor, tente novamente.");
			System.out.println("Introduza o nome do Titular: ");
			nome=leitura.nextLine();
		}while(nome.split(" ").length<2);
		Data data=new Data(0,0,0,0,0,0);
		valid=0;
		do {
			if(valid==1)
				System.out.println("Erro: Data introduzida incorreta! Por favor tente novamente.");
			System.out.println("Introduza o ano de nascimento do Titular: ");
			int ano=leitura.nextInt();
			System.out.println("Introduza o mes de nascimento do Titular: ");
			int mes=leitura.nextInt();
			System.out.println("Introduza o dia de nascimento do Titular: ");
			int dia=leitura.nextInt();leitura.nextLine(); // a segunda leitura � para libertar o buffer
			data.setAno(ano);data.setMes(mes);data.setDia(dia);
			valid=1;
		}while(!data.validarData());
		System.out.println("Introduza a morada do Titular: ");
		String morada=leitura.nextLine();
		System.out.println("Introduza o email do Titular: ");
		String email=leitura.nextLine();
		System.out.println("Introduza o numero de telefone do Titular: ");
		int tel=leitura.nextInt();
		Titular t=new Titular(doc,nome,data,morada,email,tel);
		limparEcra();
		return t;
		}
	
	/**
	 * Metodo criarDocumento
	 * ajuda o utilizador a criar um Documento passo-a-passo
	 * */
	static DocumentoId criarDocumento() {
		Scanner leitura=new Scanner(System.in);
		int tipDoc;
		int valid=0;
		do {
			if (valid==1)
				System.out.println("Erro: Escolha invalida. Por favor,tente novamente.");
			System.out.println("Passaporte .........."+TipoDoc.intValueOf("Passaporte")+"\n"+
						   	   "BI .................."+TipoDoc.intValueOf("BI")+"\n"+
						       "Carta de Condu�ao ..."+TipoDoc.intValueOf("CartaDeConducao")
		                      );
			System.out.println("Escolha o documento a utilizar: ");
			tipDoc=leitura.nextInt(); leitura.nextLine(); // a segunda leitura para libertar o buffer 
			valid=1;
		}while(tipDoc<=0 || tipDoc>3);
		TipoDoc tipo= TipoDoc.valueByInt(tipDoc);
		System.out.println("Insira o codigo do documento: ");
		String codigo=leitura.nextLine();
		DocumentoId doc=new DocumentoId(tipo,codigo);
		return doc;
		}
	
	/**
	 * Metodo criarEvento
	 * ajuda o utilizador a criar um Evento passo-a-passo
	 * */
	static Evento criarEvento() {
		Scanner leitura=new Scanner(System.in);
		System.out.println("Insira o nome do evento: ");
		String nome=leitura.nextLine();
		Data dataAtual=new Data(0,0,0,0,0,0);dataAtual.toDataAtual();
		//assume-se que o evento occorre no ano em que adquirido o passe
		Data dataInicio=new Data(dataAtual.getAno(),0,0,0,0,0);
		int valid=0;
		do {
			if (valid==1)
				System.out.println("Erro: A data inserida � invalida. Por favor, tente novamente!");
			System.out.println("Insira o mes em que inicia o evento: ");
			int mesI=leitura.nextInt();
			dataInicio.setMes(mesI);
			System.out.println("Insira o dia em que inicia o evento: ");
			int diaI=leitura.nextInt();
			dataInicio.setDia(diaI);
			valid=1;
		}while(!dataInicio.validarData());
		System.out.println("Insira o numero de dias que o evento dura: ");
		int duracao=leitura.nextInt();
		Data dataFim=dataInicio.clone();dataFim.somaDias(duracao);
		return new Evento(dataInicio,dataFim,nome);
		}
	
	/**
	 * Metodo determinarTipoPasse
	 * diz que tipo de passe Standard o titular deve ter com base na sua idade
	 * @param tit
	 * */
	static String determinarTipoPasseStandard(Titular tit) {
		Data dataNasc=tit.getDataNascimento().clone();
		Data dataAtual=new Data(0,0,0,0,0,0); dataAtual.toDataAtual();
		Data idade=dataAtual.clone().diferencaDatas(dataNasc);
		if (idade.getAno()<19) {
			return "S";}
		else if (idade.getAno()>=19 && idade.getAno()<25) {
			return "J";}
		else if (idade.getAno()>=25 && idade.getAno()<66) {
			return "F";}
		return "T";
		}
	
	/**
	 * Metodo criarPasseStudent
	 * ajuda o utilizador a criar um Passe Student passo-a-passo
	 * @param t
	 * @param cod
	 * */
	static Student criarPasseStudent(Titular t, int cod) {
		Scanner leitura=new Scanner(System.in);
		System.out.println("Insira o ano escolar do titular: ");
		String anoE=leitura.nextLine();
		System.out.println("Insira o estabelecimento da escola do titular: ");
		String estE=leitura.nextLine();
		ArrayList<String> zonas=new ArrayList<String>();
		String zona;
		while (true) {
			System.out.println("Insira as zonas livres escolhidas pelo titular (insira 0 para parar): ");
			zona=leitura.nextLine();
			if (zona.contentEquals("0"))
				break;
			zonas.add(zona);
			}
		Student stud=new Student(cod, t, anoE, estE, zonas);
		return stud;
		}

	/**
	 * Metodo criarPasseJovem
	 * cria um Passe Jovem
	 * @param tit
	 * @param cod
	 * */
	static Jovem criarPasseJovem(Titular tit,int cod) {
		return new Jovem(cod,tit);
		}
	
	/**
	 * Metodo criarPasseFuncionario
	 * cria um Passe Funcionario
	 * @param tit
	 * @param cod
	 * */
	static Funcionario criarPasseFuncionario(Titular tit,int cod) {
		return new Funcionario(cod,tit);
		}
	
	/**
	 * Metodo criarPasseTerceiraIdade
	 * cria um Passe TerceiraIdade
	 * @param tit
	 * @param cod
	 * */
	static TerceiraIdade criarPasseTerceiraIdade(Titular tit,int cod) {
		return new TerceiraIdade(cod,tit);
		}
	
	/**
	 * Metodo criarPasseFest
	 * ajuda o utilizador a criar um Passe Fest passo-a-passo
	 * @param cod
	 * */
	static Fest criarPasseFest(int cod) {
		Scanner leitura = new Scanner(System.in);
		Evento evento=criarEvento();
		int escBilh;
		int valid=0;
		do {
			if (valid==1)
				System.out.println("Erro: Escolha incorreta! Por favor, tente novamente.");
			System.out.println("Deseja adquirir logo o bilhete para o evento?\nSim....1\nNao....2");
			escBilh=leitura.nextInt();
			valid=1;
		}while( escBilh!=1 && escBilh!=2);
		boolean bilh;
		if (escBilh==1) {
			int preco;
			valid=0;
			do {
				if (valid==1)
					System.out.println("Erro: Quantia insuficiente! Por favor, tente novamente.");
				System.out.println("Insira o pagamento do bilhete (500$): ");
				preco=leitura.nextInt();
				valid=1;
			}while(preco<500);
			bilh=true;
			}
		else
			bilh=false;
		return new Fest(cod,evento,bilh);
		}
	
	/**
	 * Metodo verificarQuantiaTurista
	 * verifica com base na escolha feita do numero de dias validos se a quantia entregue basta para realizar o pagamento
	 * @param escolha
	 * @param quantia
	 * */
	static boolean verificarQuantiaTurista(int escolha, int quantia) {
		if (escolha==1 && quantia <500)
			return false;
		if (escolha==3 && quantia <700)
			return false;
		if (escolha==7 && quantia <1500)
			return false;
		else if (escolha==1) {
			if (quantia==500)
				return true;
			else {
				System.out.println("Tome o seu troco: "+(quantia-500));
				return true;
				}
			}
		else if (escolha==3) {
			if (quantia==700)
				return true;
			else {
				System.out.println("Tome o seu troco: "+(quantia-700));
				return true;
				}
			}
		else if (escolha==7) {
			if (quantia==1500)
				return true;
			else {
				System.out.println("Tome o seu troco: "+(quantia-1500)+"$");
				return true;
				}
			}
		return false;
		}
	
	/**
	 * Metodo criarPasseTurista
	 * ajuda o utilizador a criar um Passe Turista passo-a-passo
	 * @param cod
	 * */
	static Turista criarPasseTurista(int cod) {
		Scanner leitura=new Scanner(System.in);
		System.out.println("Dias de validade          Pre�o");
		System.out.println("1 ....................... 500$\n"+
				           "3 ....................... 700$\n"+
				           "7........................ 1500$");
		int escolha;
		int valid=0;
		do {
			if (valid==1)
				System.out.println("Erro: Escolha invalida! Por favor, tente novamente.");
			System.out.println("Insira o numero de dias de validade do passe que deseja adquirir: ");
			escolha=leitura.nextInt();
			valid=1;
		}while(escolha!=1 && escolha!=3 && escolha!=7 );
		int quantia;
		valid=0;
		do {
			if (valid==1)
				System.out.println("Erro: Quantia insuficiente! Por favor, tente novamente.");
			System.out.println("Insira a quantia para o pagamento do passe: ");
			quantia=leitura.nextInt();
			valid=1;
		}while(!verificarQuantiaTurista(escolha,quantia));
		if (escolha==1)
			quantia=500;
		if (escolha==3)
			quantia=700;
		if (escolha==7)
			quantia=1500;
		return new Turista(cod,quantia);
		}
}
