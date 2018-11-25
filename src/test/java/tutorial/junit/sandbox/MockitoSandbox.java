package tutorial.junit.sandbox;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class MockitoSandbox {

    @Mock
    private TestMock list;

    @Test
    public final void answerTest() {
        // with doAnswer():
        doAnswer(returnsFirstArg()).when(list).add(anyString());
        // with thenAnswer():
        when(list.add(anyString())).thenAnswer(returnsFirstArg());
        // with then() alias:
        //show unecessary stubing
        when(list.add(anyString())).then(returnsFirstArg());

        list.add("dsds");
    }

    class TestMock {
        public String add(String toAdd){
            return null;
        }
    }
}
