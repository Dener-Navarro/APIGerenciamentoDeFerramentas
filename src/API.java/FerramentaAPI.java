
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class FerramentaAPI extends Ferramenta{
    private static Map<Long, Ferramenta> ferramentas = new HashMap<>();
    private static AtomicLong idCounter = new AtomicLong(1);

    public static void main(String[] args) {
        criarFerramenta("Chave de Fenda", "Ferramenta para apertar parafusos", Status.DISPONIVEL);
        criarFerramenta("Martelo", "Ferramenta para bater em pregos", Status.DISPONIVEL);

        listarFerramentas().forEach(System.out::println);

        System.out.println("Reservando a Chave de Fenda para o Mecânico 1");
        reservarFerramenta(1, "Mecânico 1");

        listarFerramentas().forEach(System.out::println);

        System.out.println("Deletando a Ferramenta com ID 2");
        deletarFerramenta(2);

        listarFerramentas().forEach(System.out::println);
    }

    public static List<Ferramenta> listarFerramentas() {
        return new ArrayList<>(ferramentas.values());
    }

    public static Ferramenta obterFerramentaPorId(long id) {
        return ferramentas.get(id);
    }

    public static Ferramenta criarFerramenta(String nome, String descricao, Status status) {
        long id = idCounter.getAndIncrement();
        Ferramenta ferramenta = new Ferramenta(id, nome, descricao, status);
        ferramentas.put(id, ferramenta);
        return ferramenta;
    }

    public static void atualizarStatus(long id, Status status) {
        Ferramenta ferramenta = ferramentas.get(id);
        if (ferramenta != null) {
            ferramenta.setStatus(status);
        }
    }

    public static void reservarFerramenta(long id, String mecanico) {
        Ferramenta ferramenta = ferramentas.get(id);
        if (ferramenta != null) {
            ferramenta.setStatus(Status.RESERVADO);
            ferramenta.setMecanicoReservado(mecanico);
        }
    }

    public static void deletarFerramenta(long id) {
        ferramentas.remove(id);
    }
}
