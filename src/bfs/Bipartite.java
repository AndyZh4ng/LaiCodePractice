package bfs;

import java.util.*;

//Determine if an undirected graph is bipartite.
// A bipartite graph is one in which the nodes can be divided into two groups,
// such that no nodes have direct edges to other nodes in the same group.

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph){
        Set<GraphNode> u = new HashSet<>();
        Set<GraphNode> v = new HashSet<>();
        Set<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> q = new ArrayDeque<>();
        q.offer(graph.get(0));
        u.add(graph.get(0));
        while(!q.isEmpty()){
            GraphNode cur = q.poll();
            if(u.contains(cur) && v.contains(cur)){
                return false;
            }
            for(GraphNode g : cur.neighbors){
                if (!visited.contains(g)){
                    if(u.contains(cur)){
                        v.add(g);
                        q.offer(g);
                    } else {
                        u.add(g);
                        q.offer(g);
                    }
                }
            }
            visited.add(cur);
        }
        return true;
    }
}

/*
  1  --   2

      /

  3  --   4
    []
    u[1
    v[2
    2
    1.从Q里拿出来node
    2.检查是否两个set都有node，有的话返回f
    3.遍历neighbor，如果neighbor不在visited
    3.1 如果u有node，把neighbor加到v和q
    3.2 如果v有node，把neighbor加到u和q
    4. 把当前node加入visited
 */
