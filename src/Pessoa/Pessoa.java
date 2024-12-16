package Pessoa;

import Utils.ValidadorEmail;

public class Pessoa {
    private final String nome;
    private final String email;

    private Pessoa(Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    // Static nested class for builder
    public static class Builder {
        private String nome;
        private String email;

        public Builder nome(String nome) {
            if (nome == null || nome.trim().length() < 3) {
                throw new IllegalArgumentException("Nome inválido: deve conter pelo menos 3 caracteres.");
            }
            this.nome = nome.trim();
            return this;
        }

        public Builder email(String email) {
            if (email == null || !ValidadorEmail.ehEmailValido(email)) {
                throw new IllegalArgumentException("Email inválido.");
            }
            this.email = email.trim();
            return this;
        }

        public Pessoa build() {
            if (nome == null || email == null) {
                throw new IllegalStateException("Nome e email são obrigatórios.");
            }
            return new Pessoa(this);
        }
    }
}
