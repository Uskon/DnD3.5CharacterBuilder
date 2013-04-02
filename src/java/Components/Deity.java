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
public class Deity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private Alignment alignment;

    public Deity() {
    }

    public Deity(String name, Alignment alignment) {
        this.name = name;
        this.alignment = alignment;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Alignment getAlignment() {
        return alignment;
    }
}
