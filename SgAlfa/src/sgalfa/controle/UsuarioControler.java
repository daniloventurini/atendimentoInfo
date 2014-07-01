/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgalfa.controle;



import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Usuario;

/**
 *
 * @author Jaime
 */
public class UsuarioControler {

    private DaoGenerico dao;
    private static UsuarioControler instance;

    private UsuarioControler() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized UsuarioControler getInstance() {
        if (instance == null) {
            instance = new UsuarioControler();
        }
        return instance;
    }

    public Usuario salvar(Usuario objeto) {
        try {
            return (Usuario) dao.save(objeto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(Usuario objeto) {
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

    public Usuario carregar(Long id) {
        try {
            return (Usuario) dao.getById(id, Usuario.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Usuario.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Usuario.class, atributo, criterio);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List<Usuario> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;

        if (tipoConsulta == 0) {
            atributo = "login";
        
        }
        return listaCriterio(atributo, filtro);
    }
}
