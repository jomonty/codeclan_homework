import unittest
from classes.song import Song

class TestSong(unittest.TestCase):
    def setUp(self):
        self.test_song_1 = Song('You know my name')
        
    @unittest.skip('skipped')
    def test_is_song(self):
        self.assertEqual(self.test_song_1.name, 'You know my name')
    