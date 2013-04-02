/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.io.Serializable;
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

    public RuleSet() {
    }
    
    public RuleSet(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}
