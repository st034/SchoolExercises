# DizServletJSON

## Configure
___You need vscode, and Java Extension Pack to run this project___

Clone this project, open it in Visual Studio Code and then modify something into /src/App.java file, this will compile App.java.

Run the WebContent from tomcat.
___
## API Description

Base URL: __localhost:8080/WebContent/welcome__

- ### GET - get meaning:

    - Parameters: ?word=_wordToGetMeaning_

    - Response example:

        ```
        {
            "word": [
                "meaning1",
                "meaning2"
            ]    
        }
        ```

- ### PUT - add word:

    - Parameters: ?word=_wordToAdd_&meaning=_meaningOfTheWord_

    - Response example:

        ```
        {
            "wordAdded": [
                "meaning"
            ]    
        }
        ```


- ### POST - modify word:

    - Parameters: ?word=_wordToModify_&meaning=_meaning_&index=_indexOfArrayToModify_
    
    Note: __if the index is not specified, it will add a meaning__

    - Response example:

        ```
        {
            "word": [
                "meaning1",
                "meaning2"
            ]    
        }
        ```

- ### DELETE - delete a word and his meaning:

    - Parameters: ?word=_wordToDelete_

    - Response example:

        ```
        {
            "wordDeleted": [
                "meaning1",
                "meaning2"
            ]    
        }
        ```