package subastas.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "PujaGanadora.findAll", query = "select o from PujaGanadora o") })
@Table(name = "PUJA_GANADORA")
public class PujaGanadora implements Serializable {
    private static final long serialVersionUID = -2802415580180259800L;
    @ManyToOne
    @JoinColumn(name = "IDPUJA")
    private Puja puja;
    @ManyToOne
    @JoinColumn(name = "IDSUBASTA")
    private Subasta subasta;

    public PujaGanadora() {
    }

    public PujaGanadora(Puja puja, Subasta subasta) {
        this.puja = puja;
        this.subasta = subasta;
    }


    public Puja getPuja() {
        return puja;
    }

    public void setPuja(Puja puja) {
        this.puja = puja;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }
}
