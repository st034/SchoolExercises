'
'	Una richiesta con possibilità di 
'	rispondere [Annulla]
'
a=msgbox("Ci stai o no?",vbYesNoCancel)
if a=vbyes then	
	msgbox "Hai risposto si, spero tu sappia quel che fai!"
else
	if a=vbno then
		msgbox "Proprio non vuoi....!"
	else
		msgbox "Cancel...sei scarso..."
	end if
end if
