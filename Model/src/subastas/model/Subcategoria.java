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
@NamedQueries({ @NamedQuery(name = "Subcategoria.findAll", query = "select o from Subcategoria o") })
public class Subcategoria implements Serializable {
    private static final long serialVersionUID = 3971372561677456627L;
    @Column(nullable = false)
    private String descripcion;
    @Id
    @Column(nullable = false)
    private BigDecimal idsub;
    @OneToMany(mappedBy = "subcategoria", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Item> itemList;
    @ManyToOne
    @JoinColumn(name = "IDCATEGORIA")
    private Categoria categoria;

    public Subcategoria() {
    }

    public Subcategoria(String descripcion, Categoria categoria, BigDecimal idsub) {
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.idsub = idsub;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public BigDecimal getIdsub() {
        return idsub;
    }

    public void setIdsub(BigDecimal idsub) {
        this.idsub = idsub;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Item addItem(Item item) {
        getItemList().add(item);
        item.setSubcategoria(this);
        return item;
    }

    public Item removeItem(Item item) {
        getItemList().remove(item);
        item.setSubcategoria(null);
        return item;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
