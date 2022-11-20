from classes.guest import Guest
from classes.room import Room
from classes.song import Song
from classes.karaoke_bar import KaraokeBar

song_1 = Song('You know my name')
song_2 = Song('Writing''s on the wall')
song_3 = Song('You only live twice')
playlist_1 = [song_1, song_2, song_3]

room_1 = Room('Skyfall', playlist_1, 5)
room_2 = Room('Crab Key', playlist_1, 2)
rooms = [room_1, room_2]

guest_1 = Guest('Le Chiffre', 25, 'You know my name')
guest_2 = Guest('Elektra King', 15, 'The world is not enough')
guest_3 = Guest('Franz Oberhauser', 3, 'Writing''s on the wall')

bar_float = {
    room_1: 70,
    room_2: 30
}

karaoke_bar = KaraokeBar('Spectre', rooms, bar_float)

# print(guest_1.is_favourite_song(playlist_1))

print('Check of room 1 float.')
print(karaoke_bar.check_room_float(room_1))

print('\nCheck of total float across all rooms.')
print(karaoke_bar.check_total_float())