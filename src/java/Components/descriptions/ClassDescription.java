/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.descriptions;

import Components.CClass;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Uskon
 */
@Entity
public class ClassDescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @OneToOne
    private CClass cclass;
    @Column
    private String description;
    
    public ClassDescription(){}
    
    public ClassDescription(CClass cclass, String desc) {
        this.cclass = cclass;
        this.description = desc;
    }

    public CClass getCclass() {
        return cclass;
    }

    public void setCclass(CClass cclass) {
        this.cclass = cclass;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
