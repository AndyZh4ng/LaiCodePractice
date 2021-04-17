package bfs;


import java.util.PriorityQueue;

public class KthSmallestNumInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        if(k == 0) {
            return 0;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a1, a2) -> {
            if(matrix[a1[0]][a1[1]] == matrix[a2[0]][a2[1]]) {
                return 0;
            }
            return matrix[a1[0]][a1[1]] < matrix[a2[0]][a2[1]] ? -1 : 1;
        });
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] flag = new boolean[row][col];
        flag[0][0] = true;
        minHeap.offer(new int[]{0, 0});
        for(int i = 0; i < k - 1; i++) {
            int[] cur = minHeap.poll();
            int[] child1 = {cur[0] + 1, cur[1]};
            int[] child2 = {cur[0], cur[1] + 1};
            if(child1[0] < row && !flag[child1[0]][child1[1]]){
                minHeap.offer(child1);
                flag[child1[0]][child1[1]] = true;
            }
            if(child2[1] < col && !flag[child2[0]][child2[1]]){
                minHeap.offer(child2);
                flag[child2[0]][child2[1]] = true;
            }
        }
        int[] res = minHeap.peek();
        return matrix[res[0]][res[1]];
    }
}
