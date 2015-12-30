package com.mostafa.anter;

/* implement observe pattern */
/* advantage of callback method reduce class dependants */

// callback come from this expression :  hollywood principle don't call us we'll call you


interface Callable
{
    public void callBackMethod();
}
class Worker
{
    // Worker gets a handle to the boss object via the Callable interface.
    // There's no way this worker class can call any other method other than
    // the one in Callable.
    public void doSomeWork(Callable myBoss)
    {
        myBoss.callBackMethod();
        // ERROR!
        //myBoss.directMethod();
    }
}
class Boss implements Callable
{
    public Boss()
    {
        // Boss creates a worker object, and tells it to do some work.
        Worker w1 = new Worker();
        // Notice, we're passing a reference of the boss to the worker.
        w1.doSomeWork(this);
    }
    //developer that develop library just call controll the place of calling

    public void callBackMethod()
    {
        System.out.println("What do you want?");
    }
    public void directMethod()
    {
        System.out.println("I'm out for coffee.");
    }
}

public class Main {

    public static void main(String[] args) {

            Boss b = new Boss();
            b.directMethod();

	// write your code here
    }
}
