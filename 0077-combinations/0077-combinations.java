class Solution {
    // Final ans list.
    public List<List<Integer>> finalList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        List<Integer> list = new ArrayList<>();

        findCombine(n, k, list, 1); // 1 is the starting index

        return finalList;
    }
    public void findCombine(int n, int k, List<Integer> list, int index){
        // Base condition
        if(list.size() == k){
            finalList.add(new ArrayList(list));
            return;
        }

        for(int i = index; i <=n ; i++){
            list.add(i);

            findCombine(n, k, list, i+1);

            //Backtracking
            list.remove(list.size()-1);
        }
    }
}