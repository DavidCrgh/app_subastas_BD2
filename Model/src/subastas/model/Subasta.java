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
@NamedQueries({ @NamedQuery(name = "Subasta.findAll", query = "select o from Subasta o") })
public class Subasta implements Serializable {
    private static final long serialVersionUID = 6428405130725343816L;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date tiempofin;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date tiempoinicio;
    @ManyToOne
    @JoinColumn(name = "IDITEM")
    private Item item;
    @ManyToOne
    @JoinColumn(name = "ALIASVENDEDOR")
    private Participante participante;
    @OneToMany(mappedBy = "subasta", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<PujaGanadora> pujaGanadoraList;
    @OneToMany(mappedBy = "subasta", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Resenna> resennaList;

    public Subasta() {
    }

    public Subasta(Participante participante, BigDecimal id, Item item, Date tiempofin, Date tiempoinicio) {
        this.participante = participante;
        this.id = id;
        this.item = item;
        this.tiempofin = tiempofin;
        this.tiempoinicio = tiempoinicio;
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }


    public Date getTiempofin() {
        return tiempofin;
    }

    public void setTiempofin(Date tiempofin) {
        this.tiempofin = tiempofin;
    }

    public Date getTiempoinicio() {
        return tiempoinicio;
    }

    public void setTiempoinicio(Date tiempoinicio) {
        this.tiempoinicio = tiempoinicio;
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

    public List<PujaGanadora> getPujaGanadoraList() {
        return pujaGanadoraList;
    }

    public void setPujaGanadoraList(List<PujaGanadora> pujaGanadoraList) {
        this.pujaGanadoraList = pujaGanadoraList;
    }

    public PujaGanadora addPujaGanadora(PujaGanadora pujaGanadora) {
        getPujaGanadoraList().add(pujaGanadora);
        pujaGanadora.setSubasta(this);
        return pujaGanadora;
    }

    public PujaGanadora removePujaGanadora(PujaGanadora pujaGanadora) {
        getPujaGanadoraList().remove(pujaGanadora);
        pujaGanadora.setSubasta(null);
        return pujaGanadora;
    }

    public List<Resenna> getResennaList() {
        return resennaList;
    }

    public void setResennaList(List<Resenna> resennaList) {
        this.resennaList = resennaList;
    }

    public Resenna addResenna(Resenna resenna) {
        getResennaList().add(resenna);
        resenna.setSubasta(this);
        return resenna;
    }

    public Resenna removeResenna(Resenna resenna) {
        getResennaList().remove(resenna);
        resenna.setSubasta(null);
        return resenna;
    }
}
