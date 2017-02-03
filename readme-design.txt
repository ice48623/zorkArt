Map - a super class 
property:
level: String - level name
dimension: int[] - a dimension of a map
allRoom: Room[][] - 2D array contains all room and each room index
methods:
build(): Boolean - Read in file and create a map, this method will call Room, Gate, and Monster

Level - a class, Level extends from Map to create a map for that level
property:
Name: String - a name of a level

Room - a class of Room, extends Position
property:
north: Boolean - true indicate that player can go north from this room, or false otherwise
south: Boolean - true indicate that player can go south from this room, or false otherwise
east: Boolean - true indicate that player can go east from this room, or false otherwise
west: Boolean - true indicate that player can go west from this room, or false otherwise
monster: Monster - if null means no monster in this room, else there is a monster
item: Item - if null means no item in this room, else there is an item
player: Player - if null means player is not currently in this room.

Monster - a class of Monster, extends Position
property:
Name: String - a name of a monster
HP: float - a HP of a monster
attack: float - an attack power of a monster
level: float - a level of a monster
methods:
attack(): void - monster attack a player with a power of attack + level
destroy(): void - monster destroy itself when have no HP left.

Gate - a class of Gate, extend Position
method:
build(): int[] - build a gate

Position: a class of Position x, y
property:
positionX: int - an index of x-axis
positionY: int - an index of y-axis

Items - a class of item, contains all common properties of all type of item
property: 
Name: String - a name of an item
type: String - a type of an item
methods:
build(): int[] - build an item

Weapon - a class of weapon extends Item, Weapon is one type of Item, and use the same common properties as Portion
property:
attackPower: float - an attackPower of a monster

Portion - a class of portion extends Item, portion is another type of Item and use the same common properties as Weapon
property:
healPower: float - a healing power will apply to player when portion is use

Player - a class of player extends Position, this class contain of info of a player
property:
Name: String - a name of a player
HP: float - current HP of a player
weapons: String[] - all weapon that player currently holds
attack: float - an attack power of a player
items: String[] - all items that player currently holds
methods:
info(): String - display all info of current position of a player, and Room that player is at
attackWith(Items Weapon): void - player attack a monster with specified weapon
use(Items item): void - player use item (portion)
take(Items item): void - player pick up an item, this method will add picked item in to item list
drop(Items item): void - player drop item, this method will remove item of items list
go(String direction): void - player walk to specified direction, this will update position of a player
help(): String
quit(): void - quit the levelOneGame, cleat all properties