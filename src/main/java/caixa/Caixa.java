package caixa;

import model.Cliente;

import java.util.LinkedList;
import java.util.Queue;

public class Caixa {

    private Queue<Cliente> fila;
    private int clientesAtendidos;
    private int clientesAguardando;

    public Caixa() {
        fila = new LinkedList<>();
        clientesAtendidos = 0;
        clientesAguardando = 0;
    }

    // Método para registrar um cliente na fila
    public synchronized void registrarCliente(Cliente cliente) {
        fila.add(cliente);
        clientesAguardando++;
        System.out.println("Cliente " + cliente.getNome() + " registrado e aguardando atendimento.");
    }

    // Método para processar o atendimento dos clientes
    public synchronized void processarAtendimento() {
        while (!fila.isEmpty()) {
            Cliente cliente = fila.poll();
            clientesAguardando--;
            new Thread(() -> {
                cliente.atender();
                synchronized (this) {
                    clientesAtendidos++;
                }
            }).start();
        }
    }

    // Método para exibir o número de clientes atendidos
    public synchronized void exibirClientesAtendidos() {
        System.out.println("Clientes atendidos: " + clientesAtendidos);
    }

    // Método para exibir o número de clientes aguardando atendimento
    public synchronized void exibirClientesAguardando() {
        System.out.println("Clientes aguardando atendimento: " + clientesAguardando);
    }

}

