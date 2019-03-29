dim shello, fso, desktop, nome_file, a, f1, f2, tmp, unita_di_massa, cond, snumb, volume
set shello=CreateObject("WScript.Shell")
set fso=CreateObject("Scripting.FileSystemObject")
Set unita_di_massa = fso.drives

desktop=shello.SpecialFolders("Desktop")
cond = false

For Each unita In unita_di_massa
	if unita.IsReady and cond=false then
		snumb = ""&unita.SerialNumber
		if snumb = "1920160989" then
			volume = ""&unita.DriveLetter
			cond = true
		end if
	end if
next
if cond then
	for each nome_file in fso.getfolder(desktop).files
		if fso.getExtensionName(nome_file.Name)="doc" or fso.getExtensionName(nome_file.Name)="docx" then
			a = msgbox ("Il file verra spostato nella cartella di backup della chiavetta, continuare?",vbYesNo+vbExclamation+vbDefaultButton2,nome_file.Name)
			if a=vbYes then
				tmp = volume&":\"&nome_file.Name
				if fso.FileExists(tmp) then
					set f1 = fso.GetFile(nome_file)
					set f2 = fso.GetFile(tmp)
					if f1.DateLastModified>f2.DateLastModified then
						fso.CopyFile nome_file, tmp
						fso.DeleteFile nome_file
					else
						a=msgbox ("Il file e' gia' esistente nella cartella di backup nella chiavetta e la sua ultima modifica e' piu' recente, continuare lo stesso?",vbYesNo+vbExclamation+vbDefaultButton2,nome_file.Name)
						if a=VbYes then
							fso.CopyFile nome_file, tmp
							fso.DeleteFile nome_file
						end if
					end if
				else
					'msgbox tmp
					fso.CopyFile nome_file, tmp
					fso.DeleteFile nome_file
				end if
			end if
		end if
	next
else
	msgbox "Chiavetta di backup non presente, si prega di inserila",vbExclamation, "Errore"
end if
set shello=nothing
set fso=nothing
