package br.com.desafiospring.desafiospring.model.user;

public enum Type {
    SELLER("SELLER"),
    CLIENT("CLIENT");

    private String name;

    Type(String name){
        this.name = name;
    }
}
