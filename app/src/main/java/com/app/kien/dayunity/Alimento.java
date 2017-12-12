package com.app.kien.dayunity;

/**
 * Created by Kien on 11/12/2017.
 */

public class Alimento {

    private Integer id;
    private String nome;
    private String descricao;
    private String diaDaSemana;
    private String imagem;

    public Alimento() {
        super();
    }

    public Alimento(String nome, String descricao, String diaDaSemana, String imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.diaDaSemana = diaDaSemana;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String toString() {
        return nome;
    }
}
