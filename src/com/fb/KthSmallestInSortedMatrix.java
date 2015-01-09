package com.fb;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the given 2D array.
 *
 * For example, consider the following 2D array.
 *
 *  10, 20, 30, 40
 *  15, 25, 35, 45
 *  24, 29, 37, 48
 *  32, 33, 39, 50
 *
 *  The 3rd smallest element is 20 and 7th smallest element is 30
 */
public class KthSmallestInSortedMatrix {
    /**
     * n = Min(k, rows)
     * Time: O(n) + kLogn
     *
     */
    public static int kthSmallest(int[][] matrix, int k){
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = Math.min(k, cols);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(k, comparator);

        for(int i = 0; i < size; i++){
            queue.offer(new Node(matrix[0][i], 0, i));
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < k ; i++){
            Node node = queue.poll();
            min = node.val;
            int currRow = node.row;
            int currCol = node.col;
            if(currRow + 1 == rows){
                queue.offer(new Node(Integer.MAX_VALUE, currRow + 1, currCol));
            }else{
                queue.offer(new Node(matrix[currRow + 1][currCol], currRow + 1, currCol));
            }
        }
        return min;
    }

    public static class Node{
        int val;
        int row;
        int col;

        public Node(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args){
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {24, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(kthSmallest(matrix, 3));
        System.out.println(kthSmallest(matrix, 7));
    }
}
