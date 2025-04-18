package model;

public class Cliente {

    private String nome;
    private int tempoAtendimento; // em segundos

    // Construtor
    public Cliente(String nome, int tempoAtendimento) {
        this.nome = nome;
        this.tempoAtendimento = tempoAtendimento;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }

    // Método para simular o atendimento do cliente
    public void atender() {
        try {
            System.out.println("Atendendo cliente " + nome + " por " + tempoAtendimento + " segundos.");
            Thread.sleep(tempoAtendimento * 1000); // Simula o tempo de atendimento (em milissegundos)
            System.out.println("Cliente " + nome + " atendido.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
