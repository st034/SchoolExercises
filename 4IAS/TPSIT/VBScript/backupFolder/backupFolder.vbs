option explicit
dim fso, dt, backupName, drive, driveUnits, folderObj, shello, desktop, delOld, actDate, subFolderObj, subFolder, olderFolder, first, olderDate
Set fso = CreateObject("Scripting.FileSystemObject")
Set shello = CreateObject("WScript.Shell")

Set driveUnits = fso.drives
Set folderObj = fso.GetFolder("C:\Users\ZZROT\Desktop\cartellaDaSalvare")

desktop=shello.SpecialFolders("Desktop")
desktop = fso.GetFolder(desktop)

dt = now
actDate = ((year(dt)*100 + month(dt))*100 + day(dt))*10000 + hour(dt)*100 + minute(dt)
backupName = actDate&"_backup"

for each drive in driveUnits
	if drive.DriveType = 1 then
		if drive.FreeSpace > folderObj.Size then
			fso.CopyFolder desktop&"\cartellaDaSalvare", drive.DriveLetter&":\"&backupName , true
			msgbox "Backup completato."
		else
			delOld = msgbox ("La cartella e' piena, vuoi cancellare il backup piu' vecchio?",vbYesNo+vbExclamation+vbDefaultButton2)
			if delOld=vbYes then
				delOlderFolder drive.DriveLetter&":\", "backup"
			else
				msgbox "Operazione annullata."
			end if
		end if
	end if
next
Set fso = nothing

sub delOlderFolder(path, whatSearch)
	Set fso = CreateObject("Scripting.FileSystemObject")
	Set folderObj = fso.getFolder(path)
	Set subFolderObj = folderObj.SubFolders
	first = 0
	for each subFolder in subFolderObj
		if instr(subFolder.name, whatSearch)>0 then
			if first = 0 then
					olderDate = subFolder.DateCreated
					olderFolder = subFolder.name
					first = 1
			end if 
			if subFolder.DateCreated < olderDate then
				olderFolder = subFolder.name
				olderDate = subFolder.DateCreated
			end if
		end if
	next
	fso.DeleteFolder path&olderFolder
end sub
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	