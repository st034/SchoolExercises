'
'	Uso di "msgbox" come richiesta all'utente
'
'	in questo caso viene usato come funzione
'	e "restituisce" il codice del pulsante 
'	premuto
'
'	Creo una variabile, di nome a
'
dim a
a=msgbox("Che vuoi fare... si oppure no?",vbyesno)
'
'	Se comunico il valore di a, trovo:
'
'	6 se ha risposto cliccando su [SI]
'	7 se ha risposto cliccando su [NO]
'
msgbox a
