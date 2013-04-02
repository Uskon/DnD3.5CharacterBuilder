/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentLists;

import Components.Race;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Uskon
 */
public class RaceList {

    private EntityManagerFactory emf = null;

    public RaceList() {
        emf = Persistence.createEntityManagerFactory("DnDCharBuilderPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Race> getRacesTest() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT r FROM Race r WHERE r.raceName LIKE 'H%'").getResultList();
    }

    public List<Race> getRaces() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Race.class));
        Query q = em.createQuery(cq);

        return q.getResultList();

    }

    public void addRace(Race race) {
        EntityManager em = getEntityManager();

        em.getTransaction().begin();
        em.persist(race);
        em.getTransaction().commit();
    }
}
