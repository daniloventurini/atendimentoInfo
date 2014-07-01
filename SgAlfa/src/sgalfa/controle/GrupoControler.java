package sgalfa.controle;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Grupo;


/**
 *
 * @author Jaime
 */
public class GrupoControler {

    private DaoGenerico dao;
    private static GrupoControler instance;

    private GrupoControler() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized GrupoControler getInstance() {
        if (instance == null) {
            instance = new GrupoControler();
        }
        return instance;
    }

    public Grupo salvar(Grupo objeto) {
        try {
            return (Grupo) dao.save(objeto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(Grupo objeto) {
        try {
            dao.delete(objeto);
        } catch (Exception ex) {
            if (ex.getMessage().contains("org.hibernate.exception.ConstraintViolationException")) {
                throw new RuntimeException(ex);
            } else {

                throw new RuntimeException(ex);
            }
        }
    }

    public Grupo carregar(Long id) {
        try {
            return (Grupo) dao.getById(id, Grupo.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Grupo.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Grupo.class, atributo, criterio);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List<Grupo> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;

        if (tipoConsulta == 0) {
            atributo = "nome";
        } 
        return listaCriterio(atributo, filtro);
    }
}
