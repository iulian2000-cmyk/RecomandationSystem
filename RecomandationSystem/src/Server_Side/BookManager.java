package Server_Side;

import java.sql.*;


/**
 * Clasa definita in scopul de a se ocupa de gestiunea cartilor
 * @author Isac Iulian-George
 */
public class BookManager {
    private static Connection conn;
    private static Statement stmt;

    public void setConn() throws Exception{
        conn = DriverManager.getConnection("jdbc:sqlite:DatabaseRecommendationSystem.db", "root", null);
        stmt = conn.createStatement();
    }

    BookManager() throws  Exception {
        setConn();
    }

    /**
     * Metoda care returneaza top 10 carti in functie de like-uri
     * @return String
     */
    public static String getTop10Books(){
        String res4="";
        try{
            String sql = "SELECT book_name,author FROM books ORDER BY likes DESC LIMIT 10";
            //stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                //System.out.println(rs.getString(1) + "-" + rs.getString(2));
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res4 = res4.concat(line) ;
            }
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res4;
    }

    /**
     * Metoda care actualizeaza like-urile unei melodii
     * @param book - numele cartii
     * @param author -autorul unei carti
     */
    public static void updateLikesBook(String book,String author){
        try {
            String sql = "UPDATE books SET likes=likes+1 WHERE book_name=" + book + " AND author=" + author + " ;";
            //stmt = conn.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT UPDATE!");
            }
            stmt.close();
        }catch (SQLException l){
            l.printStackTrace();
        }
    }

    /**
     * Metoda care insereaza o carte in baza de date
     * @param book_name -- numele cartii
     * @param author -- autorul cartii
     * @param genre -- genul cartii
     * @param specie -- specia cartii
     * @param likes -- numarul de like-uri
     * @author Isac Iulian-George
     */
    public static void insertBook(String book_name,String author,String genre,String specie,int likes)
    {
        try {
            String sql = "INSERT INTO books VALUES (" + book_name + "," + author + "," + genre + "," + specie + "," + likes + ");";
            //stmt = conn.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT INSERT");
            }
            stmt.close();
        }catch (SQLException a){
            a.printStackTrace();
        }
    }
    /**
     * Metoda care returneaza toate cartile
     * @return String
     */
    public static String allBooks(){
        String res="";
        try{
            String sql = "SELECT movie_name,genre FROM movies";
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
