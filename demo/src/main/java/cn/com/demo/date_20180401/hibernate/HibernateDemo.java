package cn.com.demo.date_20180401.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.List;

/**
 * @author dubooooo@126.com 2018-04-03
 */
public class HibernateDemo {

    public static void main(String[] args) {
        Configuration configuration = new AnnotationConfiguration().configure("xml/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<BaiDuTieba> sqlQuery = session.createNativeQuery("select * from 百度文库", BaiDuTieba.class);
        List<BaiDuTieba> list = sqlQuery.list();
        list.forEach(obj -> {
            System.out.println(obj);
        });
        transaction.commit();
    }

    public static void main02(String[] args) {
        Configuration configuration = new Configuration().configure("xml/hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //Session session = sessionFactory.openSession();
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery<BaiDuTieba> sqlQuery = session.createNativeQuery("select * from 百度文库", BaiDuTieba.class);
        List<BaiDuTieba> list = sqlQuery.list();
        list.forEach(obj -> {
            System.out.println(obj);
        });
        transaction.commit();
    }

    public static void main01(String[] args) {
        Configuration configuration = new Configuration().configure("xml/hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        NativeQuery sqlQuery = session.createNativeQuery("select * from 百度文库");
        List<Object[]> list = sqlQuery.list();
        list.forEach(objs -> {
            for (Object obj : objs) {
                System.out.print(obj + "\t");
            }
            System.out.println();
        });
    }

}
