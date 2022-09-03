package algorithems;

import models.State;

import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class IDS {
    static Set<State> visitedList = new TreeSet<>();
    static int count = 0 ;
    static int found = 0 ;
    static int depth = 0 ;
    static Stack<State> fringe = new Stack<>();

    static public void solve(State start){
        int limit = 0 ;
        while(true){
            count = 0 ;
            fringe.add(start);
            DLS(limit++ , 0 );
            if(found==1)
                break ;
            visitedList.clear();
            fringe.clear();
            count = 0 ;
            found = 0 ;
            depth = 0 ;

        }

    }





    static int DLS(int limit , int depth){
        State state = fringe.peek() ;
        fringe.pop() ;
        visitedList.add(state) ;
        count++ ;
        if (state.isFinal()) {
            state.print();
            System.out.println("node count = " + count);
            found = 1 ;
            return 1 ;
        }
        for (State child : state.makeChild()) {
            if (!visitedList.contains(child) && depth <= limit) {
                fringe.add(child);
                if(DLS(limit , depth + 1)==1)
                    return 1 ;
            }
        }
        return  0 ;
    }
}











