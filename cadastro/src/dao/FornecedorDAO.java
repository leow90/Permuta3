package dao;

import model.Fornecedor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class FornecedorDAO {
    public void salvar(Fornecedor fornecedor) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(fornecedor);
        tx.commit();
        session.close();
    }

    public List<Fornecedor> listarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Fornecedor> lista = session.createQuery("from Fornecedor", Fornecedor.class).list();
        session.close();
        return lista;
    }
}
