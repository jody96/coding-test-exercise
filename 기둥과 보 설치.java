import java.util.*;
class Node implements Comparable<Node>{
    private int x;
    private int y;
    private int stuff;
    
    public Node(int x, int y, int stuff){
        this.x = x;
        this.y = y;
        this.stuff = stuff;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getStuff(){
        return this.stuff;
    }
    
    @Override 
    public int compareTo(Node other){
        if(this.x == other.x && this.y == other.y){
            return Integer.compare(this.stuff, other.stuff);
        }
        if(this.x == other.x){
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }
}
class Solution {
    public static boolean possible(ArrayList<ArrayList<Integer>> arr){
        for(int i=0; i<arr.size(); i++){
            int x = arr.get(i).get(0);
            int y = arr.get(i).get(1);
            int stuff = arr.get(i).get(2);
            
            if(stuff == 0){
                boolean flag = false;
                if(y == 0){
                    flag = true;
                }
                for(int j=0; j<arr.size(); j++){
                    if(arr.get(j).get(0) == x-1 && arr.get(j).get(1) == y && arr.get(j).get(2) == 1)
                        flag = true;
                    if(arr.get(j).get(0) == x && arr.get(j).get(1) == y && arr.get(j).get(2) == 1)
                        flag = true;
                    if(arr.get(j).get(0) == x && arr.get(j).get(1) == y-1 && arr.get(j).get(2) == 0)
                        flag = true;
                }
                if(!flag)
                    return false;
            } else if(stuff == 1){
                boolean flag = false;
                boolean left = false;
                boolean right = false;
                for(int j=0; j<arr.size(); j++){
                    if(arr.get(j).get(0) == x && arr.get(j).get(1) == y-1 && arr.get(j).get(2) == 0)
                        flag = true;
                    if(arr.get(j).get(0) == x+1 && arr.get(j).get(1) == y-1 && arr.get(j).get(2) == 0)
                        flag = true;
                    if(arr.get(j).get(0) == x-1 && arr.get(j).get(1) == y && arr.get(j).get(2) == 1)
                        left = true;
                    if(arr.get(j).get(0) == x+1 && arr.get(j).get(1) == y && arr.get(j).get(2) == 1)
                        right = true;
                    
                    if(left && right)
                        flag = true;
                }
                if(!flag)   
                    return false;
            }
        }
        return true;
    }

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0; i<build_frame.length; i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int stuff = build_frame[i][2];
            int operation = build_frame[i][3];

            if(operation == 0){
                ArrayList<Integer> erased = new ArrayList<>();
                int idx = 0;
                for(int j=0; j<arr.size(); j++){
                    if(arr.get(j).get(0) == x && arr.get(j).get(1) == y && arr.get(j).get(2) == stuff){
                        idx = j;
                        for(int k=0; k<3; k++){
                            erased.add(arr.get(j).get(k));
                        }
                        arr.remove(idx);
                        break;
                    }
                }
                if(!possible(arr)){
                    arr.add(erased);
                }
            } else if(operation == 1){
                ArrayList<Integer> added = new ArrayList<>();
                added.add(x);
                added.add(y);
                added.add(stuff);
                
                arr.add(added);
                if(!possible(arr)){
                    //System.out.println(added);
                    arr.remove(arr.size()-1);
                }
            }
        }
        ArrayList<Node> sorting = new ArrayList<>();
        for(int i=0; i<arr.size(); i++){
            int x = arr.get(i).get(0);
            int y = arr.get(i).get(1);
            int stuff = arr.get(i).get(2);
            sorting.add(new Node(x, y, stuff));
        }
        Collections.sort(sorting);
        answer = new int[sorting.size()][3];
        
        for(int i=0; i<sorting.size(); i++){
            answer[i][0] = sorting.get(i).getX();
            answer[i][1] = sorting.get(i).getY();
            answer[i][2] = sorting.get(i).getStuff();
        }
        return answer;
    }
}
