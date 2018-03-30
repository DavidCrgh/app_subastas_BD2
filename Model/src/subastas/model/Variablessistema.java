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
@NamedQueries({ @NamedQuery(name = "Variablessistema.findAll", query = "select o from Variablessistema o") })
public class Variablessistema implements Serializable {
    private static final long serialVersionUID = 5543695265076747865L;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(nullable = false)
    private BigDecimal incrementominimo;
    @Column(nullable = false)
    private BigDecimal porcentajemejora;
    @ManyToOne
    @JoinColumn(name = "ALIASADMINISTRADOR")
    private Administrador administrador;

    public Variablessistema() {
    }

    public Variablessistema(Administrador administrador, BigDecimal id, BigDecimal incrementominimo,
                            BigDecimal porcentajemejora) {
        this.administrador = administrador;
        this.id = id;
        this.incrementominimo = incrementominimo;
        this.porcentajemejora = porcentajemejora;
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getIncrementominimo() {
        return incrementominimo;
    }

    public void setIncrementominimo(BigDecimal incrementominimo) {
        this.incrementominimo = incrementominimo;
    }

    public BigDecimal getPorcentajemejora() {
        return porcentajemejora;
    }

    public void setPorcentajemejora(BigDecimal porcentajemejora) {
        this.porcentajemejora = porcentajemejora;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
