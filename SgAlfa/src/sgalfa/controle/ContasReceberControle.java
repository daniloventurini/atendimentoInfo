/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.ContasReceber;

/**
 *
 * @author Administrador
 */
public class ContasReceberControle {
    private DaoGenerico dao;
    private static ContasReceberControle instance;

    public ContasReceberControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized ContasReceberControle getInstance(){
        if (instance == null){
            instance = new ContasReceberControle();
        }
        return instance;
    }

    public ContasReceber salvar(ContasReceber objeto){
        try {
            return (ContasReceber) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(ContasReceber objeto){
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

        public ContasReceber carregar(Long id){
            try {
                return (ContasReceber) dao.getById(id, ContasReceber.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(ContasReceber.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(ContasReceber.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<ContasReceber> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            
            return listaCriterio(atributo, filtro);
        }

    public List<ContasReceber> montaListaObjeto(String filtro) {
         try {
            return dao.listCriterioObjeto(ContasReceber.class, filtro);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }

    }
