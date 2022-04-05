package CrackingTheCodingInterview;

import java.util.*;
import java.util.Queue;

public class BuildOrder {
    public char[] buildOrder(char[] projects, char[][] dependencies){
        Map<Character, Set<Character>> graph = new HashMap<>();

        for(char project: projects){
            graph.put(project, new HashSet<>());
        }

        for(char[] dependency: dependencies){
            char from = dependency[0];
            char to = dependency[1];
            graph.get(from).add(to);
        }

        Queue<Character> queue = new LinkedList<>();
        for (char to: projects){
            boolean noDependency = true;
            for(char from: projects){
                if(graph.get(from).contains(to)){
                    noDependency = false;
                    break;
                }
            }
            if(noDependency){
                queue.add(to);
            }
        }

        List<Character> path = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        while (!queue.isEmpty()){
            char to = queue.poll();

            boolean noDependency = true;
            for(char from: projects){
                if(graph.get(from).contains(to) && !visited.contains(from)){
                    noDependency = false;
                    break;
                }
            }

            for(char project: projects){
                if(graph.get(to).contains(project) && !visited.contains(project)){
                    queue.add(project);
                }
            }

            if(noDependency){
                if(!visited.contains(to)){
                    path.add(to);
                    visited.add(to);
                }
            }else {
                queue.add(to);
            }
        }

        char[] pathArray = new char[path.size()];
        for(int i=0; i<path.size(); i++){
            pathArray[i] = path.get(i);
        }
        return pathArray;
    }
}
