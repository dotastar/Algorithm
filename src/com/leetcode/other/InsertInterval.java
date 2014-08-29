package com.leetcode.other;

import com.leetcode.core.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Created by Xiaomeng on 8/21/2014.
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        return merge(intervals);
    }

    private List<Interval> merge(List<Interval> intervals){
        if(intervals.size() == 0 || intervals.size() == 1) return intervals;
        List<Interval> result = new ArrayList<Interval>();
        Comparator<Interval> comparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
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
