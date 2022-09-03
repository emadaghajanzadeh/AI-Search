package models;

public class Node implements Comparable<Node> {
    private State state ;
    private int fn ;
    private int gn  ;
    private int hn ;
    private int penalty;

    public int getPenalty() {
        return penalty;
    }
    public void incrementPenalty(){
        this.penalty++;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public State getState() {
        return state;
    }

    public int getGn() {
        return gn;
    }

    public int getFn() {
        return gn + state.getBoard().getNumberOfUncolored() ;
    }

    public void setFn(int fn) {
        this.fn = fn;
    }

    public Node(State state , int gn){
        this.state = state ;
        this.gn = gn ;
        this.hn = state.getBoard().getNumberOfUncolored()+ (5*this.penalty) ;         //Heuristic Function
        this.fn = this.hn + this.gn ;
    }
    @Override
    public int compareTo(Node node) {
        return node.getFn() > this.getFn() ? -1 :1;
    }
}
