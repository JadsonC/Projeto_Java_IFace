
package projetc_java;

import java.util.Scanner;

public class Projetc_Java {
    static String [] login = new String[200];
    static String [] senha = new String[200];
    static String [] nick = new String[200];	

    public static void perfil_logado(int dados) {
        System.out.println("\n1 - ADICIONAR AMIGOS\n2 - VER MENSAGENS\n3 - LISTA DE AMIGOS\n4 - MINHAS COMUNIDADES\n5 - SAIR\n");    
        while(true){
            Scanner read = new Scanner (System.in);
            int opc = read.nextInt();
            
            if(opc == 5) break; 
        }
    } 
     
    public static void cadastro() {
        int i;
        String Login, Senha, Nick;
        Scanner read = new Scanner(System.in);       
        System.out.print("LOGIN que deseja cadastrar: ");        
        Login = read.nextLine();
        System.out.print("SENHA que deseja cadastrar: ");
        Senha = read.nextLine();        
        System.out.print("NOME DO USUÁRIO: ");        
        Nick = read.nextLine();    
        
        for(i =0; i< 200; i++) {
            if(login[i] == null) {
        	login[i] = Login;
        	senha[i] = Senha;
        	nick[i] = Nick;
        	break;
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");        
        System.out.print("CADASTRADO COM SUCESSO!");        
        //System.out.println("\n\n\n\n\n");            
    }
    
    public static void login() {
        
        while(true){
        int tru = 0, i;
        String Login, Senha;                  
        System.out.print("LOGIN: ");
        Scanner read = new Scanner(System.in);        
        Login = read.nextLine();        
        System.out.print("SENHA: ");        
        Senha = read.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
            for(i=0; i < 200; i++) {
                if(login[i] == null) {
                    System.out.println("Login e/ou senha inválidos. Não possui cadastro!");
                    int a = read.nextInt();
                    if(a == 1) return;
                    break;
                }
                else if(login[i].equals(Login) && senha[i].equals(Senha)){
                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    System.out.print("BEM-VINDO(A), ");
                    System.out.print(nick[i]);
                    System.out.println("!");
                    tru++;
                    break;
                }
            }
            if(tru != 0) perfil_logado(i);
        }    
    }

    public static void main(String[] args) {

            OUTER:
            while (true) {
                char opcoes;                
                System.out.println("                                        IFACE\n");
                System.out.println("1 - CADASTRAR-SE");
                System.out.println("2 - CONECTAR-SE");
                System.out.println("3 - SAIR\n");
                Scanner input = new Scanner(System.in);
                opcoes = input.next().charAt(0);
                
                switch (opcoes) {
                    case '1':
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");                        
                        cadastro();
                        break;
                    case '2':
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");        
                        login();
                        break;
                    case '3':
                        break OUTER;
                    default:
                        System.out.println("\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("Comando inválido");
                        System.out.println("\n\n\n\n\n");
                        
                        for(int i=0; i<200; i++) {
                            if(nick[i] == null) break; 
                            System.out.println(nick[i]);
                        }       
                    break;
                }
            }
    }
}

