/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.ClassRequirement;

import Components.CClass;
import java.io.Serializable;
import javax.persistence.Column;
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
public class ClassClassRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @ManyToOne
    private CClass c;
    @JoinColumn
    @ManyToOne
    private CClass requiredClass;
    @Column
    private int requiredLvl;

    public ClassClassRequirement() {
    }

    public ClassClassRequirement(CClass c, CClass requiredClass, int requiredLvl) {
        this.requiredClass = requiredClass;
        this.c = c;
        this.requiredLvl = requiredLvl;
    }

    public CClass getRequiredClass() {
        return requiredClass;
    }

    public void setRequiredClass(CClass requiredClass) {
        this.requiredClass = requiredClass;
    }

    public CClass getC() {
        return c;
    }

    public void setC(CClass c) {
        this.c = c;
    }

    public int getRequiredLvl() {
        return requiredLvl;
    }

    public void setRequiredLvl(int requiredLvl) {
        this.requiredLvl = requiredLvl;
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
        if (!(object instanceof ClassClassRequirement)) {
            return false;
        }
        ClassClassRequirement other = (ClassClassRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatClassRequirement[ id=" + id + " ]";
    }
}
