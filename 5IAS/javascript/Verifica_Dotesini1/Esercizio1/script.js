function setBirthday() {
    var birthdayDate = new Date(document.forms['form'].birthday.value);
    var tmpDate = new Date();
    var counter = 0;
    if(document.forms['form'].birthday.value != ""){
        while(true){
            if(tmpDate.getMonth() == birthdayDate.getMonth() && tmpDate.getDate() == birthdayDate.getDate()){
                break;
            }
            counter++;
            tmpDate = new Date((tmpDate.getTime()+86400000));//86400000 è 1 giorno in millisecondi
        }
        document.getElementById("daysremaining").innerHTML = `Mancano ${counter} giorni al tuo compleanno!`;
    }
}