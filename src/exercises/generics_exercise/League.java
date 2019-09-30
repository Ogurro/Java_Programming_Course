package exercises.generics_exercise;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {

    private String name;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addTeam(T team) {
        if (this.teams.contains(team)) {
           return false;
        } else {
            this.teams.add(team);
            return true;
        }
    }

    public void showRankings(){
        if (this.teams.isEmpty()){
            System.out.println("No teams in " + this.getName() + " League");
        } else {
            Collections.sort(teams);
            System.out.println(this.getName() + " league rankings:");
            int i = 1;
            for (T team : teams) {
                System.out.println(String.format("%d. %s : %d points", i, team.getName(), team.ranking()));
                i++;
            }
        }
    }


}
