package accessControl;

public class Perfil {
    private String nome;

    public Perfil() {
    }

    public Perfil(String nome) {
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
        Perfil perfil = (Perfil) obj;

        if (this.getNome().equals(perfil.getNome())) {
            equal = true;
        }

        return equal;
    }
}
