# Information-Retrieval-Project

SEARCH ENGINE ABOUT SONGS

A) Περιγραφή του συστήματος


Το σύστημά μας υλοποιεί μια μηχανή αναζήτησης σχετικής με τραγούδια, με την βοήθεια της βιβλιοθήκης Lucene, η οποία εξειδικεύεται στην ανάκτηση πληροφορίας. Ειδικότερα, παρέχεται η δυνατότητα στον χρήστη να θέτει ερωτήματα που αφορούν την αναζήτηση οποιουδήποτε χαρακτηριστικού ενός τραγουδιού (όπως είναι ο καλλιτέχνης, ο τίτλος, το άλμπουμ, η χρονολογία κυκλοφορίας και οι στίχοι του), ενώ το σύστημα επιστρέφει τα έγγραφα σε μορφή πίνακα που είναι σχετικά με το ερώτημα που έθεσε, όπου τα κελιά που περιέχουν τον συναφή όρο φαίνονται τονισμένα. Δίνεται, επιπλέον, η δυνατότητα να ταξινομήσει το αποτέλεσμα μα βάση κάποιο συγκεκριμένο πεδίο. Τέλος, σημειώνεται πως το interface που χρησιμοποιήθηκε για την υλοποίηση του front-end είναι το Java Swing.

B) Οδηγίες εκτέλεσης της μηχανής αναζήτησης


Προκειμένου να χρησιμοποιήσει κανείς το σύστημά μας, είναι απαραίτητο να προστεθεί το Project στο Eclipse. Έπειτα, είναι απαραίτητο να προστεθούν όλες οι βιβλιοθήκες οι οποίες βρίσκονται στον φάκελο με το όνομα jars στο build path του Project. Ο φάκελος αυτός περιέχει βιβλιοθήκες της Lucene, βιβλιοθήκες αναγκαίες για την ανάγνωση του αρχείου .csv που περιέχει τα δεδομένα καθώς και βιβλιοθήκες που αφορούν το UI της Java Swing. Για να εκτελέσει κανείς την μηχανή αναζήτησης, τρέχει την main συνάρτηση του προγράμματος η οποία βρίσκεται στην κλάση WindowSearchEngine.java, με την προϋπόθεση ότι το ευρετήριο έχει ήδη δημιουργηθεί και υπάρχει στον φάκελο της εργασίας. Στην περίπτωση που δεν υπάρχει, είναι απαραίτητο να εκτελέσει ο χρήστης την κλάση Indexer.java η οποία είναι υπεύθυνη για την δημιουργία του ευρετηρίου και ύστερα να εκτελέσει την main της κλάσης WindowSearchEngine.java. 

Στην υλοποίηση που έχει αναρτηθεί παραπάνω, το ευρετήριο δεν έχει δημιουργηθεί, επομένως είναι απαραίτητο ο χρήστης πρώτα να εκτελέσει την main της συνάρτησης Indexer.java προκειμένου να δημιουργηθεί το ευρετήριο και έπειτα να εκτελέσει την κύρια main του προγράμματος, η οποία βρίσκεται στην κλάση WindowSearchEngine.java

Επισημαίνεται ότι το αρχείο data.csv το οποίο περιέχει τα δεδομένα της συλλογής μας βρίσκεται μέσα στον φάκελο SongsSearchEngine, ο οποίος περιέχει την υλοποίηση της μηχανής αναζήτησης και αποτελεί τον φάκελο ο οποίος είναι απαραίτητο να προστεθεί στο Eclipse ώστε να εκτελεστεί το σύστημα.
