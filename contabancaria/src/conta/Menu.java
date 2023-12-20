package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		while (true) {
			abrirMenu();
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}
			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "BANCO DOS DEVS - Obrigado pela preferência!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar Conta\n\n");

				System.out.println("Digite o número da Agência: ");
				agencia = leia.nextInt();
				System.out.println("Digite o nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.println("Digite o Tipo da Conta (1- Conta Corrente ou 2- Conta Poupança): ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédtio (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Dgite o dia do Aniversário da Conta: ");
						aniversario = leia.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
				}

				KeyPress();
				break;
			case 2:
				System.out.println("Listar todas as Contas\n\n");
				contas.listarTodas();
				KeyPress();
				break;
			case 3:
				System.out.println("Consultar dados da Conta - por número\n\n");
				KeyPress();

				break;
			case 4:
				System.out.println("Atualizar dados da Conta\n\n");
				KeyPress();

				break;
			case 5:
				System.out.println("Apagar a Conta\n\n");
				KeyPress();

				break;
			case 6:
				System.out.println("Saque\n\n");
				KeyPress();

				break;
			case 7:
				System.out.println("Depósito\n\n");
				KeyPress();

				break;
			case 8:
				System.out.println("Transferência entre Contas\n\n");
				KeyPress();

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				KeyPress();

				break;
			}
		}

	}

	public static void abrirMenu() {
		System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
				+ "*******************************************************");
		System.out.println("*                                                     *");
		System.out.println("*              💻   BANCO DOS DEVS   💻               *");
		System.out.println("*                                                     *");
		System.out.println("*******************************************************");
		System.out.println("*                                                     *");
		System.out.println("*            1 - Criar Conta                          *");
		System.out.println("*            2 - Listar todas as Contas               *");
		System.out.println("*            3 - Buscar Conta por Numero              *");
		System.out.println("*            4 - Atualizar Dados da Conta             *");
		System.out.println("*            5 - Apagar Conta                         *");
		System.out.println("*            6 - Sacar                                *");
		System.out.println("*            7 - Depositar                            *");
		System.out.println("*            8 - Transferir valores entre Contas      *");
		System.out.println("*            9 - Sair                                 *");
		System.out.println("*                                                     *");
		System.out.println("*******************************************************");
		System.out.println("* Entre com a opção desejada:                         *");
		System.out.println("                                                       " + Cores.TEXT_RESET);
	}

	public static void sobre() {
		System.out.println();
		System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + "*******************************************************");
		System.out.println("* Projeto Desenvolvido por:                           *");
		System.out.println("* Nathan Nolacio - nathannolacio04@gmail.com          *");
		System.out.println("* github.com/nathannolacio/projetoContaBancaria       *");
		System.out.println("*******************************************************");
	}

	public static void KeyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de Enter.");
		}
	}

}
