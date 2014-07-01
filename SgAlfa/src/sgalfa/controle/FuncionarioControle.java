/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Funcionario;

/**
 *
 * @author Administrador
 */
public class FuncionarioControle {
    private DaoGenerico dao;
    private static FuncionarioControle instance;

    public FuncionarioControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized FuncionarioControle getInstance(){
        if (instance == null){
            instance = new FuncionarioControle();
        }
        return instance;
    }

    public Funcionario salvar(Funcionario objeto){
        try {
            return (Funcionario) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Funcionario objeto){
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

        public Funcionario carregar(Long id){
            try {
                return (Funcionario) dao.getById(id, Funcionario.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Funcionario.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(Funcionario.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<Funcionario> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nome";
            } else if (tipoConsulta == 1){
                atributo = "cargo";
            }
            return listaCriterio(atributo, filtro);
        }
    
    }
