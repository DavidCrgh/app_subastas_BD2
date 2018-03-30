package subastas.model;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@NamedQueries({ @NamedQuery(name = "Item.findAll", query = "select o from Item o") })
public class Item implements Serializable {
    private static final long serialVersionUID = -5633175278087358072L;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String detallesentrega;
    private byte[] foto;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @Column(name = "PRECIO_BASE", nullable = false)
    private BigDecimal precioBase;
    @OneToMany(mappedBy = "item", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Subasta> subastaList;
    @ManyToOne
    @JoinColumn(name = "IDSUBCATEGORIA")
    private Subcategoria subcategoria;
    @OneToMany(mappedBy = "item", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Puja> pujaList;

    public Item() {
    }

    public Item(String descripcion, String detallesentrega, BigDecimal id, Subcategoria subcategoria,
                BigDecimal precioBase) {
        this.descripcion = descripcion;
        this.detallesentrega = detallesentrega;
        this.id = id;
        this.subcategoria = subcategoria;
        this.precioBase = precioBase;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetallesentrega() {
        return detallesentrega;
    }

    public void setDetallesentrega(String detallesentrega) {
        this.detallesentrega = detallesentrega;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }


    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(BigDecimal precioBase) {
        this.precioBase = precioBase;
    }

    public List<Subasta> getSubastaList() {
        return subastaList;
    }

    public void setSubastaList(List<Subasta> subastaList) {
        this.subastaList = subastaList;
    }

    public Subasta addSubasta(Subasta subasta) {
        getSubastaList().add(subasta);
        subasta.setItem(this);
        return subasta;
    }

    public Subasta removeSubasta(Subasta subasta) {
        getSubastaList().remove(subasta);
        subasta.setItem(null);
        return subasta;
    }

    public Subcategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Subcategoria subcategoria) {
        this.subcategoria = subcategoria;
    }

    public List<Puja> getPujaList() {
        return pujaList;
    }

    public void setPujaList(List<Puja> pujaList) {
        this.pujaList = pujaList;
    }

    public Puja addPuja(Puja puja) {
        getPujaList().add(puja);
        puja.setItem(this);
        return puja;
    }

    public Puja removePuja(Puja puja) {
        getPujaList().remove(puja);
        puja.setItem(null);
        return puja;
    }
}
