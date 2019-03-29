'
'	Msgbox con 3 pulsanti
'
'	normalmente il primo già selezionato è il
'	primo
'
'	se voglio che sia già selezionato il secondo
'	pulsante (oppure il terzo), basta aggiungere
'	
'	vbDefaultButton2 (per il secondo)
'	vbDefaultButton3 (per il terzo)
'	
'
'	Ora faccio una richiesta [si] [no] [annulla]
'	ma con [annulla] già selezionato
'
a=msgbox("Vuoi cancellare tutto?",vbYesNoCancel+vbExclamation+vbDefaultButton3,"Cancello il tuo disco")


