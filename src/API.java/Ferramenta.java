public class Ferramenta {
    private long id;
    private String nome;
    private String descricao;
    private Status status;
    private String mecanicoReservado;

    public Ferramenta(long id, String nome, String descricao, Status status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
    }

   

    @Override
    public String toString() {
        return "Ferramenta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", mecanicoReservado='" + mecanicoReservado + '\'' +
                '}';
    }
}
