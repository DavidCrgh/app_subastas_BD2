package subastas.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ @NamedQuery(name = "Participante.findAll", query = "select o from Participante o") })
public class Participante implements Serializable {
    private static final long serialVersionUID = -5650070436531244740L;
    @Id
    @Column(nullable = false)
    private String aliasparticipante;
    @OneToMany(mappedBy = "participante", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Resenna> resennaList;
    @OneToOne
    @JoinColumn(name = "ALIASPARTICIPANTE")
    private Usuario usuario;
    @OneToMany(mappedBy = "participante", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Subasta> subastaList;
    @OneToMany(mappedBy = "participante1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Resenna> resennaList1;
    @OneToMany(mappedBy = "participante", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Puja> pujaList;

    public Participante() {
    }

    public Participante(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAliasparticipante() {
        return aliasparticipante;
    }

    public void setAliasparticipante(String aliasparticipante) {
        this.aliasparticipante = aliasparticipante;
    }

    public List<Resenna> getResennaList() {
        return resennaList;
    }

    public void setResennaList(List<Resenna> resennaList) {
        this.resennaList = resennaList;
    }

    public Resenna addResenna(Resenna resenna) {
        getResennaList().add(resenna);
        resenna.setParticipante(this);
        return resenna;
    }

    public Resenna removeResenna(Resenna resenna) {
        getResennaList().remove(resenna);
        resenna.setParticipante(null);
        return resenna;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null) {
            this.aliasparticipante = usuario.getAlias();
        }
    }

    public List<Subasta> getSubastaList() {
        return subastaList;
    }

    public void setSubastaList(List<Subasta> subastaList) {
        this.subastaList = subastaList;
    }

    public Subasta addSubasta(Subasta subasta) {
        getSubastaList().add(subasta);
        subasta.setParticipante(this);
        return subasta;
    }

    public Subasta removeSubasta(Subasta subasta) {
        getSubastaList().remove(subasta);
        subasta.setParticipante(null);
        return subasta;
    }

    public List<Resenna> getResennaList1() {
        return resennaList1;
    }

    public void setResennaList1(List<Resenna> resennaList1) {
        this.resennaList1 = resennaList1;
    }

    public List<Puja> getPujaList() {
        return pujaList;
    }

    public void setPujaList(List<Puja> pujaList) {
        this.pujaList = pujaList;
    }

    public Puja addPuja(Puja puja) {
        getPujaList().add(puja);
        puja.setParticipante(this);
        return puja;
    }

    public Puja removePuja(Puja puja) {
        getPujaList().remove(puja);
        puja.setParticipante(null);
        return puja;
    }
}
