/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.descriptions;

import Components.Feat;
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
public class FeatDescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @OneToOne
    private Feat feat;
    @Column
    private String description;

    public FeatDescription(){}
    
    public FeatDescription(Feat feat, String desc) {
        this.feat = feat;
        this.description = desc;
    }

    public Feat getFeat() {
        return feat;
    }

    public void setFeat(Feat feat) {
        this.feat = feat;
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
