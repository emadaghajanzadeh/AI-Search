package algorithems;

import models.Node;
import models.State;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class RBFS {
    static int count = 0 ;
    static Scanner s = new Scanner(System.in);
    public static int solve(State start){
        Node node = new Node(start , 0 );
         Result result = recursive(node , 100000000) ;
        if(result.success) {
            result.node.getState().print();
            System.out.println("node count = " + count);
        }
        return  1 ;
    }

    public static Result recursive(Node node , int limit) {
        count++;
        if (node.getState().isFinal()) {
            return new Result(true, node);
        }
        Queue<Node> fringe = new PriorityQueue<>();
//        Queue<Node> temp = new PriorityQueue<>();

        for (State child : node.getState().makeChild()) {
            Node t = new Node(child, node.getGn() + 1);
            t.setFn(Math.max(t.getFn(), node.getFn()));
            fringe.add(t);
        }
//        fringe.add(temp.poll());

        if (fringe.isEmpty()) {
            return new Result(false, null);
        }
        while (!fringe.isEmpty()) {
            Node best = fringe.poll();
            best.incrementPenalty();
            if (best.getFn() > limit) return new Result(false, best);
            Node second = fringe.peek(); // dont delete second one ;
            Result res;
            if (second == null)
                res = recursive(best, limit);
            else
                res = recursive(best, Math.min(limit, second.getFn()));
            if (res.success) {
                return res;
            }
            fringe.add(res.node);
//            System.out.println();
        }
        return null;

    }


}

class Result{
    public boolean success  ;
    public Node node ;
    public Result(boolean success , Node node){
        this.success = success ;
        this.node = node ;
    }
}