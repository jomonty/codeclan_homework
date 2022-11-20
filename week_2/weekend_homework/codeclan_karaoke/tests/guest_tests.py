import unittest
from classes.guest import Guest
from classes.song import Song
from classes.room import Room

class TestGuest(unittest.TestCase):
    def setUp(self):
        self.test_guest_1 = Guest('Le Chiffre', 25, 'You know my name')
        self.test_guest_2 = Guest('Elektra Kind', 15, 'The world is not enough')
        self.test_guest_3 = Guest('Franz Oberhauser', 3, 'Writing''s on the wall')
        self.test_song_1 = Song('You know my name')
        self.test_song_2 = Song('Writing''s on the wall')
        self.test_song_3 = Song('You only live twice')
        self.test_playlist = [self.test_song_1, self.test_song_2, self.test_song_3]
        self.test_room_1 = Room('Skyfall', self.test_playlist, 5)
        
    # @unittest.skip('skipped')
    def test_is_guest(self):
        self.assertEqual(self.test_guest_1.name, 'Le Chiffre')
        self.assertEqual(self.test_guest_1.wallet, 25)
        self.assertEqual(self.test_guest_1.favourite_song, 'You know my name')
        
    # @unittest.skip('skipped')
    def test_reduce_wallet(self):
        expected_output = 10
        self.test_guest_2.reduce_wallet(5)
        actual_output = self.test_guest_2.wallet
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_is_favourite_song_cheer(self):
        expected_output = 'Whoo!'
        actual_output = self.test_guest_3.is_favourite_song(self.test_room_1.playlist)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_is_not_favourite_song_cheer(self):
        expected_output = None
        actual_output = self.test_guest_2.is_favourite_song(self.test_room_1.playlist)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_guest_can_afford_true(self):
        expected_output = True
        actual_output = self.test_guest_1.can_afford(5)
        self.assertEqual(expected_output, actual_output)
        
    # @unittest.skip('skipped')
    def test_guest_can_afford_false(self):
        expected_output = False
        actual_output = self.test_guest_3.can_afford(5)
        self.assertEqual(expected_output, actual_output)