'
'	Richiesta con possibilità di rispondere con
'	[Annulla] (come esempio 4) ma, anziché
'	usare una serie di "IF" nidificati, uso
'	il costrutto "SELECT CASE" 
'	(equivalente al costrutto switch di Java)
'
a=msgbox("Ci stai o no?",vbYesNoCancel)
'
select case a
	case vbyes
		msgbox "Hai detto si! Mi commuovo..."
	case vbno
		msgbox "Se proprio non vuoi... vabbe'"
	case vbCancel
		msgbox "Non rispondi, eh! Hai pauraaaa!"
end select	
