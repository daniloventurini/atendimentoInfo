/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Atendimento;

/**
 *
 * @author Administrador
 */
public class AtendimentoControle {

    private DaoGenerico dao;
    private static AtendimentoControle instance;

    public AtendimentoControle() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized AtendimentoControle getInstance() {
        if (instance == null) {
            instance = new AtendimentoControle();
        }
        return instance;
    }

    public Atendimento salvar(Atendimento objeto) {
        try {
            return (Atendimento) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Atendimento objeto) {
        try {
            dao.delete(objeto);
        } catch (Exception e) {
            if (e.getMessage().contains("org.hibernate.exception.ConstrainViolationException")) {
                throw new RuntimeException(e);
            } else {
                throw new RuntimeException(e);
            }
        }
    }

    public Atendimento carregar(Long id) {
        try {
            return (Atendimento) dao.getById(id, Atendimento.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Atendimento.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List listaCriterio(String atributo, String criterio) {
        try {
            return dao.listCriterio(Atendimento.class, atributo, criterio);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Atendimento> montaLista(Integer tipoConsulta, String filtro) {
        String atributo = null;
        if (tipoConsulta == 1) {
            atributo = "estado";
        }
        return listaCriterio(atributo, filtro);
    }

    public List<Atendimento> montaListaObjeto(String filtro, String estado) {
        try {
            return dao.listCriterioObjetoCli(Atendimento.class, filtro, estado);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    public List listaCriterioOrdem(String funcionario, String estado) {
        try {
            return dao.listCriterioOrdem(Atendimento.class, funcionario, estado);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
