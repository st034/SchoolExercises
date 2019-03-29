dim fso,cartella
'
'	Creo l'oggetto "Scripting.FileSystemObject"
'	usando la variabile fso (nome a piacere...)
'
Set fso = CreateObject("Scripting.FileSystemObject")

cartella="G:\prova_creazione"

if fso.FolderExists(cartella) then
	msgbox "La cartella [" & cartella & "] esiste!"
else
	fso.CreateFolder cartella
	msgbox "[" & cartella & "] creata!"
end if
'
'	Distruggo l'oggetto creato all'inizio
'
set fso=nothing