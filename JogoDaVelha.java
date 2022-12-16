"# JogoDaVelha" 

  
import java.util.Scanner;
import javax.swing.JOptionPane;
public class JogoDaVelha {
		  private int [][] tabuleiro = new int [3][3];
		  private int jogador = 1;
		  
		  public boolean jogar (int x, int y) {
			  if((x < 0) || (x > 2) || (y < 0) || (y > 2)){
				  return false;
			  }
			  if(tabuleiro[x][y] != 0) {
				  return false;
			  }
			  tabuleiro [x][y] = jogador;
			  jogador = (jogador == 1)? 2: 1;
			  return true;
			  
		  }
		  public int vencedor () {
			  // testa as linhas
			  for(int i = 0; i < 3; i++) {
				  for(int linha = 0; linha < 3; linha++) {
					  boolean fechou = true;
					  for(int coluna = 0; coluna < 3; coluna++) {
						  if(tabuleiro [coluna][linha] != i) {
							  fechou = false;
						  }  
					  }
					  if(fechou) {
						  return i;
					  }
				  }
				  // testa as colunas
				  for(int coluna = 0; coluna < 3; coluna++) {
					  	boolean fechou = true;
					  	for(int linha = 0; linha < 3; linha++) {
					  		if(tabuleiro[coluna][linha] !=i) {
					  			fechou = false;
					  		}
					  	}
					  	if(fechou) {
					  		return i;
					  	}
				  }
				  // testa a diagonal
				  boolean fechou = true;
				  for(int posicao = 0; posicao < 3; posicao++) {
					  if(tabuleiro [posicao][posicao] != i) {
						  fechou = false;
					  }
				  }
				  if(fechou) {
					  return i;
				  }
				  fechou = true;
				  for(int posicao = 2; posicao >=0; posicao--) {
					  if(tabuleiro [posicao][2-posicao] != i) {
						  fechou = false;
					  }
				  }
				  if(fechou) {
					  return i;
				  }
			  }
			  boolean 	empate = true;
			  for(int linha = 0; linha < 3; linha++) {
				  for(int coluna = 0; coluna < 3; coluna ++ ) {
					  if(tabuleiro[coluna][linha]== 0) {
						  empate = false;
					  }
				  }
			  }
			  if(empate) {
				  return 3;
			  }
			  return 0;
		  }
		  public String toString() {
			  String out="";
			  for(int linha = 0; linha < 3; linha++) {
				  for(int coluna = 0; coluna < 3; coluna++) {
					  switch (tabuleiro[coluna][linha]) {
					  case 0  : 
						  out += " | _ | ";
						  break;
					  case 1 :
						  out += " | X | ";
						  break;
					  case 2 :
						  out += " | O | ";
						  break;
						  
					  } 
				  }
				  out += "\n";
			  }
			  return out;
		  }
		  public void iniciar () {
			  Scanner entrada = new Scanner (System.in);
			  String coluna="", linha="";
			  
			  while(vencedor()==0 & coluna!=null & linha!=null) {
				  JOptionPane.showMessageDialog(null, this);;
				  JOptionPane.showMessageDialog(null, "Jogador: "+ jogador);
				  coluna = JOptionPane.showInputDialog( "Digite a coluna que deseja jogar\n0\n1\n2");
				  linha = JOptionPane.showInputDialog( "Digite a linha que deseja jogar\n0\n1\n2");
				  
				  if(coluna==null | linha == null) {
					  JOptionPane.showMessageDialog(null,"Valores Invalidos, Programa encerrado");
				  }
				  else if(!jogar(Integer.parseInt(coluna), Integer.parseInt(linha))) {
					  JOptionPane.showMessageDialog(null,"Jogada invalida, tente novamente...");
					  
				  }
				  
				  }
			  if(coluna!=null || linha != null) {
				  JOptionPane.showMessageDialog(null,this);
				  JOptionPane.showMessageDialog(null,vencedor());
			  }
			 
		      switch (vencedor()) {
		       case 1 :
		    	   JOptionPane.showMessageDialog(null,"Vencedor jogador 1!!!!!!!!!!!!!");
				 break;
		        case 2:
		        	JOptionPane.showMessageDialog(null,"Vencedor jogador 2!!!!!!!!!!!!!!!");
				 break;
			    case 3:
			    	JOptionPane.showMessageDialog(null,"Velha");
				 break;
		}
		  }
		  public static void main (String [] args) {
			  JogoDaVelha jogo = new JogoDaVelha();
			  jogo.iniciar();
			  
			 
			  
		  }	
  }
