package codewars;

public class Dubstep {

    public static void main(String[] args) {
        String str1 = "RWUBWUBWUBLWUB";
        String str2 = "WUBWUBABCWUB";

        System.out.println(songDecoder(str1));
        System.out.println(songDecoder(str2));
    }

    public static String songDecoder(String song) {
        return song.replaceAll("WUB", " ").replaceAll(" +", " ").trim();
    }

}
