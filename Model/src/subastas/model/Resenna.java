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
@NamedQueries({ @NamedQuery(name = "Resenna.findAll", query = "select o from Resenna o") })
public class Resenna implements Serializable {
    private static final long serialVersionUID = -3987866721394689139L;
    @Column(nullable = false)
    private String comentario;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @ManyToOne
    @JoinColumn(name = "PARA")
    private Participante participante;
    @ManyToOne
    @JoinColumn(name = "IDSUBASTA")
    private Subasta subasta;
    @ManyToOne
    @JoinColumn(name = "DE")
    private Participante participante1;

    public Resenna() {
    }

    public Resenna(String comentario, Participante participante1, BigDecimal id, Subasta subasta,
                   Participante participante) {
        this.comentario = comentario;
        this.participante1 = participante1;
        this.id = id;
        this.subasta = subasta;
        this.participante = participante;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }


    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    public Participante getParticipante1() {
        return participante1;
    }

    public void setParticipante1(Participante participante1) {
        this.participante1 = participante1;
    }
}
