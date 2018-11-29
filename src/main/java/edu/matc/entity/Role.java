package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


/**
 * The type Role.
 */
@Entity(name = "Role")
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String userName;

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
     * @param userName      the user name
     * @param hikerAccount     the hiker account
     */
    public Role(String roleName, String userName, HikerAccount hikerAccount) {
        this.roleName = roleName;
        this.userName = userName;
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
    public void setroleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets hiker user name.
     *
     * @return the hiker user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets hiker user name.
     *
     * @param userName the hiker user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
                ", userName='" + userName + '\'' +
                ", hikerAccount=" + hikerAccount +
                '}';
    }
}
