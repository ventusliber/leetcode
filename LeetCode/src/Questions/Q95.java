package Questions;
import java.util.ArrayList;
import java.util.List;
import Leet.TreeNode;


/*
 * 
 */

public class Q95 {
    public static List<TreeNode> generateTrees_dp(int n) 
    {
    	List<TreeNode>[] res = new List[n+1];
    	res[0] = new ArrayList<>();
    	if(n == 0) return res[0];
    	res[0].add(null);
    	for(int i=1;i<=n;i++)
    	{
    		res[i] = new ArrayList<>();
    		for(int j=0;j<i;j++)
    		{
    			for(TreeNode left:res[j])
    			{
    				for(TreeNode right:res[i-j-1])
    				{
    					TreeNode root = new TreeNode(j+1);
    					root.left = left;
    					root.right = clone(right,j+1);
    					res[i].add(root);
    				}
    			}
    		}
    	}
    	return res[n];
    }
    
    public static TreeNode clone(TreeNode node,int k)
    {
    	if(node == null) return node;
    	TreeNode curr = new TreeNode(node.val+k);
    	curr.left = clone(node.left,k);
    	curr.right = clone(node.right,k);
    	return curr;
    }
    
    
    public static List<TreeNode> generateTrees_dfs(int n) 
    {
    	if(n == 0 ) return new ArrayList<>();
    	return generateTree(1,n);
    }
    
    public static List<TreeNode> generateTree(int start,int end)
    {
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	
    	if(start > end) {res.add(null);}
    	
    	for(int idx= start; idx <= end;idx++)
    	{
    		List<TreeNode> leftlist = generateTree(start,idx-1);
    		List<TreeNode> rightlist = generateTree(idx+1,end);
    		
    		for(TreeNode left:leftlist)
    		{
    			for(TreeNode right:rightlist)
    			{
    				TreeNode node = new TreeNode(idx);
    				node.left = left;
    				node.right = right;
    				res.add(node);
    			}
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
    	generateTrees_dp(10);
    }
}
