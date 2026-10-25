class Deadlock{
    static final Object suit=new Object();
    static final Object shield=new Object();

    public static void main(String[] args){
 
        //Thread 1
        Thread thread1=new Thread(new Runnable(){
            public void run(){
                synchronized(suit){
                    System.out.println("Thread 1: Holding suit...");
                    try{Thread.sleep(100);}catch(Exception e){}
                    System.out.println("Thread 1: Waiting for shield...");
                    synchronized(shield){
                        System.out.println("Thread 1: Holding suit and shield...");
                    }
                }
            }
        });thread1.start();
           //Thread 2
        Thread thread2=new Thread(new Runnable(){
            public void run(){
                synchronized(suit){
                    System.out.println("Thread 2: Holding suit...");
                    try{Thread.sleep(100);}catch(Exception e){}
                    System.out.println("Thread 2: Waiting for shield...");
                    synchronized(shield){
                        System.out.println("Thread 2: Holding suit and shield...");
                    }
                }
            }
        });thread2.start(); 
    }

}
