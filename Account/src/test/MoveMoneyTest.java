import java.math.BigDecimal;

import junit.framework.TestCase;

public class MoveMoneyTest extends TestCase {
	
    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(MoveMoneyTest.class);
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
    public MoveMoneyTest(String arg0) {
        super(arg0);
    }
    
    /*
     * Class under test for boolean equals(Object)
     */
    public final void testA_equals()
    {
    	final  Account acnt1 = new Account("GB123-456", BigDecimal.valueOf(1000));
    	final  Account acnt2= new Account("GB123-457", BigDecimal.valueOf(200));
    	final  AccountServiceImpl acntSrv = new AccountServiceImpl();
        long start = System.currentTimeMillis();
                       	
        
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
            	try {
            		for(int i=0; i<200; i++) 
            			acntSrv.transfer(acnt1, acnt2, new BigDecimal(1));
            	} catch (Exception e) {
                    e.printStackTrace();
                }
           }
        });
        thread1.start();
         
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
            	try {
            		for(int i=0; i<201; i++)
            			acntSrv.transfer(acnt2, acnt1, new BigDecimal(1));
            	} catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

         thread2.start();
         
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        
        System.out.println("Time taken: " + (end - start));
    	
    	System.out.println("----- Acn1="+acnt1.getBalance());
    	System.out.println("----- Acn2="+acnt2.getBalance());
        }
        
}