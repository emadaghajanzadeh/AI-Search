package Algorithms;

import models.Node;
import models.State;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class IDAstar {
    static Queue<Node> fringe = new PriorityQueue<>( );
    static Set<State> visitedList = new TreeSet<>();
    static int min = 1000000;
    static public void solve(State start){

        Node node = new Node(start , 0 );
        int cuttoff = node.getFn() ;
        int count = 0 ;


        while(true){

            count = 0 ;
            fringe.add(node);
             min = 100000000;
            int found = DLS(cuttoff , count );

            if(found==1)
                break ;
            visitedList.clear();
            fringe.clear();
            count = 0 ;
            cuttoff = min ;


        }

    }
    static int DLS(int limit , int count){
        Node temp = fringe.poll() ;
        visitedList.add(temp.getState()) ;
        count++ ;
        if (temp.getState().isFinal()) {
            temp.getState().print();
            System.out.println("node count = " + count);
            return 1 ;
        }
        for (State child : temp.getState().makeChild()) {
            if (!visitedList.contains(child)) {
                Node t = new Node(child , count) ;
                if(t.getFn()<= limit){
                    fringe.add(t);
                    if(DLS(limit , count)==1)
                        return 1 ;
                }else if (t.getFn() < min){
                    min = t.getFn() ;
                }
            }
        }
        return  0 ;
    }
}
