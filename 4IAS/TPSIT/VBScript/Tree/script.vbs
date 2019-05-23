dim fso, shello, objFolder, subf, space, folderPath, objFile, fileCounter, showFiles
Set fso = createObject("Scripting.FileSystemObject")
Set shello = createObject("WScript.Shell")
Set file = fso.createtextfile("result.txt", true)
folderPath = CreateObject("Shell.Application").BrowseForFolder(0,"Select a Folder",0,0).Self.Path
Set objFolder = fso.getFolder(folderPath)
fileCounter=0

showFiles = msgbox ("Vuoi visualizzare anche i files?",vbYesNo)

for each objFile in objFolder.Files
    fileCounter = fileCounter+1
next

file.write folderPath&" "&"(file: "&fileCounter&")"&vbcrlf

if showFiles = vbYes then
    navigateFiles objFolder, file, "     "
end if

navigateFolders objFolder, file, "     ", 0

sub navigateFolders(folder, file, space, fileCounter)
    for each subf in folder.SubFolders
        for each objFile in subf.Files
            fileCounter = fileCounter+1
        next
        file.write space&subf.name&" "&"(file: "&fileCounter&")"&vbcrlf
        if showFiles = vbYes then
            navigateFiles subf, file, space&"     "
        end if
        navigateFolders subf, file, space&"     ", 0
    next
end sub

sub navigateFiles(folder, file, space)
    for each objFile in folder.Files
        file.write space&objFile.name&vbcrlf
    next
end sub