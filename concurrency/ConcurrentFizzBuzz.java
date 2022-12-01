package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CyclicBarrier;
import java.util.function.IntConsumer;

public class ConcurrentFizzBuzz {
}

class FizzBuzz {
  private AtomicInteger totalRuns;
  private AtomicInteger n;
  private AtomicBoolean isFizzBuzz = new AtomicBoolean(false);
  private AtomicBoolean isFizz = new AtomicBoolean(false);
  private AtomicBoolean isBuzz = new AtomicBoolean(false);

  final CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
    public void run() {
      doIteration();
    }
  });

  public FizzBuzz(int n) {
    this.totalRuns = new AtomicInteger(n);
    this.n = new AtomicInteger(0);
  }

  public void doIteration() {

    this.n.incrementAndGet();
    int currentN = this.n.get();
    isFizzBuzz.set(currentN % 3 == 0 && currentN % 5 == 0);
    isFizz.set(currentN % 3 == 0 &&  currentN % 5 != 0);
    isBuzz.set(currentN % 5 == 0 && currentN % 3 != 0);

  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    try {
      while(this.n.get() < this.totalRuns.get() ){

        barrier.await();
        if (isFizz.get()){

          printFizz.run();
        }
      }

    } catch (InterruptedException ie) {System.out.println(ie.toString());}
    catch (BrokenBarrierException bbe) {System.out.println(bbe.toString());}
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    try {
      while(this.n.get() < this.totalRuns.get()){
        barrier.await();
        if (isBuzz.get()){

          printBuzz.run();
        }
      }

    } catch (InterruptedException ie) {}
    catch (BrokenBarrierException bbe) {}
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    try {
      while(this.n.get() < this.totalRuns.get()){
        barrier.await();
        if (isFizzBuzz.get()){

          printFizzBuzz.run();
        }
      }
    } catch (InterruptedException ie) {}
    catch (BrokenBarrierException bbe) {}
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    try {
      while(this.n.get() < this.totalRuns.get()){
        barrier.await();
        if (!isFizz.get() && !isBuzz.get() && !isFizzBuzz.get()){

          printNumber.accept(this.n.get());
        }
      }
    }catch (InterruptedException ie) {}
    catch (BrokenBarrierException bbe) {}
  }
}