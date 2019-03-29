'
'	Uso di "msgbox" per una semplicissima comunica
'
'	in tal caso, msgbox è usato come PROCEDURA
'	(ovvero: non "restituisce" nulla)
dim fso,t

set fso=CreateObject("Scripting.FileSystemObject")
set t=fso.GetFile("c:\DODESINI CONVENZIONE.doc")
msgbox t.DateLastModified<t.DateCreated
