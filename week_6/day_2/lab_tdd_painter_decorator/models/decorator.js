const Decorator = function () {
    this.paintStock = []
}

Decorator.prototype.addPaintToStock = function (paint) {
    this.paintStock.push(paint);
}

Decorator.prototype.totalPaintLitres = function () {
    let totalLitres = 0;
    for (let i=0; i < this.paintStock.length; i ++) {
        totalLitres += this.paintStock[i].litres;
    }
    return totalLitres;
}

Decorator.prototype.enoughPaintForRoom = function (room) {
    let totalLitres = this.totalPaintLitres();
    if (totalLitres >= room.area) {
        return true;
    }
    return false;
}

Decorator.prototype.paintRoom = function (room) {
    if (this.enoughPaintForRoom(room)) {
        room.paint();
        let paintRequired = room.area;
        // let paintUsed = 0
    }
}
module.exports = Decorator;