<h1>DZ4 RMA</h1>

Potrebno je kreirati aplikaciju koja omogućuje prikaz vijesti iz RSS feed-a http://www.bug.hr/rss/vijesti/
i omogućuje prikaz po kategorijama. Aplikacija koristi ListView na koji postavlja pojedini item povučen
sa navedene stranice, prilikom povlačenja itema sa stranice pomogao sam se tutorialom sa 
linka: http://www.vogella.com/tutorials/Retrofit/article.html#exercise-using-retrofit-to-convert-xml-response-from-an-rss-feed
dok za implementaciju unutar ListView predloškom laboratorijskih vježbi. Za filtriranje je potrebno prvo unjeti sve kategorije
unutar spinera, te odabirom određene kategorije lista se filtrira i to tako što se foreachom prođe kroz listu i ubace se u novu 
samo oni itemu čija kategorija odgovaraju odabranoj kategoriji na spinneru. Osvježavanje odnosno ponovno učitavanje RSSFeed-a se 
postiže klikom na image button. 
