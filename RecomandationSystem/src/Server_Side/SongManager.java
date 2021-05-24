package Server_Side;

import java.sql.*;


/**
 * @author Isac Iulian
 */
public class SongManager {
    private static Connection connection;
    private static Statement stmt;


    SongManager() throws  Exception{
        connection = DriverManager.getConnection("jdbc:sqlite:DatabaseRecommendationSystem.db", "root", null);
        stmt = connection.createStatement();
    }

    /**
     * Metoda care returneaza top 10 Melodii in functie de numarul de like-uri
     * @return String
     */
    public static String getTop10Songs(){
        String res2="";
        try{
            String sql = "SELECT singer,song_name FROm songs ORDER BY likes DESC LIMIT 10 ;";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res2 = res2.concat(line) ;
            }
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res2;
    }

    /**
     * Functie care insereaza o melodie in baza de date
     * @param name -- numele melodiei
     * @param genre -- genul melodiei
     * @param singer -- numele compozitorului
     * @param likes -- numarul de like-uri
     */
    public static void insertSong(String name,String genre,String singer,int likes) {
        try {
            String sql = "INSERT INTO songs VALUES (" + name + "," + singer + "," + genre + "," + likes + ");";
            stmt = connection.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT INSERT");
            }
            stmt.close();
        }catch (SQLException a){
            a.printStackTrace();
        }
    }

    /**
     * Metoda care face update-ul like-urilor pt o carte anume
     * @param song -- numele melodiei
     */
    public static  void updateLikes(String song){
        try {
            String sql = "UPDATE songs SET likes=likes+1 WHERE song_name=" + song + " ;";
            stmt = connection.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT UPDATE!");
            }
            stmt.close();
        }catch (SQLException l){
            l.printStackTrace();
        }
    }

    /**
     * Metoda care returneaza toate melodiile
     * @return String
     */
    public static String allSongs(){
        String res="";
        try{
            String sql = "SELECT singer,song_name FROM songs";
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                //System.out.println(rs.getString(1) + "-" + rs.getString(2));
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res = res.concat(line) ;
            }
            stmt.close();
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res;
    }
}
