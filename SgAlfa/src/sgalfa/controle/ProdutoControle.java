/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Produto;

/**
 *
 * @author Administrador
 */
public class ProdutoControle {
    private DaoGenerico dao;
    private static ProdutoControle instance;

    public ProdutoControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized ProdutoControle getInstance(){
        if (instance == null){
            instance = new ProdutoControle();
        }
        return instance;
    }

    public Produto salvar(Produto objeto){
        try {
            return (Produto) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Produto objeto){
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

        public Produto carregar(Long id){
            try {
                return (Produto) dao.getById(id, Produto.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Produto.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

       public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(Produto.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
       
  

        public List<Produto> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nomeProduto";
            } else if (tipoConsulta == 1){
                atributo = "descricao";
            }
            return listaCriterio(atributo, filtro);
        }

    }
