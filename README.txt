R.O.N.C.E. : Rise Of New Champions Editor !

RONCE is a software that allows you to edit save file from the game Captain Tsubasa : Rise Of New Champions.

WARNING : RONCE allows configurations not allowed in the base game, which means 2 things : 
1. Some may not work properly
2. Play online with theses would be basically cheating...so don't.

RONCE is designed to help content creators to make cool stuff, so make cool stuff with it. Please.


ATTENTION : It's advised NOT TO use RONCE while the game is launched.


CONTENT : 
backup : stores automatic backups of savadata.dat files
config : configuration files
exchange : store files exported from software (each sub-directory contains a txt file. Please ignore it and try not to delete it either)
fonts : character fonts used in the software
img : images used in the software
jre : java environment (yep it's java, sorry). But it's embedded so that you don't have to install it
ronce_lib : external java libraries
src : source code of the software. I left it there because I'm to lazy to make a propre release
data.json : software save file. THIS FILE IS VITAL !
ronce.exe : to launch the software (obviously)
ronce.jar : software in itself


LAUNCH : 
1. Double-click ronce.exe
2. Survive the ugly splashscreen
3. There you are

At 1st launch, you'll be asked your language (french or english), then your savedata.dat location (usually your user directory, then AppData/Roaming)
This values are stored in the config/system.properties files, and are editable in the Config tab.


FEAUTURES : 
RONCE has several tabs, allowing to edit different elements of the game.
Each tab has 2 lists : 
In game : What is available in game for the selected savedata.
My stock : Elements available in your data.json file

Each tab has the same actions : 
Add to my stock : extract selected elements from the game and add them to your stock.
Create : create a new element in your stock. Default values are used. A unique ID is created and will be very useful for export/import.
Delete : delete selected elements from your stock. Cannot be undone.
Save : save your stock in the data.json file. WARNING if you're not doing this before selecting a new element, your changes will be lost !
Send in game : modifies the savedata.dat game file to put the selected element from your stock into the selected in game element. This will automatically backup your savedata file. You never know.
Export : Export selected elements from your stock into a shareable json file. File is stored in dedicated sub-directory of the exchange directory.
Import : Import a file stored in dedicated sub-directory of the exchange directory. When imported, it's checked if the ID already exists.

Players tab  :
Allow to manage customs players. You can store as many players as you want in RONCE, and replace one of the 20 in game slots.
Things to know : 
- You can put a diffrent alternative shot than the regular shot. All shots can be alternative (not only star shots). Same is for super shots.
- All tackles can be tackle 1. Some may work oddly, I haven't tried them all.
- If you select in the software an haircut you didn't buy in game, the game will replace it at launch.
- You can't delete a player used in a team. So just edit your teams before deleting the player.

Teams tab : 
Allow to manage customs teams. You can store as many teams as you want in RONCE, and replace one of the 5 in game slots.
Things to know : 
- Unlike players haircut, you can use an emblem part that you didn't buy in game.
- Custom positionning on the field is not editable in the software, but it's extracted from the game, store, and sent to the game, so don't hesitate to use them.
- You can put more than 8 customs players in your team.
- Any player is selectable at any position. But a field player at goalkeeping won't be able to make a single save. A goalkeeper can play on the field, but not sure you can put him back to goalkeeping in match.
- You can put the same players as many times as you want. But if the same player is at goalkeeping and on the field, it may as well disturb substitutions.
- The software can't allow to use preset uniforms
- when exported, imported, added to the stock, or sent to the game, a team comes with it's custom players.
  In every case, it's checked if the destination contains the player. That's to say if the ID is the same, or all fields are equal (beside name, ID and description). You'll be asked what to do for each players.

Base players tab : 
Allow to manage builds (techniques and skills) that can be applied to base game players. Unfortunately, only players with a friend card can be edited.
Things to know are pretty much the same than for custom players.

Base teams tab : 
Allow to manage team rosters that can be applied to base game teams. And yes, you can put customs players to them.
Things to know are pretty much the same than for custom players.


DATABASE : 
A common database located on Google Drive has been created. It allows you to where with export files yiour creations with all RONCE users.
Link : 
https://drive.google.com/drive/folders/1RO9-KrnWxWWJ80ZaGH0_cEk8VozLiEJ1?usp=sharing

There you are, this is all that comes to mind, so have fun with R.O.N.C.E. !