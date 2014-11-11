package com.cc150.TreeAndGraph;

import com.leetcode.core.UndirectedGraphNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Xiaomeng on 11/3/2014.
 */
public class GraphTraversal {
    /**
     * Recursive DFS
     *
     */
    public static void dfs1(UndirectedGraphNode node){
        if(node == null) return;

        System.out.print(node.label + " ");
        node.visited = true;

        for(UndirectedGraphNode neighbor : node.neighbors){
            if(neighbor.visited == false){
                neighbor.visited = true;
                dfs1(neighbor);
            }
        }
    }

    /**
     * Iterative DFS using stack
     *
     */
    public static void dfs2(UndirectedGraphNode node){
        if(node == null) return;

        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        node.visited = true;
        System.out.print(node.label + " ");

        while(!stack.isEmpty()){
            UndirectedGraphNode n = stack.peek();
            UndirectedGraphNode child = getUnvisitedChildNode(n);
            if(child != null){
                child.visited = true;
                System.out.print(child.label + " ");
                stack.push(child);
            }else{
                stack.pop();
            }
        }
    }

    private static UndirectedGraphNode getUnvisitedChildNode(UndirectedGraphNode node){
        for(UndirectedGraphNode neighbor : node.neighbors){
            if(neighbor.visited == false) return neighbor;
        }
        return null;
    }

    /**
     * Iterative BFS using queue
     *
     */
    public static void bfs(UndirectedGraphNode node){
        if(node == null) return;

        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        node.visited = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                UndirectedGraphNode n = queue.poll();
                System.out.print(n.label + " ");
                for(UndirectedGraphNode neighbor : n.neighbors){
                    if(neighbor.visited == false){
                        queue.add(neighbor);
                        neighbor.visited = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        UndirectedGraphNode node5 = new UndirectedGraphNode(5);
        UndirectedGraphNode node6 = new UndirectedGraphNode(6);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node5);
        node2.neighbors.add(node6);

        node3.neighbors.add(node1);
        node3.neighbors.add(node6);

        node4.neighbors.add(node1);

        node5.neighbors.add(node2);

        node6.neighbors.add(node2);
        node6.neighbors.add(node3);

//        bfs(node1);
//        dfs1(node1);
        dfs2(node1);
    }
}
