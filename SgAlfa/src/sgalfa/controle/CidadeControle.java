/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Cidade;

/**
 *
 * @author Administrador
 */
public class CidadeControle {
    private DaoGenerico dao;
    private static CidadeControle instance;

    public CidadeControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized CidadeControle getInstance(){
        if (instance == null){
            instance = new CidadeControle();
        }
        return instance;
    }

    public Cidade salvar(Cidade objeto){
        try {
            return (Cidade) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Cidade objeto){
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

        public Cidade carregar(Long id){
            try {
                return (Cidade) dao.getById(id, Cidade.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Cidade.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(Cidade.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<Cidade> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nomeCidade";
            } else if (tipoConsulta == 1){
                atributo = "estado";
            }
            return listaCriterio(atributo, filtro);
        }

    }
