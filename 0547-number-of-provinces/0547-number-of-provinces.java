class Solution {
    public class DisjointSetPractice {
    List<Integer>rank=new ArrayList<>();
    List<Integer>parent=new ArrayList<>();
    DisjointSetPractice(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findParent(int node){
        if(node==parent.get(node))return node;
        int ultiMateParent=findParent(parent.get(node));
        parent.set(node,ultiMateParent);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ultiMateParentU=findParent(u);
        int ultiMateParentV=findParent(v);
        if(ultiMateParentV==ultiMateParentU)return;
        if(parent.get(ultiMateParentV)<parent.get(ultiMateParentU)){
            parent.set(ultiMateParentV,ultiMateParentU);
        }else if(parent.get(ultiMateParentU)<parent.get(ultiMateParentV)){
            parent.set(ultiMateParentV,ultiMateParentU);
        }else{
            parent.set(ultiMateParentV,ultiMateParentU);
            int rankU=rank.get(ultiMateParentU);
            rank.set(ultiMateParentU,rankU+1);
        }
    }
}

    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisjointSetPractice ds=new DisjointSetPractice(n);
        int provinces=n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    if(ds.findParent(i)!=ds.findParent(j)){
                        provinces--;
                        ds.unionByRank(i,j);
                    }
                    
                }
            }
        }
        return provinces;
    }
}