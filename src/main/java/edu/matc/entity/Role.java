package edu.matc.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * A class to represent a hiker role.
 *
 * @author Dan Miller
 */
@Entity(name = "role")
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "email_address")
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "hiker_account_id")
    private HikerAccount hikerAccount;


    /**
     * Instantiates a new User Role.
     */
    public Role() {
    }

    /**
     * Instantiates a new User Role.
     *
     * @param roleName     the role name
     * @param emailAddress the email address
     * @param hikerAccount the hiker account
     */
    public Role(String roleName, String emailAddress, HikerAccount hikerAccount) {
        this.roleName = roleName;
        this.emailAddress = emailAddress;
        this.hikerAccount = hikerAccount;
    }

    /**
     * Gets hiker account.
     *
     * @return the hiker account
     */
    public HikerAccount getHikerAccount() {
        return hikerAccount;
    }

    /**
     * Sets hiker account.
     *
     * @param hikerAccount the hiker account
     */
    public void setHikerAccount(HikerAccount hikerAccount) {
        this.hikerAccount = hikerAccount;
    }

}
