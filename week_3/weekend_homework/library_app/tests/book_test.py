import unittest
from models.book import Book

class TestBook(unittest.TestCase):
    def setUp(self):
        self.test_book_1 = Book('Dune', 'Herbert', 'Science Fiction', False)
        self.test_book_2 = Book('Children of Dune', 'Herbert', 'Science Fiction', True)
        
    # @unittest.skip('skipped')
    def test_is_book(self):
        self.assertEqual(self.test_book_1.title, 'Dune')
        self.assertEqual(self.test_book_1.author, 'Herbert')
        self.assertEqual(self.test_book_1.genre, 'Science Fiction')
        self.assertEqual(self.test_book_1.checked_out, False)
        
    # @unittest.skip('skipped')
    def test_check_out(self):
        expected_result = True
        self.test_book_1.check_out()
        actual_result = self.test_book_1.checked_out
        self.assertEqual(expected_result, actual_result)
        
    # @unittest.skip('skipped')
    def test_check_in(self):
        expected_result = False
        self.test_book_2.check_in()
        actual_result = self.test_book_2.checked_out
        self.assertEqual(expected_result, actual_result)
         
    
    