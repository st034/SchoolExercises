<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Dizionario</title>
</head>

<body>
    <div class="container">
        <div class="jumbotron shadow p-3 mb-5 rounded">
            <?php 
                error_reporting(E_ALL & ~E_NOTICE & ~E_WARNING );
                $fileName = "dizionario.json";
                $option = $_POST["option"];
                $word = lcfirst($_POST["word"]);
                
                
                $dictionary = file_get_contents($fileName);
                $dictionary = json_decode($dictionary, true);
                if($option == "get") {
                    $meaning = $dictionary[$word];
                    if(!isset($meaning)){
                        $meaning="sorry, word not found";
                    }
                    $meaning = $meaning;
                    $word = $word;
                }
                elseif($option == "put"){
                    $temp = $dictionary[$word];
                    if(!isset($temp)){
                        $tmpMeaning = $_POST["meaning"];
                        $dictionary[$word] = $tmpMeaning;
                        $dictionary = json_encode($dictionary);
                        file_put_contents($fileName,"$dictionary");
                        $meaning = "Word added";
                    }
                    else{
                        $meaning = "Word already exists";
                    }
                }
                elseif($option == "post"){
                    $temp = $dictionary[$word];
                    if(isset($temp)){
                        $tmpMeaning = $_POST["meaning"];
                        $dictionary[$word] = $tmpMeaning;
                        $dictionary = json_encode($dictionary);
                        file_put_contents($fileName,"$dictionary");
                        $meaning = "Word modified";
                    }
                    else{
                        $meaning = "Sorry, word not found";
                    }
                }
                elseif($option == "delete"){
                    $temp = $dictionary[$word];
                    if(isset($temp)){
                        unset($dictionary[$word]);
                        $dictionary = json_encode($dictionary);
                        file_put_contents($fileName,"$dictionary");
                        $meaning = "Word deleted";
                    }
                    else{
                        $meaning = "Sorry, word not found";
                    }
                }
            ?>
            <h1 class="display-4"><?php echo ucfirst($word); ?></h1>
            <p class='lead'><?php echo ucfirst($meaning)?></p>
            <hr class='my-4'>
            <button type="button" class="btn btn-secondary btn-sm" onclick="document.location.href='index.html'">Return</button>
        </div>
    </div>
    
    <!--DON'T TOUCH-->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>

</html>