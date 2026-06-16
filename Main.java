import service.SistemaAgendamento;
import view.TelaPrincipal;
public class Main {
    public static void main(String[] args) {
        SistemaAgendamento sistema = new SistemaAgendamento();

        new TelaPrincipal(sistema);
    }
}
