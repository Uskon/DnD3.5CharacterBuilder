/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentLists;

import Components.Skill;
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
public class SkillList {
    private EntityManagerFactory emf = null;
    
    public SkillList() {
        emf = Persistence.createEntityManagerFactory("DnDCharBuilderPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Skill> getSkills() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Skill.class));
        Query q = em.createQuery(cq);

        return q.getResultList();

    }
    
    public void addSkill(Skill skill) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(skill);
        em.getTransaction().commit();
    }
}
