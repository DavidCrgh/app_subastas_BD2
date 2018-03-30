package subastas.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "Categoria.findAll", query = "select o from Categoria o") })
public class Categoria implements Serializable {
    private static final long serialVersionUID = 2833767821443081601L;
    private String descripcion;
    @Id
    @Column(nullable = false)
    private BigDecimal id;
    @OneToMany(mappedBy = "categoria", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Subcategoria> subcategoriaList;

    public Categoria() {
    }

    public Categoria(String descripcion, BigDecimal id) {
        this.descripcion = descripcion;
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public List<Subcategoria> getSubcategoriaList() {
        return subcategoriaList;
    }

    public void setSubcategoriaList(List<Subcategoria> subcategoriaList) {
        this.subcategoriaList = subcategoriaList;
    }

    public Subcategoria addSubcategoria(Subcategoria subcategoria) {
        getSubcategoriaList().add(subcategoria);
        subcategoria.setCategoria(this);
        return subcategoria;
    }

    public Subcategoria removeSubcategoria(Subcategoria subcategoria) {
        getSubcategoriaList().remove(subcategoria);
        subcategoria.setCategoria(null);
        return subcategoria;
    }
}
