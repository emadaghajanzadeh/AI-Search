package algorithems;

import models.State;

import java.util.*;

public class BDS {
    static Set<State> sVisitedList = new TreeSet<>();
    static Set<State> tVsitedList = new TreeSet<>();
    static Queue<State> sFringe = new LinkedList<>();
    static Queue<State> tFringe = new LinkedList<>();
    static ArrayList<State> allStates = new ArrayList<>() ;
    public static void solve(State start , State goal) {
        int count = 0;
        if (start.isFinal()) {
            start.print();
            return;
        }else if(goal==null){
            return;
        }
        tVsitedList.add(goal);
        tFringe.add(goal) ;
        sVisitedList.add(start) ;
        sFringe.add(start);
        allStates.add(start); allStates.add(goal);
        while ((!sFringe.isEmpty()) && (!tFringe.isEmpty() )){

            modified_bfs(1);
            modified_bfs(0);;
            State intersect = isIntersect();
            if(intersect!= null){
                System.out.println("Intersect Node Is Found : ");
                System.out.println("From Root Node To Intersect Node Path Is : ");
                intersect.print();
                System.out.println("From Intersect Node To Goal Node Path Is : ");
                goal.print(intersect);
                return;
            }

        }
    }

    private static void modified_bfs(int isSource){
        if(isSource==1){
            State temp = sFringe.poll();
            for (State child : temp.makeChild()) {
                if (!sVisitedList.contains(child)) {
                    allStates.add(child);
                    sVisitedList.add(child);
                    sFringe.add(child);
                }
            }
        }else{
            State temp = tFringe.poll();
            if(temp.getParent()!=null) {
                allStates.add(temp.getParent());
                tVsitedList.add(temp.getParent());
                tFringe.add(temp.getParent());
            }
        }
    }

    private static State isIntersect(){
        for (State state : allStates){
            if(sVisitedList.contains(state) && tVsitedList.contains(state)){
                return state ;
            }
        }
        return null ;
    }

}
