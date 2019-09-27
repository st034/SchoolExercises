function setTime(){
  let timeSetted = document.forms["form"]["wakeuptime"].value,
      wakeUpDate = new Date(timeSetted),
      currentDate = new Date();
  if(wakeUpDate.getTime()<currentDate.getTime()){
    alert("Please, insert a future date.. I can't time travel to the past.. for now ;)");
  }else{
    localStorage.setItem("wakeUpDate", wakeUpDate.getTime()-currentDate.getTime());
  }  
}
function msToTime(duration) {
  let seconds = Math.floor((duration / 1000) % 60),
      minutes = Math.floor((duration / (1000 * 60)) % 60),
      hours = Math.floor((duration / (1000 * 60 * 60)));
  
  hours = (hours < 10) ? "0" + hours : hours;
  minutes = (minutes < 10) ? "0" + minutes : minutes;
  seconds = (seconds < 10) ? "0" + seconds : seconds;
  
  return [hours, minutes, seconds];
}
function render(){
  let wakeUpDate = localStorage.getItem("wakeUpDate");
  if(wakeUpDate!==null){
    wakeUpDate = wakeUpDate-1000;
    time = msToTime(wakeUpDate);
    if(wakeUpDate>0){
      if(time[0]<6)
        document.getElementById("div").style.backgroundColor = "#ffa6a6";
      if(time[0]>=6&&time[0]<8)
        document.getElementById("div").style.backgroundColor = "#fffea8";
      if(time[0]>=8&&time[0]<10)
        document.getElementById("div").style.backgroundColor = "#b0ffba";
      if(time[0]>=10)
        document.getElementById("div").style.backgroundColor = "#c7f7ff";

      document.getElementById("wakeupat").innerHTML = `Wake up in ${time[0]}:${time[1]}:${time[2]} hours.`;
      localStorage.setItem("wakeUpDate",wakeUpDate);
    }else{
      alert("Wake up!");
      localStorage.removeItem("wakeUpDate");
    }
  }
}
function reset(){
  localStorage.removeItem("wakeUpDate");
}
setInterval(render,1000);