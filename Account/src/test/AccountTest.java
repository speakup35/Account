import java.math.BigDecimal;

import junit.framework.TestCase;

public class AccountTest extends TestCase {
	
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(AccountTest.class);
    }

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception
    {
        super.setUp();
    }

    /*
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Constructor for AccountTest
     * @param arg0
     */
    public AccountTest(String arg0) {
        super(arg0);
    }
    
    /*
     * Class under test for boolean equals(Object)
     */
    public final void testA_equals()
    {
        final Account subjectObject1 = new Account("GB123-456", BigDecimal.valueOf(30));
        final Account subjectObject2 = new Account("GB123-457", BigDecimal.valueOf(20));
        
        final Account targetObject1 = new Account("GB123-456", BigDecimal.valueOf(20));
        final Account targetObject2 = new Account("GB123-457", BigDecimal.valueOf(20));
        
        assertEquals("Should not match.", false, subjectObject1.equals( null ));
        assertEquals("Should match.", true, subjectObject1.equals( subjectObject1 ));
        assertEquals("Should match.", true, subjectObject1.equals( targetObject1 ));
        assertEquals("Should match.", true, subjectObject2.equals( subjectObject2 ));
        assertEquals("Should match.", true, subjectObject2.equals( targetObject2 ));
        assertEquals("Should match.", false, subjectObject1.equals( targetObject2 ));
        
    }
}