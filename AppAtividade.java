/*
Integrantes do grupo:

Erick Neiva Fava - RA: - 21315943
Gustavo de Campos Araujo Caramelo - RA: 21308545
Marcio Pagliuco Cardoso - RA: 21337130
Matheus Rodrigues Mariano - RA: 20959588
*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AppAtividade {

    public static void main(String[] args) {

        String[][] dadosClientes = new String[5824][6];
        int count = 0;

        try {
            File file = new File("arquivoDados.csv");

            Scanner scanner = new Scanner(file);

            // enquanto não chegar ao final do arquivo
            while (scanner.hasNextLine()) {
                // leia a próxima linha do arquivo
                String linha = scanner.nextLine();
                // System.out.println(linha);

                // quebrando a linha por ","
                dadosClientes[count] = linha.split(",");

                // exibindo cada informação
                // for (int i = 0; i < dadosClientes[count].length; i++) {
                // System.out.print(dadosClientes[count][i] + " - ");
                // }

                count++;

            }

            scanner.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        PesquisaAtividade pesquisa = new PesquisaAtividade(dadosClientes);

        String nomePesquisa = "";
        Scanner sc = new Scanner(System.in);

        while (nomePesquisa.equals("exit") == false) {
            System.out.println();
            System.out.println("Digite um nome para pesquisar ou 'exit' para sair: ");
            nomePesquisa = sc.nextLine();
            System.out.println();

            if (nomePesquisa.equals("exit") == false) {

                int resultado = pesquisa.pesquisaBinaria(nomePesquisa);

                if (resultado == -1) {
                    System.out.println("Nome não encontrado");
                    System.out.println("Comparações: " + pesquisa.getComparacoes());
                } else {
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Nome encontrado na posição [" + resultado + "] do vetor" );
                    System.out.println();
                    //for (int i = 0; i < 7; i++) {
                    //    System.out.print(dadosClientes[resultado][i] + ", ");
                    //}
                    System.out.println("Nome: " + dadosClientes[resultado][0] + "\n" +
                    "Sexo: " + dadosClientes[resultado][1] + "\n" +
                    "Endereço: " + dadosClientes[resultado][2] + "\n" +
                    "Cidade: " + dadosClientes[resultado][3] + "\n" +
                    "E-mail: " + dadosClientes[resultado][4] + "\n" +
                    "Telefone: " + dadosClientes[resultado][5] + "\n" +
                    "Idade: " + dadosClientes[resultado][6] + "\n");
                    System.out.println("Comparações: " + pesquisa.getComparacoes());
                }
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
        }

    }

}
