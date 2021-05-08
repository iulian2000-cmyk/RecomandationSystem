
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

// ClientHandler class
class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private static Connection conn;
    private static Statement stmt;



    // Constructor
    public ClientHandler(Socket socket) throws Exception
    {
        this.clientSocket = socket;
        conn = DriverManager.getConnection("jdbc:sqlite:DatabaseRecommendationSystem.db", "root", null);
    }

    public static String getTop10Songs(){
        String res="";
        try{
            String sql = "SELECT singer,song_name FROm songs ORDER BY likes DESC LIMIT 10 ;";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                //System.out.println(rs.getString(1) + "-" + rs.getString(2));
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res = res.concat(line) ;
            }
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res;
    }
    public static String getTop10Movies(){
        String res="";
        try{
            String sql = "SELECT movie_name,genre FROM movies ORDER BY likes DESC LIMIT 10";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                //System.out.println(rs.getString(1) + "-" + rs.getString(2));
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res = res.concat(line) ;
            }
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res;
    }
    public static String getTop10Books(){
        String res="";
        try{
            String sql = "SELECT book_name,author FROM books ORDER BY likes DESC LIMIT 10";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            String line;
            while(rs.next()){
                //System.out.println(rs.getString(1) + "-" + rs.getString(2));
                line = rs.getString(1) + "-" +  rs.getString(2) + ",";
                res = res.concat(line) ;
            }
        }catch (SQLException a){
            a.printStackTrace();
        }
        return res;
    }

    public String getConnectMessage(String username,String password)
    {
        String res="";
        try {
            String sql = "SELECT * FROM users WHERE username=" + username + " AND password=" + password + " ;";
            stmt = conn.createStatement();
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
    public static  void updateLikes(String song,String genre,String singer){
        try {
                String sql = "UPDATE songs SET likes=likes+1 WHERE song_name=" + song + " AND genre=" + genre + " AND singer=" + singer + " ;";
                stmt = conn.createStatement();
                if(stmt.execute(sql)){
                   System.out.println("ERROR AT UPDATE!");
                }
                stmt.close();
        }catch (SQLException l){
            l.printStackTrace();
        }
    }
    public static void updateLikesBook(String book,String author){
        try {
            String sql = "UPDATE books SET likes=likes+1 WHERE book_name=" + book + " AND author=" + author + " ;";
            stmt = conn.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT UPDATE!");
            }
            stmt.close();
        }catch (SQLException l){
            l.printStackTrace();
        }
    }
    public static void updateLikesMovies(String name,String genre)
    {
        try {
            String sql = "UPDATE movies SET likes=likes+1 WHERE movie_name=" + name + " AND genre=" + genre + " ;";
            stmt = conn.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT UPDATE!");
            }
            stmt.close();
        }catch (SQLException l){
            l.printStackTrace();
        }
    }
    public static void insertBook(String book_name,String author,String genre,String specie,int likes)
    {
        try {
            String sql = "INSERT INTO books VALUES (" + book_name + "," + author + "," + genre + "," + specie + "," + likes + ");";
            stmt = conn.createStatement();
            if(stmt.execute(sql)){
                System.out.println("ERROR AT INSERT");
            }
            stmt.close();
        }catch (SQLException a){
            a.printStackTrace();
        }
    }

    public static void insertSong(String name,String genre,String singer,int likes) {
        try {
            String sql = "INSERT INTO songs VALUES (" + name + "," + singer + "," + genre + "," + likes + ");";
            stmt = conn.createStatement();
            if(stmt.execute(sql)){
                 System.out.println("ERROR AT INSERT");
            }
            stmt.close();
        }catch (SQLException a){
            a.printStackTrace();
        }
    }
    public static void insertMovie(String name,String genre)
    {
        try{
            String sql = "INSERT INTO movies VALUES (" + name + "," + genre + ",0);";
            stmt = conn.createStatement();
            if(stmt.execute(sql)) {
                System.out.println("Error at insert!");
            }
            stmt.close();
        }catch (SQLException b){
            b.printStackTrace();
        }
    }
    public static String insertUser(String username ,String password){
        String res="";
        try{
            String sql = "INSERT INTO users VALUES (" + username + "," + password + " );";
            stmt = conn.createStatement();
            if(stmt.execute(sql)){
                res = "ERROR AT INSERT NEW USER";
            }else{
                res = "USER ADDED !" ;
            }
            stmt.close();
        }catch (SQLException b){
            b.printStackTrace();
        }
        return res;
    }
    public static String allMovies(){
        String res="";
        try{
            String sql = "SELECT book_name,author FROM books";
            stmt = conn.createStatement();
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
    public static String allBooks(){
        String res="";
        try{
            String sql = "SELECT movie_name,genre FROM movies";
            stmt = conn.createStatement();
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
    public static String allSongs(){
        String res="";
        try{
            String sql = "SELECT singer,song_name FROM songs";
            stmt = conn.createStatement();
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

    public void run()
    {
        try{
            PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
            String msg = in.readLine();
            String answer = "X",username,password;
            if(msg!=null) {
                if (msg.contains("LOGIN")) {
                    username = "\"" + msg.split(":")[1].split("-")[0] + "\"";
                    password = "\"" + msg.split(":")[1].split("-")[1] + "\"";
                    //System.out.println(username + "-" + password);
                    answer = getConnectMessage(username,password);
                    out.println(answer);
                }
                if(msg.contains("REGISTER")){
                    username = "\"" + msg.split(":")[1].split("-")[0] + "\"";
                    password = "\"" + msg.split(":")[1].split("-")[1] + "\"";
                    answer = insertUser(username,password);
                    out.println(answer);
                }
            }
            if(answer.compareTo("Connected")==0) {
                String line,msgToClient="";
                int exitStatus=1;
                int times=1;
                while (exitStatus == 1) {
                    line = in.readLine();
                    if(line!=null) {
                        //System.out.printf("Sent from the client: %s\n", line);
                        if(line.equals("TOP SONGS")){
                            msgToClient = getTop10Songs();
                        }
                        if(line.equals("TOP MOVIES")){
                            msgToClient = getTop10Movies();
                        }
                        if(line.equals("TOP BOOKS")){
                            msgToClient = getTop10Books();
                        }
                        if(line.equals("EXIT"))
                        {
                            out.println("Goodbye");
                            out.flush();
                            exitStatus=0;
                            in.close();
                            out.close();
                        }
                        if(line.contains("REFRESH")){
                            times=1;
                        }
                        if(line.contains("ADD_SONG")){
                            String [] lineComponents = line.split(":");
                            String name_song = lineComponents[1].split("-")[0];
                            String genre_song = lineComponents[1].split("-")[1];
                            String singer = lineComponents[1].split("-")[2];
                            //System.out.println(name_song + "---" + genre_song + "---" + singer );
                            insertSong(name_song,genre_song,singer,0);
                        }
                        if(line.contains("ADD_MOVIE") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String movie_name = lineComponentes[1].split("-")[0];
                            String genre = lineComponentes[1].split("-")[1];
                            insertMovie(movie_name,genre);
                            times++;
                        }
                        if(line.contains("ADD_BOOK") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String book_name = lineComponentes[1].split("-")[0];
                            String author = lineComponentes[1].split("-")[1];
                            String genre = lineComponentes[1].split("-")[2];
                            String specie = lineComponentes[1].split("-")[3];
                            insertBook(book_name,author,genre,specie,0);
                            times++;
                        }
                        if(line.contains("LIKE_BOOK") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String book_name = lineComponentes[1].split("-")[0];
                            String author = lineComponentes[1].split("-")[1];
                            updateLikesBook(book_name,author);
                            times++;
                        }
                        if(line.contains("LIKE_MOVIE") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String movie_name = lineComponentes[1].split("-")[0];
                            String genre = lineComponentes[1].split("-")[1];
                            updateLikesMovies(movie_name,genre);
                            times++;
                        }
                        if(line.contains("LIKE_SONG")&&(times == 1)){
                            String [] components = line.split(":");
                            String song_to_like = components[1].split("-")[0];
                            String genre = components[1].split("-")[1];
                            String singer = components[1].split("-")[2];
                            updateLikes(song_to_like,genre,singer);
                            times++;
                        }
                        if(line.contains("ALL MOVIES") && (times == 1)){
                            msgToClient = allMovies();
                        }
                        if(line.contains("ALL BOOKS") && (times == 1))
                        {
                            msgToClient = allBooks();
                        }
                        if(line.contains("ALL SONGS")&&(times == 1)){
                            msgToClient = allSongs();
                        }

                        if(exitStatus !=0) {
                            out.println(msgToClient);
                            out.flush();
                        }
                        out.flush();
                    }
                }
            }else{
                 out.close();
                 in.close();
            }
        }catch(IOException a){
            System.out.println("IOException");
        }

  }
}
