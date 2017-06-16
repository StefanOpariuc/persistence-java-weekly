package phonebook;

import com.firstproject.phonebook.POJOs.Person;
import com.firstproject.phonebook.POJOs.PhoneBook;

import com.firstproject.phonebook.control.PersonControl;
import com.firstproject.phonebook.repo.PersonRepo;
import com.firstproject.phonebook.repo.PhoneBookRepo;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.api.extension.listener.AnnotationEnabler;
import org.powermock.core.classloader.annotations.PowerMockListener;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.util.ReflectionTestUtils;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 04.02.2017
 **/
@RunWith(PowerMockRunner.class)
@PowerMockListener(AnnotationEnabler.class)
@ContextConfiguration("classpath:spring-config-test.xml")
@Ignore
public class PersonServiceTest {

    private PersonControl personControl = new PersonControl();

    @Mock
    private PersonRepo personRepoMock;

    @Mock
    private PhoneBookRepo phoneBookRepoMock;

    @Before
    public void setUp() {
        /*String[] personNotMockedMethods = new String[]{"getLastName", "setLastName", "setFirstName",
                "getFirstName", "setAge", "getAge", "setPhoneBook", "getPhoneBook", "getId", "getTelephoneNumber",
                "setTelephoneNumber"};
        */
        String[] personRepoNotMockedMethods = new String[]{"save", "findById", "delete",
                "findAll", "findByFirstNameAndLastName"};

        String[] phoneBookRepoNotMocketMethods = new String[]{"save", "findById", "delete", "findAll", "findByCityName",
                "addPersons"};

        ReflectionTestUtils.setField(personControl, "personRepo", personRepoMock);
        ReflectionTestUtils.setField(personControl, "phoneBookRepo", phoneBookRepoMock);
        this.mockDBcalls();
    }

    private void mockDBcalls() {
        EasyMock.reset(personRepoMock);
        EasyMock.expect(personRepoMock.save(EasyMock.anyObject(Person.class))).andReturn(new Person()).anyTimes();
        EasyMock.replay(personRepoMock);

        EasyMock.reset(phoneBookRepoMock);
        EasyMock.expect(phoneBookRepoMock.save(EasyMock.anyObject(PhoneBook.class))).andReturn(new PhoneBook()).anyTimes();
        EasyMock.replay(phoneBookRepoMock);
        EasyMock.reset(phoneBookRepoMock);
        EasyMock.expect(phoneBookRepoMock.findByCityName(EasyMock.anyObject(String.class))).andReturn(new PhoneBook()).anyTimes();
        EasyMock.replay(phoneBookRepoMock);
    }

    @Test
    public void savePerson() throws Exception {
        PhoneBook ph = new PhoneBook();
        ph.setPrefix("0232");
        ph.setCityName("Iasi");

        Person p = new Person();
        p.setFirstName("Stefan");
        p.setLastName("Opariuc");
        p.setTelephoneNumber("0232321103");
        p.setAge(22);
        p.setPhoneBook(ph);

        assertNotNull(personControl.save(p));
    }
}
