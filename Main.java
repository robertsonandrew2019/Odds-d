import java.util.Random;
public class Main {
    public static int posCount = 0;
    public static int negCount = 0;
    public static Random rand = new Random();
    public static double expectation;
    public static double proportionPos;
    public static void main(String[] args) {
        scenario1(); //Scenario 1 - 6-sided die evens
        scenario2(); //Scenario 2 - 10-sided die even or > 5
        scenario3(); //Scenario 3 - 6-side die even then odd
        scenario4(); //Scenario 4 - 6-sided die 1 or 2 then 3 or 4 then a 5 or 6
        scenario5(); //Scenario 5 - 6-sided die 1 != die 2 != die 3 != die 4
    }
    public static void scenario1() {
        expectation = 0.5;
        for (int i = 0; i < 100000; i++) {
            int num = rand.nextInt(6) + 1;
            if (num % 2 == 0) {
                posCount++;
            } else {
                negCount++;
            }
        }
        proportionPos = posCount / 100000.0;
        System.out.printf("\nScenario 1\nExpected Outcome: %f\nCount of True: %d\nCount of False: %d\nCondition Reached: %f\n", expectation, posCount, negCount, proportionPos);
    }
    public static void scenario2() {
        posCount = 0;
        negCount = 0;
        expectation = (5 / 10.0) + (5 / 10.0) - (3 / 10.0);
        for (int i = 0; i < 100000; i++) {
            int num = rand.nextInt(10) + 1;
            if ((num > 5) || (num % 2 == 0)) {
                posCount++;
            } else {
                negCount++;
            }
        }
        proportionPos = posCount / 100000.0;
        System.out.printf("\nScenario 2\nExpected Outcome: %f\nCount of True: %d\nCount of False: %d\nCondition Reached: %f\n", expectation, posCount, negCount, proportionPos);
    }
    public static void scenario3() {
        posCount = 0;
        negCount = 0;
        expectation = 0.5 * 0.5;
        for (int i = 0; i < 100000; i++) {
            int roll1 = rand.nextInt(6) + 1;
            int roll2 = rand.nextInt(6) + 1;
            if ((roll1 % 2 == 0) && (roll2 % 2 == 1)) {
                posCount++;
            }
            else {
                negCount++;
            }
        }
        proportionPos = posCount / 100000.0;
        System.out.printf("\nScenario 3\nExpected Outcome: %f\nCount of True: %d\nCount of False: %d\nCondition Reached: %f\n", expectation, posCount, negCount, proportionPos);
    }

    public static void scenario4() {
        //Scenario 4 - 6-sided die 1 or 2 then 3 or 4 then a 5 or 6
        posCount = 0;
        negCount = 0;
        expectation = (1 / 3.0) * (1 / 3.0) * (1 / 3.0);
        for (int i = 0; i < 100000; i++) {
            int roll1 = rand.nextInt(6) + 1;
            int roll2 = rand.nextInt(6) + 1;
            int roll3 = rand.nextInt(6) + 1;
            if ((roll1 > 3) && (roll2 > 2 && roll2 < 5) && (roll3 > 4)) {
                posCount++;
            }
            else {
                negCount++;
            }
        }
        proportionPos = posCount / 100000.0;
        System.out.printf("\nScenario 4\nExpected Outcome: %f\nCount of True: %d\nCount of False: %d\nCondition Reached: %f\n", expectation, posCount, negCount, proportionPos);
    }
    public static void scenario5() {
        posCount = 0;
        negCount = 0;
        expectation = (1.0) * (5 / 6.0) * (2 / 3.0) * (1 / 2.0);
        for (int i = 0; i < 100000; i++) {
            int roll1 = rand.nextInt(6) + 1;
            int roll2 = rand.nextInt(6) + 1;
            int roll3 = rand.nextInt(6) + 1;
            int roll4 = rand.nextInt(6) + 1;

            if ((roll1 != roll2 && roll1 != roll3 && roll1 != roll4) && (roll2 != roll3 && roll2 != roll4) && (roll3 != roll4)) {
                posCount++;
            }
            else {
                negCount++;
            }
        }
        proportionPos = posCount / 100000.0;
        System.out.printf("\nScenario 5\nExpected Outcome: %f\nCount of True: %d\nCount of False: %d\nCondition Reached: %f\n", expectation, posCount, negCount, proportionPos);
    }
}
