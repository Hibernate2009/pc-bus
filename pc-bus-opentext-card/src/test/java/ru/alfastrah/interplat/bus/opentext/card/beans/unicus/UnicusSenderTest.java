package ru.alfastrah.interplat.bus.opentext.card.beans.unicus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.alfastrah.interplat.bus.opentext.card.db.UnicusDLO;
import ru.alfastrah.interplat.bus.opentext.card.entities.unicus.*;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static ru.alfastrah.interplat.bus.opentext.card.entities.DocumentType.*;

@RunWith(MockitoJUnitRunner.class)
public class UnicusSenderTest {
    @InjectMocks
    private UnicusSender unicusSender;
    @Mock
    private UnicusDLO unicusDLO;
    private Act act = new Act();
    private Agreement agreement = new Agreement();
    private Contract contract = new Contract();

    @Test
    public void shouldBeReturnActTypeResponse_whenIntegrationTypeIsAct() throws Exception {
        when(unicusDLO.getActById(BigInteger.TEN)).thenReturn(act);
        UnicusRequest unicusRequest = new UnicusRequest(BigInteger.TEN, ACT);
        UnicusResponse unicusResponse = unicusSender.execute(unicusRequest);
        assertEquals(act, unicusResponse.getAct());
    }

    @Test
    public void shouldBeReturnAgreementTypeResponse_whenIntegrationTypeIsAgreement() throws Exception {
        when(unicusDLO.getAgreementById(BigInteger.TEN)).thenReturn(agreement);
        UnicusRequest unicusRequest = new UnicusRequest(BigInteger.TEN, AGREEMENT);
        UnicusResponse unicusResponse = unicusSender.execute(unicusRequest);
        assertEquals(agreement, unicusResponse.getAgreement());
    }

    @Test
    public void shouldBeReturnContractTypeResponse_whenIntegrationTypeIsContract() throws Exception {
        when(unicusDLO.getContractById(BigInteger.TEN)).thenReturn(contract);
        UnicusRequest unicusRequest = new UnicusRequest(BigInteger.TEN, CONTRACT);
        UnicusResponse unicusResponse = unicusSender.execute(unicusRequest);
        assertEquals(contract, unicusResponse.getContract());
    }
}