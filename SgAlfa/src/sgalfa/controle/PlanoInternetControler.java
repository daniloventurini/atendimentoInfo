/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgalfa.controle;



import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.PlanoInternet;

/**
 *
 * @author Jaime
 */
public class PlanoInternetControler {

    private DaoGenerico dao;
    private static PlanoInternetControler instance;

    private PlanoInternetControler() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized PlanoInternetControler getInstance() {
        if (instance == null) {
            instance = new PlanoInternetControler();
        }
        return instance;
    }

    public PlanoInternet salvar(PlanoInternet objeto) {
        try {
            return (PlanoInternet) dao.save(objeto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(PlanoInternet objeto) {
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

    public PlanoInternet carregar(Long id) {
        try {
            return (PlanoInternet) dao.getById(id, PlanoInternet.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(PlanoInternet.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(PlanoInternet.class, atributo, criterio);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List<PlanoInternet> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;

        if (tipoConsulta == 0) {
            atributo = "descricao";
        }

        return listaCriterio(atributo, filtro);
    }
}
