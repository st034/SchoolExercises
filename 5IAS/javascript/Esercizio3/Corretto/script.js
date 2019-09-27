function getPhrase(){
  let radio = document.getElementsByName("person");
  let phrases = ["A mio parere, studiando i disturbi più gravi potremo illuminare anche ciò che rimane oscuro nella spiegazione dei disturbi più leggeri..","L'uomo che non fa errori di solito non fa niente","Un cavallo, il mio regno per un cavallo!","A che serve passare dei giorni se non si ricordano?","Chi volge altrove l&#39;orecchio per non ascoltare la legge, anche la sua preghiera è in abominio..","A tavola perdonerei chiunque. Anche i miei parenti.."];
  for(i=0; i<radio.length; i++){
    if(radio[i].checked){
      alert(phrases[i]);
    }
  }
}