package com.aharoo.services;

import com.aharoo.models.Rating;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

@SuppressWarnings("deprecation")
public class RatingService {

    Configuration con = new Configuration().configure().addAnnotatedClass(Rating.class);

    public void saveCloudRating(Rating rating){
        Session session = null;
        Transaction tx = null;
        try {
            SessionFactory factory = con.buildSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            session.persist(rating);
            tx.commit();
        } catch (Exception e){
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
    }
    public List<Rating> getAllCloudRatings(){
        Session session = null;
        Transaction tx = null;
        try {
            SessionFactory factory = con.buildSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from Rating");
            List<Rating> ratings = query.list();
            tx.commit();
            return ratings;
        } catch (Exception e){
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
        return null;
    }
    public void deleteCloudRating(Rating rating){
        Session session = null;
        Transaction tx = null;
        try {
            SessionFactory factory = con.buildSessionFactory();
            session = factory.openSession();
            tx = session.beginTransaction();
            session.delete(rating);
            tx.commit();
        } catch (Exception e){
            if (tx != null) tx.rollback();
        } finally {
            if (session != null) session.close();
        }
    }
}
