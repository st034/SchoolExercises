# Install and run PHP on windows with XAMPP

download php from [here](https://www.php.net/downloads.php) and extract it in some directory and rename the folder to __"php"__

Copy __{your_directory}\php\php.ini-development__ to __{your_directory}\php\php.ini__ 

open __php.ini__ and modify this value:

__extension_dir = "{your_directory}/php/ext"__

remove the comment from these settings:
```
- extension=curl
- extension=gd2
- extension=mbstring
- extension=mysql
- extension=pdo_mysql
- extension=xmlrpc
```

Next set __"Path"__ environment variable with a new value: __"{your_directory}\php"__

install xampp (download from [here](https://www.apachefriends.org/it/download.html)) (__use default installation settings__)

Insert your PHP exercises into __"C:\xampp\htdocs"__ folder.

Open xampp control panel and run apache server by clicking "Start" in the apache module row.

Enjoy your applications to [localhost](https://localhost)
