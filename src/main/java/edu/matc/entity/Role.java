package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * The type Role.
 */
@Entity(name = "role")
@Table(name = "role")
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
     * @param roleName      the role name
     * @param emailAddress      the email address
     * @param hikerAccount     the hiker account
     */
    public Role(String roleName, String emailAddress, HikerAccount hikerAccount) {
        this.roleName = roleName;
        this.emailAddress = emailAddress;
        this.hikerAccount = hikerAccount;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets hiker role name.
     *
     * @return the hiker role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets hiker role name.
     *
     * @param roleName the hiker role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets hiker email address.
     *
     * @return the hiker email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Sets hiker email address.
     *
     * @param emailAddress the hiker email address
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", hikerAccount=" + hikerAccount +
                '}';
    }
}
