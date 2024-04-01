package br.com.rps.lojaVirtual.models;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "acesso")
@SequenceGenerator(name = "seq_acesso", sequenceName = "seq_acesso", allocationSize = 1, initialValue = 1)
@Data
public class Acesso implements GrantedAuthority , Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_acesso")
    private Long id;

    @Column(nullable = false)
    private String descricao; //*Acesso ex: ROLE_ADMIN ou ROLE_SECRETARIO
    @Override
    public String getAuthority() {
        return this.descricao;
    }
}
