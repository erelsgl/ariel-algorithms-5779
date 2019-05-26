import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



public class DanielEitan {
	public static void main(String[] args) {
		Map<String, Map<String, Integer>> team1 = new TreeMap<>();
		TreeMap<String, Integer> aviva = new TreeMap<String, Integer>();
		aviva.put("Rafi", 1);
		aviva.put("Shlomo", 2);
		aviva.put("Tomer", 3);
		team1.put("Aviva", aviva);
		TreeMap<String, Integer> batia = new TreeMap<String, Integer>();
		batia.put("Shlomo", 1);
		batia.put("Tomer", 2);
		batia.put("Rafi", 3);
		team1.put("Batia", batia);
		TreeMap<String, Integer> galia = new TreeMap<String, Integer>();
		galia.put("Tomer", 1);
		galia.put("Rafi", 2);
		galia.put("Shlomo", 3);
		team1.put("Galia", galia);
		System.out.println("Team 1:");
		System.out.println(team1);

		Map<String, Map<String, Integer>> team2 = new TreeMap<>();
		TreeMap<String, Integer> rafi = new TreeMap<String, Integer>();
		rafi.put("Batia", 1);
		rafi.put("Galia", 2);
		rafi.put("Aviva", 3);
		team2.put("Rafi", rafi);
		TreeMap<String, Integer> shlomo = new TreeMap<String, Integer>();
		shlomo.put("Galia", 1);
		shlomo.put("Aviva", 2);
		shlomo.put("Batia", 3);
		team2.put("Shlomo", shlomo);
		TreeMap<String, Integer> tomer = new TreeMap<String, Integer>();
		tomer.put("Aviva", 1);
		tomer.put("Batia", 2);
		tomer.put("Galia", 3);
		team2.put("Tomer", tomer);
		System.out.println("\nTeam 2:");
		System.out.println(team2);

		System.out.println("\nMatchings:");
		Map<String, String>[] matchings = new Map[]{
			new TreeMap<String,String>() {{ put("Aviva","Rafi"); put("Batia","Shlomo"); put("Galia", "Tomer"); }},
			new TreeMap<String,String>() {{ put("Aviva","Rafi"); put("Batia","Tomer"); put("Galia", "Shlomo"); }},
			new TreeMap<String,String>() {{ put("Aviva","Shlomo"); put("Batia","Rafi"); put("Galia", "Tomer"); }},
			new TreeMap<String,String>() {{ put("Aviva","Shlomo"); put("Batia","Tomer"); put("Galia", "Rafi"); }},
			new TreeMap<String,String>() {{ put("Aviva","Tomer"); put("Batia","Rafi"); put("Galia", "Shlomo"); }},
			new TreeMap<String,String>() {{ put("Aviva","Tomer"); put("Batia","Shlomo"); put("Galia", "Rafi"); }},
		};

		for (Map<String, String> matching: matchings) {
			boolean ans = isStableMatching(team1, team2, matching);
			System.out.println(matching+": "+(ans? "stable": "unstable"));
		}
	} // main


	public static boolean isBetterMatching(
		Map<String,	Map<String, Integer>> team1,
		Map<String, Map<String, Integer>> team2,
		Map<String, String> matching,
		String player1,
		String player2) {
		if(team1.get(player1).get(player2) <
			team1.get(player1).get(matching.get(player1))
		&& 
		team2.get(player2).get(player1) <
		team2.get(player2).get(getKey(matching, player2))) {
			return true;
		}
		return false;
	}

	public static boolean isStableMatching(
		Map<String, Map<String, Integer>> team1,
		Map<String,	Map<String, Integer>> team2,
		Map<String, String> matching) {
		for (String player1 : team1.keySet()) {
			Set<String> t = new TreeSet<>(team2.keySet());
			t.remove(matching.get(player1));
			for (String player2 : t) {
				if(isBetterMatching(team1, team2, matching, player1, player2))
					return false;
			}
		}
		return true;
	}

	public static String getKey(Map<String, String> map, String value) {
		for (String key : map.keySet()) {
			if(map.get(key).equals(value))
				return key;
		}
		return null;
	}
}