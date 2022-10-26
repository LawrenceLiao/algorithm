package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] arr = cpdomain.split(" ");
            int num = Integer.parseInt(arr[0]);
            String domain = arr[1];

            map.put(domain, map.getOrDefault(domain, 0) + num);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) != '.') continue;
                String subDomain = domain.substring(i + 1);
                map.put(subDomain, map.getOrDefault(subDomain, 0) + num);
            }
        }
        List<String> results = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            results.add(String.format("%d %s", entry.getValue(), entry.getKey()));
        }
        return results;
    }
}
