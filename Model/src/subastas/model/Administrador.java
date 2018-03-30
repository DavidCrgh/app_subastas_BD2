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
@NamedQueries({ @NamedQuery(name = "Administrador.findAll", query = "select o from Administrador o") })
public class Administrador implements Serializable {
    private static final long serialVersionUID = -5750273500532297550L;
    @Id
    @Column(nullable = false)
    private String aliasadministrador;
    @OneToOne
    @JoinColumn(name = "ALIASADMINISTRADOR")
    private Usuario usuario;
    @OneToMany(mappedBy = "administrador", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Variablessistema> variablessistemaList;

    public Administrador() {
    }

    public Administrador(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAliasadministrador() {
        return aliasadministrador;
    }

    public void setAliasadministrador(String aliasadministrador) {
        this.aliasadministrador = aliasadministrador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        if (usuario != null) {
            this.aliasadministrador = usuario.getAlias();
        }
    }

    public List<Variablessistema> getVariablessistemaList() {
        return variablessistemaList;
    }

    public void setVariablessistemaList(List<Variablessistema> variablessistemaList) {
        this.variablessistemaList = variablessistemaList;
    }

    public Variablessistema addVariablessistema(Variablessistema variablessistema) {
        getVariablessistemaList().add(variablessistema);
        variablessistema.setAdministrador(this);
        return variablessistema;
    }

    public Variablessistema removeVariablessistema(Variablessistema variablessistema) {
        getVariablessistemaList().remove(variablessistema);
        variablessistema.setAdministrador(null);
        return variablessistema;
    }
}
