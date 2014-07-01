/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.ItensVenda;

/**
 *
 * @author Administrador
 */
public class ItensVendaControle {
    private DaoGenerico dao;
    private static ItensVendaControle instance;

    public ItensVendaControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized ItensVendaControle getInstance(){
        if (instance == null){
            instance = new ItensVendaControle();
        }
        return instance;
    }

    public ItensVenda salvar(ItensVenda objeto){
        try {
            return (ItensVenda) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(ItensVenda objeto){
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

        public ItensVenda carregar(Long id){
            try {
                return (ItensVenda) dao.getById(id, ItensVenda.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(ItensVenda.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(ItensVenda.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<ItensVenda> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nomeItensVenda";
            } else if (tipoConsulta == 1){
                atributo = "estado";
            }
            return listaCriterio(atributo, filtro);
        }

    }
