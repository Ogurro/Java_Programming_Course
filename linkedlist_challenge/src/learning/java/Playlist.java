package learning.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

    private LinkedList<Song> songLinkedList;
    private ArrayList<Album> albumList;

    public Playlist() {
        this.songLinkedList = new LinkedList<>();
        this.albumList = new ArrayList<>();
    }

    public void addSongToPlaylist(Album album, Song song) {
        for (Album existingAlbum : this.albumList) {
            if (existingAlbum == album){
                if (album.songOnFile(song)){
                    this.songLinkedList.add(song);
                }
            }
        }
    }

    public void addAlbum(Album album) {
        this.albumList.add(album);
    }

    public Album getRandomAlbum() {
        if (this.albumList.isEmpty()) {
            return null;
        }
        return this.albumList.get((int) (Math.random() * this.albumList.size()));
    }

    public ListIterator<Song> songIterator(){
        return this.songLinkedList.listIterator();
    }
}
