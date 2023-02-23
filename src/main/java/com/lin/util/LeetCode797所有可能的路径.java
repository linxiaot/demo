package com.lin.util;

import java.util.LinkedList;
import java.util.List;

/**
 * @author liuxiaojia
 * @date 2023/2/22 16:33
 * @Description:
 */
public class LeetCode797所有可能的路径 {

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{3},{3},{}};
        allPathsSourceTarget(graph);
        System.out.println(res);
    }

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph){
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0 , path);
        return res;
    }

    public static void traverse(int[][] graph, int index, LinkedList<Integer> path){
        path.addLast(index);
        if(index == graph.length - 1){
            res.add(new LinkedList<>(path));
        }

        for (int s : graph[index]){
            traverse(graph, s, path);
        }
        path.removeLast();
    }

}
