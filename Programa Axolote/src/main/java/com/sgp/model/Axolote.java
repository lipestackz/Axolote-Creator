package main.java.com.sgp.model;

public class Axolote {

    private String nome;
    private String cor;
    private String comida;
    private String habitat;
    private int idade;

    public Axolote(String nome, String cor, String comida, String habitat, int idade) {
        setNome(nome);
        setCor(cor);
        setComida(comida);
        setHabitat(habitat);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido! Definindo como 'Axolote'.");
            this.nome = "Axolote";
        } else {
            this.nome = nome;
        }

    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {

        if (cor == null || cor.trim().isEmpty()) {
            System.out.println("Cor inválida! Definindo como Rosa.");
            this.cor = "Rosa";
        } else {
            this.cor = cor;
        }

    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {

        if (comida == null || comida.trim().isEmpty()) {
            System.out.println("Comida inválida! Definindo como Minhoca.");
            this.comida = "Minhoca";
        } else {
            this.comida = comida;
        }

    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {

        if (habitat == null || habitat.trim().isEmpty()) {
            System.out.println("Habitat inválido! Definindo como Aquário.");
            this.habitat = "Aquário";
        } else {
            this.habitat = habitat;
        }

    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {

        if (idade < 0 || idade > 20) {
            System.out.println("Idade inválida! Definindo como 1.");
            this.idade = 1;
        } else {
            this.idade = idade;
        }

    }

    public void mostrarDados() {

        System.out.println("Nome: " + nome);
        System.out.println("Cor: " + cor);
        System.out.println("Comida favorita: " + comida);
        System.out.println("Habitat: " + habitat);
        System.out.println("Idade: " + idade);
        System.out.println("-------------------------");

    }

}
