
package main;
import java.util.Scanner;

public class Main {
    static String [] mensagens = new String[200]; 
    static String [] login = new String[200];
    static String [] senha = new String[200];
    static String [] nick = new String[200];  
    static int [][] amigos = new int[200][200];
    
    public static void excluir_perfil(int dados_logado) {
        int opc;
        Scanner read = new Scanner (System.in);
        System.out.println("             VOCÊ TEM CERTEZA QUE DESEJA EXCLUIR ESTA CONTA? TODOS OS DADOS SERÃO PERDIDOS!");
        System.out.println("1 - SIM\n2 - VOLTAR");
        opc = read.nextInt();
        
        if(opc == 1) {
            login[dados_logado] = "-1";
            senha[dados_logado] = null;
            nick[dados_logado]  = "-1";
            
            for(int i = 0; i < 200; i++) {
                amigos[dados_logado][i] = 0;
                amigos[i][dados_logado] = 0;                
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("CONTA EXCLUÍDA COM SUCESSO!");
            System.out.println("1 - VOLTAR AO MENU PRINCIPAL");
            opc = read.nextInt();
            
            if(opc == 1) return;
        }
        else if(opc == 2) return;
    }
    public static void perfil_logado(int dados_logado) {
      
    }

    public static void preenche_tabelas() {
        for(int i = 0; i <200; i++) {
            nick[i] = "-1";
        }
        for(int c = 0; c < 200; c++) {
            for(int l = 0; l <200; l++) {
                amigos[l][c] = 0;
            }
        }
    }

    public static void menu_logado(int dados) {
        while(true){
            if(nick[dados].equals("-1")) break;
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("BEM-VINDO(A), ");
            System.out.print(nick[dados]);
            System.out.println("!");            
            System.out.println("\n1 - ADICIONAR AMIGOS\n2 - VER MENSAGENS\n3 - LISTA DE AMIGOS\n4 - MINHAS COMUNIDADES\n5 - SOLICITAÇÕES DE AMIZADE\n6 - MEU PERFIL");
            System.out.println("7 - EXCLUIR CONTA\n8 - SAIR");
            Scanner read = new Scanner (System.in);
            int opc = read.nextInt();
            
            if(opc == 1) adicionar_amigos(dados); 
            else if(opc == 2) mensagens();
            else if(opc == 3) lista_amigos(dados);
            else if(opc == 4) minhas_comunidades();
            else if(opc == 5) solicitacoes_amizade(dados);
            else if(opc == 6) perfil_logado(dados);
            else if(opc == 7) excluir_perfil(dados);
            else if(opc == 8) break;
        }
    } 
    
    public static void solicitacoes_amizade(int dados_logado) {
        
        while(true){
            System.out.println("                       SOLICITAÇÕES:\n");
            for(int i = 0; i < 200; i++) {
                if(amigos[i][dados_logado] == 1) {
                    System.out.println(nick[i]);
                }
            }

            Scanner read = new Scanner(System.in);
            String usuario;
            System.out.println("1 - ACEITAR SOLICITAÇÕES\n2 - EXCLUIR SOLICITAÇÕES\n3 - VOLTAR");
            int opc = read.nextInt();

            if(opc == 1) {
                System.out.println("                       ACEITAR SOLICITAÇÕES");
                System.out.print("NOME DE USUÁRIO: ");
                Scanner read2 = new Scanner(System.in);        
                usuario = read2.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                for(int i = 0; i < 200; i++) {
                  if(nick[i].equals(usuario)) {
                    if(amigos[i][dados_logado] == 1) {
                      amigos[i][dados_logado] = 2;
                      amigos[dados_logado][i] = 2;                      
                      System.out.print("VOCÊ E ");
                      System.out.print(nick[i]);
                      System.out.println(" SÃO AMIGOS AGORA!\n");        
                    }
                    else System.out.println("NÃO HÁ SOLICITAÇOES DESSE USUÁRIO\n");
                    break;
                  }
                }
            }
            else if(opc == 2) {
                System.out.println("                       EXCLUIR SOLICITAÇÕES");
                System.out.print("NOME DE USUÁRIO: ");
                Scanner read2 = new Scanner(System.in);        
                usuario = read2.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");                
                for(int i = 0; i < 200; i++) {                    
                    if(nick[i].equals(usuario)) {
                        if(amigos[i][dados_logado] == 1) {
                            amigos[i][dados_logado] = 0;                      
                            System.out.println(" SOLICITAÇÃO EXCLUÍDA!\n");        
                    }
                    else System.out.println("NÃO HÁ SOLICITAÇOES DESSE USUÁRIO");
                    break;
                  }
                }
            }
            else if(opc == 3) {
                break;
            }
        }
    }

    public static void adicionar_amigos(int dados_logado) {
        int i;
        String usuario;
        int opc;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        while(true){        
            System.out.println("1 - PROCURAR");                
            System.out.println("2 - VOLTAR AO PERFIL");
            Scanner read = new Scanner(System.in);
            opc = read.nextInt();

            if(opc == 1){
                System.out.print("NOME DO USUÁRIO: ");
                Scanner read2 = new Scanner(System.in);                                
                usuario = read2.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

                for(i = 0; i < 200; i++) {
                    if(nick[i].equals(usuario)) {
                        amigos[dados_logado][i] = 1;
                        System.out.println("CONVITE ENVIADO COM SUCESSO!\n");
                        break;
                    }
                }
                if(i == 200) System.out.println("USUÁRIO NÃO ENCONTRADO!\n");
            }
            else if(opc == 2) {
                break;
            }           
        }
    }

    public static void mensagens() {
        
    }

    public static void lista_amigos(int dados_logado) {
        int opc;
        Scanner read = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        //while(true) {
            for(int i = 0; i < 200; i++) {
                if(amigos[dados_logado][i] == 2 && amigos[i][dados_logado] == 2) {
                    System.out.println(nick[i]);
                }
            }
            System.out.println("1 - VOLTAR");
            opc = read.nextInt();
            
            if(opc == 1) return;
            else lista_amigos(dados_logado);
        //}
    }

    public static void minhas_comunidades() {
            
    }

    public static void cadastro() {
        int i, opc;
        String Login, Senha, Nick;
        Scanner read = new Scanner(System.in);       
        System.out.print("LOGIN que deseja cadastrar: ");        
        Login = read.nextLine();
        System.out.print("SENHA que deseja cadastrar: ");
        Senha = read.nextLine();        
        System.out.print("NOME DO USUÁRIO: ");        
        Nick = read.nextLine();    
        
        for(i =0; i< 200; i++) {
            if(login[i] == null || login[i].equals("-1")) {
            login[i] = Login;
            senha[i] = Senha;
            nick[i] = Nick;
            break;
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");        
        System.out.println("CADASTRADO COM SUCESSO!");
        System.out.println("1 - VOLTAR AO MENU PRINCIPAL");
        opc = read.nextInt();
    }

    public static void login() {
        
        while(true){
        int tru = 0, i;
        String Login, Senha;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");                          
        System.out.print("LOGIN: ");
        Scanner read = new Scanner(System.in);        
        Login = read.nextLine();        
        System.out.print("SENHA: ");        
        Senha = read.nextLine();
        
            for(i=0; i < 200; i++) {
                if(login[i] == null) {
                    System.out.println("\nLOGIN E/OU SENHA INVÁLIDOS! NÃO POSSUI CADASTRO!\n");
                    System.out.println("1 - VOLTAR A TELA DE LOGIN!\n2 - VOLTAR AO MENU PRINCIPAL");                    
                    int a = read.nextInt();
                    if(a == 1) break;
                    else if(a == 2) return;
                    else continue;
                }
                else if(login[i].equals(Login) && senha[i].equals(Senha)){
                    tru++;
                    break;
                }
            }
            if(tru != 0) {
                menu_logado(i);
                break;
            }    
        }    
    }

    public static void main(String[] args) {
        preenche_tabelas();

            OUTER:
            while (true) {
                char opcoes;
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");                                
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
