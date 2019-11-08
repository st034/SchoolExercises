var setData = () => {
    resetError();
    var name = document.forms['dati'].nome.value;
    var surname = document.forms['dati'].cognome.value;
    var genders = document.forms['dati'].gender;//useless?
    var vote = document.forms['dati'].votodiploma.value;
    var birthyear = document.forms['dati'].birthdaydate.value;
    var courses = document.forms['dati'].course;
    var cond = true;
    errors = [];
    if(name == ""){
        document.getElementById('name').style = "border:2px solid #ff0000"
        errors.push("Nome");
        cond = false;
    }
    if(surname == ""){
        document.getElementById('surname').style = "border:2px solid #ff0000"
        errors.push("Cognome");
        cond = false;
    }
    if(vote == ""){
        document.getElementById('voto').style = "border:2px solid #ff0000"
        errors.push("Voto Diploma");
        cond = false;
    }else{
        if(vote < 0 || vote > 110){
            document.getElementById('voto').style = "border:2px solid #ff0000"
            errors.push("Voto Diploma");
            cond = false;
        }
    }
    if(birthyear == ""){
        document.getElementById('birthday').style = "border:2px solid #ff0000"
        errors.push("Anno di nascita");
        cond = false;
    }else{
        if(birthyear < 1900 || birthyear > new Date().getFullYear()){
            document.getElementById('birthday').style = "border:2px solid #ff0000"
            errors.push("Anno di nascita");
            cond = false;
        }
    }
    if(cond){
        localStorage.setItem("name", name);
        localStorage.setItem("surname", surname);
        if(courses[0].checked){
            localStorage.setItem("course", "informatica");
            localStorage.setItem("meeting", "10 settembre 2020");
        }
        if(courses[1].checked){
            localStorage.setItem("course", "giurisprudenza");
            localStorage.setItem("meeting", "11 settembre 2020");
        }
        if(courses[2].checked){
            localStorage.setItem("course", "economia & commercio");
            localStorage.setItem("meeting", "12 settembre 2020");
        }
        location.href = "welcome.html";
    }else{
        setError(errors);
    }
}
var setError = (errors) => {
    document.getElementById('error').innerHTML = `Please check the <b>${errors.toString()}</b> field`;
}
var resetError = () => {
    document.getElementById('name').style = "";
    document.getElementById('surname').style = "";
    document.getElementById('voto').style = "";
    document.getElementById('birthday').style = "";
    document.getElementById('error').innerHTML = ``;
}
var setContent = () => {
    document.getElementById('content').innerHTML = `Grazie,<br>${localStorage.getItem("name")} ${localStorage.getItem("surname")} per esserti iscritto al nostro corso di laurea in ${localStorage.getItem("course")}.<br>`+
                                                   `La riunione delle matricole e' convocata per il ${localStorage.getItem("meeting")}`;
    localStorage.removeItem("name");
    localStorage.removeItem("surname");
    localStorage.removeItem("course");
    localStorage.removeItem("meeting");
}