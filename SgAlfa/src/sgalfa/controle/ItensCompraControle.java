/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.ItensCompra;

/**
 *
 * @author Administrador
 */
public class ItensCompraControle {
    private DaoGenerico dao;
    private static ItensCompraControle instance;

    public ItensCompraControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized ItensCompraControle getInstance(){
        if (instance == null){
            instance = new ItensCompraControle();
        }
        return instance;
    }

    public ItensCompra salvar(ItensCompra objeto){
        try {
            return (ItensCompra) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(ItensCompra objeto){
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

        public ItensCompra carregar(Long id){
            try {
                return (ItensCompra) dao.getById(id, ItensCompra.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(ItensCompra.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(ItensCompra.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<ItensCompra> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nomeItensCompra";
            } else if (tipoConsulta == 1){
                atributo = "estado";
            }
            return listaCriterio(atributo, filtro);
        }

    }
