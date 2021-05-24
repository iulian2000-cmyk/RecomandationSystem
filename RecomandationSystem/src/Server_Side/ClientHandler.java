package Server_Side;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * @author  Isac Iulian-George
 * Clasa care se ocupa de tratarea fiecarui client in parte
 */

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    private final LoginSystem loginSystem;
    private final SongManager songManager;
    private final MovieManager movieManager;
    private final BookManager bookManager;
    /**
     * Constructor
     * @param socket - socket-ul prin care se comunica cu clientul
     */
    public ClientHandler(Socket socket) throws Exception
    {
        this.clientSocket = socket;
        loginSystem = new LoginSystem();
        songManager = new SongManager();
        movieManager = new MovieManager();
        bookManager = new BookManager();

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
                    answer = loginSystem.getConnectMessage(username,password);
                    out.println(answer);
                }
                if(msg.contains("REGISTER")){
                    username = "\"" + msg.split(":")[1].split("-")[0] + "\"";
                    password = "\"" + msg.split(":")[1].split("-")[1] + "\"";
                    answer = loginSystem.insertUser(username,password);
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
                            msgToClient = songManager.getTop10Songs();
                        }
                        if(line.equals("TOP MOVIES")){
                            msgToClient = movieManager.getTop10Movies();
                        }
                        if(line.equals("TOP BOOKS")){
                            msgToClient = bookManager.getTop10Books();
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
                            songManager.insertSong(name_song,genre_song,singer,0);
                        }
                        if(line.contains("ADD_MOVIE") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String movie_name = lineComponentes[1].split("-")[0];
                            String genre = lineComponentes[1].split("-")[1];
                            movieManager.insertMovie(movie_name,genre);
                            times++;
                        }
                        if(line.contains("ADD_BOOK") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String book_name = lineComponentes[1].split("-")[0];
                            String author = lineComponentes[1].split("-")[1];
                            String genre = lineComponentes[1].split("-")[2];
                            String specie = lineComponentes[1].split("-")[3];
                            bookManager.insertBook(book_name,author,genre,specie,0);
                            times++;
                        }
                        if(line.contains("LIKE_BOOK") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String book_name = lineComponentes[1].split("-")[0];
                            String author = lineComponentes[1].split("-")[1];
                            bookManager.updateLikesBook(book_name,author);
                            times++;
                        }
                        if(line.contains("LIKE_MOVIE") && (times == 1)){
                            String [] lineComponentes = line.split(":");
                            String movie_name = lineComponentes[1].split("-")[0];
                            movieManager.updateLikesMovies(movie_name);
                            times++;
                        }
                        if(line.contains("LIKE_SONG")&&(times == 1)){
                            String [] components = line.split(":");
                            String song_to_like = components[1].split("-")[0];
                            songManager.updateLikes(song_to_like);
                            times++;
                        }
                        if(line.contains("ALL MOVIES") && (times == 1)){
                            msgToClient = movieManager.allMovies();
                        }
                        if(line.contains("ALL BOOKS") && (times == 1))
                        {
                            msgToClient = bookManager.allBooks();
                        }
                        if(line.contains("ALL SONGS")&&(times == 1)){
                            msgToClient = songManager.allSongs();
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
