package subastas.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Puja.findAll", query = "select o from Puja o") })
public class Puja implements Serializable {
    private static final long serialVersionUID = 6166313011015057197L;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_HORA", nullable = false)
    private Date fechaHora;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(name = "PRECIO_OFERTA", nullable = false)
    private BigDecimal precioOferta;
    @OneToMany(mappedBy = "puja", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<PujaGanadora> pujaGanadoraList;
    @ManyToOne
    @JoinColumn(name = "IDITEM")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "ALIASCOMPRADOR")
    private Participante participante;

    public Puja() {
    }

    public Puja(Participante participante, Date fechaHora, BigDecimal id, Item item, BigDecimal precioOferta) {
        this.participante = participante;
        this.fechaHora = fechaHora;
        this.id = id;
        this.item = item;
        this.precioOferta = precioOferta;
    }


    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }


    public BigDecimal getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(BigDecimal precioOferta) {
        this.precioOferta = precioOferta;
    }

    public List<PujaGanadora> getPujaGanadoraList() {
        return pujaGanadoraList;
    }

    public void setPujaGanadoraList(List<PujaGanadora> pujaGanadoraList) {
        this.pujaGanadoraList = pujaGanadoraList;
    }

    public PujaGanadora addPujaGanadora(PujaGanadora pujaGanadora) {
        getPujaGanadoraList().add(pujaGanadora);
        pujaGanadora.setPuja(this);
        return pujaGanadora;
    }

    public PujaGanadora removePujaGanadora(PujaGanadora pujaGanadora) {
        getPujaGanadoraList().remove(pujaGanadora);
        pujaGanadora.setPuja(null);
        return pujaGanadora;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
}
