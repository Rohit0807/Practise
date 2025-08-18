
public class TreesPractise {

	public static void main(String[] args) {
		// tree, Root(head), subtree, child, leaf, Ancestors
		//types:
		// 1. Full BT: each node has either 0 or 2 children, cannot have 1 child node
		// 2. Complete BT : all levels completely filled except last, last level should fill from left.
		//					 
		// 3. Perfect BT : all leafs are at same level
		// 4. Balanced BT : height of tree max(log (n)).   height of left-right<=1
		// 5. Degenerate BT : skewed tree, ek side se tree hoga, ek ke niche ek, like linked list
		
		// Traversal : BFS / DFS
		
		// DFS
		// 1. In-order Traversal :  Left Root Right
		// 1. Pre-order Traversal : Root Left Right
		// 1. Post-order Traversal : Left Right Root
		
		// BFS : Level wise traversal
		
		heightOfTree();
	}
	
	
	
	private static void heightOfTree() {
		
		TreeNode root = new TreeNode(12);
        root.left = new TreeNode(8);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(11);

        System.out.println(height(root));
		
	}
	
	private static int height(TreeNode root) {
		if(root==null) return 0;
		
		int left = height(root.left);
		int right = height(root.right);
		
		return 1+Math.max(left, right);
	}
}

class TreeNode {
    int data;
    TreeNode left, right;
    
    public TreeNode() {
    	
    }

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }

	public TreeNode(int data, TreeNode left, TreeNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
