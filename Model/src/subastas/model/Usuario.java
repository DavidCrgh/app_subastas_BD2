package subastas.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "select o from Usuario o") })
public class Usuario implements Serializable {
    private static final long serialVersionUID = -8422333744015919767L;
    @Id
    @Column(nullable = false)
    private String alias;
    @Column(nullable = false)
    private String cedula;
    private String direccion;
    @Column(name = "NOMBRE_APELLIDOS")
    private String nombreApellidos;
    @OneToOne(mappedBy = "usuario")
    private Participante participante;
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Telefono> telefonoList;
    @OneToOne(mappedBy = "usuario")
    private Administrador administrador;

    public Usuario() {
    }

    public Usuario(String alias, String cedula, String direccion, String nombreApellidos) {
        this.alias = alias;
        this.cedula = cedula;
        this.direccion = direccion;
        this.nombreApellidos = nombreApellidos;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreApellidos() {
        return nombreApellidos;
    }

    public void setNombreApellidos(String nombreApellidos) {
        this.nombreApellidos = nombreApellidos;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public List<Telefono> getTelefonoList() {
        return telefonoList;
    }

    public void setTelefonoList(List<Telefono> telefonoList) {
        this.telefonoList = telefonoList;
    }

    public Telefono addTelefono(Telefono telefono) {
        getTelefonoList().add(telefono);
        telefono.setUsuario(this);
        return telefono;
    }

    public Telefono removeTelefono(Telefono telefono) {
        getTelefonoList().remove(telefono);
        telefono.setUsuario(null);
        return telefono;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
