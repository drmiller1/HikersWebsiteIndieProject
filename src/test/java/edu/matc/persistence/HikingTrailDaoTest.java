package edu.matc.persistence;

import edu.matc.entity.HikingTrail;
import edu.matc.entity.HikerAccount;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTrailDaoTest {

    GenericDao genericDao;

    /**
     * Creating the dao.
     */
    @BeforeEach
    void setUp() {

        genericDao = new GenericDao(HikingTrail.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

    }

    @Test
    void getAllHikingTrailsSuccess() {
        List<HikingTrail> HikingTrails = (List<HikingTrail>) genericDao.getAll();
        assertEquals(3, HikingTrails.size());
    }

    @Test
    void getByIdSuccess() {
        HikingTrail retrievedHikingTrails = (HikingTrail)genericDao.getById(1);
        assertNotNull(retrievedHikingTrails);
        assertEquals("Trailhead1", retrievedHikingTrails.getTrailHeadName());
    }

    /**
     * Verifies a HikingTrail is returned correctly based on id search
     */
    @Test
    void getByIdVerifyHikerAccountSuccess() {
        HikingTrail retrievedHikingTrails = (HikingTrail) genericDao.getById(2);
        assertNotNull(retrievedHikingTrails);
        assertEquals("Trailhead2", retrievedHikingTrails.getTrailHeadName());
    }

    /**
     * Verify successful insert
     */
    @Test
    void insertSuccess() {

        GenericDao hikerAccountGenericDao = new GenericDao(HikerAccount.class);
        HikerAccount hikerAccount = (HikerAccount)hikerAccountGenericDao.getById(1);
        HikingTrail newHikingTrail = new HikingTrail( "Trailhead1", "Madison WI", 2, 1, 5, "Waterfall, Small Stream", "Trees", "Greate for kids", hikerAccount);
        hikerAccount.addHikingTrail(newHikingTrail);

        int id = genericDao.insert(newHikingTrail);

        assertNotEquals(0, id);
        HikingTrail insertedHikingTrails = (HikingTrail) genericDao.getById(id);
        assertNotNull(insertedHikingTrails);
        assertEquals("Trailhead1", insertedHikingTrails.getTrailHeadName());
        assertNotNull(insertedHikingTrails.getHikerAccount());

    }

    /**
     * Verify successful delete of HikingTrail
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(3));
        assertNull(genericDao.getById(3));
    }

    /**
     * Verify successful update of HikingTrail
     */
    @Test
    void updateSuccess() {
        String newTrailHeadName = "Trailhead2";
        HikingTrail hikingTrailsToUpdate = (HikingTrail) genericDao.getById(2);
        hikingTrailsToUpdate.setTrailHeadName(newTrailHeadName);
        genericDao.saveOrUpdate(hikingTrailsToUpdate);
        HikingTrail retrievedHikingTrails = (HikingTrail) genericDao.getById(2);
        assertEquals(newTrailHeadName, retrievedHikingTrails.getTrailHeadName());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<HikingTrail> HikingTrails = genericDao.getByPropertyEqual("trailHeadName", "TrailHead2");
        assertEquals(1, HikingTrails.size());
        assertEquals(2, HikingTrails.get(0).getId());
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<HikingTrail> HikingTrails = genericDao.getByPropertyLike("trailDescription", "t");
        assertEquals(3, HikingTrails.size());
    }
}