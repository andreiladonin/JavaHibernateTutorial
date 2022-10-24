package org.hibernategeek;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // начальные настройки
        // надо добавить класс
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(UserDetails.class)
                .buildSessionFactory();


        Session session = null;
        //===Create==
//        session = sessionFactory.getCurrentSession();
//        // открыть транкзацию
//        session.beginTransaction();
//        Product product = new Product("Хлеб", 45);
//        System.out.println(product);
//        session.save(product);
//        System.out.println(product);
//        // закрыть
//        session.getTransaction().commit();

        // READ
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Product product = session.get(Product.class, 1L);
//        session.getTransaction().commit();
//        System.out.println(product);

        // UPDATE
//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        Product product = session.get(Product.class, 2L);
//        System.out.println(product);
//        product.setPrice(50);
//        session.getTransaction().commit();
//        sessionFactory.close();


//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//        List<Product> products = session.createQuery("FROM Product", Product.class).getResultList();
//
//        products.forEach(System.out::println);
//        session.getTransaction().commit();
//        sessionFactory.close();

//        session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
//
//        User user = session.get(User.class, 1L);
//
//        System.out.println(user);
//        System.out.println(user.getDetails());
//
//        session.getTransaction().commit();


        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        UserDetails userDetails = new UserDetails("some@mail.com", "Moscow");
        User user = new User("Ivan", userDetails);
        session.save(userDetails);
        session.save(user);
        session.getTransaction().commit();
        sessionFactory.close();
    }
}