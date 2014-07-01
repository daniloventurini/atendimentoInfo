/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgalfa.controle;


import sgalfa.entidades.Curso;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;

/**
 *
 * @author Jaime
 */
public class CursoControler {

    private DaoGenerico dao;
    private static CursoControler instance;

    private CursoControler() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized CursoControler getInstance() {
        if (instance == null) {
            instance = new CursoControler();
        }
        return instance;
    }

    public Curso salvar(Curso objeto) {
        try {
            return (Curso) dao.save(objeto);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void excluir(Curso objeto) {
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

    public Curso carregar(Long id) {
        try {
            return (Curso) dao.getById(id, Curso.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Curso.class);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Curso.class, atributo, criterio);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List<Curso> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;

        if (tipoConsulta == 0) {
            atributo = "nome";
        } 
        return listaCriterio(atributo, filtro);
    }
}
