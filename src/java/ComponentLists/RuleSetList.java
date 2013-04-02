/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentLists;

import Components.RuleSet;
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
public class RuleSetList {
    private EntityManagerFactory emf = null;
    
    public RuleSetList() {
        emf = Persistence.createEntityManagerFactory("DnDCharBuilderPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<RuleSet> getRuleSets() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(RuleSet.class));
        Query q = em.createQuery(cq);

        return q.getResultList();

    }
    
    public void addRuleSet(RuleSet rset) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(rset);
        em.getTransaction().commit();
    }
}
