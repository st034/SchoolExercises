'
'	MIGLIORIAMO IL TUTTO CHIEDENDO ALL'UTENTE
'	ANCHE IL PERCORSO INIZIALE DA CUI EFFETTUARE LA RICERCA.
'	HO AGGIUNTO ANCHE IL CONTEGGIO DEI FILES
'
'
dim file_da_cercare,shella,oggetto_cartella
dim fso,stringa,oggetto_explorer,testata
dim quanti

file_da_cercare=ucase(inputbox("Nome (o parte del nome) del file da cercare"))
Set shella = CreateObject("Shell.Application")
Set oggetto_cartella= shella.BrowseForFolder(0, "Seleziona la cartella d'inizio ricerca", 0+&H0200,0 )
If not(oggetto_cartella is nothing) Then 
	percorso_iniziale=oggetto_cartella.Self.Path
	stringa=""
	quanti=0
	'
	'	CHIAMA LA PROCEDURA, PASSANDO ANCHE LA STRINGA VUOTA
	cerca percorso_iniziale,file_da_cercare,stringa,quanti
	'
	'	COMUNICA LA STRINGA, USANDO INTERNET EXPLORER
	'
	'	CREO UN NUOVO "OGGETTO" INTERNETEXPLORER.APPLICATION
	'	(1)
	Set oggetto_explorer = CreateObject("InternetExplorer.Application")
	'
	'	LO RENDO "VISIBILE"
	'
	oggetto_explorer.visible=true
	'
	'	APRO UNA "PAGINA VUOTA"
	'
	oggetto_explorer.navigate "about:blank"
	'
	'	STABILISCO LA POSIZIONE:
	'		-TOP = VERTICALE, DA ANGOLO SUPERIORE SINISTRO
	'		-LEFT= ORIZZONTALE, DA LATO SINISTRO
	'
	oggetto_explorer.top=10
	oggetto_explorer.left=10
	'
	'	DEFINISCO LE DIMENSIONI DELLA FINESTRA (LARGHEZZA ED ALTEZZA):
	'
	oggetto_explorer.Width=1000
	oggetto_explorer.Height=700
	'
	'	"SCRIVO" DIRETTAMENTE NEL "BODY" DEL DOCUMENTO LA STRINGA
	'
	testata="<span style='font-size:24px;color:red;'>"
	testata=testata & "Elenco dei files trovati (ricerca di "
	testata=testata & "<span style='font-weight:bold;'>"
	testata=testata & file_da_cercare 
	testata=testata & "</span>"
	testata=testata & " - Trovati:" & quanti & ")"
	testata=testata & "</span>"
	testata=testata & "<hr/>"
	oggetto_explorer.Document.Body.InnerHTML = testata & stringa & "<hr/>"
else
	msgbox "Non hai selezionato nessun percorso!",vbokonly+vbExclamation,"Nulla da fare..."
end if



sub cerca(percorso,cosa_cercare,risultati,conteggio)
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set oggetto_cartella=fso.GetFolder(percorso)

	for each file_trovato in oggetto_cartella.files
		if instr(ucase(file_trovato.name),cosa_cercare)>0 then
			conteggio=conteggio+1
			risultati=risultati & conteggio & " - [<span style='font-weight:bold;'>" & file_trovato.name & "</span>] in [<span style='font-weight:bold;'>" & oggetto_cartella & "</span>]<br/>"
		end if
	Next
	For Each sotto_cartella In oggetto_cartella.SubFolders 
		'
		'	QUANDO LA PROCEDURA SI AUTO-RICHIAMA DOVRA' PASSARE LA STRINGA
		'
		cerca sotto_cartella,cosa_cercare,risultati,conteggio
	next  
end sub	