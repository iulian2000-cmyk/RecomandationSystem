package Server_Side;

import java.sql.*;

public class MovieManager {

    private static Statement stmt;
    private static Connection conn ;

    public void setConn() throws Exception{
        conn = DriverManager.getConnection("jdbc:sqlite:DatabaseRecommendationSystem.db", "root", null);
        stmt = conn.createStatement();
    }
    MovieManager() throws Exception{
        setConn();
    }



    public static String getTop10Movies(){
        String res1="";
        try{
            String sql = "SELECT movie_name,genre FROM movies ORDER BY likes DESC LIMIT 10";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                //System.out.println(rs.getString(1) + "-" + rs.getString(2));
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res1 = res1.concat(line) ;
            }
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res1;
    }


    public static void updateLikesMovies(String name)
    {
        try {
            String sql = "UPDATE movies SET likes=likes+1 WHERE movie_name=" + name + " ;";
            //stmt = conn.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT UPDATE!");
            }
            stmt.close();
        }catch (SQLException l){
            l.printStackTrace();
        }
    }



    public static void insertMovie(String name,String genre)
    {
        try{
            String sql = "INSERT INTO movies VALUES (" + name + "," + genre + ",0);";
            //stmt = conn.createStatement();
            if(stmt.execute(sql)) {
                System.out.println("Error at insert!");
            }
            stmt.close();
        }catch (SQLException b){
            b.printStackTrace();
        }
    }

    public static String allMovies(){
        String res="";
        try{
            String sql = "SELECT book_name,author FROM books";
            //stmt = conn.createStatement();
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
