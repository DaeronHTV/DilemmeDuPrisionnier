package fr.uga.miage.pc.dilemme.front;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Order;

/**SI UTILISE VISUAL STUDIO CODE NE PAS LANCER UN RUN TEST GLOBAL**/
/**NE PREND PAS EN COMPTE LE PARAMETRE ORDER DONNE SUR LES TESTS**/

public class TestParamFrame {
    private static final ParamFrame instance = ParamFrame.getInstance();

    private class testObserver implements IObserver{
        private boolean notifier;

        private testObserver(){notifier = false;}

        @Override
        public void notifier() {notifier = true;}

        public boolean isNotified(){return notifier;}
    }

    @Test
    @Order(1)
    public void testGetInstance(){
        assertTrue(instance != null);
        assertTrue(instance instanceof ParamFrame);
    }

    @Test
    @Order(2)
    public void testGetNbTours(){ assertEquals(0, instance.getNbTours()); }

    @Test
    @Order(3)
    public void testGetList(){
        assertEquals(0, instance.getList().size());
        assertTrue(instance.getList() != null);
        assertTrue(instance.getList().isEmpty());
    }

    @Test
    @Order(4)
    public void testGetObservers(){
        assertEquals(0, instance.getObservers().size());
        assertTrue(instance.getObservers() != null);
        assertTrue(instance.getObservers().isEmpty());
    }

    @Test
    @Order(5)
    public void testInstance(){
        assertEquals(0, instance.getNbTours());
        assertTrue(instance.getList() != null);
        assertTrue(instance.getList().isEmpty());
        assertTrue(instance.getObservers() != null);
        assertTrue(instance.getObservers().isEmpty());
    }

    /**PERMET DE TESTER INITPARAMETER***/
    @Test
    @Order(6)
    public void testSetList(){
        String[] result = new String[]{"1","2","3","4"};
        assertEquals(4, result.length);
        assertEquals("2", result[1]);
        instance.setList(result);
        assertEquals(4, instance.getList().size());
        assertEquals(3, instance.getList().get(2));
        instance.reset();
    }

    @Test
    @Order(7)
    public void testSetNbTours(){
        instance.setNbTours(20);
        assertEquals(20, instance.getNbTours());
        instance.reset();
    }
    /*********************************/

    @Test
    @Order(8)
    public void testAddObserver(){
        IObserver observer = new testObserver();
        instance.addObserver(observer);
        assertTrue(instance.getObservers() != null);
        assertFalse(instance.getObservers().isEmpty());
        assertEquals(1, instance.getObservers().size());
        instance.removeObserver(observer);
    }

    @Test
    @Order(9)
    public void testRemoveObserver(){
        IObserver observer = new testObserver();
        instance.addObserver(observer);
        assertTrue(instance.getObservers() != null);
        assertFalse(instance.getObservers().isEmpty());
        assertEquals(1, instance.getObservers().size());
    }

    @Test
    @Order(10)
    public void testReset(){
        instance.reset();
        assertEquals(0, instance.getNbTours());
        assertTrue(instance.getList() != null);
        assertTrue(instance.getList().isEmpty());
        assertEquals(0, instance.getList().size());
    }

    @Test
    @Order(11)
    public void testNotifierAll(){
        testObserver observer = new testObserver();
        instance.addObserver(observer);
        assertTrue(instance.getObservers() != null);
        assertFalse(instance.getObservers().isEmpty());
        assertEquals(1, instance.getObservers().size());
        instance.notifierAll();
        assertTrue(observer.isNotified());
        instance.removeObserver(observer);
    }
}
