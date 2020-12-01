package br.edu.univas.main;

import java.util.Scanner;
import br.edu.univas.vo.*;

public class StartApp {
	
	static Scanner input = new Scanner (System.in);
	
	public static void main(String[] args) {

		Conta [] contas = new Conta [3];
		
		
		do {
			imprimirMenu();
			System.out.printf("\n");
			int opcao = input.nextInt();
			if(opcao == 1){
				cadastrarContas(contas);
			}else if (opcao == 2){
				saldoConta(contas);
			}else if (opcao == 3 ){
				break;
			}else {
				System.out.printf("Opcão Inválida!!\n");
			}
			
			
			
		}while (true);
		
	}public static void imprimirMenu () {
		
		System.out.printf("1. Cadastro de Conta\r\n"
				+ "2. Ver Saldo\r\n"
				+ "3. Sair");
		
	}public static void cadastrarContas (Conta [] conta) {
		for (int i = 0; i < conta.length; i++) {
			Conta contas = new Conta ();
			System.out.printf("Descrição:");
			contas.descricao = input.next();
			System.out.printf("Data de Movimento:");
			contas.dataMovimento = input.next();
			System.out.printf("Tipo:");
			contas.tipo = input.next();
			System.out.printf("Valor:");
			contas.valor = input.nextFloat();
			conta[i] = contas;
		}

	}/*public static void imprimirContas (Conta [] conta) {    // conferir contas
		for (int i = 0; i < conta.length; i++) {
			if(conta != null) {
				Conta contas = conta [i]; 
				
				System.out.printf("Descrição: %s Data de Movimento: %s\n"
								+ "Tipo: %s\n"
								+ "Valor: %s\n\n",
								contas.descricao, contas.dataMovimento, contas.tipo, contas.valor);
			}
		}
	}*/
	public static void saldoConta (Conta [] conta) {
		float totalReceita = 0;
		float totalDespesa = 0;
		for (int i = 0; i < conta.length; i++) {
			if (conta[i] != null) {
				Conta contas = conta[i];
				if (contas.tipo.equalsIgnoreCase("Receita")) {
					totalReceita = contas.valor + totalReceita;
				} else if (contas.tipo.equalsIgnoreCase("Despesa")) {
					totalDespesa = contas.valor + totalDespesa;
				}
			}
		}
		
		float saldoTotal = totalReceita - totalDespesa;
		if (saldoTotal < 0) {
			System.out.printf("Seu saldo atual é: R$%.2f\n\n", saldoTotal);			
		}else if (saldoTotal == 0) {
			System.out.printf("Seu saldo atual é: R$%.2f\n\n", saldoTotal);
		}else if (saldoTotal > 0) {
			System.out.printf("Seu saldo atual é: R$+%.2f\n\n", saldoTotal);
		}
		

	}
}
