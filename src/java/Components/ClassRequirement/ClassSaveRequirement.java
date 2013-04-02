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
public class ClassSaveRequirement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @ManyToOne
    private CClass c;
    @Column
    private int fortSave;
    @Column
    private int willSave;
    @Column
    private int reflSave;

    public ClassSaveRequirement() {
    }

    public ClassSaveRequirement(CClass c, int fortSave, int willSave, int reflSave) {
        this.c = c;
        this.fortSave = fortSave;
        this.willSave = willSave;
        this.reflSave = reflSave;
    }

    public CClass getC() {
        return c;
    }

    public void setC(CClass c) {
        this.c = c;
    }


    public int getFortSave() {
        return fortSave;
    }

    public void setFortSave(int fortSave) {
        this.fortSave = fortSave;
    }

    public int getWillSave() {
        return willSave;
    }

    public void setWillSave(int willSave) {
        this.willSave = willSave;
    }

    public int getReflSave() {
        return reflSave;
    }

    public void setReflSave(int reflSave) {
        this.reflSave = reflSave;
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
        if (!(object instanceof ClassSaveRequirement)) {
            return false;
        }
        ClassSaveRequirement other = (ClassSaveRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatSaveRequirement[ id=" + id + " ]";
    }
    
}
