dim fso,cartella,nome_file
'
'	Creo l'oggetto "Scripting.FileSystemObject"
'	usando la variabile fso (nome a piacere...)
'
Set fso = CreateObject("Scripting.FileSystemObject")
'
'	Nella variabile 'cartella' specifico il percorso
'	che intendo esaminare
'
cartella="G:\4IE_TEP\20181129 Processi\"
'
'	Scorre tutti i files presenti nella cartella
'	'cartella' e scrive a video il nome del file
'	e la sua estensione
'
for each nome_file in fso.getfolder(cartella).files
	msgbox nome_file.Name & " - estensione: " & fso.GetExtensionName(nome_file.Name)
next	
'
'	Distruggo l'oggetto
'
set fso=nothing