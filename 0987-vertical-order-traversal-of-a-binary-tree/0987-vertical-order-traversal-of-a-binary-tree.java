import java.util.*;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: Column -> (Map: Row -> Sorted Values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        dfs(root, 0, 0, map);
        
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> currentColumn = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : rows.values()) {
                // Empty the PQ to maintain sorted order for identical coordinates
                while (!nodes.isEmpty()) {
                    currentColumn.add(nodes.poll());
                }
            }
            result.add(currentColumn);
        }
        return result;
    }

    private void dfs(TreeNode node, int col, int row, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;
        
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new PriorityQueue<>());
        map.get(col).get(row).offer(node.val);
        
        dfs(node.left, col - 1, row + 1, map);
        dfs(node.right, col + 1, row + 1, map);
    }
}