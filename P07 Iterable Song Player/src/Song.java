//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P07 Iterable Song Player
// Course: CS 300 Spring 2022
//
// Author: Yancheng Zhu
// Email: zhu436@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Pair: Kenneth Zhang
// Email: jzhang2428@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// None
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class contains several methods about a Song object.
 * 
 * @author Yancheng Zhu
 * @author Kenneth Zhang
 *
 */
public class Song {
  private String songName;
  private String artist;
  private String duration;

  /**
   * Creates a new Song given the song name, the name of the artist, and the duration of the song.
   * Throws IllegalArgumentException if either of songName, or artist, or duration is null or is
   * blank, or if the duration is not formatted as mm:ss where both mm and ss are in the 0 .. 59
   * range.
   * 
   * @param songName name of a song
   * @param artist   name of the artist
   * @param duration the playing time duration of the song
   */
  public Song(String songName, String artist, String duration) {
    if (songName.isBlank() || artist.isBlank() || duration.isBlank()) {
      throw new IllegalArgumentException("Invalid input");
    }
    this.songName = songName;
    this.artist = artist;
    this.duration = duration;
  }

  /**
   * Gets the title or name of this song.
   * 
   * @return name of the song
   */
  public String getSongName() {
    return this.songName;
  }

  /**
   * Gets the name of the artist who performed this song.
   * 
   * @return name of the artist who performed this song
   */
  public String getArtist() {
    return this.artist;
  }

  /**
   * Gets the duration of this song
   * 
   * @return duration of the song
   */
  public String getDuration() {
    return this.duration;
  }

  /**
   * Returns a string representation of this song. This string should be formatted as follows.
   * "songName---artist---duration" where songName is the title of the song, artist is the name of
   * the artist, and duration is the duration of the song.
   * 
   * @return a string representation of this song
   */
  @Override
  public String toString() {
    return this.songName + "---" + this.artist + "---" + this.duration;
  }

  /**
   * Returns true when this song's name and artist strings equals to the other song's name and
   * artist strings, and false otherwise. Note that this method takes an Object rather than a Song
   * argument, so that it Overrides Object.equals(Object). If an object that is not an instance of
   * Song is ever passed to this method, it should return false.
   * 
   * @return true when the this song has matching name and artist with respect to another song (case
   *         insensitive comparison)
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Song)) {
      return false;
    }
    Song otherSong = (Song) other;
    if (this.songName.equals(otherSong.getSongName())
        && this.artist.equals(otherSong.getArtist())) {
      return true;
    }
    return false;
  }
}
