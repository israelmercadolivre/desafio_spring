package br.com.desafiospring.desafiospring.model;

public enum Type {
    SELLER("SELLER"),
    CLIENT("CLIENT");

    private String name;

    Type(String name){
        this.name = name;
    }
}
