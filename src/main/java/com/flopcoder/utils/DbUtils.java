package com.flopcoder.utils;

/**
 * Created by Flop Coder on 6/1/14.
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DbUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new AnnotationConfiguration()
                    .configure()
                    .buildSessionFactory();
        } catch (Throwable ert) {
            System.err.println("Initial SessionFactory creation failed." + ert);
            throw new ExceptionInInitializerError(ert);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}