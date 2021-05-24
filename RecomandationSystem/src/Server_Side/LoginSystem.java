package Server_Side;

import java.sql.*;

/**
 * Clasa folosita pentru sistemul de inregistrare si logare .
 */
public class LoginSystem {
    private static Connection conn;
    private static Statement stmt;

    public  void setConn() throws  Exception{
        conn = DriverManager.getConnection("jdbc:sqlite:DatabaseRecommendationSystem.db", "root", null);
    }
    LoginSystem() throws Exception{
        setConn();
        stmt = conn.createStatement();
    }

    /**
     * Metoda care verifica daca username-ul exista in baza de date .
     * @param username --numele utilizatorului
     * @param password -- parola contului
     * @return String
     */
    public static String getConnectMessage(String username,String password)
    {
        String res="";
        try {
            String sql = "SELECT * FROM users WHERE username=" + username + " AND password=" + password + " ;";
            //stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.getString(1)!=null && rs.getString(2)!=null){
                res = "Connected";
            }else{
                res = "Not connected!";
            }
            stmt.close();
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res;
    }

    /**
     * Metoda care insereaza un utilizator in baza de date
     * @param username -- numele utilizatorului
     * @param password -- parola contului
     */
    public static String insertUser(String username ,String password){
        String message="";
        try{
            String sql = "INSERT INTO users VALUES (" + username + "," + password + " );";
            stmt = conn.createStatement();
            if(stmt.execute(sql)){
                message= "ERROR AT INSERT NEW USER";
            }else{
                message = "USER ADDED !" ;
            }
            stmt.close();
        }catch (SQLException b){
            b.printStackTrace();
        }
        return message;
    }

}
