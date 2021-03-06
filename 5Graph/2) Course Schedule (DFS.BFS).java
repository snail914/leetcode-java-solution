/*
There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]. 
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
For example, given 2 and [[1,0]], there are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

For another example, given 2 and [[1,0],[0,1]], there are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
Analysis

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
click to show more hints.

Hints:
This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and 
therefore it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
*/
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len=prerequisites.length;
        int arc=0;
        if (numCourses*len==0) return true;
        LinkedList<Integer> queue=new LinkedList();
        int [] counter=new int[numCourses];
        for (int i=0; i<len; i++){
            counter[prerequisites[i][0]]++;            
        }
        for (int i=0; i<numCourses; i++){
            if (counter[i]==0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int top=queue.remove();
            arc++;
            for (int i=0; i<len; i++){
                if (prerequisites[i][1]==top){
                    --counter[prerequisites[i][0]];
                    if(counter[prerequisites[i][0]]==0){
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return arc==numCourses;
    }
}