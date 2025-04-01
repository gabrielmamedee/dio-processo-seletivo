package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        //analisarCandidato(1900.0);
        //analisarCandidato(2200.0);
        //analisarCandidato(2000.0);
        //selecionarCandidatos();
        //imprimirSelecionados();
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        for(String candidato: candidatos) {
            entrandoEmContato(candidato);
        }
    }
    static void  entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso!!");
        } while (continuarTentando && tentativasRealizadas < 3);

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        else
            System.out.println("NÃO CONEGUIMOS CONTATO COM " + candidato + ", NÚMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADA");
    }

    //metodo auxiliar
    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");

        for(int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de Nº: " + (i+1) + " é " + candidatos[i]);
        }

        System.out.println("Imprimindo a lista apenas com nome do candidato");
        for (String candidato: candidatos) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    static void selecionarCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static void analisarCandidato (double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioPretendido < salarioBase){
            System.out.println("Ligar para o candidato");
        }
        else if (salarioPretendido == salarioBase){
            System.out.println("Ligar para o candidato, com contra proposta");
        }
        else {
            System.out.println("Aguardar outros candidatos");
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

}
