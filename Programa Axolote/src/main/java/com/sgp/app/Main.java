package main.java.com.sgp.app;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.com.sgp.model.Axolote;

public class Main {

    // ================= VALIDAÇÕES =================

    public static String validarNome(Scanner sc) {

        String nome;

        while (true) {

            nome = sc.nextLine();

            if (nome.trim().isEmpty()) {
                System.out.print("Nome não pode estar vazio. Digite novamente: ");
            }

            else if (!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
                System.out.print("Nome não pode conter números. Digite novamente: ");
            }

            else {
                return nome;
            }

        }
    }

    public static int validarIdade(Scanner sc) {

        int idade;

        while (true) {

            if (!sc.hasNextInt()) {

                System.out.print("Idade deve ser um número. Digite novamente: ");
                sc.next();
                continue;

            }

            idade = sc.nextInt();
            sc.nextLine();

            if (idade < 0 || idade > 20) {

                System.out.print("Idade inválida (0 a 20). Digite novamente: ");

            }

            else {

                return idade;

            }

        }
    }

    public static String validarTexto(Scanner sc, String campo) {

        String texto;

        while (true) {

            texto = sc.nextLine();

            if (texto.trim().isEmpty()) {

                System.out.print(campo + " não pode estar vazio. Digite novamente: ");

            }

            else {

                return texto;

            }

        }

    }

    public static int validarMenu(Scanner sc) {

        while (!sc.hasNextInt()) {

            System.out.print("Digite apenas números: ");
            sc.next();

        }

        int opcao = sc.nextInt();
        sc.nextLine();

        return opcao;
    }

    public static int validarIndice(Scanner sc, int tamanhoLista) {

        int indice;

        while (true) {

            if (!sc.hasNextInt()) {

                System.out.print("Digite um número válido: ");
                sc.next();
                continue;

            }

            indice = sc.nextInt();
            sc.nextLine();

            if (indice < 0 || indice >= tamanhoLista) {

                System.out.print("Índice inválido. Escolha novamente: ");

            }

            else {

                return indice;

            }

        }

    }

    // ================= MÉTODOS AUXILIARES =================

    public static String escolherCor(Scanner sc) {

        String[] cores = {
            "Rosa",
            "Branco",
            "Preto",
            "Dourado",
            "Azul"
        };

        System.out.println("Cores disponíveis:");

        for (int i = 0; i < cores.length; i++) {
            System.out.println((i + 1) + " - " + cores[i]);
        }

        int escolha = validarMenu(sc);

        if (escolha < 1 || escolha > cores.length) {
            System.out.println("Opção inválida! Cor definida como Rosa.");
            return "Rosa";
        }

        return cores[escolha - 1];
    }

    public static void listarAxolotes(ArrayList<Axolote> axolotes) {

        if (axolotes.isEmpty()) {
            System.out.println("Nenhum axolote criado.");
            return;
        }

        for (int i = 0; i < axolotes.size(); i++) {
            System.out.println("Axolote #" + i);
            axolotes.get(i).mostrarDados();
        }

    }

    // ================= MAIN =================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Axolote> axolotes = new ArrayList<>();

        int opcao;

        do {

            System.out.println("\n=== MENU AXOLOTE ===");
            System.out.println("1 - Criar Axolote");
            System.out.println("2 - Listar Axolotes");
            System.out.println("3 - Alterar Habitat");
            System.out.println("4 - Alterar Idade");
            System.out.println("5 - Alimentar Axolote");
            System.out.println("0 - Sair");

            System.out.print("Escolha: ");

            opcao = validarMenu(sc);

            switch (opcao) {

                case 1:

                    System.out.print("Nome do Axolote: ");
                    String nome = validarNome(sc);

                    String cor = escolherCor(sc);

                    System.out.print("Comida favorita: ");
                    String comida = validarTexto(sc, "Comida");

                    System.out.print("Habitat: ");
                    String habitat = validarTexto(sc, "Habitat");

                    System.out.print("Idade: ");
                    int idade = validarIdade(sc);

                    Axolote novo = new Axolote(nome, cor, comida, habitat, idade);

                    axolotes.add(novo);

                    System.out.println("Axolote criado com sucesso!");

                    break;

                case 2:

                    listarAxolotes(axolotes);

                    break;

                case 3:

                    listarAxolotes(axolotes);

                    System.out.print("Escolha o axolote: ");
                    int indiceHabitat = validarIndice(sc, axolotes.size());

                    System.out.print("Novo habitat: ");
                    String novoHabitat = validarTexto(sc, "Habitat");

                    axolotes.get(indiceHabitat).setHabitat(novoHabitat);

                    System.out.println("Habitat alterado!");

                    break;

                case 4:

                    listarAxolotes(axolotes);

                    System.out.print("Escolha o axolote: ");
                    int indiceIdade = validarIndice(sc, axolotes.size());

                    System.out.print("Nova idade: ");
                    int novaIdade = validarIdade(sc);

                    axolotes.get(indiceIdade).setIdade(novaIdade);

                    System.out.println("Idade alterada!");

                    break;

                case 5:

                    listarAxolotes(axolotes);

                    System.out.print("Escolha o axolote: ");
                    int indiceComida = validarIndice(sc, axolotes.size());

                    System.out.print("O que ele vai comer: ");
                    String comidaNova = validarTexto(sc, "Comida");

                    axolotes.get(indiceComida).setComida(comidaNova);

                    System.out.println("Agora ele está comendo " + comidaNova);

                    break;

                case 0:

                    System.out.println("Saindo...");
                    break;

                default:

                    System.out.println("Opção inválida!");

            }

        } while (opcao != 0);

        sc.close();
    }

}