package learning.java;

import java.util.ArrayList;

public class Album {

    private String name;
    private ArrayList<Song> songList;

    public Album(String name) {
        this.name = name.toLowerCase();
        this.songList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addSong(Song song){
        this.songList.add(song);
    }

    boolean songOnFile(Song song) {
        return this.songList.contains(song);
    }
    public Song getRandomSong(){
        if (this.songList.isEmpty()) {
            return null;
        }
        return this.songList.get((int) (Math.random() * this.songList.size()));
    }
}
