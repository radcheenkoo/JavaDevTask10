package org.example.crud.services;

import org.example.HibernateUtil;
import org.example.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {

    private Session session = HibernateUtil.getInstance().getSessionFactory().openSession();

    public boolean create(Client client) {

            Transaction transaction = session.beginTransaction();

            try {
                session.persist(client);
                transaction.commit();

                return true;

            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }

        return false;
    }


    public boolean update(Client client) {

        if (client == null){
            return false;
        }

            Transaction transaction = session.beginTransaction();

            try{
                session.merge(client);
                transaction.commit();

                return true;

            }catch (Exception e){
                e.printStackTrace();
                transaction.rollback();
            }


        return false;
    }


    public Client getById(int clientId) {
           return session.get(Client.class, clientId);

    }



    public List<Client> getAll() {
            return session.createQuery("from client", Client.class).list();

    }


    public void deleteById(int clientId) {
            Transaction transaction = session.beginTransaction();
            Client client = session.get(Client.class,clientId);
            session.remove(client);
            transaction.commit();

    }


}
