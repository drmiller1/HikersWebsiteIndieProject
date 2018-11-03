package edu.matc.persistence;

import edu.matc.entity.HikerAccount;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikerAccountgenericDaoTest {

    GenericDao genericDao;

    /**
     * Creating the genericDao.
     */
    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(HikerAccount.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getAllHikerAccountsSuccess() {
        List<HikerAccount> hikerAccounts = genericDao.getAll();
        assertEquals(6, hikerAccounts.size());
    }

    @Test
    void getHikerAccountsByLastNameSuccess() {
        List<HikerAccount> hikerAccounts = genericDao.getByPropertyLike("lastName","c");
        assertEquals(3, hikerAccounts.size());
    }

    @Test
    void getByIdSuccess() {
        HikerAccount retrievedHikerAccount = (HikerAccount) genericDao.getById(1);
        assertNotNull(retrievedHikerAccount);
        assertEquals("Joe", retrievedHikerAccount.getFirstName());
    }

    /**
     * Verify successful insert
     */
    @Test
    void updateSuccess() {
        String newLastName = "Coyne";
        HikerAccount hikerToUpdate = (HikerAccount) genericDao.getById(1);
        hikerToUpdate.setLastName(newLastName);
        genericDao.saveOrUpdate(hikerToUpdate);
        HikerAccount retrievedHiker = (HikerAccount) genericDao.getById(1);
        assertEquals(hikerToUpdate, retrievedHiker);
    }

    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        HikerAccount newHiker = new HikerAccount("Fred", "Flintstone", "Madison", "WI","emailaddress7@hotmail.com",7);
        int id = genericDao.insert(newHiker);
        assertNotEquals(0, id);
        HikerAccount insertedHikerAccount = (HikerAccount) genericDao.getById(id);
        assertNotNull(insertedHikerAccount);
        assertEquals("Fred", insertedHikerAccount.getFirstName());
    }

    /**
     * Verify successful insert of a user and an order
     */
    /**@Test
    void insertWithOrderSuccess() {

        String hikingTrailName = "Trail2";
        HikerAccount newHiker = new HikerAccount("Barney", "Rubble", "Madison", "WI","emailaddress2@hotmail.com",2);
        HikingTrail hikingTrail = new HikingTrail(hikingTrailName, newHiker);

        newHiker.addHikingTrail(hikingTrail);

        int id = genericDao.insert(newHiker);

        assertNotEquals(0, id);
        HikerAccount insertedHiker = genericDao.getById(id);
        assertNotNull(insertedHiker);
        assertEquals("Fred", insertedHiker.getFirstName());
        assertEquals(1, insertedHiker.getHikingTrails().size());*/
}