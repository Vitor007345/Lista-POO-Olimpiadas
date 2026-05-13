package main;

import java.util.Scanner;
import menu.Menu;
import olimpiada.*;

public class Program {
	
	private static Scanner scanner = new Scanner(System.in);
    private static DelegacaoOlimpica delegacao = new DelegacaoOlimpica();

    public static void main(String[] args) {
        
        Modalidade judo = new Modalidade(5, "Judo");
        Modalidade natacao = new Modalidade(15, "Natacao");
        delegacao.adicionarModalidade(judo);
        delegacao.adicionarModalidade(natacao);
        
        delegacao.adicionarMembro(new Atleta("Mayra Aguiar", "Femenino", 32, judo));
        delegacao.adicionarMembro(new ProfissionalSaude("Dr. Paulo", "Masculino", 45, "Fisioterapia"));
        
        

        Menu menuPrincipal = new Menu("SISTEMA OLÍMPICO");

        boolean[] sair = new boolean[] {false};
        menuPrincipal.addOption("Sair", () -> {sair[0] = true;});
        
        menuPrincipal.addOption("Adicionar Modalidade", () -> menuAdicionarModalidade());
        menuPrincipal.addOption("Adicionar Membro", () -> menuAdicionarMembro());
        menuPrincipal.addOption("Listar Modalidades", () -> {
            System.out.println("\n--- MODALIDADES ---");
            System.out.println(delegacao.listarModalidades());
        });
        menuPrincipal.addOption("Listar membros", () -> {
        	System.out.println("\n--- MEMBROS ---");
            System.out.println(delegacao.listarMembros());
        });
        menuPrincipal.addOption("Listar Tudo", () -> {
            System.out.println("\n--- MODALIDADES ---");
            System.out.println(delegacao.listarModalidades());
            System.out.println("--- MEMBROS ---");
            System.out.println(delegacao.listarMembros());
        });
        
       

        while (!sair[0]) {
            menuPrincipal.start();
        }
    }


    private static void menuAdicionarModalidade() {
        System.out.print("Descrição da Modalidade: ");
        String desc = scanner.nextLine();
        System.out.print("Limite de Membros: ");
        int limite = scanner.nextInt();
        scanner.nextLine();

        if (delegacao.adicionarModalidade(new Modalidade(limite, desc))) {
            System.out.println("Modalidade cadastrada!");
        } else {
            System.out.println("Erro: Modalidade já existe.");
        }
    }

    private static void menuAdicionarMembro() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Gênero: ");
        String gen = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Tipo: 1-Atleta, 2-Técnico, 3-Saúde");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 3) {
            System.out.print("Especialidade: ");
            String esp = scanner.nextLine();
            delegacao.adicionarMembro(new ProfissionalSaude(nome, gen, idade, esp));
        } else {
        	Modalidade mod = null;
        	do {
        		 System.out.print("Descrição da Modalidade: ");
                 String modDesc = scanner.nextLine();
                 mod = delegacao.getModalidade(modDesc);
                 if(mod == null) {
                	 System.out.println("Modalidade inexistentes, selecione uma dessas:");
                	 System.out.println(delegacao.listarModalidades());
                 }
        	}while(mod == null);
           
            
            
            
            if (tipo == 1) {
                if (delegacao.adicionarMembro(new Atleta(nome, gen, idade, mod))) 
                    System.out.println("Atleta adicionado!");
                else System.out.println("Erro: Limite atingido");
            } else {
                System.out.print("Atividade: ");
                String atividade = scanner.nextLine();
                if (delegacao.adicionarMembro(new Tecnico(nome, gen, idade, atividade, mod)))
                    System.out.println("Técnico adicionado!");
                else System.out.println("Erro: Limite atingido");
            }
        }
    }

}
