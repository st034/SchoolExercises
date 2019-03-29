dim shello,cartella_desktop,cartella_documenti
'
'	Creo l'oggetto WScript.Shell usando
'	la variabile 'shello' (nome a piacere...)
'
'	Se si crea un oggetto (come in questo caso)
'	è obbligatorio farlo precedere da set
'
set shello=CreateObject("WScript.Shell")
'
'	Memorizzo nella variabile 'cartella_desktop'
'	il percorso del desktop dell'utente
'	
cartella_desktop=shello.SpecialFolders("Desktop")
'	Comunico una scritta, concatenandola ( & )
'	alla variabile
msgbox "La tua cartella 'Desktop' e' in realta' " & cartella_desktop
'
'	Memorizzo nella variabile 'cartella_documenti'
'	il percorso dei documenti dell'utente
'	
cartella_documenti=shello.SpecialFolders("MyDocuments")
'	Comunico una scritta, concatenandola ( & )
'	alla variabile
msgbox "La tua cartella 'Documenti' e' " & cartella_documenti
'
'	Distruggo l'oggetto creato all'inizio
'
set shello=nothing
