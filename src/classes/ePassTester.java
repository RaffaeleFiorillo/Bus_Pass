package classes;
import java.util.ArrayList;
import java.util.Scanner;

public class ePassTester {

	public static void main(String[] args) {
		Data dataT=new Data(2000,9,7,4,36,49);
		TipoDoc t=TipoDoc.Passaporte;
		DocumentoId docT=new DocumentoId(t,"dasflk32k");
		Titular titularJ= new Titular(docT,"Raffaele Fiorillo Junior",dataT,"Madeiralzinho","raffadeus8@gmail.com",9891711);
		Data dataE=new Data(2020,6,29,12,14,22);
		Titular tit=new Titular(docT,"Ruisaha Jorge Santos Duarte Silva Varela",dataT,"Dgi d'Sal","rvarela@uta.cv",9770154);
		Jovem j=new Jovem(10,tit);
		System.out.println(j.getChave());
		}
	
}
