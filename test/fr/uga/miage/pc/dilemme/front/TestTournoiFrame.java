package fr.uga.miage.pc.dilemme.front;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Order;

public class TestTournoiFrame {
    private static volatile TournoiFrame instance = TournoiFrame.getInstance();

    @Test
    @Order(1)
    public void testGetInstance(){
        assertTrue(instance != null);
        assertTrue(instance instanceof TournoiFrame);
    }

    @Test
    @Order(2)
    public void testInstance(){
        ParamFrame instanceParam = ParamFrame.getInstance();
        assertTrue(instanceParam.getObservers() != null);
        assertFalse(instanceParam.getObservers().isEmpty());
        assertEquals(1, instanceParam.getObservers().size());
    }

    @Test
    @Order(3)
    public void testOpenWebPage() throws Exception{
        boolean test = false;
        test = instance.openWebPage("https://www.google.com/");
        assertTrue(test);
        test = instance.openWebPage("");
        assertTrue(test);
        assertThrows(NullPointerException.class, () -> {
            instance.openWebPage(null);
        });
    }
}
