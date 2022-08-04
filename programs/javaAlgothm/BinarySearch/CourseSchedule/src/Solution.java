import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    List<List<Integer>> edges;
    Boolean valid = true;
    int[] visited;
    int[] indeg;
    public boolean canFinish_DFS(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        visited = new int[numCourses];//初始化visited数组
        for (int i = 0; i<numCourses;i++){
            edges.add(new ArrayList<Integer>());//初始化整个图
        }
        for(int[] edge : prerequisites){
            //想学edge[0]就要先学edge[1]
            //所以找到edge[1]位置的arrayList中加上edge[0]
            edges.get(edge[1]).add(edge[0]);
        }
        for(int i = 0; i<numCourses && valid; i++){
            if(visited[i] == 0){
                dfs(i);
            }
        }
        return valid;


    }

    public void dfs(int n){
        visited[n] = 1;//标记 该科目 为 搜索中
        for(int c : edges.get(n)){
            if(visited[c] == 0){
                dfs(c);//递归dfs
                if(!valid){//当发现valid为false 结束
                    return;
                }
            }
            else if(visited[c] == 1){//如果访问到的科目是 搜索中 的状态， 那么说明有环，标记valid
                valid = false;
                return;
            }
        }
        visited[n] = 2; //该科目已经完成搜索， 标记为 搜索过
    }

    public boolean canFinish_BFS(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for(int i = 0;i<numCourses;i++){
            edges.add(new ArrayList<Integer>());//初始化
        }
        indeg = new int[numCourses];
        for(int[] info: prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i =0; i<numCourses; i++){
            if(indeg[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()){
            ++count;
            int v = queue.poll();
            for (int n:edges.get(v)){
                indeg[n]--;
                if(indeg[n] == 0){
                    queue.offer(n);
                }
            }
        }
        return count == numCourses;
    }





}
