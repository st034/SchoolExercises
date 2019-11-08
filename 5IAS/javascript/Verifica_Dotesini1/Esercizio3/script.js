var setData = () => {
    reset();
    var nome = document.forms['dati'].nomecognome.value;
    var luogoNascita = document.forms['dati'].luogonascita.value;
    var dataNascita = document.forms['dati'].datanascita.value;
    var gender = document.forms['dati'].gender.value;
    var residenza = document.forms['dati'].residenza.value;
    var lavoro = document.forms['dati'].lavoro.value;
    var richiesta = document.forms['dati'].richiesta.value;
    var errors = [];
    var cond = true;
    var text = "";
    if(nome == ""){
        errors.push("Nome e Cognome");
        document.getElementById('nomecognome').style = "border:2px solid #ff0000";
        cond = false;
    }
    if(richiesta == ""){
        errors.push("Richiesta");
        document.getElementById('richiesta').style = "border:2px solid #ff0000";
        cond = false;
    }
    if(cond){
        text = `<p>Il sottoscritto ${nome} `;
        text += luogoNascita==""?"":`nato a ${luogoNascita} `;
        text += dataNascita==""?"":`il ${dataNascita} `;
        text += gender==""?"":`di sesso ${gender}, `;
        text += residenza==""?"":`residente a ${residenza}, `;
        text += lavoro==""?"":`di professione ${lavoro}</p> `;
        text += `<p style="text-align:center">Richiede<br>di ${richiesta}.</p>`;
        document.getElementById('modulo').innerHTML = text;
        document.getElementById('modulo').style = "border:1px solid black";
    }else{
        setErrors(errors);
    }
}
var reset = () => {
    document.getElementById('nomecognome').style = "";
    document.getElementById('richiesta').style = "";
    document.getElementById('error').innerHTML = "";
    document.getElementById('modulo').innerHTML = "";
    document.getElementById('modulo').style = "";
}
var setErrors = (errors) => {
    document.getElementById('error').innerHTML = `Please check these fields: <b>${errors.toString()}</b>`;
}
var setDate = () => {
    var today = new Date();
    var todayDay = today.getDate()<10?`0${today.getDate()}`:today.getDate();
    var todayMonth = today.getMonth()<10?`0${today.getMonth()}`:today.getMonth();
    document.forms['dati'].dataodierna.value = `${today.getFullYear()}-${todayMonth}-${todayDay}`;
}