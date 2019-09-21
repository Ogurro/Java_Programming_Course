package exercises.linked_list_challenge;

import exercises.linked_list_challenge.src.Album;
import exercises.linked_list_challenge.src.Playlist;
import exercises.linked_list_challenge.src.Song;

import java.util.ListIterator;
import java.util.Scanner;

public class PlaySongs {

    private static Playlist playlist = new Playlist();
    private static ListIterator<Song> songIterator;
    private static boolean isMovingForward = true;
    private static Scanner scanner = new Scanner(System.in);
    private static final String INVALID_VALUE = "Invalid Value";

    public static void main(String[] args) {
        populate();

        songIterator = playlist.songIterator();
        boolean quit = false;
        int choice;


        System.out.println("Welcome to Playlist simulator");
        printActions();

        while (!quit) {
            System.out.print("\nEnter choice (0 for action list: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println(INVALID_VALUE);
                choice = 0;
            }
            scanner.nextLine();

            switch (choice) {
                case -1:
                    System.out.println("Finishing");
                    quit = true;
                    break;

                case 0:
                    printActions();
                    break;

                case 1:
                    playNextSong();
                    break;

                case 2:
                    playPreviousSong();
                    break;

                case 3:
                    replaySong();
                    break;

                case 4:
                    removeSongFromPlaylist();
                    break;

                default:
                    System.out.println(INVALID_VALUE);
                    printActions();
                    break;
            }
        }
    }

    private static void playNextSong() {
        if (!isMovingForward) {
            if (songIterator.hasNext()) {
                songIterator.next();
            }
            isMovingForward = true;
        }
        if (songIterator.hasNext()) {
            System.out.println("Playing\n\t" + songIterator.next().getInfo());
        } else {
            System.out.println("End of playlist");
            isMovingForward = false;
        }
    }

    private static void playPreviousSong() {
        if (isMovingForward) {
            if (songIterator.hasPrevious()) {
                songIterator.previous();
            }
            isMovingForward = false;
        }
        if (songIterator.hasPrevious()) {
            System.out.println("Playing\n\t" + songIterator.previous().getInfo());
        } else {
            System.out.println("Start of playlist");
            isMovingForward = true;
        }
    }

    private static void replaySong() {
        if (songIterator.hasNext() && !songIterator.hasPrevious() && isMovingForward) {
            System.out.println("Nothing to replay - at the beginning of playlist");
        } else if (songIterator.hasPrevious() && !songIterator.hasNext() && !isMovingForward) {
            System.out.println("Not playing anything - at the end of list");
        } else if (isMovingForward) {
            songIterator.previous();
            System.out.println("Playing\n\t" + songIterator.next().getInfo());
        } else {
            songIterator.next();
            System.out.println("Playing\n\t" + songIterator.previous().getInfo());
        }
    }

    private static void removeSongFromPlaylist() {
        if (!isMovingForward && !songIterator.hasNext()) {
            System.out.println("Nothing to delete, at the end of playlist");
        } else if (isMovingForward && !songIterator.hasPrevious()) {
            System.out.println("Nothing to delete, at the beginning of playlist");
        } else {
            songIterator.remove();
            if (songIterator.hasNext()) {
                System.out.println("Removed song and playing next song");
                System.out.println("\t" + songIterator.next().getInfo());
                isMovingForward = true;
            } else {
                System.out.println("Removed song and previous previous song");
                System.out.println("\t" + songIterator.previous().getInfo());
                isMovingForward = false;
            }
        }
    }

    private static void printActions() {
        System.out.println("-1: Exit playlist");
        System.out.println("0: Print actions");
        System.out.println("1: Play next song");
        System.out.println("2: Play previous song");
        System.out.println("3: Replay current song");
        System.out.println("4: Remove song from playlist and play next/previous song (default next)");
    }

    private static void populate() {
        Album album;
        Song song;
        for (int i = 1; i < 3; i++) {
            album = new Album("Album " + i);
            for (int j = 1; j < 5; j++) {
                int randMin = (int) (Math.random() * 100);
                int randSec = (int) (Math.random() * 60);
                song = new Song(String.format("song %d %d", i, j), String.format("%d:%d", randMin, randSec));
                album.addSong(song);
            }
            playlist.addAlbum(album);
        }
        album = new Album("Album 3");
        song = new Song("song 3 1", ":");
        playlist.addSongToPlaylist(album, song);

        for (int i = 0; i < 10; i++) {
            album = playlist.getRandomAlbum();
            song = album.getRandomSong();
            playlist.addSongToPlaylist(album, song);
        }

        songIterator = playlist.songIterator();
        while (songIterator.hasNext()) {
            System.out.println(songIterator.next().getInfo());
        }
        System.out.println();
    }
}
