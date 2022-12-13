const assert = require('assert');
const Paint = require('../paint.js');

describe('Paint', function () {
    let paint;
    beforeEach(function () {
        paint = new Paint(10);
    });
    it('should have a number of litres of paint', function () {
        let expectedValue = 10;
        let actualValue = paint.litres;
        assert.strictEqual(actualValue, expectedValue);
    });
    it('should be able to check if it is empty', function () {
        let expectedValue = false;
        let actualValue = paint.isEmpty();
        assert.strictEqual(actualValue, expectedValue);

    });
    it('should be able to empty itself of paint', function () {
        paint.emptyCan();
        let expectedValue = true;
        let actualValue = paint.isEmpty();
        assert.strictEqual(actualValue, expectedValue);
    });
});