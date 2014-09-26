package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;


public class WordLadder {
	
	public static boolean isDiffChar(String a, String b) {
		int diff = 0;
        for (int i = 0; i < a.length(); i++) {  
            if (a.charAt(i) != b.charAt(i)) {  
                diff++;
                if (diff >= 2) return false;  
            }  
        }
        return diff == 1;  
	}
	
    public static int ladderLength(String start, String end, Set<String> dict) {
    	int res = dict.size() + 1;
    	List<String> words = new ArrayList<String>();
    	words.add(start);
    	words.add(end);
    	for (String dic : dict) {
			words.add(dic);
		}
    	List<Integer> stack = new ArrayList<Integer>();
    	stack.add(0);
    	int len = 0;
    	int index = 0;
    	while (0 != stack.size()) {
    		String src = words.get(stack.get(stack.size() - 1));
    		int i = 0;
    		for (i = index + 1; i < words.size(); i++) {
    			if (!stack.contains(i) && isDiffChar(src, words.get(i))) {
    				stack.add(i);
    				len = len + 1;
    				break;
    			} 
    		}
    		if (words.get(stack.get(stack.size() - 1)).equals(end)) {
    			len = stack.size();
    			if (res > len - 1) res = len - 1;
    			if (res < 2) return res;
    			else {
        			index = stack.remove(stack.size() - 1);
        			index = stack.remove(stack.size() - 1);
        			len = len - 2;
    			}
    		} else if (i == words.size() || len >= res) {
    			index = stack.remove(stack.size() - 1);
    			len = len - 1;
    		} else {
    			index = 0;
    		}
    	}
    	return res == dict.size() + 1 ? 0 : res;
    }
    
    public static class GraphNode {
    	String lab;
    	List<GraphNode> neighbors = null;
    	
    	public GraphNode(String val) {
    		lab = val;
    		neighbors = new ArrayList<GraphNode>();
    	}
    }
    
    public static List<GraphNode> generateGraph(List<String> values) {
    	GraphNode head = null;
    	List<GraphNode> nodes = new ArrayList<GraphNode>();
    	for (int i = 0; i < values.size(); i++) {
			GraphNode node = new GraphNode(values.get(i));
			if (null == head) head = node;
			nodes.add(node);
		}
    	for (GraphNode node : nodes) {
    		for (GraphNode neighbor : nodes) {
    			if (node != neighbor && !node.neighbors.contains(neighbor) && isDiffChar(node.lab, neighbor.lab)) {
    				node.neighbors.add(neighbor);
    				neighbor.neighbors.add(node);
    			}
    		}
    	}
    	return nodes;
    } 
    
    public static int ladderLength2(String start, String end, Set<String> dict) {
    	List<String> nodes = new ArrayList<String>();
    	nodes.add(start);
    	nodes.add(end);
    	for (String val : dict) {
    		if (!nodes.contains(val)) nodes.add(val);
    	}
    	List<GraphNode> graph = generateGraph(nodes);
    	//print(graph.get(0));
    	GraphNode snode = graph.get(0);
    	GraphNode enode = graph.get(1);
    	List<GraphNode> stack = new ArrayList<GraphNode>();
    	stack.add(snode);
    	int b = 0, e = 0;
    	int step = 0;
    	while (true) {
    		int endnode = e + 1;
    		for (int i = b; i < endnode; i++) {
    			GraphNode cnode = stack.get(i);
    			for (GraphNode n : cnode.neighbors) {
    				if (n == enode) return step + 1;
    				else if (!stack.contains(n)) {
    					stack.add(n);
    					e = e + 1;
    				}
    			}
    		}
    		if (b == e) {
    			break;
    		}
    		step = step + 1;
    		b = endnode;
    	}
    	return -1;
    }
    
    public static void print(GraphNode node) {
    	if (null == node) return;
    	List<GraphNode> nodes = new ArrayList<GraphNode>();
    	int index = 0;
    	if (null != node)nodes.add(node);
    	while (index != nodes.size()) {
    		GraphNode n = nodes.get(index);
    		System.out.print(n.lab + "(");
    		for (GraphNode neighbor : n.neighbors) {
    			if (!(nodes.contains(neighbor))) {
    				nodes.add(neighbor);
    			}
    			System.out.print(neighbor.lab + ",");
    		}
    		System.out.println(")");
    		index = index + 1;
    	}
    }
    
    public static int ladderLength3(String start, String end, Set<String> dict) {
    	if (null == start || null == end || start.length() != end.length() || start.equals(end)) return 0;
    	if (isDiffChar(start, end)) return 2;
    	List<String> stack = new ArrayList<String>();
    	Map<String, Integer> pathlen = new HashMap<String, Integer>();
    	pathlen.put(start, 1);
    	stack.add(start);
    	while (0 != stack.size()) {
    		String word = stack.remove(0);
    		int len = pathlen.get(word);
    		for (int i = 0; i < word.length(); i++) {
    			for (char c = 'a'; c <= 'z'; c++) {
    				if (word.charAt(i) == c) continue;
    				StringBuffer sb = new StringBuffer(word);
    				sb.setCharAt(i, c);
    				String tmp = sb.toString();
    				if (tmp.equals(end)) return len + 1;
    				if (dict.contains(tmp)) {
    					if (!pathlen.containsKey(tmp)) {
    						stack.add(tmp);
    						pathlen.put(tmp, len + 1);
    					}
    				}
    			}
    		}
    	}
    	return 0;
    }
    
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> res = new ArrayList<List<String>>();
    	if (null == start || null == end 
    			|| start.length() != end.length() 
    			|| start.equals(end)
    			|| 0 == dict.size()) 
    		return res;
    	if (isDiffChar(start, end)) {
    		List<String> path = new ArrayList<String>();
    		path.add(start);
    		path.add(end);
    		res.add(path);
    		return res;
    	}
    	
    	Map<String, Integer> len = new HashMap<String, Integer>();
    	int min = Integer.MAX_VALUE;
    	for (String str : dict) {
			len.put(str, Integer.MAX_VALUE);
		}
    	len.put(start, 0);
    	dict.add(end);
    	
    	List<String> stack = new ArrayList<String>();
    	stack.add(start);
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	
    	int index = 0;
    	while (index != stack.size()) {
    		String word = stack.get(index);
    		int length = len.get(word) + 1;
    		if (length > min) break;
    		for (int i = 0; i < word.length(); i++) {
    			for (char c = 'a'; c <= 'z'; c++) {
    				if (word.charAt(i) == c) continue;
    				StringBuffer sb = new StringBuffer(word);
    				sb.setCharAt(i, c);
    				String tmp = sb.toString();
    				if (len.containsKey(tmp)) {
    					if (length > len.get(tmp)) continue;
    					else if (length < len.get(tmp)) {
    						stack.add(tmp);
    						len.put(tmp, length);
    					}
    				
	    				if (map.containsKey(tmp)) {
	    					if (!(map.get(tmp).contains(word))) map.get(tmp).add(word);
	    				} else {
	    					List<String> l = new ArrayList<String>();
	    					l.add(word);
	    					map.put(tmp, l);
	    				}
    				
	    				if (tmp.equals(end)) min = length;
	    				/*if (tmp.equals(start)) continue; 
	    				if (tmp.equals(end)) {
	    					if (!path.contains(word)) path.add(word);
	    					break;
	    				}
	    				if (dict.contains(tmp)) {
	    					List<String> v = pathlen.get(word);
	    					if (null == v || (null != v && !v.contains(tmp))) {
	    						stack.add(tmp);
	    						List<String> s = pathlen.get(tmp);
	    						if (null == s) {
	    							s = new ArrayList<String>();
	    							pathlen.put(tmp, s);
	    						}
	    						if (!s.contains(word)) s.add(word);
	    					}
	    				}*/
    				}
    			}
    		}
    		index = index + 1;
    	}
    	
/*    	pathlen.put(end, path);
    	if (null == path || 0 == path.size()) return new ArrayList<List<String>>();*/
    	List<String> result = new ArrayList<String>();
    	//List<List<String>> res = new ArrayList<List<String>>();
    	return traversal(start, end, res, result, map);
    }
    
    public static List<List<String>> traversal(
    		String start, 
    		String word, 
    		List<List<String>> res, 
    		List<String> result, 
    		Map<String, List<String>> map) {
        if (word.equals(start)){
            result.add(0,start);
            res.add(new ArrayList<String>(result));
            result.remove(0);
            return res;
        }
        result.add(0,word);
        if (map.get(word)!=null)
            for (String s : map.get(word))
            	traversal(start, s, res, result, map);
        result.remove(0);
    	return res;
    }
    
    public static List<List<String>> traversal(Map<String, List<String>> graph, 
    		List<List<String>> res,
    		List<String> parentTraversal,
    		String head) {
    	//List<List<String>> res = new ArrayList<List<String>>();
    	List<String>children = graph.get(head);
    	if (null == children || 0 == children.size()) {
    		//List<String> l = new ArrayList<String>();
    		parentTraversal.add(head);
    		res.add(parentTraversal);
    		return res;
    	} else if (null != children) {
    		int i = 0;
    		List<List<String>> cr = null;
	    	for (String child : children) {
	    		List<String> tmp = null;
	    		if (i != 0) tmp = new ArrayList<String>(parentTraversal);
				tmp = parentTraversal;
	    		cr = traversal(graph, res, tmp, child);
	    		if (0 == cr.size()) {
	    			List<String> l = new ArrayList<String>();
	    			l.add(head);
	    			cr.add(l);
	    		} else {
		    		for (List<String> l : cr) {
		    			l.add(head);
		    		}
	    		}
	    	}
	    	return cr;
    	}
    	return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		String start = "cet";
		String end = "ism";
		String[] dicts = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < dicts.length; i++) {
			dict.add(dicts[i]);
		}
		System.out.println(ladderLength(start, end, dict));*/
		
		String start = "qa";
		String end = "sq";
		String[] dicts = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < dicts.length; i++) {
			dict.add(dicts[i]);
		}
		List<List<String>> res = findLadders(start, end, dict);
		for (List<String> l : res) {
			for (String s : l) System.out.print(s + " ");
			System.out.println();
		}
	}
}
