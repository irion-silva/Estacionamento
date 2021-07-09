/*Escreva um algoritmo para gerenciar as 20 vagas de um estacionamento.
Ele deve mostrar um menu com as opções
"Registrar entrada de veículo", "Registrar saída de veículo",
"Listar vagas" e "Fechar sistema".Esse menu deve ser exibido
após todas as operações, até que o usuário escolha a opção 4.
Para o registro de entradas, o usuário deverá informar a vaga
que foi preenchida e receber uma mensagem de sucesso ou
informando que a vaga está preenchida. O registro de saídas
deve se comportar de maneira análoga ao de entradas.A
opção três deve simplesmente listar quais vagas estão
preenchidas ou não. A opção quatro encerra a execução.
 */
package estacionamento;

import java.util.Scanner;

/**
 * @version 1.0
 * @since 2021-07-06
 * @author irion-silva
 */
public class Estacionamento {
    static int vagas[] = new int[20];
    public static void main(String[] args) {
        int opcao;
        boolean continuar = true;
        
        Scanner entrada = new Scanner(System.in);
        
        while(continuar){
            System.out.println("1. Registrar entrada\t3. Listar registros\n2. Registrar saída\t4. Fechar");
            System.out.print("Escolha uma opção:");
            opcao = entrada.nextInt();
            
            switch (opcao){
                case 1:
                    registrarEntrada();
                    break;
                case 2:
                    registrarSaida();
                    break;
                case 3:
                    listarVagas();
                    break;
                default:
                    continuar = false;
            }
        }
        
    }
    static Scanner entrada = new Scanner(System.in);
    //Métodos
    public static boolean vagaOcupada(int vaga){
        if (vagas[vaga-1] == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void registrarEntrada(){
        int vaga;
        System.out.print("Digite o número da vaga para a qual você deseja registrar uma entrada:");
        vaga = entrada.nextInt();
        if (vagaOcupada(vaga)) {
            System.out.println("Há um veículo estacionado nesta vaga.");
        } else {
            vagas[vaga-1] = 1;
            System.out.println("Sucesso.");
        }
    }
    
    public static void registrarSaida(){
        int vaga;
        System.out.print("Digite o número da vaga para a qual você deseja registrar a saída:");
        vaga = entrada.nextInt();
        if (vagaOcupada(vaga)) {
            vagas[vaga-1] = 0;
            System.out.println("Sucesso.");
        } else {
            System.out.println("Não há nenhum veículo estacionado nesta vaga.");
        }
    }
    
    public static void listarVagas(){
        System.out.println("As vagas serão listadas abaixo.Dois pontos indicam área ocupada,\nenquanto números indicam vagas disponíveis.");
        System.out.println("---------------------------------------------------------------");
        for (int i = 1; i <= 20; i++) {
            if (vagaOcupada(i)) {
                System.out.print("|••");
            } else {
                if (i < 10) {
                    System.out.print("|0"+i);
                } else {
                    System.out.print("|"+i);
                }
            }
        }
        System.out.println("|\n---------------------------------------------------------------");
        
    }
}
