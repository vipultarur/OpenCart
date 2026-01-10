package opencart.Opencart;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase{
   
    public AppTest( String testName )
    {
        super( testName );
        Register_TC.TC_001();
    }
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
        assertTrue( true );
    }
}
