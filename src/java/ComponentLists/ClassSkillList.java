/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ComponentLists;

import Components.ClassSkill;
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
public class ClassSkillList {
    private EntityManagerFactory emf = null;
    
    public ClassSkillList() {
        emf = Persistence.createEntityManagerFactory("DnDCharBuilderPU");
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<ClassSkill> getClassSkills() {
        EntityManager em = getEntityManager();
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(ClassSkill.class));
        Query q = em.createQuery(cq);

        return q.getResultList();

    }
    
    public void addClassSkill(ClassSkill cskill) {
        EntityManager em = getEntityManager();
        
        em.getTransaction().begin();
        em.persist(cskill);
        em.getTransaction().commit();
    }
    
}
