import java.util.*;

class Checker implements Comparator<Player> {
    @Override
    public int compare(Player player1, Player player2) {
        int scoreCompare = Integer.compare(player1.score, player2.score);
        if (scoreCompare == 0) {
            int nameComapre = player1.name.compareTo(player2.name);
            if (nameComapre == 0) {
                return 0;
            } else {
                return nameComapre;
            }
        } else {
            return -scoreCompare;
        }
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}