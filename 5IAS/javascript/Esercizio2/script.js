function register(){
    let firstName = document.forms['userinfo']['firstname'].value;
    let lastName = document.forms['userinfo']['lastname'].value;
    if(!firstName){
        alert("Please insert your first name.");
        return;
    }
    if(!lastName){
        alert("please insert your last name");
        return;
    }
    let birthday = new Date(document.getElementById('birthday').value);
    let radio = document.getElementsByName('gender');
    let currentDate = new Date();
    let gifts = [["Light blue Usb","Eros Ramazzotti's last songs CD","Trip bag","Radico pipe"],
            ["Pink Usb","Laura Pausini's last songs CD","Bucket bag","Leather agenda"]];
    let ageInMillis = currentDate.getTime()-birthday.getTime();
    let days = Math.floor(ageInMillis / (1000*60*60*24));
    let years = Math.floor(ageInMillis / (1000*60*60*24*365));
    let gender = radio[0].checked? radio[0].value : radio[1].value;
    let gift = checkForGift(years, gender, gifts);
    let bonusGift = checkDays(days);
    
    
    location.href = './gift.html';
    
    localStorage.setItem("gender",gender);
    localStorage.setItem("gift",gift);
    localStorage.setItem("bonusGift",bonusGift);
    localStorage.setItem("firstName",firstName);
    localStorage.setItem("lastName",lastName);
}
function checkForGift(years,gender, gifts){
    if(years <= 20){
        if(gender == "Male") 
            return gifts[0][0];
        else 
            return gifts[1][0];
    }
    if(years > 20 && years <= 30){
        if(gender == "Male") 
            return gifts[0][1] 
        else 
            return gifts[1][1];
    }
    if(years > 30 && years <= 40){
        if(gender == "Male") 
            return gifts[0][2] 
        else 
            return gifts[1][2];
    }
    if(years > 40){
        if(gender == "Male") 
            return gifts[0][3] 
        else 
            return gifts[1][3];
    }
}
function checkDays(days){
    if((days%5000)==0){
        return "Also, because your days of life are a multiple of 5000, you won a 100$ discount voucher!";
    }else{
        return "";
    }
}
function returnHome(){
    location.href = `./index.html`;
}
function insertData(){
    if(localStorage.getItem("gender") =="Female")
      document.getElementById("app").style.backgroundColor="#ffc9fb";
    else
      document.getElementById("app").style.backgroundColor="#cffffd";

    document.getElementById("gift").innerHTML = `${localStorage.getItem("firstName")} ${localStorage.getItem("lastName")}! You won a <b>${localStorage.getItem("gift")}</b>`;
    document.getElementById("bonus").innerHTML = localStorage.getItem("bonusGift");
}