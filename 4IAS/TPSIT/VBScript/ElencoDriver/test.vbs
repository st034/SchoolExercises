option explicit
dim fso,unita_di_massa,unita,dettaglio
Set fso = CreateObject("Scripting.FileSystemObject")
Set unita_di_massa = fso.drives
For Each unita In unita_di_massa
	if unita.IsReady then
		dettaglio = ""&unita.VolumeName
		if dettaglio = "DODE88" then
			msgbox unita.DriveLetter
		end if
	end if
next
Set fso=nothing
