package Questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lower case alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

 */

public class Q127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
    	HashSet<String> set = new HashSet<String>(wordList);
    	if(set.contains(beginWord))set.remove(beginWord);
    	
        Queue<String> queue = new LinkedList<String>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        map.put(beginWord,1);
        queue.offer(beginWord);
        
        while(!queue.isEmpty())
        {
        	String word = queue.poll();
        	int currLevel = map.get(word);
        	
        	for(int i=0;i<word.length();i++)
        	{
        		char[] wordUnit = word.toCharArray();
        		for(char j='a';j<='z';j++)
        		{
        			wordUnit[i] = j;
        			String temp = new String(wordUnit);
        			if(set.contains(temp))
        			{
        				if(temp.equals(endWord))
        				{
        					return currLevel+1;
        				}
        				map.put(temp,currLevel+1);
        				queue.offer(temp);
        				set.remove(temp);
        			}
        		}
        	}
        }
        return 0;
    }
    
	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		List<String>wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		int result = ladderLength(beginWord,endWord,wordList);
		System.out.println(result);
	}
}
