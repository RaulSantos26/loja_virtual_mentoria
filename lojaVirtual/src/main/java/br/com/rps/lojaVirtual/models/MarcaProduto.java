package br.com.rps.lojaVirtual.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "marca_produto")
@SequenceGenerator(name = "seq_marca_produto", sequenceName = "seq_marca_produto", allocationSize = 1, initialValue = 1)
@Data
public class MarcaProduto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marca_produto")
    private Long id;

    @Column(nullable = false)
    private String NomeDesc;

}
