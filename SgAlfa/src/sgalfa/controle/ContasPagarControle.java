/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.ContasPagar;

/**
 *
 * @author Administrador
 */
public class ContasPagarControle {
    private DaoGenerico dao;
    private static ContasPagarControle instance;

    public ContasPagarControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized ContasPagarControle getInstance(){
        if (instance == null){
            instance = new ContasPagarControle();
        }
        return instance;
    }

    public ContasPagar salvar(ContasPagar objeto){
        try {
            return (ContasPagar) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(ContasPagar objeto){
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

        public ContasPagar carregar(Long id){
            try {
                return (ContasPagar) dao.getById(id, ContasPagar.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(ContasPagar.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(ContasPagar.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<ContasPagar> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            
            return listaCriterio(atributo, filtro);
        }

    public List<ContasPagar> montaListaObjeto(String filtro) {
         try {
            return dao.listCriterioObjetoPagar(ContasPagar.class, filtro);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    }
