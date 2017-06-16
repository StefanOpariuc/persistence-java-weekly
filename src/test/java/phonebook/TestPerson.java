package phonebook;

import com.firstproject.phonebook.repo.PersonRepo;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 19.01.2017
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config-test.xml")
@Ignore
public class TestPerson extends DBTestCase {

    @Autowired
    private PersonRepo personRepo;

    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("D:/projects/learning/PersonalProject/src/test/resources/database-init.xml"));
    }

    @Before
    public void init() {
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "org.postgresql.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:postgresql://localhost:5432/personal_project_test");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "postgres");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "postgres");
    }

    @Test
    public void findPersonTest() throws Exception {
        IDatabaseConnection jdbConn = getConnection();
        IDataSet dataSet = getDataSet();
        DatabaseOperation.CLEAN_INSERT.execute(jdbConn, dataSet);

        assertFalse(personRepo.findAll().isEmpty());
        assertEquals(3, personRepo.findAll().size());
        assertNotNull(personRepo.findByFirstNameAndLastName("Stefan", "Opariuc"));
        jdbConn.close();
    }

}
