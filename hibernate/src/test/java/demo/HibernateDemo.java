package demo;

import cn.com.hibernate.demo.BaiDuTieba;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.junit.Test;

import java.util.List;

/**
 * @author dubooooo@126.com 2018-04-03
 */
public class HibernateDemo {

    private static String hibernate_cfg_xml = "hibernate.cfg.xml";

    public static void main(String[] args) {
        //        Configuration configuration = new AnnotationConfiguration().configure(hibernate_cfg_xml);
        //        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //        //Session session = sessionFactory.openSession();
        //        Session session = sessionFactory.getCurrentSession();
        //        Transaction transaction = session.beginTransaction();
        //        NativeQuery<BaiDuTieba> sqlQuery = session.createNativeQuery("select * from 百度文库", BaiDuTieba.class);
        //        List<BaiDuTieba> list = sqlQuery.list();
        //        list.forEach(obj -> {
        //            System.out.println(obj);
        //        });
        //        transaction.commit();
    }

    @Test
    public void test02() {
        Configuration configuration = new Configuration().configure(hibernate_cfg_xml);
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

    @Test
    public void test01() {
        Configuration configuration = new Configuration().configure(hibernate_cfg_xml);

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
