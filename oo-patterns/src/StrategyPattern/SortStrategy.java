/**
 *  -> Strategy Pattern
 *
 *  1. Create interface for strategies
 *  2. Implement interface and create strategies
 *
 */

package StrategyPattern;

import java.util.ArrayList;
import java.util.Collections;

public interface SortStrategy {
    void sort(ArrayList<Integer> numbers);
}

class SortAsc implements SortStrategy {
    @Override
    public void sort(ArrayList<Integer> numbers) {
        Collections.sort(numbers);
    }
}

class SortDesc implements SortStrategy {
    @Override
    public void sort(ArrayList<Integer> numbers) {
        Collections.sort(numbers, Collections.reverseOrder());
    }
}

class Test {
    public static void main(String[] args) {
        ArrayList<Integer> testNumbers = new ArrayList<Integer>();

        testNumbers.add(3);
        testNumbers.add(1);
        testNumbers.add(7);
        testNumbers.add(2);

        SortDesc desc = new SortDesc();
        desc.sort(testNumbers);
        System.out.println(testNumbers);

        SortAsc asc = new SortAsc();
        asc.sort(testNumbers);
        System.out.println(testNumbers);
    }
}
