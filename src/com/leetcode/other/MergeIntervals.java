package com.leetcode.other;

import com.leetcode.core.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 * Created by Xiaomeng on 8/21/2014.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0 || intervals.size() == 1) return intervals;

        List<Interval> result = new ArrayList<Interval>();

        Comparator<Interval> comparator = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };

        Collections.sort(intervals, comparator);
        Interval curr = intervals.get(0);
        result.add(curr);
        for(int i = 1; i < intervals.size(); i++){
            Interval next = intervals.get(i);
            if(curr.end >= next.start){
                Interval interval = new Interval();
                interval.start = curr.start;
                interval.end = curr.end >= next.end ? curr.end : next.end;
                result.remove(result.size() - 1);
                result.add(interval);
            }else{
                result.add(next);
            }
            curr = result.get(result.size() - 1);
        }
        return result;
    }

}
