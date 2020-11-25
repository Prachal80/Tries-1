// Time Complexity : o(mn + n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : The output is null. I tried to debug but didn't help
// Leetcode : 720
//Approach :  TRIES + BFS 

class Solution {
    class TrieNode{
            String word;
            TrieNode[] children;
            public TrieNode(){
                children = new TrieNode[26];
            }
        }
     TrieNode root ;
     public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words){
            insert(word) ;
            }
         Queue<TrieNode> q = new LinkedList<>();
         q.add(root);
         TrieNode curr = null;
         while(!q.isEmpty()){
             curr = q.poll();
             for(int j = 25 ; j <=0 ; j-- ){
                if(curr.children[j]!=null && curr.children[j].word != null){
                 q.add(curr.children[j]);
                }
             }    
         }
         return curr.word;
        }
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
        curr = curr.children[c - 'a'];
       
        }
    curr.word = word;
    }
    
}
    
