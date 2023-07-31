package com.fernandes.Desafio.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String preco;

    @OneToMany(mappedBy = "blocos")
    List<Bloco> blocos = new ArrayList<>();

    @OneToMany(mappedBy = "categorias")
    List<Categoria> categorias = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_atividade_participante",
    joinColumns = @JoinColumn(name = "atividade_id"),
    inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes = new HashSet<>();

    public Atividade(){

    }

    public Atividade(Integer id, String nome, String descricao, String preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }

}
