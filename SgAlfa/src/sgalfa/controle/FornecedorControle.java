/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Fornecedor;

/**
 *
 * @author Administrador
 */
public class FornecedorControle {
    private DaoGenerico dao;
    private static FornecedorControle instance;

    public FornecedorControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized FornecedorControle getInstance(){
        if (instance == null){
            instance = new FornecedorControle();
        }
        return instance;
    }

    public Fornecedor salvar(Fornecedor objeto){
        try {
            return (Fornecedor) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Fornecedor objeto){
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

        public Fornecedor carregar(Long id){
            try {
                return (Fornecedor) dao.getById(id, Fornecedor.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Fornecedor.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(Fornecedor.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<Fornecedor> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nome";
            } else if (tipoConsulta == 1){
                atributo = "cnpj";
            } else if (tipoConsulta == 2){
                atributo = "inscricao";
            }
            return listaCriterio(atributo, filtro);
        }

    }
