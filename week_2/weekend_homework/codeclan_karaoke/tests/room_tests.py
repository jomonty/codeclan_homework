import unittest
from classes.room import Room
from classes.guest import Guest
from classes.song import Song

class TestRoom(unittest.TestCase):
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
        
    @unittest.skip('skipped')
    def test_is_room(self):
        self.assertEqual(self.test_room_1.name, 'Skyfall')
        self.assertEqual(len(self.test_room_1.songs), 3)
        self.assertEqual(self.test_room_1.songs[0].name, 'You know my name')
        self.assertEqual(self.test_room_1.guests, 0)
        self.assertEqual(self.test_room_1.guest_limit, 5)
        
    @unittest.skip('skipped')
    def test_add_guest_to_room_pass(self):
        expect_output = 2
        self.test_room_1.add_guest(self.test_guest_1)
        self.test_room_1.add_guest(self.test_guest_2)
        actual_output = len(self.test_room_1.guests)
        self.assertEqual(expect_output, actual_output)
    
    @unittest.skip('skipped')
    def test_add_guest_to_room_fail_room_full(self):
        self.test_room_2.guests = [self.test_guest_1, self.test_guest_2]
        expect_output = 2
        self.test_room_2.add_guest(self.test_guest_3)
        actual_output = len(self.test_room_2.guests)
        self.assertEqual(expect_output, actual_output)
        
    @unittest.skip('skipped')
    def test_add_guest_to_room_fail_guest_already_in_room(self):
        self.test_room_1.guests = [self.test_guest_1, self.test_guest_2]
        expect_output = 2
        self.test_room_1.add_guest(self.test_guest_1)
        actual_output = len(self.test_room_1.guests)
        self.assertEqual(expect_output, actual_output)
        
    @unittest.skip('skipped')
    def test_is_guest_in_room_false(self):
        expected_output = False
        actual_output = self.test_room_1.is_guest_in_room(self.test_guest_1)
        self.assertEqual(expected_output, actual_output)
        
    @unittest.skip('skipped')
    def test_is_guest_in_room_true(self):
        expected_output = True
        self.test_room_1.guests = [self.test_guest_1]
        actual_output = self.test_room_1.is_guest_in_room(self.test_guest_1)
        self.assertEqual(expected_output, actual_output)
        
    @unittest.skip('skipped')
    def test_is_room_full_false(self):
        self.test_room_1.guests = [self.test_guest_1, self.test_guest_2, self.test_guest_3]
        expect_output = False
        actual_output = self.test_room_1.is_room_full()
        self.assertEqual(expect_output, actual_output)
        
    @unittest.skip('skipped')
    def test_is_room_full_true(self):
        self.test_room_2.guests = [self.test_guest_1, self.test_guest_2]
        expected_output = True
        actual_output = self.test_room_2.is_room_full()
        self.assertEqual(expected_output, actual_output)