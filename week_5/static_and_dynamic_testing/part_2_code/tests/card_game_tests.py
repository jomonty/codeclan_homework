import unittest
from src.card import Card
from src.card_game import CardGame

class TestCardGame(unittest.TestCase):
    def setUp(self):
        self.card_1 = Card('Hearts', 3)
        self.card_2 = Card('Clubs', 9)
        self.card_ace = Card('Diamonds', 1)
        self.card_game = CardGame()
        
    def test_check_for_ace_true(self):
        expected_value = True
        actual_value = self.card_game.check_for_ace(self.card_ace)
        self.assertEqual(expected_value, actual_value)
        
    def test_check_for_ace_false(self):
        expected_value = False
        actual_value = self.card_game.check_for_ace(self.card_1)
        self.assertEqual(expected_value, actual_value)
        
    def test_highest_card(self):
        expected_value = self.card_2
        actual_value = self.card_game.highest_card(self.card_1, self.card_2)
        self.assertEqual(expected_value, actual_value)
        
    def test_cards_total(self):
        cards = [self.card_1, self.card_2, self.card_ace]
        expected_value = "You have a total of 13"
        actual_value = self.card_game.cards_total(cards)
        self.assertEqual(expected_value, actual_value)