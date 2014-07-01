/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sgalfa.controle;

import java.util.List;
import sgalfa.dao.DaoGenerico;
import sgalfa.dao.DaoHibernateGenerico;
import sgalfa.entidades.Matricula;

/**
 *
 * @author Administrador
 */
public class MatriculaControle {
    private DaoGenerico dao;
    private static MatriculaControle instance;

    public MatriculaControle(){
        dao = new DaoHibernateGenerico();
    }

    public static synchronized MatriculaControle getInstance(){
        if (instance == null){
            instance = new MatriculaControle();
        }
        return instance;
    }

    public Matricula salvar(Matricula objeto){
        try {
            return (Matricula) dao.save(objeto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Matricula objeto){
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

        public Matricula carregar(Long id){
            try {
                return (Matricula) dao.getById(id, Matricula.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaTodos(){
            try {
                return dao.list(Matricula.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List listaCriterio(String atributo, String criterio){
            try {
                return dao.listCriterio(Matricula.class, atributo, criterio);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public List<Matricula> montaLista(Integer tipoConsulta, String filtro){
            String atributo=null;
            if (tipoConsulta == 0){
                atributo = "data";
            } 
            return listaCriterio(atributo, filtro);
        }
    public List<Matricula> montaListaMatricula(String filtro) {
         try {
            return dao.listCriterioMatriculaCliente(Matricula.class, filtro);
        } catch (Exception ex) {

            throw new RuntimeException(ex);
        }
    }
    }
