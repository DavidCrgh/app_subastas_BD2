package subastas.model;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless(name = "SubastasFacade", mappedName = "app_subastas_BD2-Model-SubastasFacade")
public class SubastasFacadeBean implements SubastasFacade, SubastasFacadeLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public SubastasFacadeBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Subasta persistSubasta(Subasta subasta) {
        em.persist(subasta);
        return subasta;
    }

    public Subasta mergeSubasta(Subasta subasta) {
        return em.merge(subasta);
    }

    public void removeSubasta(Subasta subasta) {
        subasta = em.find(Subasta.class, subasta.getId());
        em.remove(subasta);
    }

    /** <code>select o from Subasta o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Subasta> getSubastaFindAll() {
        return em.createNamedQuery("Subasta.findAll", Subasta.class).getResultList();
    }

    public Administrador persistAdministrador(Administrador administrador) {
        em.persist(administrador);
        return administrador;
    }

    public Administrador mergeAdministrador(Administrador administrador) {
        return em.merge(administrador);
    }

    public void removeAdministrador(Administrador administrador) {
        administrador = em.find(Administrador.class, administrador.getAliasadministrador());
        em.remove(administrador);
    }

    /** <code>select o from Administrador o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Administrador> getAdministradorFindAll() {
        return em.createNamedQuery("Administrador.findAll", Administrador.class).getResultList();
    }

    public Categoria persistCategoria(Categoria categoria) {
        em.persist(categoria);
        return categoria;
    }

    public Categoria mergeCategoria(Categoria categoria) {
        return em.merge(categoria);
    }

    public void removeCategoria(Categoria categoria) {
        categoria = em.find(Categoria.class, categoria.getId());
        em.remove(categoria);
    }

    /** <code>select o from Categoria o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Categoria> getCategoriaFindAll() {
        return em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
    }

    public Variablessistema persistVariablessistema(Variablessistema variablessistema) {
        em.persist(variablessistema);
        return variablessistema;
    }

    public Variablessistema mergeVariablessistema(Variablessistema variablessistema) {
        return em.merge(variablessistema);
    }

    public void removeVariablessistema(Variablessistema variablessistema) {
        variablessistema = em.find(Variablessistema.class, variablessistema.getId());
        em.remove(variablessistema);
    }

    /** <code>select o from Variablessistema o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Variablessistema> getVariablessistemaFindAll() {
        return em.createNamedQuery("Variablessistema.findAll", Variablessistema.class).getResultList();
    }

    public Subcategoria persistSubcategoria(Subcategoria subcategoria) {
        em.persist(subcategoria);
        return subcategoria;
    }

    public Subcategoria mergeSubcategoria(Subcategoria subcategoria) {
        return em.merge(subcategoria);
    }

    public void removeSubcategoria(Subcategoria subcategoria) {
        subcategoria = em.find(Subcategoria.class, subcategoria.getIdsub());
        em.remove(subcategoria);
    }

    /** <code>select o from Subcategoria o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Subcategoria> getSubcategoriaFindAll() {
        return em.createNamedQuery("Subcategoria.findAll", Subcategoria.class).getResultList();
    }

    public Puja persistPuja(Puja puja) {
        em.persist(puja);
        return puja;
    }

    public Puja mergePuja(Puja puja) {
        return em.merge(puja);
    }

    public void removePuja(Puja puja) {
        puja = em.find(Puja.class, puja.getId());
        em.remove(puja);
    }

    /** <code>select o from Puja o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Puja> getPujaFindAll() {
        return em.createNamedQuery("Puja.findAll", Puja.class).getResultList();
    }

    public Participante persistParticipante(Participante participante) {
        em.persist(participante);
        return participante;
    }

    public Participante mergeParticipante(Participante participante) {
        return em.merge(participante);
    }

    public void removeParticipante(Participante participante) {
        participante = em.find(Participante.class, participante.getAliasparticipante());
        em.remove(participante);
    }

    /** <code>select o from Participante o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Participante> getParticipanteFindAll() {
        return em.createNamedQuery("Participante.findAll", Participante.class).getResultList();
    }

    public Resenna persistResenna(Resenna resenna) {
        em.persist(resenna);
        return resenna;
    }

    public Resenna mergeResenna(Resenna resenna) {
        return em.merge(resenna);
    }

    public void removeResenna(Resenna resenna) {
        resenna = em.find(Resenna.class, resenna.getId());
        em.remove(resenna);
    }

    /** <code>select o from Resenna o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Resenna> getResennaFindAll() {
        return em.createNamedQuery("Resenna.findAll", Resenna.class).getResultList();
    }

    public PujaGanadora persistPujaGanadora(PujaGanadora pujaGanadora) {
        em.persist(pujaGanadora);
        return pujaGanadora;
    }

    public PujaGanadora mergePujaGanadora(PujaGanadora pujaGanadora) {
        return em.merge(pujaGanadora);
    }

    /** <code>select o from PujaGanadora o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<PujaGanadora> getPujaGanadoraFindAll() {
        return em.createNamedQuery("PujaGanadora.findAll", PujaGanadora.class).getResultList();
    }

    public Usuario persistUsuario(Usuario usuario) {
        em.persist(usuario);
        return usuario;
    }

    public Usuario mergeUsuario(Usuario usuario) {
        return em.merge(usuario);
    }

    public void removeUsuario(Usuario usuario) {
        usuario = em.find(Usuario.class, usuario.getAlias());
        em.remove(usuario);
    }

    /** <code>select o from Usuario o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Usuario> getUsuarioFindAll() {
        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }

    public Telefono persistTelefono(Telefono telefono) {
        em.persist(telefono);
        return telefono;
    }

    public Telefono mergeTelefono(Telefono telefono) {
        return em.merge(telefono);
    }

    public void removeTelefono(Telefono telefono) {
        telefono = em.find(Telefono.class, telefono.getId());
        em.remove(telefono);
    }

    /** <code>select o from Telefono o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Telefono> getTelefonoFindAll() {
        return em.createNamedQuery("Telefono.findAll", Telefono.class).getResultList();
    }

    public Item persistItem(Item item) {
        em.persist(item);
        return item;
    }

    public Item mergeItem(Item item) {
        return em.merge(item);
    }

    public void removeItem(Item item) {
        item = em.find(Item.class, item.getId());
        em.remove(item);
    }

    /** <code>select o from Item o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Item> getItemFindAll() {
        return em.createNamedQuery("Item.findAll", Item.class).getResultList();
    }
}
