const assert = require('assert');
const exp = require('constants');
const Decorator = require('../decorator.js');
const Paint = require('../paint.js');
const Room = require('../room.js');

describe('Decorator', function () {
    let decorator1;
    let decorator2;
    let paint1;
    let paint2;
    let room1;
    beforeEach(function () {
        decorator1 = new Decorator();
        paint1 = new Paint(10);
        paint2 = new Paint(15);
        room1 = new Room(20);
        decorator2 = new Decorator();
        decorator2.paintStock = [paint1, paint2];

    });
    it('should start with an empty paint stock', function () {
        let expectedValue = [];
        let actualValue = decorator1.paintStock;
        assert.deepStrictEqual(actualValue, expectedValue);
    });
    it('should be able to add a can of paint to paint stock', function () {
        decorator1.addPaintToStock(paint1);
        let expectedValue = 1;
        let actualValue = decorator1.paintStock.length;
        assert.strictEqual(actualValue, expectedValue);
    });
    it('should be able to calculate total litres of paint in stock', function () {
        let expectedValue = 25;
        let actualValue = decorator2.totalPaintLitres();
        assert.strictEqual(actualValue, expectedValue);
    });
    it('should be able to calculate whether it has enough stock to paint a room', function () {
        let expectedValue = true;
        let actualValue = decorator2.enoughPaintForRoom(room1);
        assert.strictEqual(actualValue, expectedValue);
    });
    it('should be able to paint a room if it has enough paint in stock', function () {
        let expectedValue = true;
        decorator2.paintRoom(room1);
        let actualValue = room1.roomPainted();
        assert.strictEqual(actualValue, expectedValue);
    });
    xit('should be able to decrease paint in stock once a room is painted', function () {
        
    });
    xit('should be able to remove empty paint cans from stock', function () {

    });
});