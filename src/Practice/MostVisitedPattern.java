package Practice;

import java.util.*;

public class MostVisitedPattern {
    private class Session implements Comparable<Session> {
        String username;
        int timestamp;
        String website;

        public Session(String username, String website, int timestamp) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }

        public int compareTo(Session session) {
            return Integer.compare(this.timestamp, session.timestamp);
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<Session> sessions = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            String user = username[i];
            String site = website[i];
            int time = timestamp[i];
            sessions.add(new Session(user, site, time));
        }

        Collections.sort(sessions);

        Map<String, List<String>> visits = new HashMap<>();

        for (Session session : sessions) {
            String user = session.username;
            String site = session.website;
            visits.computeIfAbsent(user, key -> new ArrayList<>()).add(site);
        }

        Map<String, Integer> freq = new HashMap<>();
        for (List<String> visit : visits.values()) {
            if (visit.size() < 3) {
                continue;
            }
            Map<String, Integer> localFreq = new HashMap<>();
            List<List<String>> allThreesPatterns = generateAllPatterns(visit);
            for(List<String> threeVisit: allThreesPatterns){
                if(threeVisit.size() != 3) continue;
                StringBuilder stringBuilder;
                String site1 = threeVisit.get(0);
                String site2 = threeVisit.get(1);
                String site3 = threeVisit.get(2);
                stringBuilder = new StringBuilder(site1);
                stringBuilder.append(" ");
                stringBuilder.append(site2);
                stringBuilder.append(" ");
                stringBuilder.append(site3);
                String pattern = stringBuilder.toString();
                localFreq.put(pattern,1);
            }


            for (String pattern : localFreq.keySet()) {
                if (freq.containsKey(pattern)) {
                    freq.put(pattern, freq.get(pattern) + 1);
                } else {
                    freq.put(pattern, 1);
                }
            }
        }
        int maxFreq = 0;
        String maxPattern = "";
        for (String pattern : freq.keySet()) {
            int curFreq = freq.get(pattern);

            if (curFreq > maxFreq) {
                maxFreq = curFreq;
                maxPattern = pattern;
            } else if (maxFreq == curFreq) {
                if (pattern.compareTo(maxPattern) < 0) {
                    maxPattern = pattern;
                }
            }
        }
        return Arrays.asList(maxPattern.split(" "));

    }

    public List<List<String>> generateAllThreePatterns(List<String> visit){
        List<List<String>> threePatterns = new ArrayList<>();
        for(List<String> patterns: generateAllPatterns(visit)){
            if(patterns.size() == 3){
                threePatterns.add(patterns);
            }
        }
        return threePatterns;
    }

    public List<List<String>> generateAllPatterns(List<String> visit) {
        if(visit.size() == 1){
            List<String> newList = new ArrayList<>();
            newList.add(visit.get(0));
            List<List<String>> curList = new ArrayList<>();
            curList.add(visit);
            return curList;
        }

        String firstItem = visit.get(0);
        List<String> newList = new ArrayList<>();
        for(int i=1; i<visit.size();i++){
            newList.add(visit.get(i));
        }

        List<List<String>> curList = new ArrayList<>();
        List<String> another = new ArrayList<>();
        another.add(firstItem);
        curList.add(another);
        for(List<String> patterns: generateAllPatterns(newList)){
            if(patterns.size() > 3) continue;
            curList.add(patterns);
            if(patterns.size() > 2) continue;
            List<String> newPattern = new ArrayList<>();
            newPattern.add(firstItem);
            for(String pattern: patterns){
                newPattern.add(pattern);
            }
            curList.add(newPattern);
        }

        return curList;

    }

    public static void main(String[] args) {
        MostVisitedPattern mostVisitedPattern = new MostVisitedPattern();
        List<String> sites = mostVisitedPattern.mostVisitedPattern(new String[]{"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new String[]{"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"});
        for (String site : sites) {
            System.out.println(site);
        }

        List<String> sites2 = mostVisitedPattern.mostVisitedPattern(new String[]{"dowg", "dowg", "dowg"}, new int[]{158931262, 562600350, 148438945}, new String[]{"y", "loedo", "y"});
        for (String site : sites2) {
            System.out.println(site);
        }

        List<String> sites3 = mostVisitedPattern.mostVisitedPattern(new String[]{"ua","ua","ua","ub","ub","ub"}, new int[]{1,2,3,4,5,6}, new String[]{"a","b","a","a","b","c"});
        for (String site : sites3) {
            System.out.println(site);
        }

        List<String> sites4 = mostVisitedPattern.mostVisitedPattern(new String[]{"zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv"}, new int[]{436363475, 710406388, 386655081, 797150921}, new String[]{"wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht"});
        for (String site : sites4) {
            System.out.println(site);
        }

        List<String> sites5 = mostVisitedPattern.mostVisitedPattern(new String[]{"lpgbr","by","by","lpgbr","by","ditctqnahs","by"}, new int[]{117853717,760542754,858167998,235286033,992196098,273717872,792447849}, new String[]{"inc","inc","inc","ftd","inc","ftd","inc"});
        for (String site : sites5) {
            System.out.println(site);
        }
    }
}
