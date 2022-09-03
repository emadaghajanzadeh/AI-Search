package algorithems;

import models.Node;
import models.State;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class Astar {

    public static State solve(State start) {
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return start;
        }
        Node node = new Node(start , 0) ;
        Queue<Node> fringe = new PriorityQueue<>( );
        fringe.add(node);



        Set<State> visitedList = new TreeSet<>();
        visitedList.add(start);


        while (!fringe.isEmpty()) {
            Node temp = fringe.poll();
            count++;
            if (temp.getState().isFinal()) {
                temp.getState().print();
                System.out.println("node count = " + count);
                return temp.getState();
            }
            for (State child : temp.getState().makeChild()) {
                if (!visitedList.contains(child)) {
                    visitedList.add(child);
                    fringe.add(new Node(child , count));
                }
            }


        }
        System.out.println("not found");
        return null ;

    }
}

