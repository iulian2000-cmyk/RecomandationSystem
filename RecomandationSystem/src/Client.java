
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.io.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.*;
import javax.swing.*;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.net.Socket;



public class Client extends JFrame implements ActionListener
{
    private static JPanel panel;
    private String msgToServer;
    private JTextField name_song_text,genre_text_field,singer_text_field,
                       name_book_text,author_text_field,specie_text_field,
                       name_movie_text;
    private Box box;

    private JTextField userText;
    private JPasswordField password;
    public void showMenu() {

        JButton buttonRefresh = new JButton("REFRESH");
        JButton buttonExit = new JButton("EXIT");


        JButton buttonTop = new JButton("TOP 10 SONGS");
        JButton buttonAdd = new JButton("ADD SONG");
        JButton buttonLike = new JButton("LIKE SONG");
        JButton allSongs = new JButton("ALL SONGS");


        JButton buttonTopBooks = new JButton("TOP 10 BOOKS");
        JButton buttonAddBooks = new JButton("ADD BOOK");
        JButton buttonLikeBook = new JButton("LIKE BOOK");
        JButton allBooks = new JButton("ALL BOOKS");


        JButton buttonTopMovies = new JButton("TOP 10 MOVIES");
        JButton buttonAddMovie = new JButton("ADD MOVIE");
        JButton buttonLikeMovie = new JButton("LIKE MOVIE");
        JButton allMovies = new JButton("ALL MOVIES");





        setButtonConfiguration(buttonRefresh);
        setButtonConfiguration(buttonExit);
        setButtonConfiguration(buttonTop);
        setButtonConfiguration(buttonAdd);
        setButtonConfiguration(buttonLike);
        setButtonConfiguration(allSongs);
        setButtonConfiguration(buttonTopBooks);
        setButtonConfiguration(buttonAddBooks);
        setButtonConfiguration(buttonLikeBook);
        setButtonConfiguration(allBooks);
        setButtonConfiguration(buttonTopMovies);
        setButtonConfiguration(buttonAddMovie);
        setButtonConfiguration(buttonLikeMovie);
        setButtonConfiguration(allMovies);
        pack();


        addButtonToPanel(buttonRefresh);
        addButtonToPanel(buttonTop);
        addButtonToPanel(buttonAdd);
        addButtonToPanel(buttonLike);
        addButtonToPanel(allSongs);
        addButtonToPanel(buttonTopBooks);
        addButtonToPanel(buttonAddBooks);
        addButtonToPanel(buttonLikeBook);
        addButtonToPanel(allBooks);
        addButtonToPanel(buttonTopMovies);
        addButtonToPanel(buttonAddMovie);
        addButtonToPanel(buttonLikeMovie);
        addButtonToPanel(allMovies);

        addButtonToPanel(buttonExit);



        box = Box.createVerticalBox();
        addButtonToBox(buttonRefresh);
        addButtonToBox(buttonTop);
        addButtonToBox(buttonAdd);
        addButtonToBox(buttonLike);
        addButtonToBox(allSongs);
        addButtonToBox(buttonTopBooks);
        addButtonToBox(buttonAddBooks);
        addButtonToBox(buttonLikeBook);
        addButtonToBox(allBooks);
        addButtonToBox(buttonTopMovies);
        addButtonToBox(buttonAddMovie);
        addButtonToBox(buttonLikeMovie);
        addButtonToBox(allMovies);
        addButtonToBox(buttonExit);

        panel.add(box);
        add(panel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setVisible(true);
        validate();
        repaint();
    }
    public void addButtonToBox(JButton button){
        box.add(button);
    }
    public void addButtonToPanel(JButton button){
        panel.add(button);
    }

    public void setButtonConfiguration(JButton button){
        button.addActionListener(this);
        button.setMaximumSize(new Dimension(150,30));
        button.setFont(new Font("Monospaced",Font.ITALIC,14));
        button.setBackground(new Color(0x2dce98));
        button.setForeground(Color.white);
    }

    public Client(int login)  {
         super("RecommendationSystem");
         if(login == 0) {
             setLayout(new BorderLayout());
             panel = new JPanel();
             panel.setLayout(new FlowLayout());
             Image background_img;
             background_img = Toolkit.getDefaultToolkit().getImage("icon.jpg");
             ImageIcon icon = new ImageIcon("back.jpg");
             setIconImage(icon.getImage());
             this.setContentPane(new JPanel() {
                 @Override
                 public void paintComponent(Graphics g) {
                     super.paintComponent(g);
                     g.drawImage(background_img, 0, 0, null);
                 }
             });
             showMenu();
             validate();
             repaint();
         }else{
             setLayout(new FlowLayout());
             JLabel userLabel = new JLabel("Username: ");
             JLabel passwordLabel = new JLabel("Password: ");

             userText = new JTextField(15);
             password = new JPasswordField(15);

             JButton logButton = new JButton("LOGIN");
             JButton registerButton = new JButton("REGISTER");

             registerButton.addActionListener(this);
             logButton.addActionListener(this);

             add(userLabel);
             add(userText);
             add(passwordLabel);
             add(password);
             add(logButton);
             add(registerButton);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setSize(300, 180);
             setVisible(true);
         }
    }


    public void ShowSongsRequest(String [] serverResponse,int order) {
        for (Component component : panel.getComponents()) {
            panel.remove(component);
        }
        box = Box.createVerticalBox();
        box.setMaximumSize(new Dimension(1200,300));
        JButton buttonBack = new JButton("BACK");
        addBackButton(buttonBack);
        box.setMaximumSize(new Dimension(1200,300));
        box.add(buttonBack);
        box.add(buttonBack);

            for (int indexSong = 0; indexSong < serverResponse.length; indexSong++) {
                JButton song;
                if(order==1) {
                    song = new JButton((indexSong + 1) + "-" + serverResponse[indexSong]);
                }else{
                    song = new JButton(serverResponse[indexSong]);
                }
                song.setMaximumSize(new Dimension(1200, 30));
                song.setFont(new Font("Monospaced", Font.ITALIC, 14));
                song.setBackground(new Color(0xad));
                song.setForeground(Color.white);
                panel.add(song);
                box.add(song);
            }
        panel.add(box);
        add(panel, BorderLayout.CENTER);
        validate();
        repaint();
    }



    public void actionPerformed(ActionEvent event) {

        if(event.getActionCommand().equals("ALL SONGS")){
            msgToServer = "ALL SONGS";
        }
        if(event.getActionCommand().equals("ALL BOOKS")){
            msgToServer = "ALL BOOKS";
        }
        if(event.getActionCommand().equals("ALL MOVIES")){
            msgToServer = "ALL MOVIES";
        }
        if(event.getActionCommand().equals("LOGIN")){
            msgToServer = "LOGIN:" + userText.getText() + "-" + new String(password.getPassword());
            //System.out.println("-" + msgToServer);
            removeAll();
            dispose();
        }
        if(event.getActionCommand().equals("REGISTER")){
            msgToServer = "REGISTER:" + userText.getText() + "-" + new String(password.getPassword());
            removeAll();
            dispose();
        }
        if (event.getActionCommand().equals("TOP 10 SONGS")) {
            msgToServer = "TOP SONGS";
        }
        if(event.getActionCommand().equals("TOP 10 BOOKS")){
            msgToServer = "TOP BOOKS";
        }
        if(event.getActionCommand().equals("TOP 10 MOVIES")){
            msgToServer = "TOP MOVIES";
        }

        if(event.getActionCommand().equals("SUBMIT SONG")){

            msgToServer = "ADD_SONG:" + "\"" + name_song_text.getText() + "\"" + "-" + "\"" + genre_text_field.getText() + "\"" +
                    "-" + "\"" + singer_text_field.getText() + "\"" ;
            deleteComponents();
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("LIKE_MOVIE")){
            msgToServer ="LIKE_MOVIE:" + "\"" + name_movie_text.getText() + "\"" + "-" + "\"" + genre_text_field.getText() + "\"";
            deleteComponents();
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("SUBMIT MOVIE"))
        {
            msgToServer = "ADD_MOVIE:" + "\"" + name_movie_text.getText() + "\"" + "-" +  "\"" + genre_text_field.getText() + "\"";
            deleteComponents();
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("SUBMIT BOOK")){
            msgToServer = "ADD_BOOK:" + "\"" + name_book_text.getText() + "\"" + "-" + "\"" + author_text_field.getText() +"\"" +"-" +
                            "\"" + genre_text_field.getText() + "\"" + "-" + "\"" + specie_text_field.getText() + "\"" ;
            deleteComponents();
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("LIKE_BOOK")){
            msgToServer = "LIKE_BOOK:" + "\"" + name_book_text.getText() + "\"" + "-" + "\"" + author_text_field.getText() +"\"";
            deleteComponents();
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("LIKE_SONG")){
            msgToServer = "LIKE_SONG:" + "\"" + name_song_text.getText() + "\"" + "-" + "\"" + genre_text_field.getText() + "\"" +
                    "-" + "\"" + singer_text_field.getText() + "\"" ;
            deleteComponents();
            showMenu();
            validate();
            repaint();
        }
        if (event.getActionCommand().equals("REFRESH") || event.getActionCommand().equals("BACK")) {
            deleteComponents();
            msgToServer="REFRESH";
            showMenu();
            validate();
            repaint();
        }
        if(event.getActionCommand().equals("ADD MOVIE") || event.getActionCommand().equals("LIKE MOVIE")){
            deleteComponents();
            JButton buttonBack = new JButton("BACK");
            addBackButton(buttonBack);
            box = Box.createVerticalBox();
            box.setMaximumSize(new Dimension(1200,300));
            box.add(buttonBack);

            JLabel name_movie = new JLabel();
            name_movie.setText("Name movie:");
            name_movie_text = new JTextField();

            JLabel genre = new JLabel();
            genre.setText("Genre movie: ");
            genre_text_field = new JTextField();

            box.add(name_movie);
            box.add(name_movie_text);
            box.add(genre);
            box.add(genre_text_field);

            if(event.getActionCommand().equals("LIKE MOVIE")){
                JButton likeBook = new JButton("LIKE_MOVIE");
                setSpecialConfigButton(likeBook);
                box.add(likeBook);
                panel.add(box);
                add(panel, BorderLayout.CENTER);
                validate();
                repaint();
            }else{
                JButton submitBook = new JButton("SUBMIT MOVIE");
                setSpecialConfigButton(submitBook);
                box.add(submitBook);
                panel.add(box);
                add(panel, BorderLayout.CENTER);
                validate();
                repaint();
            }
        }
        if(event.getActionCommand().equals("ADD BOOK") || event.getActionCommand().equals("LIKE BOOK"))
        {
            deleteComponents();
            JButton buttonBack = new JButton("BACK");
            addBackButton(buttonBack);
            box = Box.createVerticalBox();
            box.setMaximumSize(new Dimension(1200,300));
            box.add(buttonBack);

            JLabel name_book = new JLabel();
            name_book.setText("Name Book :");
            name_book_text = new JTextField();

            JLabel author = new JLabel();
            author.setText("Author :");
            author_text_field = new JTextField();

            JLabel genre = new JLabel();
            genre.setText("Genre book :");
            genre_text_field = new JTextField();

            JLabel specie = new JLabel();
            specie.setText("Specie book :");
            specie_text_field = new JTextField();

            box.add(name_book);
            box.add(name_book_text);
            box.add(author);
            box.add(author_text_field);
            box.add(genre);
            box.add(genre_text_field);
            box.add(specie);
            box.add(specie_text_field);

            if(event.getActionCommand().equals("LIKE BOOK")){
                JButton likeBook = new JButton("LIKE_BOOK");
                setSpecialConfigButton(likeBook);
                box.add(likeBook);
                panel.add(box);
                add(panel, BorderLayout.CENTER);
                validate();
                repaint();
            }else{
                JButton submitBook = new JButton("SUBMIT BOOK");
                setSpecialConfigButton(submitBook);
                box.add(submitBook);
                panel.add(box);
                add(panel, BorderLayout.CENTER);
                validate();
                repaint();
            }
        }
        if(event.getActionCommand().equals("ADD SONG")|| event.getActionCommand().equals("LIKE SONG")){
            deleteComponents();
            JButton buttonBack = new JButton("BACK");
            addBackButton(buttonBack);
            box = Box.createVerticalBox();
            box.setMaximumSize(new Dimension(1200,300));
            box.add(buttonBack);

            // Name Song
            JLabel name_song = new JLabel();
            name_song.setText("Name Song :");
            name_song_text = new JTextField();
            // Genre
            JLabel genre_label = new JLabel();
            genre_label.setText("Genre :");
            genre_text_field = new JTextField();

            // Singer
            JLabel singer_label = new JLabel();
            singer_label.setText("Singer: ");
            singer_text_field = new JTextField();

            // Submit
            if(event.getActionCommand().equals("LIKE SONG")){
                JButton like = new JButton("LIKE_SONG");
                addingComponents(box, name_song, genre_label, singer_label, like);
            }else {
                JButton submit = new JButton("SUBMIT SONG");
                addingComponents(box, name_song, genre_label, singer_label, submit);
            }
        }
        if (event.getActionCommand().equals("EXIT")) {
            msgToServer = "EXIT";
            System.exit(0);
        }

    }
    public void setSpecialConfigButton(JButton button){
        button.setMaximumSize(new Dimension(1200,30));
        button.setFont(new Font("Monospaced",Font.ITALIC,14));
        button.setBackground(new Color(0x2dce98));
        button.setForeground(Color.white);
        button.addActionListener(this);
    }
    private void deleteComponents()
    {
        Component[] storeAllButtonInPanel = panel.getComponents();
        for(Component component : storeAllButtonInPanel ){
            panel.remove(component);
        }
    }
    private void addBackButton(JButton buttonBack) {
        //JButton buttonBack = new JButton("BACK");
        buttonBack.addActionListener(this);
        buttonBack.setMaximumSize(new Dimension(1200, 30));
        buttonBack.setFont(new Font("Monospaced", Font.ITALIC, 14));
        buttonBack.setBackground(new Color(0x2dce98));
        buttonBack.setForeground(Color.white);
    }


    private void addingComponents(Box box, JLabel name_song, JLabel genre_label, JLabel singer_label, JButton submit) {
        setButtonConfiguration(submit);
        box.add(name_song);
        box.add(name_song_text);
        box.add(genre_label);
        box.add(genre_text_field);
        box.add(singer_label);
        box.add(singer_text_field);

        box.add(submit);

        panel.add(box);
        add(panel, BorderLayout.CENTER);

        validate();
        repaint();
    }


    public  String getMsgToServer() {
        return msgToServer;
    }


    public static void main(String[] args){


        try (Socket socket = new Socket("localhost", 1234)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Client clientInterface = new Client(1);
            int exitLog = 1;
            String msg;
            while (exitLog == 1){
                msg = clientInterface.getMsgToServer();
                System.out.println("MESSAGE FOR SERVER : " + msg);
                if(msg!=null) {
                    if (msg.contains("LOGIN")) {
                        exitLog = 0;
                        out.println(msg);
                        out.flush();
                    }
                    if(msg.contains("REGISTER")){
                        exitLog = 0;
                        out.println(msg);
                        out.flush();
                        System.exit(0);
                    }
                }
            }
            msg = in.readLine();
            JOptionPane.showMessageDialog(null, msg, "Login status", JOptionPane.INFORMATION_MESSAGE);

            if (msg.compareTo("Connected") != 0) {
                System.out.println("Goodbye!");
                System.exit(0);
            } else {
                clientInterface = new Client(0);
                String msgToServer, answerFromServer;
                int exitStatus = 1;
                int times = 1;
                while (exitStatus == 1) {
                    msgToServer = clientInterface.getMsgToServer();
                    //System.out.println("Message for server :" + msgToServer);
                    out.println(msgToServer);
                    out.flush();
                    if (msgToServer != null) {
                        if (msgToServer.equals("EXIT")) {
                            exitStatus = 0;
                            in.close();
                            out.close();
                        }
                        if (msgToServer.equals("REFRESH") || msgToServer.equals("BACK")) {
                            times = 1;
                        }
                    }
                    if (exitStatus != 0) {
                        answerFromServer = in.readLine();
                        if (answerFromServer != null && msgToServer != null) {
                            //System.out.println("ANSWER : " + answerFromServer);
                            if ((msgToServer.equals("TOP SONGS") || msgToServer.equals("TOP MOVIES") || msgToServer.equals("TOP BOOKS")) && (times == 1))
                            {
                                //System.out.println(answerFromServer);
                                clientInterface.ShowSongsRequest(answerFromServer.split(","),1);
                                times++;
                            }
                            if((msgToServer.equals("ALL SONGS") || msgToServer.equals("ALL BOOKS") || msgToServer.equals("ALL MOVIES")) &&(times==1)){
                                clientInterface.ShowSongsRequest(answerFromServer.split(","),0);
                                times++;
                            }
                        }
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
             }

        }
    }


