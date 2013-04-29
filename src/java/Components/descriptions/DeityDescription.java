/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components.descriptions;

import Components.Deity;
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
public class DeityDescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JoinColumn
    @OneToOne
    private Deity deity;
    @Column
    private String description;

    public DeityDescription() {
    }

    public DeityDescription(Deity deity, String description) {
        this.deity = deity;
        this.description = description;
    }

    public Deity getDeity() {
        return deity;
    }

    public void setDeity(Deity deity) {
        this.deity = deity;
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
