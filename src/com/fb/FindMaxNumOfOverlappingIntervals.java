package com.fb;

import com.leetcode.core.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Find the maximum number of overlapping intervals.
 *
 * For example, given a series of the following int-based intervals [[1,2], [3,4], [2,10]]
 * the following intervals overlap: [1,2] with [2,10], [3,4] with [2,10], hence the maximum
 * number of overlapping intervals is 2.
 *
 */
public class FindMaxNumOfOverlappingIntervals {
    /**
     * Reference:
     * https://gist.github.com/Thinkscape/5341248
     * http://stackoverflow.com/questions/18365107/maximum-no-of-overlaps-of-all-time-intervals?answertab=active#tab-top
     *
     * Time: O(nlogn)
     */
    public static int findMax(List<Interval> intervals){
        List<Integer> list = new ArrayList<Integer>();
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        };

        for(Interval interval : intervals){
            list.add(interval.start);
            list.add(-interval.end);
        }
        System.out.println(list);
        Collections.sort(list, comparator);
        System.out.println(list);

        int max = 0;
        int counter = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) > 0){
                counter++;
            }else{
                counter--;
            }
            max = Math.max(max, counter);
        }
        return max;
    }

    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 4));
        intervals.add(new Interval(3, 10));

        System.out.println(findMax(intervals));
    }
}
