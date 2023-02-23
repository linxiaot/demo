package com.lin.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuxiaojia
 * @date 2023/2/1 13:52
 * @Description:
 */
public class LeetCode406根据身高重建队列 {

    public static void main(String[] args) {
        int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res = reconstructQueue(people);
        System.out.println(Arrays.deepToString(res));
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
