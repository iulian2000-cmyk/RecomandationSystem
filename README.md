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
 
 
 
