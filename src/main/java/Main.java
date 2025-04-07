import caixa.Caixa;
import model.Cliente;

public class Main {
    public static void main(String[] args) {

        Caixa caixa = new Caixa();

        caixa.registrarCliente(new Cliente("João", 3));
        caixa.registrarCliente(new Cliente("Maria", 2));
        caixa.registrarCliente(new Cliente("Pedro", 5));

        caixa.exibirClientesAguardando();

        caixa.processarAtendimento();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        caixa.exibirClientesAtendidos();
    }
}

