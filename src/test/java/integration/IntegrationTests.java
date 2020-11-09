package integration;

import io.quell.AnotherBean;
import io.quell.AppConfig;
import io.quell.entities.OptionsMaster;
import io.quell.entities.OptionsTran;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Transactional
@ActiveProfiles("test")
public class IntegrationTests {
    static {
        System.setProperty("envTarget", "test");
    }

    @Autowired
    AnotherBean anotherBean;

    @PersistenceContext
    EntityManager entityManager;

    @Before
    public void setUp() {
        OptionsMaster optionsMaster = OptionsMaster.builder()
                .createdDate(new Timestamp(new Date().getTime()))
                .updatedDate(null)
                .message("mData")
                .destination("someDestination")
                .messageType("someMessageType")
                .build();

        entityManager.persist(optionsMaster);

        OptionsTran optionsTran = OptionsTran.builder()
                .optionsMaster(optionsMaster)
                .createdDate(new Timestamp(new Date().getTime()))
                .updatedDate(null)
                .message("tData")
                .build();

        entityManager.persist(optionsTran);
        entityManager.flush();
    }

    @Test
    public void testDockerIntegration() {
        final Query query = entityManager.createNativeQuery("SELECT MID FROM OPTIONS_MASTER");
        long seqNo = Long.parseLong(query.getResultList().get(0).toString());

        OptionsMaster optionsMaster = entityManager.find(OptionsMaster.class, seqNo);
        System.out.println("testing " + optionsMaster);
        OptionsTran optionsTran = entityManager.find(OptionsTran.class, seqNo);
        System.out.println("testing " + optionsTran);
        System.out.println("testing " + anotherBean);
    }

    @Test
    public void testTwo() {
        final Query query = entityManager.createNativeQuery("SELECT MID FROM OPTIONS_MASTER");
        long seqNo = Long.parseLong(query.getResultList().get(0).toString());

        TypedQuery<OptionsMaster> typedQuery =
                entityManager.createQuery("SELECT e FROM OptionsMaster e " +
                        "WHERE e.mId IN (SELECT a.tId FROM OptionsTran a WHERE a.tId = :seqNo)", OptionsMaster.class);

        System.out.println("DALE: " + typedQuery.setParameter("seqNo", seqNo).getResultList());
    }
}
