class Solution {
    class NodeInfo {
        int row, col, val;
        NodeInfo(int r, int c, int v) {
            this.row = r;
            this.col = c;
            this.val = v;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<NodeInfo> nodes = new ArrayList<>();
        dfs(root, 0, 0, nodes);

        // Sort by: Column first, then Row, then Value
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> result = new ArrayList<>();
        if (nodes.isEmpty()) return result;

        int currentCol = nodes.get(0).col;
        List<Integer> currentList = new ArrayList<>();
        
        for (NodeInfo node : nodes) {
            if (node.col != currentCol) {
                result.add(currentList);
                currentList = new ArrayList<>();
                currentCol = node.col;
            }
            currentList.add(node.val);
        }
        result.add(currentList);
        return result;
    }

    private void dfs(TreeNode root, int row, int col, List<NodeInfo> nodes) {
        if (root == null) return;
        nodes.add(new NodeInfo(row, col, root.val));
        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}