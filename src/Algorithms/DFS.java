package Algorithms;

import models.State;

import java.util.*;

public class DFS {
    static Set<State> visitedList = new TreeSet<>();
    static int count = 0 ;
    static int found = 0 ;
    static Stack<State> fringe = new Stack<>();
    public static void solve(State start) {
        count = 0 ;
        fringe.add(start);
        recursive() ;
        if(found==0)
          System.out.println("not found");

    }
     static int recursive(){
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
                if (!visitedList.contains(child)) {
                    fringe.add(child);
                     if(recursive()==1)
                         return 1 ;
                }
         }
         return 0;

    }

}
