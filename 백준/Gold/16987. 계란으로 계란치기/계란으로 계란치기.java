
import java.util.Scanner;

public class Main {

    // TSP Algorithm
    // 16987 이랑 풀이가 바뀌어 있음

    static Egg[] eggs;
    static int n;
    static int answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }

        solve(0);
        System.out.println(answer);
    }

    public static void solve(int pick){
        // base case
        if (pick == n){
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].durability <= 0)count++;
            }
            answer = Math.max(answer, count);
            return;
        }


        // recursive case
        if (eggs[pick].durability > 0){
            boolean targetExists = false;
            for (int i = 0; i < n; i++) {
                if (pick == i) continue;
                if (eggs[i].durability > 0){
                    targetExists = true;
                    eggs[pick].fight(eggs[i]);
                    solve(pick + 1);
                    eggs[pick].restore(eggs[i]);
                }
            }
            // target 이 존재하지 않을때
            if (!targetExists) solve(pick + 1);
        }else{
            solve(pick + 1);
        }
    }

}

class Egg{
    int durability;
    int weight;

    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }

    public void fight(Egg other){
        this.durability -= other.weight;
        other.durability -= this.weight;
    }

    public void restore(Egg other){
        this.durability += other.weight;
        other.durability += this.weight;
    }
}
