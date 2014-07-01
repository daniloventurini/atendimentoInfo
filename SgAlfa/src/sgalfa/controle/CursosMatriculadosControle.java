/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.CursosMatriculados;

/**
 *
 * @author Administrador
 */
public class CursosMatriculadosControle {
    private DaoGenerico dao;
    private static CursosMatriculadosControle instance;

    public CursosMatriculadosControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized CursosMatriculadosControle getInstance(){
        if (instance == null){
            instance = new CursosMatriculadosControle();
        }
        return instance;
    }

    public CursosMatriculados salvar(CursosMatriculados objeto){
        try {
            return (CursosMatriculados) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(CursosMatriculados objeto){
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

        public CursosMatriculados carregar(Long id){
            try {
                return (CursosMatriculados) dao.getById(id, CursosMatriculados.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(CursosMatriculados.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(CursosMatriculados.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<CursosMatriculados> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "nomeCursosMatriculados";
            } else if (tipoConsulta == 1){
                atributo = "estado";
            }
            return listaCriterio(atributo, filtro);
        }

    }
