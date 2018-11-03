package edu.matc.persistence;

import edu.matc.entity.HikingTrail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

public class HikingTrailDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<HikingTrail> getAllHikingTrails() {

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrail> query = builder.createQuery(HikingTrail.class);
        Root<HikingTrail> root = query.from(HikingTrail.class);
        List<HikingTrail> HikingTrails = session.createQuery(query).getResultList();
        session.close();
        return(HikingTrails);
    }

    public List<HikingTrail> getHikingTrailsByTrailHeadName(String trailHeadName) {

        logger.debug("Searching for {}" + trailHeadName);

        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrail> query = builder.createQuery(HikingTrail.class);
        Root<HikingTrail> root = query.from(HikingTrail.class);
        Expression<String> propertyPath = root.get("trailHeadName");
        query.where(builder.like(propertyPath, "%" + trailHeadName + "%"));
        List<HikingTrail> HikingTrails = session.createQuery(query).getResultList();
        session.close();
        return(HikingTrails);
    }

    /**
     * Gets a HikingTrail by id
     * @return a HikingTrail
     */

    public HikingTrail getById(int id) {

        Session session = sessionFactory.openSession();
        HikingTrail HikingTrails = session.get(HikingTrail.class, id);
        session.close();
        return HikingTrails;
    }


    /**
     * update HikingTrail
     * @param HikingTrails  HikingTrail to be inserted or updated
     */
    public void saveOrUpdate(HikingTrail HikingTrails) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(HikingTrails);
        session.close();
    }

    /**
     * update HikingTrail
     * @param HikingTrails  HikingTrail to be inserted or updated
     */
    public int insert(HikingTrail HikingTrails) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(HikingTrails);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a HikingTrail
     * @param HikingTrails HikingTrail to be deleted
     */
    public void delete(HikingTrail HikingTrails) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(HikingTrails);
        transaction.commit();
        session.close();
    }


    /** Return a list of all HikingTrail
     *
     * @return All HikingTrail
     */
    public List<HikingTrail> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrail> query = builder.createQuery( HikingTrail.class );
        Root<HikingTrail> root = query.from( HikingTrail.class );
        List<HikingTrail> HikingTrails = session.createQuery( query ).getResultList();

        logger.debug("The list of HikingTrail " + HikingTrails);
        session.close();

        return HikingTrails;
    }

    /**
     * Get HikingTrail by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<HikingTrail> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for HikingTrail with " + propertyName + " = " + value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrail> query = builder.createQuery( HikingTrail.class );
        Root<HikingTrail> root = query.from( HikingTrail.class );
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<HikingTrail> HikingTrails = session.createQuery( query ).getResultList();

        session.close();
        return HikingTrails;
    }

    /**
     * Get HikingTrail by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<HikingTrail> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for HikingTrail with {} = {}",  propertyName, value);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<HikingTrail> query = builder.createQuery( HikingTrail.class );
        Root<HikingTrail> root = query.from( HikingTrail.class );
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<HikingTrail> HikingTrails = session.createQuery( query ).getResultList();
        session.close();
        return HikingTrails;
    }

}
