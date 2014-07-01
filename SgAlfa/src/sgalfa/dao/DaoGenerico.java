package sgalfa.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import sgalfa.entidades.Cliente;
import sgalfa.entidades.Compra;
import sgalfa.entidades.ContasPagar;
import sgalfa.entidades.ContasReceber;
import sgalfa.entidades.Matricula;
import sgalfa.entidades.Atendimento;
import sgalfa.entidades.Produto;
import sgalfa.entidades.Venda;
import sgalfa.entidades.VendaPlano;

public interface DaoGenerico {

    public Object save(Object objeto);

    public void delete(Object objeto);

    public List list(Class clazz);

    public List listTeste(Class clazz);

    public List listCriterio(Class clazz, String atributo, String criterio);

    public List listCriterioVenda(Class clazz, Date data1, Date data2, String cliente);

    public Object getById(Serializable id, Class clazz);

    public List<ContasReceber> listCriterioObjeto(Class<ContasReceber> aClass, String filtro);

    public List<Atendimento> listCriterioObjetoCli(Class<Atendimento> aClass, String filtro, String estado);

    public List listCriterioOrdem(Class<Atendimento> aClass, String funcionario, String estado);

    public List listCriterioCompra(Class clazz, Date data1, Date data2, String cliente);

    public List<VendaPlano> listCriterioObjetoClientePlano(Class<VendaPlano> aClass, String filtro);

    public List<VendaPlano> listCriterioObjetoPlanoInternet(Class<VendaPlano> aClass, String filtro);

    public List<ContasPagar> listCriterioObjetoPagar(Class<ContasPagar> aClass, String filtro);

    public List<Matricula> listCriterioMatriculaCliente(Class<Matricula> aClass, String filtro);
}
