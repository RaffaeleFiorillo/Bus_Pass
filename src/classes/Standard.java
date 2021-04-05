package classes;
import java.util.ArrayList;
/**
 * @author RAFFAELE FIORILLO
 * */
public abstract class Standard extends ePass {
		protected int pontos;
		protected int numViagens;
		protected Titular titular;
		
		/**
		 * Metodo gerarChave
		 * gera uma chave valida para o passe
		 * */
		protected String gerarChave() {
			ArrayList<String> nomeCompleto= new ArrayList<String>();
			for (String n: titular.getNome().split(" ")) {
				nomeCompleto.add(n.toUpperCase());
				}
			while(nomeCompleto.size()!=2) {
				nomeCompleto.remove(1);
				}
			String n2="";String n3="";
			n2=nomeCompleto.get(0).substring(0,5);
			n3=nomeCompleto.get(1).substring(0,5);
			nomeCompleto.add(n2);
			nomeCompleto.add(n3);
			nomeCompleto.remove(0);
			nomeCompleto.remove(0);
			n2=""; n3="";
			for (String n: nomeCompleto) {
				for(int i=n.length()-1; i>=0;i--) {
					if (nomeCompleto.indexOf(n)==0)
						n2+=n.charAt(i);
					else
						n3+=n.charAt(i);
					}
				}
			nomeCompleto.add(n2);
			nomeCompleto.add(n3);
			nomeCompleto.remove(0);
			nomeCompleto.remove(0);		
			String dataC=titular.getDataNascimento().dataToString();
			return n2+n3+dataC+codigo;
			}
		
		/**
		 * Metodo pagarViagem
		 * efetua o pagamento de uma viagem
		 * */
		@Override
		public void pagarViagem() {
			if (saldo<precoViagem) {
				if (pontos<101) {
					System.out.println("Lamentamos informar que o saldo disponivel nao permite realizar o pagamento.");
					}
				else {
					pontos-=40;
					System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Pontos. Numero de pontos restantes: "+this.pontos);
					}
				}
			else {
				saldo-=precoViagem;
				atualizarPontos();
				System.out.println("Pagamento efetuado com sucesso! Recurso utilizado: Saldo. Saldo restante: "+this.saldo);
				}
			}
		
		/**
		 * Metodo carregarPasse
		 * recarrega o passe com uma certa quantia
		 * */
		@Override
		public void carregarPasse(int quantia) {
			if (quantia>0) {
				this.saldo+=quantia;
				System.out.println("Recarga do Passe "+this.tipo+" efetuada com sucesso!");
				}
			System.out.println("Lamentamos informar, mas a quantia introduzida nao é valida para realizar a recarga do Passe.");
			}
		
		/**
		 * Metodo getPontos
		 * return pontos
		 * */
		public int getPontos() {
			return pontos;
			}
		
		/**
		 * Metodo getNumViagens
		 * return numViagens
		 * */
		public int getNumviagens() {
			return numViagens;
			}
		
		/**
		 * Metodo getTitular
		 * return titular
		 * */
		public Titular getTitular() {
			return titular;
			}
		
		/**
		 * Metodo atualizarPontos
		 * aumenta o numero de viagens ate atingir o numero necessario para ganhar um ponto e depois recomeca
		 * */
		protected void atualizarPontos() {
			this.numViagens++;
			if(this.numViagens==10) {
				this.pontos++;
				this.numViagens=0;
				}
			}

}
