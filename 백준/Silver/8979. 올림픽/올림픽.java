import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private final StringBuilder sb = new StringBuilder();
    private class Country implements Comparable<Country> {
        private int name;
        private int gold;
        private int silver;
        private int copper;

        public Country(int name, int gold, int silver, int copper) {
            this.name = name;
            this.gold = gold;
            this.silver = silver;
            this.copper = copper;
        }

        @Override
        public int compareTo(Country o) {
            if (this.gold != o.gold) {
                return o.gold - this.gold;
            }
            if (this.silver != o.silver) {
                return o.silver - this.silver;
            }
            return o.copper - this.copper;
        }
    }

    public void run() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Country> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int name = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int copper = Integer.parseInt(st.nextToken());
            list.add(new Country(name, gold, silver, copper));
        }

        Collections.sort(list);
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        int previousRank = 1;
        Country previousCountry = null;

        for (Country country : list) {
            if (previousCountry != null && country.compareTo(previousCountry) != 0) {
                rank = previousRank + 1;
            }
            rankMap.put(country.name, rank);
            previousCountry = country;
            previousRank = rank;
        }

        System.out.println(rankMap.get(K));
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}
