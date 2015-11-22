

import java.math.BigDecimal;

class testTh {
	private static Account acnt1;
	private static Account acnt2;
	private static AccountServiceImpl acntSrv;
    long start = System.currentTimeMillis();
       
	public testTh () {
		acnt1 = new Account("GB123-456", BigDecimal.valueOf(1000));
		acnt2 = new Account("GB123-457", BigDecimal.valueOf(200));
		acntSrv = new AccountServiceImpl();	
	}
	
    public void stageOne() {
        
            try {
        		for(int i=0; i<200; i++) {
        			acntSrv.transfer(acnt1, acnt2, new BigDecimal(1));
        		}
            } catch (Exception e) {
                e.printStackTrace();
            }     
    }
     
    public void stageTwo() {
         
            try {
        		for(int i=0; i<201; i++) {
        			acntSrv.transfer(acnt2, acnt1, new BigDecimal(1));
        		}
            } catch (Exception e) {
                e.printStackTrace();
            }         
    }
	
    public void testmain() {
    Thread thread1 = new Thread(new Runnable() {
        public void run() {
        	try {
        		stageOne();
        	} catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    thread1.start();
     
    Thread thread2 = new Thread(new Runnable() {
        public void run() {
        	try {
        		stageTwo();
        	} catch (Exception e) {
                e.printStackTrace();
            }
        }
    });

     thread2.start();
     
    try {
        thread1.join(1000);
        thread2.join(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    long end = System.currentTimeMillis();
    
    System.out.println("Time taken: " + (end - start));
	
	System.out.println("----- Acn1="+acnt1.getBalance());
	System.out.println("----- Acn2="+acnt2.getBalance());
    }
}

class AccountMain {

	public static void main(String[] args) {
		testTh ttTH = new testTh();
		ttTH.testmain();
	}
}