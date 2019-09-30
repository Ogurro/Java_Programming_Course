package learning.java;

public class Main {

    public static void main(String[] args) {
        Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        Team<FootballPlayer> melbourne = new Team<>("Melbourne");
        Team<FootballPlayer> hawthorn = new Team<>("Hawthorn");
        Team<FootballPlayer> fremantle = new Team<>("Fremantle");

        hawthorn.matchResult(fremantle, 1, 0);
        hawthorn.matchResult(adelaideCrows, 3, 8);
        adelaideCrows.matchResult(fremantle, 2, 1);

        System.out.println("Rankings");
        System.out.println(adelaideCrows.getName() + ": " + adelaideCrows.ranking());
        System.out.println(melbourne.getName() + ": " + melbourne.ranking());
        System.out.println(fremantle.getName() + ": " + fremantle.ranking());
        System.out.println(hawthorn.getName() + ": " + hawthorn.ranking());

        League<Team<FootballPlayer>> fLeague = new League<>("Football");
        fLeague.addTeam(adelaideCrows);
        fLeague.addTeam(melbourne);
        fLeague.addTeam(hawthorn);
        fLeague.addTeam(fremantle);
        fLeague.addTeam(adelaideCrows);

        fLeague.showRankings();
    }
}
