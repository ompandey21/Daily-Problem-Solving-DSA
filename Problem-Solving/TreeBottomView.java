import java.util.*;
import java.io.*;
public class TreeBottomView {
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] arr=br.readLine().split(" ");
        BinaryTree bt=new BinaryTree(arr);
        
        bt.bottomView();
        
    }
}

class BinaryTree
{
    private class Node
    {
        int data;
        Node left,right;
        Node(int data)
        {
            this.data=data;
        }
    }

    Node root;

    BinaryTree(String[] arr)
    {
        Queue<Node> queue=new LinkedList<Node>();
        construct(arr,0,queue);
    }

    public void bottomView()
    {
        bottomView(this.root);
    }

   private void bottomView(Node root) {
	   TreeMap<Integer, Integer> map = new TreeMap<>();

	   bottom(map, 0, root);

	   for(int a : map.keySet()){
		   System.out.print(map.get(a)+" ");
	   }

	}
	private static void bottom(TreeMap<Integer, Integer> map, int level, Node root){
		if(root == null) return;
	   if(root.data == -1) return;

	   map.put(level, root.data);
	   bottom(map, level - 1, root.left);
	   bottom(map, level + 1, root.right);
   }


    private void construct(String[] arr,int ind,Queue<Node> queue)
    {
        if(ind>=arr.length)
        return;
        if(queue.size()==0)
        {
            Node nn=new Node(Integer.parseInt(arr[ind]));
            this.root=nn;
            queue.add(nn);
        }
        else
        {
            Node parent=queue.peek();
                if(parent.data!=-1){
                if(parent.left==null)
                {
                    parent.left=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.left);
                }
                else
                {
                    if(parent.right==null)
                    {
                    parent.right=new Node(Integer.parseInt(arr[ind]));
                    queue.add(parent.right);
                    queue.poll();
                    }
               }
               }
               else
               {
                   queue.poll();
                   ind--;
               }
        }
        construct(arr,ind+1,queue);
    }

    public void display()
    {
        display_tree(this.root);
    }

    private void display_tree(Node root)
    {
        if(root==null)
        return;
        String str=root.data+"";
        if(root.left!=null)
        {
            str=root.left.data+" <= "+str;
        }
        else
        {
            str="END <= "+str;
        }

        if(root.right!=null)
        {
            str=str+" => "+root.right.data;
        }
        else
        {
            str=str+" => END";
        }
        System.out.println(str);
        display_tree(root.left);
        display_tree(root.right);

    }


}
