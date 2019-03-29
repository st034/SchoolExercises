option explicit
dim fso,unita_di_massa,unita,dettaglio
Set fso = CreateObject("Scripting.FileSystemObject")
Set unita_di_massa = fso.drives
For Each unita In unita_di_massa
	If unita.IsReady  Then
		dettaglio=""
		dettaglio=dettaglio &  "Lettera associata: " & unita.DriveLetter  & vbcr
		dettaglio=dettaglio &  "Nome dell'unita': " & unita.VolumeName & vbcr
		dettaglio=dettaglio &  "Tipo unita': " & unita.DriveType  & vbcr
		dettaglio=dettaglio &  "Spazio disponibile: " & unita.AvailableSpace & vbcr
		dettaglio=dettaglio &  "Tipo file system: " & unita.FileSystem  & vbcr
		dettaglio=dettaglio &  "Spazio libero: " & unita.FreeSpace  & vbcr
		dettaglio=dettaglio &  "E' attiva (inteso: utilizzabile): " & unita.IsReady  & vbcr
		dettaglio=dettaglio &  "Percorso: " & unita.Path  & vbcr
		dettaglio=dettaglio &  "Root: " & unita.RootFolder  & vbcr
		dettaglio=dettaglio &  "Numero seriale: " & unita.SerialNumber  & vbcr
		dettaglio=dettaglio &  "Nome di condivisione: " & unita.ShareName  & vbcr
		dettaglio=dettaglio &  "Dimensione totale: " & unita.TotalSize  & vbcr
		'msgbox "Trovata Chiave USB, Associata a lettera: " & unita.DriveLetter
		msgbox dettaglio
	End If
next
set fso=nothing
