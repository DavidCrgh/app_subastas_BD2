package subastas.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Telefono.findAll", query = "select o from Telefono o") })
public class Telefono implements Serializable {
    private static final long serialVersionUID = 6280346248355822547L;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(nullable = false, unique = true)
    private String telefono;
    @ManyToOne
    @JoinColumn(name = "ALIASUSUARIO")
    private Usuario usuario;

    public Telefono() {
    }

    public Telefono(Usuario usuario, BigDecimal id, String telefono) {
        this.usuario = usuario;
        this.id = id;
        this.telefono = telefono;
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
