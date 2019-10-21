//package main;
import java.util.Scanner;

public class Main {
    static int [][] contador_mensagens = new int[200][200];
    static int cont;
    static String [][][] mensagens = new String[200][200][200]; 
    static String [] login = new String[200];
    static String [] senha = new String[200];
    static String [] nick = new String[200];  
    static int [][] amigos = new int[200][200];
    static int [] idade = new int[200];
    static String [] estado_civil = new String[200];

    public static void altera_perfil(int dados_logado) {
      Scanner read = new Scanner(System.in);
      int opc, opc_2, altera_idade;
      String altera;
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("EDITAR:\n1 - NOME DE USUÁRIO\n2 - IDADE\n3 - ESTADO CIVIL\n4 - VOLTAR");
        opc = read.nextInt();
        if(opc == 1) {
          System.out.print("DIGITE O NOVO NOME DE USUÁRIO: ");
          Scanner read2 = new Scanner(System.in);           
          altera = read2.nextLine();
          for(int i = 0; i < 200; i++) {
            if(nick[i].equals(altera)) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println("NOME DE USUÁRIO JÁ EXISTENTE!\n1 - VOLTAR");
                opc_2 = read.nextInt();
                altera_perfil(dados_logado);
                return;
            }
          }
          nick[dados_logado] = altera;
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");   
          System.out.println("NOME DE USUÁRIO ALTERADO COM SUCESSO!\n1 - VOLTAR");
          opc_2 = read.nextInt();
          if(opc_2 == 1) altera_perfil(dados_logado); 
        }
        if(opc == 2) {
          System.out.print("DIGITE A IDADE (somente numeros): ");
          Scanner read2 = new Scanner(System.in);           
          altera_idade = read2.nextInt();
          idade[dados_logado] = altera_idade;
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");   
          System.out.println("IDADE ALTERADA COM SUCESSO!\n1 - VOLTAR");
          opc_2 = read.nextInt();
          if(opc_2 == 1) altera_perfil(dados_logado);           
        }
        if(opc == 3) {
          System.out.print("DIGITE SEU ATUAL ESTADO CIVIL: ");
          Scanner read2 = new Scanner(System.in);           
          altera = read2.nextLine();
          estado_civil[dados_logado] = altera;
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");   
            System.out.println("ESTADO CIVIL ALTERADO COM SUCESSO!\n1 - VOLTAR");
            opc_2 = read.nextInt();
            if(opc_2 == 1) altera_perfil(dados_logado); 
        }
        if(opc == 4) return;                  
    } 
    
    public static void excluir_perfil(int dados_logado) {
        int opc;
        Scanner read = new Scanner (System.in);
        System.out.println("             VOCÊ TEM CERTEZA QUE DESEJA EXCLUIR ESTA CONTA? TODOS OS DADOS SERÃO PERDIDOS!");
        System.out.println("1 - SIM\n2 - VOLTAR");
        opc = read.nextInt();
        
        if(opc == 1) {
            login[dados_logado] = "-1";
            senha[dados_logado] = "-1";
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
    public static void perfis(int dados_logado) {
        Scanner read = new Scanner(System.in);
        int opc;
        String procura;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("1 - MEU PERFIL\n2 - PROCURAR PERFIS DE OUTROS USUÁRIOS\n3 - VOLTAR");
        opc = read.nextInt();
        if(opc == 1) {
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");          
          System.out.print("        MEU PERFIL\n\nNOME DE USUÁRIO: ");
          System.out.println(nick[dados_logado]);
          System.out.print("IDADE: ");
          System.out.println(idade[dados_logado]);
          System.out.print("ESTADO CIVIL: ");                 
          System.out.println(estado_civil[dados_logado]);       
          System.out.println("\n\n1 - EDITAR PERFIL\n2 - VOLTAR");
          opc = read.nextInt();

          if(opc == 1) {
            altera_perfil(dados_logado);
          }
          else if(opc == 2) return;
          else perfis(dados_logado);
        }
        if(opc == 2) {
          Scanner read2 = new Scanner(System.in);
          System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nPROCURAR PERFIS");
          System.out.print("DIGITE O NOME DE USUÁRIO: ");
          procura = read2.nextLine();

          for(int i = 0; i < 200; i++) {
            if(nick[i].equals(procura)) {
              System.out.println("\n" + "NOME DE USUÁRIO: " + nick[i]);
              System.out.print("IDADE: ");
              System.out.println(idade[i]);
              System.out.print("ESTADO CIVIL: ");                 
              System.out.println(estado_civil[i]);
              System.out.println("\n1 - VOLTAR");
              opc = read.nextInt();
              perfis(dados_logado);
              return;
            }
          }
          System.out.println("USUÁRIO NÃO ENCONTRADO!\n1 - VOLTAR");
          opc = read.nextInt();
        }
        if(opc == 3) return;
    }

    public static void preenche_tabelas() {
        for(int i = 0; i <200; i++) {
            nick[i] = "-1";
            login[i] = "-1";
            senha[i] = "-1";
        }
        for(int c = 0; c < 200; c++) {
            for(int l = 0; l <200; l++) {
                amigos[l][c] = 0;
                contador_mensagens[l][c] = 0;
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
            System.out.println("\n1 - ADICIONAR AMIGOS\n2 - MENSAGENS\n3 - LISTA DE AMIGOS\n4 - SOLICITAÇÕES DE AMIZADE\n5 - PERFIS");
            System.out.println("6 - EXCLUIR CONTA\n7 - SAIR");
            Scanner read = new Scanner (System.in);
            int opc = read.nextInt();
            
            if(opc == 1) adicionar_amigos(dados); 
            else if(opc == 2) mensagens(dados);
            else if(opc == 3) lista_amigos(dados);
            else if(opc == 4) solicitacoes_amizade(dados);
            else if(opc == 5) perfis(dados);
            else if(opc == 6) excluir_perfil(dados);
            else if(opc == 7) break;
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
            System.out.println("2 - VOLTAR AO MENU");
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
                if(i == 200) {
                    System.out.println("USUÁRIO NÃO ENCONTRADO!\n1 - VOLTAR");
                    opc = read.nextInt();
                }    
            }
            else if(opc == 2) {
                break;
            }           
        }
    }

    public static void mensagens(int dados_logado) {
        int opc, dados_recebe;
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");        
        System.out.println("   MENSAGENS\n1 - ENVIAR\n2 - VISUALIZAR\n3 - VOLTAR");
        Scanner read = new Scanner(System.in);        
        opc = read.nextInt();
        if(opc == 1) {
            int truth = 0; 
            System.out.print("DESEJA ENVIAR UMA MENSAGEM PARA QUAL AMIGO? (digite o nome de usuário): ");
            String enviar;
            Scanner read2 = new Scanner(System.in);            
            enviar = read2.nextLine();
            
            for(dados_recebe = 0; dados_recebe < 200; dados_recebe++) {
                if(nick[dados_recebe].equals(enviar)) {
                    truth++;
                    break;
                }
            }
            if(truth == 0) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");   
                System.out.println("AMIGO NÃO ENCONTRADO!\n");
                opc = read.nextInt();
                mensagens(dados_logado);
                return;
            }
            else {
                System.out.println("ESCREVA SUA MENSAGEM: ");
                enviar = read2.nextLine();

                for(; contador_mensagens[dados_logado][dados_recebe] < 200; contador_mensagens[dados_logado][dados_recebe]++) {
                  if(mensagens[dados_logado][dados_recebe][contador_mensagens[dados_logado][dados_recebe]] == null) {
                    mensagens[dados_logado][dados_recebe][contador_mensagens[dados_logado][dados_recebe]] = (nick[dados_logado]+ ":" + " " + enviar);
                    System.out.println("MENSAGEM ENVIADA COM SUCESSO!\n");
                    contador_mensagens[dados_recebe][dados_logado] = contador_mensagens[dados_logado][dados_recebe];
                    contador_mensagens[dados_recebe][dados_logado]++;
                    opc = read2.nextInt();
                      System.out.println(contador_mensagens[dados_logado][dados_recebe]);
                    break;
                  }
                }                
            }
        }
        if(opc == 2) {
           int truth = 0; 
            System.out.print("DESEJA VER MENSAGENS DE QUAL AMIGO? (digite o nome de usuário): ");
            String enviar;
            Scanner read2 = new Scanner(System.in);            
            enviar = read2.nextLine();
            
            for(dados_recebe = 0; dados_recebe < 200; dados_recebe++) {
                if(nick[dados_recebe].equals(enviar)) {
                    truth++;
                    break;
                }
            }
            if(truth == 0) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");   
                System.out.println("AMIGO NÃO ENCONTRADO!\n1 - VOLTAR");
                opc = read.nextInt();
                mensagens(dados_logado);
                return;
            }
            else {
              System.out.println("\n");
              for(int i =0; i < 200; i++) {
                if(mensagens[dados_logado][dados_recebe][i] != null) {
                  System.out.println(mensagens[dados_logado][dados_recebe][i]);
                }
                if(mensagens[dados_recebe][dados_logado][i] != null) {
                    System.out.println(mensagens[dados_recebe][dados_logado][i]);                    
                  }
              }
              System.out.println("\n1 - VOLTAR");
              opc = read.nextInt();                                       
            }   
        }
        if(opc == 3) return;
        else mensagens(dados_logado);
        
    }

    public static void lista_amigos(int dados_logado) {
        int opc;
        Scanner read = new Scanner(System.in);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        for(int i = 0; i < 200; i++) {
            if(amigos[dados_logado][i] == 2 && amigos[i][dados_logado] == 2) {
                System.out.println(nick[i]);
            }
        }
        System.out.println("1 - VOLTAR");
        opc = read.nextInt();
            
        if(opc == 1) return;
        else lista_amigos(dados_logado);
    }

    public static void minhas_comunidades() {
            
    }

    public static void cadastro() {
        int i, opc, Idade, truth = 0;
        String Login, Senha, Nick, Estado_civil;
        Scanner read = new Scanner(System.in);       
        System.out.print("LOGIN que deseja cadastrar: ");        
        Login = read.nextLine();

        for(i = 0; i < 200; i++) {
          if(login[i].equals(Login)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");           
            System.out.println("LOGIN JÁ EXISTENTE!\n");
            truth++;
            break;              
          }
        }
        if(truth == 1) {
          cadastro();
          return;
        }
        System.out.print("SENHA que deseja cadastrar: ");
        Senha = read.nextLine();

        for(i = 0; i < 200; i++) {
          if(senha[i].equals(Senha)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");           
            System.out.println("\nSENHA JÁ EXISTENTE!\n");
            truth++;
            break;              
          }
        }
        if(truth == 1) {
          cadastro();
          return;
        }
        System.out.print("NOME DO USUÁRIO: ");        
        Nick = read.nextLine();
        for(i = 0; i < 200; i++) {
          if(nick[i].equals(Nick)) {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");           
            System.out.println("\nNOME DE USUÁRIO JÁ EXISTENTE!\n");
            truth++;
            break;              
          }
        }
        if(truth == 1) {
          cadastro();
          return;
        }        
        System.out.print("ESTADO CIVIL: ");        
        Estado_civil = read.nextLine();
        System.out.print("IDADE (somente numeros): ");        
        Idade = read.nextInt();                    
        
        for(i =0; i< 200; i++) {
            if(login[i] == null || login[i].equals("-1")) {
              login[i] = Login;
              senha[i] = Senha;
              nick[i] = Nick;
              estado_civil[i] = Estado_civil;
              idade[i] = Idade;
              break;
            }
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");        
        System.out.println("CADASTRADO COM SUCESSO!");
        System.out.println("1 - VOLTAR AO MENU PRINCIPAL");
        opc = read.nextInt();
        if(opc == 1) return;
         
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
                if(login[i] == "-1" && i == 199) {
                    System.out.println("\nLOGIN E/OU SENHA INVÁLIDOS! NÃO POSSUI CADASTRO!\n");
                    System.out.println("1 - VOLTAR A TELA DE LOGIN\n2 - VOLTAR AO MENU PRINCIPAL");                    
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
                System.out.println(" \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");                
                System.out.println("      ___   __________  ___________   ___________   ___________");
                System.out.println("      |*|   |*-------|  |*-------*|   |*--------|   |*--------|");
                System.out.println("      |*|   |*|         |*|     |*|   |*|           |*|");
                System.out.println("      |*|   |*|______|  |*-------*|   |*|           |*|_______");
                System.out.println("      |*|   |*-------|  |*-------*|   |*|           |*--------|");
                System.out.println("      |*|   |*|         |*|     |*|   |*|           |*|");
                System.out.println("      |*|   |*|         |*|     |*|   |*|_______|   |*|_______|");
                System.out.println("      ---   ---         ---     ---   |---------|   |---------|");
                System.out.println("\n\n1 - CADASTRAR-SE");
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
                    break;
                }
            }
    }
}
