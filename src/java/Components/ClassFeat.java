/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

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
public class ClassFeat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @ManyToOne
    private CClass cclass;
    @JoinColumn
    @ManyToOne
    private Feat feat;
    @Column
    private int lvl;

    public ClassFeat() {
    }

    public ClassFeat(CClass cclass, Feat feat, int lvl) {
        this.cclass = cclass;
        this.feat = feat;
        this.lvl = lvl;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }


    public long getId() {
        return id;
    }

    public CClass getCclass() {
        return cclass;
    }

    public Feat getFeat() {
        return feat;
    }

    public int getLevel() {
        return lvl;
    }
    
    
}
