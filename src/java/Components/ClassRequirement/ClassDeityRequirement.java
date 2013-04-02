/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.ClassRequirement;

import Components.CClass;
import Components.Deity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Uskon
 */
@Entity
public class ClassDeityRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @ManyToOne
    private CClass c;
    @JoinColumn
    @ManyToOne
    private Deity deity;

    public ClassDeityRequirement() {
    }

    public ClassDeityRequirement(CClass c, Deity deity) {
        this.c = c;
        this.deity = deity;
    }

    public CClass getC() {
        return c;
    }

    public void setC(CClass c) {
        this.c = c;
    }

    public Deity getDeity() {
        return deity;
    }

    public void setDeity(Deity deity) {
        this.deity = deity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClassDeityRequirement)) {
            return false;
        }
        ClassDeityRequirement other = (ClassDeityRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatDeityRequirement[ id=" + id + " ]";
    }
}
