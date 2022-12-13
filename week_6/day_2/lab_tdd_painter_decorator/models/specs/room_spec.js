const assert = require('assert');
const Room = require('../room.js');

describe('Room', function () {
    let room;
    beforeEach(function () {
        room = new Room(20);
    });
    it('should have an area', function () {
        let expectedValue = 20;
        let actualValue = room.area;
        assert.strictEqual(actualValue, expectedValue);
    });
    it('should start not painted', function () {
        let expectedValue = false;
        let actualValue = room.isPainted;
        assert.strictEqual(actualValue, expectedValue);
    });
    it('should be able to be painted', function () {
        let expectedValue = true;
        room.paint();
        let actualValue = room.roomPainted();
        assert.strictEqual(actualValue, expectedValue);
    });
});