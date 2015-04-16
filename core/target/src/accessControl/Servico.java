package accessControl;

public class Servico {
    private String nome;

    public Servico() {
    }

    public Servico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean equals(Object obj) {
        boolean equal = false;
        Servico servico = (Servico) obj;

        if (this.getNome().equals(servico.getNome())) {
            equal = true;
        }

        return equal;
    }
}
