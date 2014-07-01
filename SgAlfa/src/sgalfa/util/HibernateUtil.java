package sgalfa.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import sgalfa.entidades.Curso;
import sgalfa.entidades.Cidade;
import sgalfa.entidades.Cliente;
import sgalfa.entidades.Compra;
import sgalfa.entidades.ContasPagar;
import sgalfa.entidades.ContasReceber;
import sgalfa.entidades.CursosMatriculados;
import sgalfa.entidades.Despesas;
import sgalfa.entidades.Fornecedor;
import sgalfa.entidades.Funcionario;
import sgalfa.entidades.Grupo;
import sgalfa.entidades.ItensCompra;
import sgalfa.entidades.ItensVenda;
import sgalfa.entidades.Matricula;
import sgalfa.entidades.Atendimento;
import sgalfa.entidades.Estado;
import sgalfa.entidades.PlanoInternet;
import sgalfa.entidades.Produto;
import sgalfa.entidades.Usuario;
import sgalfa.entidades.Venda;
import sgalfa.entidades.VendaPlano;


public class HibernateUtil {

 private static final SessionFactory factory;
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final ThreadLocal transactionThread = new ThreadLocal();

    public static Session getSession() {
        Session session = (Session) sessionThread.get();
        if ((session == null) || (!(session.isOpen()))) {
            session = factory.openSession();
            sessionThread.set(session);
        }
        return ((Session) sessionThread.get());
    }

    public static void closeSession() {
        Session session = (Session) sessionThread.get();
        if ((session != null) && (session.isOpen())) {
            sessionThread.set(null);
            session.close();
        }
    }

    public static void beginTransaction() {
        Transaction transaction = getSession().beginTransaction();
        transactionThread.set(transaction);
    }

    public static void commitTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.commit();
            transactionThread.set(null);
        }
    }

    public static void rollbackTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.rollback();
            transactionThread.set(null);
        }
    }

    static {
        try {
            factory = new AnnotationConfiguration()
               .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
                    .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/sgalfa")
                    .setProperty("hibernate.connection.username", "root")
                    .setProperty("hibernate.connection.password", "root")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.c3p0.max_size", "10")
                    .setProperty("hibernate.c3p0.min_size", "2")
                    .setProperty("hibernate.c3p0.timeout", "5000")
                    .setProperty("hibernate.c3p0.max_statements", "10")
                    .setProperty("hibernate.c3p0.idle_test_period", "3000")
                    .setProperty("hibernate.c3p0.acquire_increment", "2")
                    .setProperty("show_sql", "true")
                    .setProperty("use_outer_join", "true")
                    .setProperty("hibernate.generate_statistics", "true")
                    .setProperty("hibernate.use_sql_comments", "true")
                    .setProperty("hibernate.format_sql", "true")
                    .addAnnotatedClass(Cidade.class)
                    .addAnnotatedClass(Cliente.class)
                    .addAnnotatedClass(Produto.class)
                    .addAnnotatedClass(Venda.class)
                    .addAnnotatedClass(ItensVenda.class)
                    .addAnnotatedClass(ContasReceber.class)
                    .addAnnotatedClass(ContasPagar.class)
                    .addAnnotatedClass(Funcionario.class)
                    .addAnnotatedClass(Despesas.class)
                    .addAnnotatedClass(Atendimento.class)
                    .addAnnotatedClass(Fornecedor.class)
                    .addAnnotatedClass(Usuario.class)
                    .addAnnotatedClass(Compra.class)
                    .addAnnotatedClass(ItensCompra.class)
                    .addAnnotatedClass(PlanoInternet.class)
                    .addAnnotatedClass(VendaPlano.class)
                    .addAnnotatedClass(Curso.class)
                    .addAnnotatedClass(Grupo.class)
                    .addAnnotatedClass(CursosMatriculados.class)
                    .addAnnotatedClass(Matricula.class)
                    .addAnnotatedClass(Estado.class)
                    .buildSessionFactory();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
