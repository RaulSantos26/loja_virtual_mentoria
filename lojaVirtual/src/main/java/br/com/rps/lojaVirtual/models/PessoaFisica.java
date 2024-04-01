package br.com.rps.lojaVirtual.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name = "id")
@Data
public class PessoaFisica  extends Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;


}
