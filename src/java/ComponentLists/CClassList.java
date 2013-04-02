/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentLists;

import Components.CClass;
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
public class CClassList {
    private EntityManagerFactory emf = null;
    
    public CClassList() {
        emf = Persistence.createEntityManagerFactory("DnDCharBuilderPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<CClass> getClasses() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT c FROM CClass c").getResultList();
    }
    
    public List<CClass> getClasses2() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(CClass.class));
        Query q = em.createQuery(cq);

        return q.getResultList();

    }
    
    public void addClass(CClass c) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
