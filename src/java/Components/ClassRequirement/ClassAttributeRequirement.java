/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.ClassRequirement;

import Components.CClass;
import Components.Feat;
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
public class ClassAttributeRequirement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JoinColumn
    @ManyToOne
    private CClass cclass;
    @Column
    private int STR;
    @Column
    private int DEX;
    @Column
    private int CON;
    @Column
    private int INTG;
    @Column
    private int WIS;
    @Column
    private int CHA;

    public ClassAttributeRequirement() {
    }

    public ClassAttributeRequirement(CClass c, int STR, int DEX, int CON, int INT, int WIS, int CHA) {
        this.cclass = c;
        this.STR = STR;
        this.DEX = DEX;
        this.CON = CON;
        this.INTG = INT;
        this.WIS = WIS;
        this.CHA = CHA;
    }

    public CClass getCclass() {
        return cclass;
    }

    public void setCclass(CClass c) {
        this.cclass = c;
    }

    public int getSTR() {
        return STR;
    }

    public void setSTR(int STR) {
        this.STR = STR;
    }

    public int getDEX() {
        return DEX;
    }

    public void setDEX(int DEX) {
        this.DEX = DEX;
    }

    public int getCON() {
        return CON;
    }

    public void setCON(int CON) {
        this.CON = CON;
    }

    public int getINTG() {
        return INTG;
    }

    public void setINT(int INT) {
        this.INTG = INT;
    }

    public int getWIS() {
        return WIS;
    }

    public void setWIS(int WIS) {
        this.WIS = WIS;
    }

    public int getCHA() {
        return CHA;
    }

    public void setCHA(int CHA) {
        this.CHA = CHA;
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
        if (!(object instanceof ClassAttributeRequirement)) {
            return false;
        }
        ClassAttributeRequirement other = (ClassAttributeRequirement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Components.FeatRequirements.FeatAttributeRequirement[ id=" + id + " ]";
    }
}
