import org.junit.Test;

import static org.junit.Assert.*;
public class FreundTest {

    @Test
    public void isSingle() {
        Freund neuerFreund = new Freund("Sabrina", "10.05.2004", "Stier", true, "Braun", "Fliegen");
        boolean v1 = neuerFreund.isSingle();
        assertTrue(v1);
    }
}