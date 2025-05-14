package util;

import model.Fornecedor;
import model.Produto;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                .configure() // carrega hibernate.cfg.xml
                .addAnnotatedClass(Fornecedor.class)
                .addAnnotatedClass(Produto.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
