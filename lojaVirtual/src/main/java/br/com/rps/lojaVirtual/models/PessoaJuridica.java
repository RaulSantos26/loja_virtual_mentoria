package br.com.rps.lojaVirtual.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn(name = "id")
@Data
public class PessoaJuridica extends Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cnpj;

    private String inscEstadual;

    private String inscMunicipal;

    private String nomeFantasia;

    private String razaoSocial;

    private String categoria;



}
