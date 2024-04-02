package br.com.rps.lojaVirtual.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario", allocationSize = 1, initialValue = 1)
@Data
public class Usuario implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario")
    private Long id;

    private String login;

    private String senha;

    @Temporal(TemporalType.DATE)
    private Date dataAtualSenha;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "usuarios_acesso", uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "acesso_id"},
            name = "unique_acesso_user"), joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id",
            table = "usuario", unique = false, foreignKey = @ForeignKey(name = "usuario_fk",
            value = ConstraintMode.CONSTRAINT)), inverseJoinColumns = @JoinColumn(name = "acesso_id", unique = false,
            referencedColumnName = "id", table = "acesso", foreignKey = @ForeignKey(name = "acesso_fk", value = ConstraintMode.CONSTRAINT)) )
    private List<Acesso> acessos;

    /* Autoridades = São os Acessos, ou seja ROLE_ADMIN, ROLE_SECRETARIO*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.acessos;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
