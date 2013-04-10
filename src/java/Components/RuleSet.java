/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Uskon
 */
@Entity
public class RuleSet implements Serializable {

    @Id
    private String name;
    @Column
    private String fullname;

    public RuleSet() {
    }
    
    public RuleSet(String name, String fullname) {
        this.name = name;
        this.fullname = fullname;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getFullname() {
        return this.fullname;
    }
}
