To run this zork command line levelOneGame. The following steps should be perform:
1) cd ../../zorkArt (where ../../ is your path)
2) mvn package
3) java -jar target/zorkArt.jar

To create your own map:
1) create a text file named "level<LEVEL>Config.txt" and put it in ../../zorkArt/src/main/java/io/muic/ooc/zorkArt/mapConfigFiles

This config file should config as follow:

5             --> Total number of room
0 -1 -1 1 2   --> currentRoom westRoom northRoom eastRoom southRoom
1 0 -1 -1 3   --> -1 means no connected room in that direction
2 -1 0 3 -1
3 2 1 4 -1
4 3 -1 -1 -1
