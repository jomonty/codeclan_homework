import unittest
from classes.karaoke_bar import KaraokeBar
from classes.guest import Guest
from classes.room import Room
from classes.song import Song

class TestKaraokeBar(unittest.TestCase):
    def setUp(self):
        self.test_guest_1 = Guest('Le Chiffre', 25, 'You know my name')
        self.test_guest_2 = Guest('Elektra Kind', 15, 'The world is not enough')
        self.test_guest_3 = Guest('Franz Oberhauser', 3, 'Writing''s on the wall')
        self.test_song_1 = Song('You know my name')
        self.test_song_2 = Song('Writing''s on the wall')
        self.test_song_3 = Song('You only live twice')
        self.test_songs = [self.test_song_1, self.test_song_2, self.test_song_3]
        self.test_room_1 = Room('Skyfall', self.test_songs, 5)
        self.test_room_2 = Room('Crab Key', self.test_songs, 2)
        self.test_rooms = [self.test_room_1, self.test_room_2]
        self.test_karaoke_bar_1 = KaraokeBar('Spectre', self.test_rooms, 100)
        
    @unittest.skip('skipped')
    def test_is_karaoke_bar(self):
        self.assertEqual(self.test_karaoke_bar_1.name, 'Spectre')
        self.assertEqual(len(self.test_karaoke_bar_1.rooms), 2)
        self.assertEqual(self.test_karaoke_bar_1.rooms[0].name, 'Skyfall')
        
    @unittest.skip('skipped')
    def test_check_float(self):
        self.assertEqual(100, self.test_karaoke_bar_1.float)
        
    @unittest.skip('skipped')
    def test_find_room_by_name(self):
        expected_output = self.test_room_1
        actual_output = self.test_karaoke_bar_1.find_room_by_name('Skyfall')
        self.assertEqual(expected_output, actual_output)
        
    @unittest.skip('skipped')
    def test_add_guest_to_room_pass_float(self):
        expected_output = 105
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_1, self.test_room_1)
        actual_output = self.test_karaoke_bar_1.float
        self.assertEqual(expected_output, actual_output)
        
    @unittest.skip('skipped')
    def test_add_guest_to_room_fail_cannot_afford_float(self):
        expected_output = 100
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_3, self.test_room_1)
        actual_output = self.test_karaoke_bar_1.float
        self.assertEqual(expected_output, actual_output)
        
    @unittest.skip('skipped')
    def test_add_guest_to_room_fail_room_full_float(self):
        expected_output = 100
        self.test_room_2.guests = [self.test_guest_1, self.test_guest_2]
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_3, self.test_room_2)
        actual_output = self.test_karaoke_bar_1.float
        self.assertEqual(expected_output, actual_output)