const assert = require('assert');
const Park = require('../models/park.js');
const Dinosaur = require('../models/dinosaur.js');

describe('Park', function() {
  let park;
  let bigPark;
  let collection;
  let bigCollection;
  let dino1;
  let dino2;
  let dino3;
  beforeEach(function () {
    dino1 = new Dinosaur('Velociraptor', 'carnivore', 200);
    dino2 = new Dinosaur('Triceratops', 'herbivore', 100);
    dino3 = new Dinosaur('Khaan', 'omnivore', 150);
    collection = [dino1, dino2, dino3];
    park = new Park('Lost World', 20, collection);
    bigCollection = [dino1, dino2, dino3, dino1, dino1, dino1, dino2, dino3, dino3];
    bigPark = new Park('Fallen Kingdom', 40, bigCollection);
  })

  it('should have a name', function () {
    let expectedValue = 'Lost World';
    let actualValue = park.name;
    assert.strictEqual(actualValue, expectedValue);
  });
  it('should have a ticket price', function () {
    let expectedValue = 20;
    let actualValue = park.ticketPrice;
    assert.strictEqual(actualValue, expectedValue);
  });
  it('should have a collection of dinosaurs', function () {
    let expectedValue = collection;
    let actualValue = park.collection;
    assert.deepStrictEqual(actualValue, expectedValue);
  });
  it('should be able to add a dinosaur to its collection', function () {
    let expectedValue = collection;
    park.collection = [dino1, dino2];
    park.addDino(dino3);
    let actualValue = park.collection;
    assert.deepStrictEqual(actualValue, expectedValue);
  });
  it('should be able to remove a dinosaur from its collection', function () {
    let expectedValue = [dino1, dino3];
    park.removeDino(dino2);
    let actualValue = park.collection;
    assert.deepStrictEqual(actualValue, expectedValue);
  });
  it('should be able to find the dinosaur that attracts the most visitors', function () {
    let expectedValue = dino1;
    let actualValue = park.highestVisitDino();
    assert.strictEqual(actualValue, expectedValue);
  });
  it('should be able to find all dinosaurs of a particular species', function () {
    let expectedValue = [dino2];
    let actualValue = park.findDinoBySpecies('Triceratops');
    assert.deepStrictEqual(actualValue, expectedValue);
  });
  it('should be able to calculate the total number of visitors per day', function () {
    let expectedValue = 450;
    let actualValue = park.getTotalDailyVisitors();
    assert.strictEqual(actualValue, expectedValue);
  });
  it('should be able to calculate the total number of visitors per year', function () {
    let expectedValue = 164250;
    let actualValue = park.getTotalAnnualVisitors();
    assert.strictEqual(actualValue, expectedValue);
  });
  it('should be able to calculate total revenue for one year', function () {
    let expectedValue = 3285000;
    let actualValue = park.getTotalAnnualRevenue();
    assert.strictEqual(actualValue, expectedValue);
  });
  it('should be able to remove all dinos of a particular species', function () {
    let expectedValue = [dino2, dino3, dino2, dino3, dino3];
    bigPark.removeAllBySpecies('Velociraptor');
    let actualValue = bigPark.collection;
    assert.deepStrictEqual(actualValue, expectedValue);
  });
  it('should return an object containing a summary of diet types with no of dinos', function () {
    let expectedValue = {
      'carnivore': 4,
      'herbivore': 2,
      'omnivore': 3,
    };
    let actualValue = bigPark.getSummaryDiets();
    assert.deepStrictEqual(actualValue, expectedValue);
  });

});
