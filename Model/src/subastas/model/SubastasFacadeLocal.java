package subastas.model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface SubastasFacadeLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Subasta persistSubasta(Subasta subasta);

    Subasta mergeSubasta(Subasta subasta);

    void removeSubasta(Subasta subasta);

    List<Subasta> getSubastaFindAll();

    Administrador persistAdministrador(Administrador administrador);

    Administrador mergeAdministrador(Administrador administrador);

    void removeAdministrador(Administrador administrador);

    List<Administrador> getAdministradorFindAll();

    Categoria persistCategoria(Categoria categoria);

    Categoria mergeCategoria(Categoria categoria);

    void removeCategoria(Categoria categoria);

    List<Categoria> getCategoriaFindAll();

    Variablessistema persistVariablessistema(Variablessistema variablessistema);

    Variablessistema mergeVariablessistema(Variablessistema variablessistema);

    void removeVariablessistema(Variablessistema variablessistema);

    List<Variablessistema> getVariablessistemaFindAll();

    Subcategoria persistSubcategoria(Subcategoria subcategoria);

    Subcategoria mergeSubcategoria(Subcategoria subcategoria);

    void removeSubcategoria(Subcategoria subcategoria);

    List<Subcategoria> getSubcategoriaFindAll();

    Puja persistPuja(Puja puja);

    Puja mergePuja(Puja puja);

    void removePuja(Puja puja);

    List<Puja> getPujaFindAll();

    Participante persistParticipante(Participante participante);

    Participante mergeParticipante(Participante participante);

    void removeParticipante(Participante participante);

    List<Participante> getParticipanteFindAll();

    Resenna persistResenna(Resenna resenna);

    Resenna mergeResenna(Resenna resenna);

    void removeResenna(Resenna resenna);

    List<Resenna> getResennaFindAll();

    PujaGanadora persistPujaGanadora(PujaGanadora pujaGanadora);

    PujaGanadora mergePujaGanadora(PujaGanadora pujaGanadora);

    List<PujaGanadora> getPujaGanadoraFindAll();

    Usuario persistUsuario(Usuario usuario);

    Usuario mergeUsuario(Usuario usuario);

    void removeUsuario(Usuario usuario);

    List<Usuario> getUsuarioFindAll();

    Telefono persistTelefono(Telefono telefono);

    Telefono mergeTelefono(Telefono telefono);

    void removeTelefono(Telefono telefono);

    List<Telefono> getTelefonoFindAll();

    Item persistItem(Item item);

    Item mergeItem(Item item);

    void removeItem(Item item);

    List<Item> getItemFindAll();
}
