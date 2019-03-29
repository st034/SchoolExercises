'
'	Usare il costrutto "IF"
'
'	Richiede all'utente di rispondere alla domanda
'	se la risposta vale 6 
'	(ma, senza ricordarselo a memoria, esiste
'	la costante di nome vbyes, già definita)
'	allora scrive a video "Allora...."
'	altrimenti scrive "NON PUOI..."
'
if msgbox("Sei maggiorenne?",vbyesno)=vbyes then 
	msgbox "Allora puoi andare a votare!"
else
	msgbox "NON PUOI VOTARE!"
end if	
