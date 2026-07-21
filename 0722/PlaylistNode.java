public class PlaylistNode {
    String code;
    String songName;
    PlaylistNode next;

    public PlaylistNode(String code, String songName) {
        this.code     = code;
        this.songName = songName;
        this.next     = null;
    }

    @Override
    public String toString() {
        return "[" + code + "] " + songName;
    }
}