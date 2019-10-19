
import java.util.Scanner;

public class Main {
    static String [] login = new String[200];
    static String [] senha = new String[200];
    static String [] nick = new String[200];	
    static int [][] amigos = new int[200][200];
    
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

    public static void perfil_logado(int dados) {
        while(true){
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("BEM-VINDO(A), ");
            System.out.print(nick[dados]);
            System.out.println("!");            
            System.out.println("\n1 - ADICIONAR AMIGOS\n2 - VER MENSAGENS\n3 - LISTA DE AMIGOS\n4 - MINHAS COMUNIDADES\n5 - SOLICITAÇÕES DE AMIZADE\n6 - SAIR\n");            
            Scanner read = new Scanner (System.in);
            int opc = read.nextInt();
            
            if(opc == 1) adicionar_amigos(dados); 
            else if(opc == 2) mensagens();
            else if(opc == 3) lista_amigos();
            else if(opc == 4) minhas_comunidades();
            else if(opc == 5) solicitacoes_amizade(dados);
            else if(opc == 6) break;
        }
    } 
    
    public static void solicitacoes_amizade(int dados_logado) {
        System.out.println("SOLICITAÇÕES:\n");        
        for(int i = 0; i < 200; i++) {
            if(amigos[dados_logado][i] == 1) {
                System.out.println(nick[i]);
            }
        }
        Scanner read = new Scanner(System.in);
        System.out.println("1 - ACEITAR SOLICITAÇÕES\n2 - EXCLUIR SOLICITAÇÕES\n3 - VOLTAR");
        int opc = read.nextInt();
        
        if(opc == 1) {
            System.out.println("                       ACEITAR SOLICITAÇÕES");
            System.out.print("NOME DE USUÁRIO: ");
            String usuario = read.nextLine();
            
            if(amigos[dados_logado][])
        }
        else if(opc == 2) {
            
        }
        else if(opc == 3) {
                
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

    public static void lista_amigos() {
        
    }

    public static void minhas_comunidades() {
            
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
                    System.out.println("Login e/ou senha inválidos. Não possui cadastro!");
                    int a = read.nextInt();
                    if(a == 1) return;
                    break;
                }
                else if(login[i].equals(Login) && senha[i].equals(Senha)){
                    tru++;
                    break;
                }
            }
            if(tru != 0) {
                perfil_logado(i);
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
