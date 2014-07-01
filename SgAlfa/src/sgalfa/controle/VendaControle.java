/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgalfa.controle;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.ContasReceber;
import sgalfa.entidades.ItensVenda;
import sgalfa.entidades.Produto;
import sgalfa.entidades.Venda;

/**
 *
 * @author Administrador
 */
public class VendaControle {

    private DaoGenerico dao;
    private static VendaControle instance;
   
    public VendaControle() {
        dao = new DaoHibernateGenerico();
    }

    public static synchronized VendaControle getInstance() {
        if (instance == null) {
            instance = new VendaControle();
        }
        return instance;
    }

    public Venda salvar(Venda objeto) {
        try {
            Produto prod = new Produto();
            for (Iterator<ItensVenda> it = objeto.getItensVenda().iterator(); it.hasNext();) {
                ItensVenda iv = it.next();
                prod = iv.getProduto();
                prod.setQnt(prod.getQnt() - iv.getQuantidade());
                dao.save(prod);
            }
            return (Venda) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Venda objeto) {
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

    public Venda carregar(Long id) {
        try {
            return (Venda) dao.getById(id, Venda.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List listaTodos() {
        try {
            return dao.list(Venda.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List listaCriterio(Date data1, Date data2, String cliente) {
        try {
            return dao.listCriterioVenda(Venda.class, data1, data2, cliente);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
