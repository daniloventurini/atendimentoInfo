package sgalfa.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.Select;
import sgalfa.entidades.ContasPagar;
import sgalfa.entidades.ContasReceber;
import sgalfa.entidades.Matricula;
import sgalfa.entidades.Atendimento;
import sgalfa.entidades.Cliente;
import sgalfa.entidades.Produto;
import sgalfa.entidades.Venda;
import sgalfa.entidades.VendaPlano;
import sgalfa.util.HibernateUtil;

public class DaoHibernateGenerico implements DaoGenerico {

    @Override
    public Object save(Object objeto) {
        try {
            Object obj = null;
            HibernateUtil.beginTransaction();
            obj = HibernateUtil.getSession().merge(objeto);
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();
            return obj;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            HibernateUtil.closeSession();
            throw hibernateException;
        }
    }

    @Override
    public void delete(Object objeto) {
        try {
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().delete(objeto);
            HibernateUtil.commitTransaction();
            HibernateUtil.closeSession();
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List list(Class clazz) {
        try {
            List lista = null;
            lista = HibernateUtil.getSession().createCriteria(clazz).list();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List listTeste(Class clazz) {
        try {
            List lista = null;
            Criteria crit= HibernateUtil.getSession().createCriteria(clazz);
            crit.add(Restrictions.ne("status", "DESATIVADO"));
            lista = crit.list();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public Object getById(Serializable id, Class clazz) {
        try {
            Object obj = HibernateUtil.getSession().get(clazz, id);
            return obj;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List listCriterio(Class clazz, String atributo, String criterio) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(clazz, atributo);
            crit.add(Restrictions.ilike(atributo, "%" + criterio + "%"));
            crit.addOrder(Order.asc(atributo));
            crit.setMaxResults(30);
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List listCriterioVenda(Class clazz, Date data1, Date data2, String cliente) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(clazz);
            if ((data1 != null) && (data2 != null)) {
                crit.add(Restrictions.between("dataVenda", data1, data2));
            }
            if (!cliente.equals("")) {
                crit.createCriteria("cliente").add(Restrictions.ilike("nome", "%" + cliente + "%"));
            }
            crit.setMaxResults(30);
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }

    }

    public List<ContasReceber> listCriterioObjeto(Class<ContasReceber> aClass, String filtro) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass, "cliente");
            crit.createCriteria("cliente").add(Restrictions.ilike("nome", "%" + filtro + "%"));
            crit.addOrder(Order.asc("cliente"));
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List<Atendimento> listCriterioObjetoCli(Class<Atendimento> aClass, String filtro, String estado) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass, "funcionario");
            crit.createCriteria("funcionario").add(Restrictions.ilike("nome", "%" + filtro + "%"));
            crit.add(Restrictions.ilike("estado", "%" + estado + "%"));
            crit.addOrder(Order.asc("cliente"));
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List listCriterioOrdem(Class<Atendimento> aClass, String funcionario, String estado) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass);
            if ((funcionario != null) && (estado != null)) {
                crit.createCriteria("funcionario").add(Restrictions.ilike("nome", "%" + funcionario + "%"));
            }
            if (!estado.equals("")) {
                crit.createCriteria("estado").add(Restrictions.ilike("nome", "%" + estado + "%"));
            }
            crit.setMaxResults(30);
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List listCriterioCompra(Class clazz, Date data1, Date data2, String cliente) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(clazz);
            if ((data1 != null) && (data2 != null)) {
                crit.add(Restrictions.between("dataCompra", data1, data2));
            }
            if (!cliente.equals("")) {
                crit.createCriteria("fornecedor").add(Restrictions.ilike("nome", "%" + cliente + "%"));
            }
            crit.setMaxResults(30);
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List<VendaPlano> listCriterioObjetoClientePlano(Class<VendaPlano> aClass, String filtro) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass, "planoInternet");
            crit.createCriteria("planoInternet").add(Restrictions.ilike("descricao", "%" + filtro + "%"));
            crit.addOrder(Order.asc("planoInternet"));
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List<VendaPlano> listCriterioObjetoPlanoInternet(Class<VendaPlano> aClass, String filtro) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass, "cliente");
            crit.createCriteria("cliente").add(Restrictions.ilike("nome", "%" + filtro + "%"));
            crit.addOrder(Order.asc("cliente"));
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List<ContasPagar> listCriterioObjetoPagar(Class<ContasPagar> aClass, String filtro) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass, "fornecedor");
            crit.createCriteria("fornecedor").add(Restrictions.ilike("nome", "%" + filtro + "%"));
            crit.addOrder(Order.asc("fornecedor"));
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }

    public List<Matricula> listCriterioMatriculaCliente(Class<Matricula> aClass, String filtro) {
        try {
            List lista = null;
            Criteria crit = HibernateUtil.getSession().createCriteria(aClass, "cliente");
            crit.createCriteria("cliente").add(Restrictions.ilike("nome", "%" + filtro + "%"));
            crit.addOrder(Order.asc("cliente"));
            lista = crit.list();
            //HibernateUtil.closeSession();
            return lista;
        } catch (HibernateException hibernateException) {
            HibernateUtil.rollbackTransaction();
            throw new RuntimeException(hibernateException);
        }
    }
}