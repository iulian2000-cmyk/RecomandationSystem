# RecomandationSystem

## Autori : Isac Iulian-George 
 *  Proiectul a fost realizat in integralitate de Isac Iulian-George , student in anul II la Facultatea de Informatica din Iasi . Ca si functionalitati aceasta aplicatie iti recomanda o multime de carti/filme/melodii in functie de un numar de like-uri pe care acestea le au .
 *  Functionalitati : 
       * Un utilizator poate insera o melodie care sa fie ascultata de ceilalti utilizatori .
       * Un utilizator poate insera un film care sa fie vazut de ceilalti utilizatori . 
       * Un  utilizator poate insera o carte care sa fie citita de ceilalti utilizatori .
       * Vizualizarea de top carti/filme/melodii in functie de numarul de like-uri .
       * Like-ul unei melodii/carti/film .
       * Informarea cu privire la toate cartile,melodiile si filmele existente in sistem . 
 
## Detalii de proiectare.
   * Realizarea proiectului s-a bazat pe modelul server-client . 
   * Server-ul e unu multi-thread , alocand pentru fiecare client in parte un fir de executie in scopul satisfacerii cererilor acestuia , implementarea acestuia se gaseste in pachetul **Server_Side** . 
   * Clientul e constituit dintr-o interfata grafica realizata cu **Swing** si **AWT** , acesta conectandu-se la server , cererile acestuia fiind preluate direct din interfata .
   * Pe parte de server,are loc o conexiune la o baza de date (fisierul **DatabaseRecommendationSystem.db**) cu ajutorul unui driver specific ( fisierul **sqlite-jdbc-3.20.1.jar**) 

## Detalii de implementare . 
  * Pe parte de client in momentul in care utilizatorul apasa un buton din GUI , un mesaj specific va fi trimis catre server , acesta din urma primeste mesajul si va trimite inapoi un raspuns, la primirea raspunsului , interfata grafica se va modifica cu content-ul raspunsului . 
  * Pe parte de server, clasa ClientHandler e o clasa care se ocupa de tratarea cererilor fiecarui client in parte . 
  * Clasa LoginSystem se ocupa de procesul de logare al unui utlizator .
  * Clasa BookManager se ocupa de managementul operatiilor ce au in vizor cartile   ( top , update like-uri,adaugare, all_books   ) . 
  * Clasa SongManager se ocupa de managementul operatiilor ce au in vizor melodiile ( top , update like-uri,adaugare, all_songs   ) .
  * Clasa MovieManager se ocupa de managementul operatiilor ce au in vizor filmele  ( top , update like-uri,adaugare, all_movies  ) .
  * Clasa ClientHandler contine ca si membrii cate o instanta a fiecarei clase mentionate anterior . 
 
 
 
