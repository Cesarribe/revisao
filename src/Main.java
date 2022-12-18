import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AdaTwitter twInfra = new AdaTwitter();

        printMenu(sc, twInfra);

    }

    private static void printMenu(Scanner sc, AdaTwitter twInfra){

        int opcaoMenu;
        loopMenu:
        while (true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.print(" .....Bem vindo ao TT dos Pobres, se vc é pobre sinta-se em casa........\n");
            System.out.print("");
            System.out.println(" ");
            System.out.println(" ");
            System.out.print(".......Não é pobre e entrou por acaso? digite 0 ........................\n");
            System.out.print(".......É pobre mas não se juntou a turma? digite 1 para se registrar... \n");
            System.out.print(".......já é de casa? digite 2 para logar ...............................\n");
            System.out.print(".......Deseja ver oq os pobres estão falando? digite 3..................\n");

            opcaoMenu = Integer.parseInt(sc.nextLine());
            if (opcaoMenu == 1) {
                String login;
                String mail;
                String password;
                String userName;
                String dataNasc;
                System.out.println("Qual teu nome? ");
                login = sc.nextLine();
                System.out.println("Tua senha? ");
                password = sc.nextLine();
                System.out.println("Qual teu vulgo? ");
                userName = sc.nextLine();
                System.out.println("teu insta?: ");
                mail = sc.nextLine();
                System.out.println("nasce-se quando? (dd/MM/yyyy): ");
                dataNasc = sc.nextLine();

                twInfra.cadastrarUsuario(login, password, userName, mail, dataNasc);
            }
            else if (opcaoMenu == 2) {
                String user;
                String password;
                System.out.println("Qual teu vulgo? ");
                user = sc.nextLine();
                System.out.println("tua senha?: ");
                password = sc.nextLine();
                twInfra.loginSystem(user, password);
                System.out.println();
                if (twInfra.userLogado != null) {
                    int opcoesLogado;
                    loopUserLogged:
                    while(true) {
                        System.out.println(" ");


                        System.out.print("cansou e deseja sair? digite 0\n");
                        System.out.print("Quer mandar a real? dale no 1\n");
                        System.out.print("Quer acompanhar a resenha? dale no 2 \n");
                        System.out.print("Falou de mais? apague digitando o 3               \n");
                        System.out.print("Acompanhe oq vc falou quando tava bebo, digitando 4 \n");


                        opcoesLogado = Integer.parseInt(sc.nextLine());
                        loopUserTweetar:

                        while (true) {

                            if (opcoesLogado == 1) {
                                String msg;
                                System.out.print("Manda tua ideia ou digita voltar");
                                msg = sc.nextLine();
                                if ("sair".equals(msg.toLowerCase()) || "voltar".equals(msg.toLowerCase())) {
                                    System.out.println();
                                    break loopUserTweetar;
                                } else {
                                    twInfra.saveNewTweete(twInfra.userLogado.twitar(msg));
                                }

                            } else if (opcoesLogado == 2) {
                                twInfra.viewFullTimeLine();
                                System.out.println();
                                break loopUserTweetar;

                            } else if (opcoesLogado == 3) {
                                int nTweete;
                                String twDeleted;
                                System.out.print("Qual B.O tu quer apagar?: ");

                                nTweete = Integer.parseInt(sc.nextLine());
                                twDeleted = twInfra.userLogado.deletarTwitter(nTweete);
                                if (twDeleted != null) {
                                    System.out.println();
                                    twInfra.deletaTwiteOfTimeLine(twDeleted);
                                } else {
                                    System.out.println("Tweet does not exist!");
                                    System.out.println();
                                }
                                System.out.println();
                                break loopUserTweetar;

                            } else if (opcoesLogado == 4) {
                                twInfra.userLogado.timeline();
                                System.out.println();
                                break loopUserTweetar;

                            }else if (opcoesLogado == 0) {
                                System.out.println();
                                System.out.println(twInfra.userLogado.getUser() + " Vaza Pai");
                                twInfra.userLogado = null;
                                break loopUserLogged;
                            }

                        }


                    }
                    }
                }else if (opcaoMenu == 3) {
                twInfra.viewFullTimeLine();
                System.out.println();

            } else if (opcaoMenu == 0) {
                System.out.println("Já vai tarde!");
                System.out.println();
                break loopMenu;
            }
        }
    }

}

// tive bastante dificuldade de fazer, mas com o apoio dos colegas consegui fazer uma versao meio frankstein kkk,
// mas entendi a logica e respeitei o conteudo dado, realizando o trabalho! obrigado professor