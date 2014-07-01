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
import sgalfa.entidades.Compra;
import sgalfa.entidades.ItensCompra;
import sgalfa.entidades.ItensVenda;
import sgalfa.entidades.Produto;

/**
 *
 * @author Administrador
 */
public class CompraControle {
    private DaoGenerico dao;
    private static CompraControle instance;

    public CompraControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized CompraControle getInstance(){
        if (instance == null){
            instance = new CompraControle();
        }
        return instance;
    }

    public Compra salvar(Compra objeto){
        try {
            Produto prod = new Produto();
            for (Iterator<ItensCompra> it = objeto.getItensCompra().iterator(); it.hasNext();) {
                ItensCompra iv = it.next();
                prod = iv.getProduto();
                prod.setQnt(prod.getQnt() + iv.getQuantidade());
                dao.save(prod);
            }
            return (Compra) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

     public void excluir(Compra objeto){
        try {
            dao.delete(objeto);
        } catch (Exception e) {
            if (e.getMessage().contains("org.hibernate.exception.ConstrainViolationException")){
                throw new RuntimeException(e);
            }else{
                throw new RuntimeException(e);
            }
        }
    }

        public Compra carregar(Long id){
            try {
                return (Compra) dao.getById(id, Compra.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Compra.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(Date data1, Date data2, String cliente){
            try {
                return dao.listCriterioCompra(Compra.class, data1, data2, cliente);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }
