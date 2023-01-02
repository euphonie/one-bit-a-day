package stack;

import java.util.*;
import java.util.concurrent.FutureTask;
import java.util.function.Predicate;

enum LockType{
  ACQUIRE, RELEASE
}


public class AcquireReleaseLocks {
  static int danglingLocks = 0;
  static int lockViolations = 0;
  static Deque<Integer> lockIds = new ArrayDeque<Integer>();

  static List<LockAction> NO_LOCK_ISSUES_LIST = Arrays.asList(
      new LockAction(LockType.ACQUIRE, 83),
      new LockAction(LockType.ACQUIRE, 123),
      new LockAction(LockType.ACQUIRE, 159465785),
      new LockAction(LockType.RELEASE, 159465785),
      new LockAction(LockType.RELEASE, 123),
      new LockAction(LockType.RELEASE, 83)
  );
  static List<LockAction> ONE_DANGLING_LOCK = Arrays.asList(
    new LockAction(LockType.ACQUIRE, 83)
  );

  static List<LockAction> TWO_VIOLATIONS_LIST = new ArrayList<LockAction>(){{
    add(new LockAction(LockType.ACQUIRE, 83));
    add(new LockAction(LockType.ACQUIRE, 123));
    add(new LockAction(LockType.ACQUIRE, 83));
    add(new LockAction(LockType.RELEASE, 159465785));
    add(new LockAction(LockType.RELEASE, 123));
    add(new LockAction(LockType.RELEASE, 83));
  }};

  public static void validateAction(LockAction action) {
    Predicate<LockAction> isRelease = act -> act.getType() == LockType.RELEASE;
    Predicate<LockAction> isAcquire = act -> act.getType() == LockType.ACQUIRE;
    Predicate<LockAction> isAlreadyLocked = act -> lockIds.contains(act.getId());
    Predicate<LockAction> isMostRecentLock =
        act -> lockIds.peekLast() != null && act.getId() == lockIds.peek();

    if (
        isAcquire.test(action) && isAlreadyLocked.test(action)
    ){
      lockViolations++; // already acquired
    }
    else if (isRelease.test(action) && !isMostRecentLock.test(action)){
      lockViolations++; // violation acquire-release + non-acquired lock
    }
    else if (
        isRelease.test(action) && isMostRecentLock.test(action)
    ) {
      lockIds.pop();
    }else if (action.getType() == LockType.ACQUIRE) {
      lockIds.addFirst(action.getId());
    }
  }

  // @Input
  // List<LockAction>
  // @Output
  // 0   - no-lock issues
  // N+1 - dangling locks
  // K   - number of lock related issues
  //       Non-acquired lock, acquire already held lock, lock-acquire violation
  public static void findLockIssues(List<LockAction> actions){
    Iterator<LockAction> iter = actions.iterator();
    while (iter.hasNext()) {
      LockAction action = iter.next();
      validateAction(action);
    }
    while (!lockIds.isEmpty()){
      lockIds.pop();
      danglingLocks++;
    }
  }

  public static void main(String[] args){
    findLockIssues(TWO_VIOLATIONS_LIST);
    System.out.printf("Violations: %s\n", lockViolations);
    System.out.printf("Dangling Locks: %s\n", danglingLocks);

  }


  static class LockAction {
    private LockType type;
    private int id;
    public LockAction(LockType type, int id) {
      this.type = type;
      this.id = id;
    }
    public LockType getType(){
      return type;
    }
    public int getId() {
      return id;
    }
  }
}
