/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgalfa.controle;


import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.VendaPlano;

/**
 *
 * @author Jaime
 */
public class VendaPlanoCotroler {

    private DaoGenerico dao;
    private static VendaPlanoCotroler instance;

    private VendaPlanoCotroler() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized VendaPlanoCotroler getInstance() {
        if (instance == null) {
            instance = new VendaPlanoCotroler();
        }
        return instance;
    }

    public VendaPlano salvar(VendaPlano objeto) {
        try {

            return (VendaPlano) dao.save(objeto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(VendaPlano objeto) {
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

    public VendaPlano carregar(Long id) {
        try {
            return (VendaPlano) dao.getById(id, VendaPlano.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(VendaPlano.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(VendaPlano.class, atributo, criterio);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List<VendaPlano> montaLista( Integer tipoConsulta, String filtro) {
        String atributo = null;
        if (tipoConsulta == 0) {
            atributo = "id";
        }
        return listaCriterio(atributo, filtro);
    }

     public List<VendaPlano> montaListaObjetoClientePlano(String filtro) {
          try {
            return dao.listCriterioObjetoClientePlano(VendaPlano.class, filtro);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }
    public List<VendaPlano> montaListaObjetoPlanoInternet(String filtro) {
          try {
            return dao.listCriterioObjetoPlanoInternet(VendaPlano.class, filtro);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    }

