package Questions;

import java.util.*;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, 
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,

	Given:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log","cog"]
	Return
	  [
	    ["hit","hot","dot","dog","cog"],
	    ["hit","hot","lot","log","cog"]
	  ]
	  
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lower case alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 *   Undirected Graph -> BFS -> Tree -> DFS -> Result
 *   
 *   hit -> hot -> dot
 *   			-> lot
 *   
 *   map:	hot(hit)
 *   		dot(hot)
 *   		lot(hot)
 *
 */
public class Q126 {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	if(wordList.size() == 0) return res;
    	
    	
    	Queue<String> queue = new LinkedList();
    	HashSet<String> unvisited = new HashSet<>(wordList);
    	HashSet<String> visited = new HashSet<>();
    	HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    	
    	queue.offer(beginWord);
    	int currNum = 1;
    	int nextNum = 0;
    	boolean found = false;
    	
    	while(!queue.isEmpty())
    	{
    		String word = queue.poll();
    		currNum--;
    		for(int i=0;i<word.length();i++)
    		{
    			StringBuilder sb = new StringBuilder(word);

        		for(char c = 'a';c<='z';c++)
        		{
        			sb.setCharAt(i, c);
        			String temp = sb.toString();
        			if(unvisited.contains(temp))
        			{
        				if(visited.add(temp))
        				{
        					nextNum++;
        					queue.offer(temp);
        				}
    					if(map.containsKey(temp)){
        					map.get(temp).add(word);
        				}else
        				{
        					List<String> list = new ArrayList<>();
        					list.add(word);
        					map.put(temp,list);
        				}
        	
        				if(temp.equals(endWord))found = true;
        			}
        		}
    		}
    		
    		if(currNum == 0)
    		{
    			if(found) break;
    			currNum = nextNum;
    			nextNum = 0;
    			for(String s:visited)
    			{unvisited.remove(s);}
    			visited.clear();
    		}
    	}
    	dfs(res,new ArrayList<>(),beginWord,endWord,map);
    	return res;
    }

	private static void dfs(List<List<String>> res,List<String> list, String beginWord, String word,
			HashMap<String, List<String>> map) {
		
		if(word.equals(beginWord))
		{
			list.add(0,beginWord);
			res.add(new ArrayList<>(list));
			list.remove(0);
			return;
		}
		list.add(0,word);
		if(map.get(word)!=null)
		{
			for(String s : map.get(word))
			{
				dfs(res,list,beginWord,s,map);
			}
		}
		list.remove(0);
	}
	
	
	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String>wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		List<List<String>> result = findLadders(beginWord,endWord,wordList);
		System.out.println(result);
	}
}
