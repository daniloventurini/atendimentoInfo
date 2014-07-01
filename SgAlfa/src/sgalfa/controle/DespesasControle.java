/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Despesas;

/**
 *
 * @author Administrador
 */
public class DespesasControle {
    private DaoGenerico dao;
    private static DespesasControle instance;

    public DespesasControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized DespesasControle getInstance(){
        if (instance == null){
            instance = new DespesasControle();
        }
        return instance;
    }

    public Despesas salvar(Despesas objeto){
        try {
            return (Despesas) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Despesas objeto){
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

        public Despesas carregar(Long id){
            try {
                return (Despesas) dao.getById(id, Despesas.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Despesas.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(Despesas.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<Despesas> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "despesa";
            } 
            return listaCriterio(atributo, filtro);
        }
    
    }
