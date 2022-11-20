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
        self.test_float = {self.test_room_1: 70, self.test_room_2: 30}
        self.test_karaoke_bar_1 = KaraokeBar('Spectre', self.test_rooms, self.test_float)
        
    # @unittest.skip('skipped')
    def test_is_karaoke_bar(self):
        self.assertEqual(self.test_karaoke_bar_1.name, 'Spectre')
        self.assertEqual(len(self.test_karaoke_bar_1.rooms), 2)
        self.assertEqual(self.test_karaoke_bar_1.rooms[0].name, 'Skyfall')
        self.assertEqual(self.test_karaoke_bar_1.room_charge, 5)
        
    # @unittest.skip('skipped')
    def test_check_total_float(self):
        expected_output = 100
        actual_output = self.test_karaoke_bar_1.check_total_float()
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_check_room_float(self):
        expected_output = 70
        test_room = self.test_karaoke_bar_1.rooms[0]
        actual_output = self.test_karaoke_bar_1.check_room_float(test_room)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_find_room_by_name_pass(self):
        expected_output = self.test_room_1
        actual_output = self.test_karaoke_bar_1.find_room_by_name('Skyfall')
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_find_room_by_name_fail(self):
        expected_output = None
        actual_output = self.test_karaoke_bar_1.find_room_by_name('Boogaloo')
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_to_float(self):
        expected_output = 75
        self.test_karaoke_bar_1.add_to_room_float(self.test_room_1, self.test_karaoke_bar_1.room_charge)
        actual_output = self.test_karaoke_bar_1.float[self.test_room_1]
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_room_pass_float(self):
        expected_output = 75
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_1, self.test_room_1)
        actual_output = self.test_karaoke_bar_1.float[self.test_room_1]
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_room_pass_guest_wallet(self):
        expected_output = 20
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_1, self.test_room_1)
        actual_output = self.test_guest_1.wallet
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_rooom_pass_room_guests(self):
        expected_output = 1
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_1, self.test_room_1)
        actual_output = len(self.test_room_1.guests)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_room_fail_cannot_afford_float(self):
        expected_output = 70
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_3, self.test_room_1)
        actual_output = self.test_karaoke_bar_1.float[self.test_room_1]
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_room_fail_room_full_float(self):
        expected_output = 30
        self.test_room_2.guests = [self.test_guest_1, self.test_guest_2]
        self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_3, self.test_room_2)
        actual_output = self.test_karaoke_bar_1.float[self.test_room_2]
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_remove_guest_from_room_pass(self):
        expected_output = False
        test_room = self.test_karaoke_bar_1.find_room_by_name('Skyfall')
        test_room.guests = [self.test_guest_1, self.test_guest_2]
        self.test_karaoke_bar_1.remove_guest_from_room(self.test_guest_2, test_room)
        actual_output = test_room.is_guest_in_room(self.test_guest_2)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_remove_guest_from_room_fail(self):
        expected_output = True
        test_room = self.test_karaoke_bar_1.find_room_by_name('Skyfall')
        test_room.guests = [self.test_guest_1]
        self.test_karaoke_bar_1.remove_guest_from_room(self.test_guest_2, test_room)
        actual_output = test_room.is_guest_in_room(self.test_guest_1)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_room_favourite_song(self):
        expected_output = 'Whoo!'
        actual_output = self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_1, self.test_room_1)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_add_guest_to_room_not_favourite_song(self):
        expected_output = None
        actual_output = self.test_karaoke_bar_1.add_guest_to_room(self.test_guest_2, self.test_room_1)
        self.assertEqual(expected_output, actual_output)